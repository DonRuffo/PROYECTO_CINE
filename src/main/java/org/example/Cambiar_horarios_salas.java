package org.example;

import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cambiar_horarios_salas {
    private JComboBox TituloBox;
    private JComboBox FechaBox;
    private JComboBox SalaBox;
    private JComboBox HoraBox;
    private JComboBox NuevaSalaBox;
    private JComboBox NuevaHoraBox;
    private JButton regresarButton;
    private JButton cambiarButton;
    private JComboBox DiaBox;
    private JComboBox MesBox;
    private JComboBox AnioBpx;
    public JPanel MainPanel;
    DefaultComboBoxModel tituloModel= new DefaultComboBoxModel();
    DefaultComboBoxModel fechaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel salaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel horaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel nuevaSalaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel nuevaHoraModel = new DefaultComboBoxModel();
    DefaultComboBoxModel diaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel mesModel = new DefaultComboBoxModel();
    DefaultComboBoxModel anioModel = new DefaultComboBoxModel();

    public Cambiar_horarios_salas(){
        TituloBox.setModel(tituloModel);
        FechaBox.setModel(fechaModel);
        SalaBox.setModel(salaModel);
        HoraBox.setModel(horaModel);;
        NuevaSalaBox.setModel(nuevaSalaModel);
        NuevaHoraBox.setModel(nuevaHoraModel);
        DiaBox.setModel(diaModel);
        MesBox.setModel(mesModel);
        AnioBpx.setModel(anioModel);

        fechaModel.addElement("Fecha");
        salaModel.addElement("Sala");
        horaModel.addElement("Hora");
        diaModel.addElement("Dia");
        mesModel.addElement("Mes");
        anioModel.addElement("Año");
        nuevaSalaModel.addElement("Sala");
        nuevaHoraModel.addElement("Hora");

        anioModel.addElement("2024");
        anioModel.addElement("2025");

        MesBox.setModel(mesModel);
        for(int i=1; i<=9; i++){
            mesModel.addElement("0"+i);
        }
        mesModel.addElement("10");
        mesModel.addElement("11");
        mesModel.addElement("12");

        DiaBox.setModel(diaModel);
        for(int j=1; j<=9; j++){
            diaModel.addElement("0"+j);
        }
        for(int i=10; i<=31; i++){
            diaModel.addElement(i);
        }
        for(int i=1; i<=10;i++){
            nuevaSalaModel.addElement(i);
        }
        nuevaHoraModel.addElement("12:00");
        nuevaHoraModel.addElement("15:00");
        nuevaHoraModel.addElement("18:00");
        nuevaHoraModel.addElement("21:00");

        PELICULAS peliCambiar=new PELICULAS();

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
            tituloModel.addElement(pelisnuevas.get(i));
        }
        pelis.clear();
        MesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PELICULAS peli=new PELICULAS();
                peli.setMes(mesModel.getSelectedItem().toString());
                peli.setAnio(anioModel.getSelectedItem().toString());
                if(peli.getMes().equals("01") || peli.getMes().equals("03") || peli.getMes().equals("05")
                        || peli.getMes().equals("07") || peli.getMes().equals("08") || peli.getMes().equals("10")
                        || peli.getMes().equals("12")){
                    DiaBox.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=31; i++){
                        diaModel.addElement(i);
                    }
                }else if(peli.getMes().equals("04") || peli.getMes().equals("06") || peli.getMes().equals("09")
                        || peli.getMes().equals("11")){
                    DiaBox.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=30; i++){
                        diaModel.addElement(i);
                    }
                }else if(peli.getMes().equals("02") && peli.getAnio().equals("2024")){
                    DiaBox.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=29; i++){
                        diaModel.addElement(i);
                    }
                }else if(peli.getAnio().equals("2025") && peli.getMes().equals("02")){
                    DiaBox.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=28; i++){
                        diaModel.addElement(i);
                    }
                }
            }
        });

        TituloBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FechaBox.getItemCount()>1){
                    for(int i = 0; i<= FechasPelis.size()-1; i++){
                        FechaBox.removeItem(FechasPelis.get(i));
                    }
                    FechasPelis.clear();
                }

                peliCambiar.setTitulo(tituloModel.getSelectedItem().toString());
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento2 : documento){
                        if((documento2.getString("titulo")).equals(peliCambiar.getTitulo())){
                            FechasPelis.add(documento2.getString("fecha"));
                        }
                    }
                }
                List<String> fechasNuevas= removerduplicados(FechasPelis);
                for(int i=0;i<=fechasNuevas.size()-1;i++){
                    fechaModel.addElement(fechasNuevas.get(i));
                }
            }
        });


        FechaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SalaBox.getItemCount()>1){
                    for(int i=0; i<=salas.size()-1; i++){
                        SalaBox.removeItem(salas.get(i));
                    }
                    salas.clear();
                }
                peliCambiar.setFecha(fechaModel.getSelectedItem().toString());
                try(MongoClient cliente1 = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente1.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("fecha")).equals(peliCambiar.getFecha()) && (documento3.getString("titulo")).equals(peliCambiar.getTitulo())){
                            salas.add(documento3.getString("sala"));
                        }
                    }
                }
                List<String> salasLimpiadas = removerduplicados(salas);
                for(int i=0;i<=salasLimpiadas.size()-1;i++){
                    salaModel.addElement(salasLimpiadas.get(i));
                }
            }
        });
        SalaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(HoraBox.getItemCount()>1){
                    HoraBox.removeAllItems();
                    horaModel.addElement("Hora");
                }
                peliCambiar.setSala(salaModel.getSelectedItem().toString());
                try(MongoClient cliente2 = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente2.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("titulo")).equals(peliCambiar.getTitulo()) && (documento3.getString("fecha")).equals(peliCambiar.getFecha())
                                && (documento3.getString("sala")).equals(peliCambiar.getSala())){
                            horaModel.addElement(documento3.getString("hora"));
                        }
                    }
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionPeliculas = new JFrame();
                gestionPeliculas.setTitle("PoliCine");
                gestionPeliculas.setContentPane(new GestionarPeliculas().MainPanel);
                gestionPeliculas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                gestionPeliculas.setSize(500, 300);
                gestionPeliculas.setLocationRelativeTo(null);
                gestionPeliculas.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                gestionPeliculas.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        cambiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fechaModel.getSelectedItem().toString().equals("Fecha") ||
                    salaModel.getSelectedItem().toString().equals("Sala") ||
                    horaModel.getSelectedItem().toString().equals("Hora") ||
                    anioModel.getSelectedItem().toString().equals("Año") ||
                    mesModel.getSelectedItem().toString().equals("Mes") ||
                    diaModel.getSelectedItem().toString().equals("Dia") ||
                    nuevaHoraModel.getSelectedItem().toString().equals("Hora") ||
                    nuevaSalaModel.getSelectedItem().toString().equals("Sala")){
                    JOptionPane.showMessageDialog(null,"Seleccione correctamente");

                }
                else{
                    PELICULAS peliActual = new PELICULAS();
                    String fechaActual = diaModel.getSelectedItem().toString()+"/"+mesModel.getSelectedItem().toString()
                            +"/"+anioModel.getSelectedItem().toString();
                    peliActual.setTitulo(peliCambiar.getTitulo());
                    peliActual.setHorario(nuevaHoraModel.getSelectedItem().toString());
                    peliActual.setSala(nuevaSalaModel.getSelectedItem().toString());
                    peliActual.setFecha(fechaActual);
                    peliCambiar.setHorario(horaModel.getSelectedItem().toString());
                    try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                        MongoDatabase base = cliente.getDatabase("Peliculas");
                        MongoCollection<Document> coleccion = base.getCollection("Datos_Peliculas");
                        Document buscar = new Document("titulo", peliCambiar.getTitulo()).append("fecha", peliCambiar.getFecha())
                                .append("sala", peliCambiar.getSala()).append("hora", peliCambiar.getHorario());
                        Document actualizar = new Document("$set",new Document("fecha",peliActual.getFecha()).append("sala", peliActual.getSala())
                                .append("hora", peliActual.getHorario()));
                        UpdateResult actualizacion = coleccion.updateOne(buscar, actualizar);
                        JOptionPane.showMessageDialog(null,"Horario modificado correctamente");
                    }
                    FechaBox.removeAllItems();
                    fechaModel.addElement("Fecha");
                    HoraBox.removeAllItems();
                    horaModel.addElement("Hora");
                    SalaBox.removeAllItems();
                    salaModel.addElement("Sala");
                }
            }
        });
    }
    public static <T> List<T> removerduplicados(List<T> lista){
        Set<T> set= new LinkedHashSet<>(lista);
        return new ArrayList<>(set);
    }
}
