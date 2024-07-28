package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AgregarPelicula {
    private JTextField TituloField;
    private JTextField CateegoriaField;
    private JTextField PrecioField;
    private JButton agregarButton;
    public JPanel MainPanel;
    private JComboBox HorarioBox;
    private JComboBox SalaBox;
    private JComboBox EdadBox;
    private JButton regresarButton;
    private JComboBox AnioBox;
    private JComboBox MesBox;
    private JComboBox DiaBox;

    DefaultComboBoxModel horarioModel=new DefaultComboBoxModel();
    DefaultComboBoxModel salaModel=new DefaultComboBoxModel();
    DefaultComboBoxModel edadModel=new DefaultComboBoxModel();
    DefaultComboBoxModel anioModel=new DefaultComboBoxModel();
    DefaultComboBoxModel mesModel=new DefaultComboBoxModel();
    DefaultComboBoxModel diaModel=new DefaultComboBoxModel();


    public AgregarPelicula() {
        Border borde = BorderFactory.createLineBorder(Color.black,2);
        TituloField.setBorder(borde);
        PrecioField.setBorder(borde);
        CateegoriaField.setBorder(borde);
        HorarioBox.setModel(horarioModel);
        horarioModel.addElement("12:00");
        horarioModel.addElement("15:00");
        horarioModel.addElement("18:00");
        horarioModel.addElement("21:00");
        SalaBox.setModel(salaModel);

        for(int i=1; i<=10; i++){
            salaModel.addElement(i);
        }

        EdadBox.setModel(edadModel);
        edadModel.addElement("Familiar");
        edadModel.addElement("+15");
        edadModel.addElement("+18");

        AnioBox.setModel(anioModel);
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

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ident=0;
                if (TituloField.getText().isEmpty() || CateegoriaField.getText().isEmpty() || PrecioField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos");
                }else{
                    Boolean comprobarCat= letrassinnumeros(CateegoriaField.getText());
                    Boolean comprobarPrecio= numero(PrecioField.getText());
                    if(comprobarCat==false){
                        JOptionPane.showMessageDialog(null, "No ingrese numeros en la Categoría");
                    }else{
                        if(comprobarPrecio==false){
                            JOptionPane.showMessageDialog(null,"No ingrese letras en el precio");
                        }else{
                            PELICULAS peli1 = new PELICULAS();
                            peli1.setTitulo(TituloField.getText());
                            peli1.setCategoria(CateegoriaField.getText());
                            peli1.setPrecio(Float.parseFloat(PrecioField.getText()));
                            peli1.setRestriccion(edadModel.getSelectedItem().toString());
                            peli1.setSala(salaModel.getSelectedItem().toString());
                            peli1.setHorario(horarioModel.getSelectedItem().toString());
                            peli1.setAnio(anioModel.getSelectedItem().toString());
                            peli1.setMes(mesModel.getSelectedItem().toString());
                            peli1.setDia(diaModel.getSelectedItem().toString());
                            try(MongoClient cliente= MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                                MongoDatabase peliculas=cliente.getDatabase("Peliculas");
                                MongoCollection<Document> datos=peliculas.getCollection("Datos_Peliculas");
                                System.out.println("CONEXION EXITOSA");
                                String fechas=peli1.getDia()+"/"+peli1.getMes()+"/"+peli1.getAnio();
                                FindIterable<Document> documentos= datos.find();
                                for(Document documento:documentos) {
                                    if (Objects.equals(peli1.getSala(), documento.getString("sala")) && peli1.getHorario().equals(documento.getString("hora")) &&
                                            fechas.equals(documento.getString("fecha"))){
                                        ident = 1;
                                    }
                                }
                                if (ident==1){
                                    JOptionPane.showMessageDialog(null,"La hora "+peli1.getHorario()+" en la sala "+peli1.getSala()+" con fecha:"
                                            +fechas+" está ocupado."+" Seleccione otro horario, sala o fecha");
                                }else{
                                    Document insercion=new Document("titulo",peli1.getTitulo()).append("categoria",peli1.getCategoria())
                                            .append("hora",peli1.getHorario()).append("sala", peli1.getSala())
                                            .append("precio_asiento", peli1.getPrecio()).append("restriccion_edad",peli1.getRestriccion())
                                            .append("fecha",fechas);
                                    datos.insertOne(insercion);
                                    JOptionPane.showMessageDialog(null,"Registro Exitoso");
                                    TituloField.setText("");
                                    CateegoriaField.setText("");
                                    PrecioField.setText("");
                                    ident=0;
                                }
                            }
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
    }
    public boolean numero(String cadena){
        try{
            Double.parseDouble(cadena);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public boolean letrassinnumeros(String cadena){
        for(int i=0; i<cadena.length();i++){
            if(Character.isDigit(cadena.charAt(i))){
                return false;
            }
        }
        return true;
    }
}

