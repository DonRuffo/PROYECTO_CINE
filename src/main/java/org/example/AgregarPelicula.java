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
                            int puerta=0;
                            PELICULAS peli1 = new PELICULAS();
                            SALAS salaGeneral = new SALAS();
                            peli1.setTitulo(TituloField.getText());
                            peli1.setCategoria(CateegoriaField.getText());
                            peli1.setPrecio(Float.parseFloat(PrecioField.getText()));
                            peli1.setRestriccion(edadModel.getSelectedItem().toString());
                            peli1.setSala(salaModel.getSelectedItem().toString());
                            peli1.setHorario(horarioModel.getSelectedItem().toString());
                            peli1.setAnio(anioModel.getSelectedItem().toString());
                            peli1.setMes(mesModel.getSelectedItem().toString());
                            peli1.setDia(diaModel.getSelectedItem().toString());
                            salaGeneral.setAsientos_vendidos("0");
                            salaGeneral.setAsientos_disponibles("200");
                            String fechas=peli1.getDia()+"/"+peli1.getMes()+"/"+peli1.getAnio();
                            try(MongoClient cliente= MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                                MongoDatabase peliculas=cliente.getDatabase("Peliculas");
                                MongoCollection<Document> datos=peliculas.getCollection("Datos_Peliculas");
                                System.out.println("CONEXION EXITOSA");
                                FindIterable<Document> documentos= datos.find();
                                for(Document documento:documentos) {
                                    if (peli1.getSala().equals(documento.getString("sala")) && peli1.getHorario().equals(documento.getString("hora")) &&
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
                                    puerta=1;
                                    ident=0;
                                }
                            }
                            if(puerta==1){
                                try(MongoClient definirsala = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                                    MongoDatabase sala=definirsala.getDatabase("Salas");
                                    MongoCollection<Document> datos=sala.getCollection("Sala"+peli1.getSala());
                                    Document insercion2= new Document("titulo",peli1.getTitulo())
                                            .append("hora",peli1.getHorario()).append("fecha",fechas)
                                            .append("asientos_disponibles",salaGeneral.getAsientos_disponibles())
                                            .append("asientos_vendidos",salaGeneral.getAsientos_vendidos())
                                            .append("1","libre").append("2","libre").append("3","libre")
                                            .append("4","libre").append("5","libre").append("6","libre")
                                            .append("7","libre").append("8","libre").append("9","libre")
                                            .append("10","libre").append("11","libre").append("12","libre")
                                            .append("13","libre").append("14","libre").append("15","libre")
                                            .append("16","libre").append("17","libre").append("18","libre")
                                            .append("19","libre").append("20","libre").append("21","libre")
                                            .append("22","libre").append("23","libre").append("24","libre")
                                            .append("25","libre").append("26","libre").append("27","libre")
                                            .append("28","libre").append("29","libre").append("30","libre")
                                            .append("31","libre").append("32","libre").append("33","libre")
                                            .append("34","libre").append("35","libre").append("36","libre")
                                            .append("37","libre").append("38","libre").append("39","libre")
                                            .append("40","libre").append("41","libre").append("42","libre")
                                            .append("43","libre").append("44","libre").append("45","libre")
                                            .append("46","libre").append("47","libre").append("48","libre")
                                            .append("49","libre").append("50","libre").append("51","libre")
                                            .append("52","libre").append("53","libre").append("54","libre")
                                            .append("55","libre").append("56","libre").append("57","libre")
                                            .append("58","libre").append("59","libre").append("60","libre")
                                            .append("61","libre").append("62","libre").append("63","libre")
                                            .append("64","libre").append("65","libre").append("66","libre")
                                            .append("67","libre").append("68","libre").append("69","libre")
                                            .append("70","libre").append("71","libre").append("72","libre")
                                            .append("73","libre").append("74","libre").append("75","libre")
                                            .append("76","libre").append("77","libre").append("78","libre")
                                            .append("79","libre").append("80","libre").append("81","libre")
                                            .append("82","libre").append("83","libre").append("84","libre")
                                            .append("85","libre").append("86","libre").append("87","libre")
                                            .append("88","libre").append("89","libre").append("90","libre")
                                            .append("91","libre").append("92","libre").append("93","libre")
                                            .append("94","libre").append("95","libre").append("96","libre")
                                            .append("97","libre").append("98","libre").append("99","libre")
                                            .append("100","libre").append("101","libre").append("102","libre")
                                            .append("103","libre").append("104","libre").append("105","libre")
                                            .append("106","libre").append("107","libre").append("108","libre")
                                            .append("109","libre").append("110","libre").append("111","libre")
                                            .append("112","libre").append("113","libre").append("114","libre")
                                            .append("115","libre").append("116","libre").append("117","libre")
                                            .append("118","libre").append("119","libre").append("120","libre")
                                            .append("121","libre").append("122","libre").append("123","libre")
                                            .append("124","libre").append("125","libre").append("126","libre")
                                            .append("127","libre").append("128","libre").append("129","libre")
                                            .append("130","libre").append("131","libre").append("132","libre")
                                            .append("133","libre").append("134","libre").append("135","libre")
                                            .append("136","libre").append("137","libre").append("138","libre")
                                            .append("139","libre").append("140","libre").append("141","libre")
                                            .append("142","libre").append("143","libre").append("144","libre")
                                            .append("145","libre").append("146","libre").append("147","libre")
                                            .append("148","libre").append("149","libre").append("150","libre")
                                            .append("151","libre").append("152","libre").append("153","libre")
                                            .append("154","libre").append("155","libre").append("156","libre")
                                            .append("157","libre").append("158","libre").append("159","libre")
                                            .append("160","libre").append("161","libre").append("162","libre")
                                            .append("163","libre").append("164","libre").append("165","libre")
                                            .append("166","libre").append("167","libre").append("168","libre")
                                            .append("169","libre").append("170","libre").append("171","libre")
                                            .append("172","libre").append("173","libre").append("174","libre")
                                            .append("175","libre").append("176","libre").append("177","libre")
                                            .append("178","libre").append("179","libre").append("180","libre")
                                            .append("181","libre").append("182","libre").append("183","libre")
                                            .append("184","libre").append("185","libre").append("186","libre")
                                            .append("187","libre").append("188","libre").append("189","libre")
                                            .append("190","libre").append("191","libre").append("192","libre")
                                            .append("193","libre").append("194","libre").append("195","libre")
                                            .append("196","libre").append("197","libre").append("198","libre")
                                            .append("199","libre").append("200","libre");
                                    datos.insertOne(insercion2);
                                    MongoDatabase base = definirsala.getDatabase(peli1.getAnio());
                                    MongoCollection<Document> datoMes = base.getCollection(peli1.getMes());
                                    MongoCollection<Document> anual = base.getCollection("Anual");

                                    Document insertar = new Document("titulo", peli1.getTitulo()).append("fecha", fechas)
                                            .append("sala", peli1.getSala()).append("hora", peli1.getHorario())
                                            .append("precio_asiento", peli1.getPrecio()).append("asientos_disponibles", "200")
                                            .append("asientos_vendidos", "0");
                                    datoMes.insertOne(insertar);
                                    anual.insertOne(insertar);
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
                gestionPeliculas.setSize(500, 350);
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

