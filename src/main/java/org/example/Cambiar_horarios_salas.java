package org.example;

import com.mongodb.client.*;
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

        List<String> horarios= new ArrayList<>();
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

    }
    public static <T> List<T> removerduplicados(List<T> lista){
        Set<T> set= new LinkedHashSet<>(lista);
        return new ArrayList<>(set);
    }
}
