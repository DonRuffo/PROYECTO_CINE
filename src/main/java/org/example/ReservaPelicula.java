package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.internal.BsonUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ReservaPelicula {
    private JComboBox PeliBox;
    private JComboBox FechaBox;
    private JComboBox SalaBox;
    private JComboBox HoraBox;
    private JButton pasarAEscogerUnButton;
    private JButton regresarButton;
    public JPanel MainPanel;

    DefaultComboBoxModel PeliModel = new DefaultComboBoxModel();
    DefaultComboBoxModel FechaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel SalaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel HoraModel = new DefaultComboBoxModel();

    PELICULAS peliReserva= new PELICULAS();

    public ReservaPelicula(){
        PeliBox.setModel(PeliModel);
        FechaBox.setModel(FechaModel);
        SalaBox.setModel(SalaModel);
        HoraBox.setModel(HoraModel);


        PeliModel.addElement("Pelicula");
        FechaModel.addElement("Fecha");
        SalaModel.addElement("Sala");
        HoraModel.addElement("Hora");

        java.util.List<String> pelis = new ArrayList<>();
        java.util.List<String> FechasPelis = new ArrayList<>();
        java.util.List<String> salas=new ArrayList<>();



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
            PeliModel.addElement(pelisnuevas.get(i));
        }
        pelis.clear();
        PeliBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FechaBox.getItemCount()>1){
                    for(int i = 0; i<= FechasPelis.size()-1; i++){
                        FechaBox.removeItem(FechasPelis.get(i));
                    }
                    FechasPelis.clear();
                }
                peliReserva.setTitulo(PeliModel.getSelectedItem().toString());
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("titulo")).equals(peliReserva.getTitulo())){
                            FechasPelis.add(documento3.getString("fecha"));
                        }
                    }
                }
                List<String> diasLimpios = removerduplicados(FechasPelis);
                for(int i=0; i<= diasLimpios.size()-1;i++){
                    FechaModel.addElement(diasLimpios.get(i));
                }
                diasLimpios.clear();
            }
        });
        FechaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SalaBox.getItemCount()>1){
                    for(int i=0; i<=salas.size()-1;i++){
                        SalaBox.removeItem(salas.get(i));
                    }salas.clear();
                }

                peliReserva.setFecha(FechaModel.getSelectedItem().toString());
                try(MongoClient cliente1 = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente1.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("fecha")).equals(peliReserva.getFecha()) && (documento3.getString("titulo")).equals(peliReserva.getTitulo())){
                            salas.add(documento3.getString("sala"));
                        }
                    }
                }
                List<String> SalasLimpias = removerduplicados(salas);
                for(int i = 0; i<= SalasLimpias.size()-1; i++){
                    SalaModel.addElement(SalasLimpias.get(i));
                }
                SalasLimpias.clear();
            }
        });
        SalaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(HoraBox.getItemCount()>1){
                    HoraBox.removeAllItems();
                    HoraModel.addElement("Hora");
                }

                peliReserva.setSala(SalaModel.getSelectedItem().toString());
                try(MongoClient cliente2 = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente2.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    FindIterable<Document> documento=coleccion.find();
                    for(Document documento3 : documento){
                        if((documento3.getString("titulo")).equals(peliReserva.getTitulo()) && (documento3.getString("fecha")).equals(peliReserva.getFecha())
                                && (documento3.getString("sala")).equals(peliReserva.getSala())){
                            HoraModel.addElement(documento3.getString("hora"));
                        }
                    }
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame paginaClientes = new JFrame();
                paginaClientes.setTitle("PoliCine");
                paginaClientes.setContentPane(new PaginaClientes().MainPanel);
                paginaClientes.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                paginaClientes.setSize(500, 350);
                paginaClientes.setLocationRelativeTo(null);
                paginaClientes.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                paginaClientes.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        pasarAEscogerUnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peliReserva.setTitulo(PeliModel.getSelectedItem().toString());
                peliReserva.setFecha(FechaModel.getSelectedItem().toString());
                peliReserva.setSala(SalaModel.getSelectedItem().toString());
                peliReserva.setHorario(HoraModel.getSelectedItem().toString());
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase basedeDatos = cliente.getDatabase("Caché");
                    MongoCollection<Document> coleccion = basedeDatos.getCollection("CacheBase");

                    Document insercionCache = new Document("titulo", peliReserva.getTitulo()).append("fecha",peliReserva.getFecha())
                            .append("sala", peliReserva.getSala()). append("hora", peliReserva.getHorario());
                    coleccion.insertOne(insercionCache);
                }
                JFrame reservas = new JFrame();
                reservas.setTitle("PoliCine");
                reservas.setContentPane(new AsientosSala().MaiinPanel);
                reservas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                reservas.setSize(1350, 700);
                reservas.setLocationRelativeTo(null);
                reservas.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                reservas.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(pasarAEscogerUnButton)).dispose();
            }
        });

    }

    public static <T> List<T> removerduplicados(List<T> lista){
        Set<T> set= new LinkedHashSet<>(lista);
        return new ArrayList<>(set);
    }
}
