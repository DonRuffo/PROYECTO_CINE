package org.example;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import java.util.LinkedHashSet;
import javax.print.Doc;
import javax.swing.*;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class EliminarDeCartelera {
    private JComboBox SeleccionBox;
    private JButton eliminarButton;
    public JPanel MainPanel;
    private JButton regresarButton;
    private JComboBox SalaBox;
    private JComboBox HorarioBox;
    private JLabel SalaLabel;
    private JLabel HorarioLabel;
    private JCheckBox eliminarPorHorarioYCheckBox;
    private JComboBox FechaBox;
    private JLabel FechaLabel;
    private JComboBox Seleccion2box;
    private JLabel SeleccionLabel;
    private JLabel Seleccion2Label;
    DefaultComboBoxModel seleccionModel = new DefaultComboBoxModel();
    DefaultComboBoxModel seleccion2model= new DefaultComboBoxModel<>();
    DefaultComboBoxModel horarioModel = new DefaultComboBoxModel();
    DefaultComboBoxModel salaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel fechaModel = new DefaultComboBoxModel<>();

    public EliminarDeCartelera() {
        SalaBox.setModel(salaModel);
        HorarioBox.setModel(horarioModel);
        FechaBox.setModel(fechaModel);
        SeleccionBox.setModel(seleccionModel);
        Seleccion2box.setModel(seleccion2model);

        seleccion2model.addElement("Título");
        seleccionModel.addElement("Título");
        fechaModel.addElement("Fecha");
        horarioModel.addElement("Hora");
        salaModel.addElement("Sala");


        PELICULAS peliEliminar= new PELICULAS();


        List<String> pelis = new ArrayList<>();
        List<String> FechasPelis = new ArrayList<>();
        List<String> salas=new ArrayList<>();

        try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
            MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
            MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

            FindIterable<Document> documento=coleccion.find();
            for(Document documento2 : documento){
                pelis.add(documento2.getString("titulo"));
            }
        }
        List<String> pelisnuevas = removerduplicados(pelis);
        for(int i=0;i<=pelisnuevas.size()-1;i++){
            seleccionModel.addElement(pelisnuevas.get(i));
            seleccion2model.addElement(pelisnuevas.get(i));
        }
        pelis.clear();
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    if(SalaBox.isVisible() && HorarioBox.isVisible() && FechaBox.isVisible()){
                        if(fechaModel.getSelectedItem().toString().equals("Fecha") ||
                                salaModel.getSelectedItem().toString().equals("Sala") ||
                                horarioModel.getSelectedItem().toString().equals("Hora")){
                            JOptionPane.showMessageDialog(null, "Seleccione un horario");
                        }else{
                            peliEliminar.setTitulo(seleccionModel.getSelectedItem().toString());
                            peliEliminar.setHorario(horarioModel.getSelectedItem().toString());
                            peliEliminar.setSala(salaModel.getSelectedItem().toString());
                            peliEliminar.setFecha(fechaModel.getSelectedItem().toString());
                            Document filtro = new Document("titulo", peliEliminar.getTitulo())
                                    .append("sala", peliEliminar.getSala())
                                    .append("hora", peliEliminar.getHorario())
                                    .append("fecha", peliEliminar.getFecha());
                            DeleteResult resultado = coleccion.deleteOne(filtro);

                            MongoDatabase BaseSalas = cliente.getDatabase("Salas");
                            MongoCollection<Document> datos_salas = BaseSalas.getCollection("Sala"+peliEliminar.getSala());
                            Document filtro_salas = new Document("titulo", peliEliminar.getTitulo())
                                    .append("hora", peliEliminar.getHorario())
                                    .append("fecha", peliEliminar.getFecha());
                            DeleteResult resultado3 = datos_salas.deleteOne(filtro_salas);

                            JOptionPane.showMessageDialog(null, "Pelicula " + peliEliminar.getTitulo() + " elimnada con éxito");
                            if(FechaBox.getItemCount()>1){
                                for(int i = 0; i<= FechasPelis.size()-1; i++){
                                    FechaBox.removeItem(FechasPelis.get(i));
                                }
                                FechasPelis.clear();
                            }
                            if(SalaBox.getItemCount()>1){
                                for(int i=0; i<=salas.size()-1;i++){
                                    SalaBox.removeItem(salas.get(i));
                                }salas.clear();
                            }
                            if(HorarioBox.getItemCount()>1){
                                HorarioBox.removeAllItems();
                                horarioModel.addElement("Hora");
                            }
                            FindIterable<Document> verificarPelicula = coleccion.find();
                            int verificacion =0;
                            for(Document documento : verificarPelicula){
                                if(peliEliminar.getTitulo().equals(documento.getString("titulo"))){
                                    verificacion++;
                                }
                            }
                            if(verificacion==0){
                                seleccionModel.removeElement(peliEliminar.getTitulo());
                            }

                        }
                    }else{
                        peliEliminar.setTitulo(seleccion2model.getSelectedItem().toString());
                        Document filtro = new Document("titulo",peliEliminar.getTitulo());
                        DeleteResult resultado=coleccion.deleteMany(filtro);
                        JOptionPane.showMessageDialog(null, "Pelicula " +peliEliminar.getTitulo()+" elimnada con éxito");
                        Seleccion2box.removeItem(peliEliminar.getTitulo());
                        SeleccionBox.removeItem(peliEliminar.getTitulo());
                    }
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                JFrame gestionPeliculas = new JFrame();
                gestionPeliculas.setTitle("PoliCine");
                gestionPeliculas.setContentPane(new GestionarPeliculas().MainPanel);
                gestionPeliculas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                gestionPeliculas.setSize(500, 350);
                gestionPeliculas.setLocationRelativeTo(null);
                gestionPeliculas.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                gestionPeliculas.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        eliminarPorHorarioYCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent b) {
                if(!eliminarPorHorarioYCheckBox.isSelected()){
                    SalaLabel.setVisible(false);
                    HorarioLabel.setVisible(false);
                    SalaBox.setVisible(false);
                    HorarioBox.setVisible(false);
                    FechaLabel.setVisible(false);
                    FechaBox.setVisible(false);
                    SeleccionBox.setVisible(false);
                    SeleccionLabel.setVisible(false);
                    Seleccion2box.setVisible(true);
                    Seleccion2Label.setVisible(true);


                }else{
                    SalaLabel.setVisible(true);
                    HorarioLabel.setVisible(true);
                    SalaBox.setVisible(true);
                    HorarioBox.setVisible(true);
                    FechaLabel.setVisible(true);
                    FechaBox.setVisible(true);
                    SeleccionBox.setVisible(true);
                    SeleccionLabel.setVisible(true);
                    Seleccion2Label.setVisible(false);
                    Seleccion2box.setVisible(false);
                }
            }
        });
        SeleccionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent c) {

                if(FechaBox.getItemCount()>1){
                    for(int i = 0; i<= FechasPelis.size()-1; i++){
                        FechaBox.removeItem(FechasPelis.get(i));
                    }
                    FechasPelis.clear();
                }

                peliEliminar.setTitulo(seleccionModel.getSelectedItem().toString());
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("titulo")).equals(peliEliminar.getTitulo())){
                            FechasPelis.add(documento3.getString("fecha"));
                        }
                    }
                }
                List<String> diasLimpios = removerduplicados(FechasPelis);
                for(int i=0; i<= diasLimpios.size()-1;i++){
                    fechaModel.addElement(diasLimpios.get(i));
                }
                diasLimpios.clear();

            }
        });

        FechaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent d) {
                if(SalaBox.getItemCount()>1){
                    for(int i=0; i<=salas.size()-1;i++){
                        SalaBox.removeItem(salas.get(i));
                    }salas.clear();
                }

                peliEliminar.setFecha(fechaModel.getSelectedItem().toString());
                try(MongoClient cliente1 = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente1.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("fecha")).equals(peliEliminar.getFecha()) && (documento3.getString("titulo")).equals(peliEliminar.getTitulo())){
                            salas.add(documento3.getString("sala"));
                        }
                    }
                }
                List<String> SalasLimpias = removerduplicados(salas);
                for(int i = 0; i<= SalasLimpias.size()-1; i++){
                    salaModel.addElement(SalasLimpias.get(i));
                }
                SalasLimpias.clear();
            }
        });
        SalaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(HorarioBox.getItemCount()>1){
                    HorarioBox.removeAllItems();
                    horarioModel.addElement("Hora");
                }

                peliEliminar.setSala(salaModel.getSelectedItem().toString());
                try(MongoClient cliente2 = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente2.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("titulo")).equals(peliEliminar.getTitulo()) && (documento3.getString("fecha")).equals(peliEliminar.getFecha())
                        && (documento3.getString("sala")).equals(peliEliminar.getSala())){
                            horarioModel.addElement(documento3.getString("hora"));
                        }
                    }
                }
            }
        });
    }
    public static <T> List<T> removerduplicados(List<T> lista){
        Set<T> set= new LinkedHashSet<>(lista);
        return new ArrayList<>(set);
    }
}
