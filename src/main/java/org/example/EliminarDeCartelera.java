package org.example;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import java.util.LinkedHashSet;
import javax.swing.*;
import java.util.Set;

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
    private JComboBox DiaBox;
    private JLabel DiaLabel;
    DefaultComboBoxModel seleccionModel = new DefaultComboBoxModel();
    DefaultComboBoxModel horarioModel = new DefaultComboBoxModel();
    DefaultComboBoxModel salaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel diaModel= new DefaultComboBoxModel<>();

    public EliminarDeCartelera() {
        SalaBox.setModel(salaModel);
        HorarioBox.setModel(horarioModel);
        DiaBox.setModel(diaModel);

        salaModel.addElement("Sala");
        horarioModel.addElement("Horario");
        diaModel.addElement("Día");

        SeleccionBox.setModel(seleccionModel);

        PELICULAS peliEliminar= new PELICULAS();

        List<String> horarios= new ArrayList<>();
        List<String> pelis = new ArrayList<>();
        List<String> dias= new ArrayList<>();
        List<Integer> salas=new ArrayList<>();

        try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
            MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
            MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

            FindIterable<Document> documento=coleccion.find();
            for(Document documento2 : documento){
                pelis.add(documento2.getString("titulo"));
            }
            cliente.close();
        }
        List<String> pelisnuevas = removerduplicados(pelis);
        for(int i=0;i<=pelisnuevas.size()-1;i++){
            seleccionModel.addElement(pelisnuevas.get(i));
        }
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");
                    peliEliminar.setTitulo(seleccionModel.getSelectedItem().toString());
                    peliEliminar.setHorario(horarioModel.getSelectedItem().toString());
                    peliEliminar.setSala(Integer.parseInt(salaModel.getSelectedItem().toString()));
                    peliEliminar.setDia(diaModel.getSelectedItem().toString());
                    if(SalaBox.isVisible() && HorarioBox.isVisible()){
                        Document filtro = new Document("titulo",peliEliminar.getTitulo())
                                .append("sala",peliEliminar.getSala())
                                .append("horario",peliEliminar.getHorario())
                                .append("dia", peliEliminar.getDia());
                        DeleteResult resultado=coleccion.deleteOne(filtro);
                        JOptionPane.showMessageDialog(null, "Pelicula " +peliEliminar.getTitulo()+" elimnada con éxito");
                        SeleccionBox.removeItem(peliEliminar.getTitulo());
                        cliente.close();
                    }else{
                        Document filtro = new Document("titulo",peliEliminar.getTitulo());
                        DeleteResult resultado=coleccion.deleteMany(filtro);
                        JOptionPane.showMessageDialog(null, "Pelicula " +peliEliminar.getTitulo()+" elimnada con éxito");
                        SeleccionBox.removeItem(peliEliminar.getTitulo());
                        cliente.close();
                    }
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                JFrame gestionPeliculas = new JFrame();
                gestionPeliculas.setTitle("Gestionar Peliculas");
                gestionPeliculas.setContentPane(new GestionarPeliculas().MainPanel);
                gestionPeliculas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                gestionPeliculas.setSize(500, 300);
                gestionPeliculas.setLocationRelativeTo(null);
                gestionPeliculas.setVisible(true);
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
                    DiaLabel.setVisible(false);
                    DiaBox.setVisible(false);

                }else{
                    SalaLabel.setVisible(true);
                    HorarioLabel.setVisible(true);
                    SalaBox.setVisible(true);
                    HorarioBox.setVisible(true);
                    DiaLabel.setVisible(true);
                    DiaBox.setVisible(true);
                }
            }
        });
        SeleccionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent c) {
                peliEliminar.setTitulo(seleccionModel.getSelectedItem().toString());
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("titulo")).equals(peliEliminar.getTitulo())){
                            dias.add(documento3.getString("dia"));
                        }
                    }
                    cliente.close();
                }
                List<String> diasLimpios = removerduplicados(dias);
                for(int i=0; i<= diasLimpios.size()-1;i++){
                    diaModel.addElement(diasLimpios.get(i));
                }
                diasLimpios.clear();
                dias.clear();
            }
        });

        DiaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent d) {
                peliEliminar.setDia(diaModel.getSelectedItem().toString());
                peliEliminar.setTitulo(seleccionModel.getSelectedItem().toString());
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("dia")).equals(peliEliminar.getDia()) && (documento3.getString("titulo")).equals(peliEliminar.getTitulo())){
                            salas.add(documento3.getInteger("sala"));
                            /*horarios.add(documento3.getString("horario"));*/
                        }
                    }
                    List<Integer> SalasLimpias = removerduplicados(salas);
                    for(int i = 0; i<= SalasLimpias.size()-1; i++){
                        salaModel.addElement(SalasLimpias.get(i));
                    }
                    salas.clear();
                    SalasLimpias.clear();
                    cliente.close();
                }
            }
        });
        SalaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peliEliminar.setTitulo(seleccionModel.getSelectedItem().toString());
                peliEliminar.setDia(diaModel.getSelectedItem().toString());
                peliEliminar.setSala(Integer.parseInt(salaModel.getSelectedItem().toString()));
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("titulo")).equals(peliEliminar.getTitulo()) && (documento3.getString("dia")).equals(peliEliminar.getDia())
                        && (documento3.getInteger("sala")).equals(peliEliminar.getSala())){
                            horarios.add(documento3.getString("horario"));
                        }
                    }
                    List<String> horariosLimpios=removerduplicados(horarios);
                    for (int j=0;j<=horariosLimpios.size()-1;j++){
                        horarioModel.addElement(horariosLimpios.get(j));
                    }
                    horariosLimpios.clear();
                    horarios.clear();
                    cliente.close();
                }
            }
        });
    }
    public static <T> List<T> removerduplicados(List<T> lista){
        Set<T> set= new LinkedHashSet<>(lista);
        return new ArrayList<>(set);
    }
}
