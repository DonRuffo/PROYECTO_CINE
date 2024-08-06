package org.example;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import javax.print.Doc;
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
            public void actionPerformed(ActionEvent a) {
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
            public void actionPerformed(ActionEvent b) {
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
                fechasNuevas.clear();
            }
        });


        FechaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent c) {
                if(SalaBox.getItemCount()>1){
                    for(int i=0; i<=salas.size()-1;i++){
                        SalaBox.removeItem(salas.get(i));
                    }salas.clear();
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
                salasLimpiadas.clear();
            }
        });
        SalaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent d) {
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
                gestionPeliculas.setSize(500, 350);
                gestionPeliculas.setLocationRelativeTo(null);
                gestionPeliculas.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                gestionPeliculas.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        cambiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
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
                    peliActual.setMes(mesModel.getSelectedItem().toString());
                    peliActual.setAnio(anioModel.getSelectedItem().toString());
                    peliCambiar.setHorario(horaModel.getSelectedItem().toString());
                    String anioAcambiar= peliCambiar.getFecha().substring(6,10);
                    String mesAcambiar= peliCambiar.getFecha().substring(3,5);
                    int ident=0;
                    String valor = "";
                    try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                        MongoDatabase base = cliente.getDatabase("Peliculas");
                        MongoCollection<Document> coleccion = base.getCollection("Datos_Peliculas");

                        FindIterable<Document> documentos = coleccion.find();
                        for(Document documento:documentos) {
                            if (peliActual.getSala().equals(documento.getString("sala")) && peliActual.getHorario().equals(documento.getString("hora")) &&
                                    peliActual.getFecha().equals(documento.getString("fecha"))){
                                ident = 1;
                            }
                        }
                        if(ident==0){
                            MongoDatabase Historial = cliente.getDatabase(anioAcambiar);
                            MongoCollection<Document> histColeccion = Historial.getCollection(mesAcambiar);
                            MongoCollection<Document> anualColeccion = Historial.getCollection("Anual");
                            FindIterable<Document> busquedaVentas = histColeccion.find();
                            for(Document busqueda:busquedaVentas){
                                if((busqueda.getString("titulo")).equals(peliCambiar.getTitulo()) && (busqueda.getString("fecha")).equals(peliCambiar.getFecha())
                                    && (busqueda.getString("sala")).equals(peliCambiar.getSala()) && (busqueda.getString("hora")).equals(peliCambiar.getHorario())){
                                    valor=busqueda.getString("asientos_vendidos");
                                }
                            }
                            System.out.println(valor);
                            if(valor.equals("0")){
                                //documento de búsqueda en general
                                Document buscar = new Document("titulo", peliCambiar.getTitulo()).append("fecha", peliCambiar.getFecha())
                                        .append("sala", peliCambiar.getSala()).append("hora", peliCambiar.getHorario());

                                //Documento para buscar en coleccion Salas
                                Document buscar2 = new Document("titulo", peliCambiar.getTitulo()).append("fecha", peliCambiar.getFecha())
                                        .append("hora", peliCambiar.getHorario());

                                //actualiza la cartelera
                                Document actualizar = new Document("$set",new Document("fecha",peliActual.getFecha()).append("sala", peliActual.getSala())
                                        .append("hora", peliActual.getHorario()));

                                //actualiza la coleccion Salas
                                Document actualizarMiSala = new Document("$set", new Document("fecha",peliActual.getFecha())
                                        .append("hora", peliActual.getHorario()));

                                //nuevo documento para insertar en el historial del nuevo horario de la pelicula
                                Document insercionCambio = new Document("titulo", peliActual.getTitulo()).append("fecha", peliActual.getFecha())
                                        .append("sala", peliActual.getSala()).append("hora", peliActual.getHorario())
                                        .append("precio_asiento", peliActual.getPrecio()).append("asientos_disponibles", "200")
                                        .append("asientos_vendidos", "0");

                                //Documento para insertar una nueva sala al cambiar el horario
                                Document ActualizarSala= new Document("titulo",peliActual.getTitulo())
                                        .append("hora",peliActual.getHorario()).append("fecha",peliActual.getFecha())
                                        .append("asientos_disponibles","200")
                                        .append("asientos_vendidos","0")
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

                                //ejecucion en la cartelera
                                UpdateResult actualizacion = coleccion.updateOne(buscar, actualizar);

                                //eliminar la pelicula con su antiguo horario del historial
                                DeleteResult eliminardeHistorial = histColeccion.deleteOne(buscar);
                                DeleteResult eliminardelAnual = anualColeccion.deleteOne(buscar);

                                //agregar el documento con su nuevo horario en el nuevo historial
                                MongoDatabase Historialnuevo = cliente.getDatabase(peliActual.getAnio());
                                MongoCollection<Document> nuevoHist = Historialnuevo.getCollection(peliActual.getMes());
                                MongoCollection<Document> nuevoEnAnual = Historialnuevo.getCollection("Anual");
                                nuevoHist.insertOne(insercionCambio);
                                nuevoEnAnual.insertOne(insercionCambio);

                                //ejecución de la actualización para la coleccion Salas
                                MongoDatabase baseSalas = cliente.getDatabase("Salas");
                                MongoCollection<Document> coleccionSalas = baseSalas.getCollection("Sala"+peliCambiar.getSala());
                                MongoCollection<Document> coleccionSalasActual = baseSalas.getCollection("Sala"+peliActual.getSala());
                                DeleteResult eliminandoSala = coleccionSalas.deleteOne(buscar2);
                                coleccionSalasActual.insertOne(ActualizarSala);


                                //verificacion
                                JOptionPane.showMessageDialog(null,"Horario modificado correctamente");
                            }else{
                                JOptionPane.showMessageDialog(null, "Esta pelicula ya registra reservas, no se puede modificar");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"El horario seleccionado se encuntra ocupado");
                            ident=0;
                        }

                    }
                    //eliiminacion de valores antiguos de los JComboBox
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
                    if(HoraBox.getItemCount()>1){
                        HoraBox.removeAllItems();
                        horaModel.addElement("Hora");
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
