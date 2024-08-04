package org.example;

import com.mongodb.client.*;
import com.mongodb.internal.operation.FindAndDeleteOperation;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class AsientosSala {
    private JButton a1;
    private JLabel AsientosLabel;
    public JPanel MaiinPanel;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    private JButton a5;
    private JButton a6;
    private JButton a7;
    private JButton a8;
    private JButton a9;
    private JButton a10;
    private JButton a11;
    private JButton a12;
    private JButton a13;
    private JButton a14;
    private JButton a15;
    private JButton a29;
    private JButton a43;
    private JButton a57;
    private JButton a71;
    private JButton a85;
    private JButton a99;
    private JButton a113;
    private JButton a127;
    private JButton a141;
    private JButton a155;
    private JButton a16;
    private JButton a17;
    private JButton a18;
    private JButton a19;
    private JButton a20;
    private JButton a21;
    private JButton a22;
    private JButton a23;
    private JButton a24;
    private JButton a25;
    private JButton a26;
    private JButton a27;
    private JButton a28;
    private JButton a42;
    private JButton a56;
    private JButton a55;
    private JButton a41;
    private JButton a40;
    private JButton a39;
    private JButton a38;
    private JButton a37;
    private JButton a36;
    private JButton a35;
    private JButton a34;
    private JButton a33;
    private JButton a32;
    private JButton a31;
    private JButton a30;
    private JButton a44;
    private JButton a58;
    private JButton a72;
    private JButton a86;
    private JButton a100;
    private JButton a114;
    private JButton a128;
    private JButton a142;
    private JButton a156;
    private JButton a157;
    private JButton a158;
    private JButton a159;
    private JButton a160;
    private JButton a161;
    private JButton a162;
    private JButton a163;
    private JButton a164;
    private JButton a165;
    private JButton a166;
    private JButton a167;
    private JButton a168;
    private JButton a154;
    private JButton a140;
    private JButton a126;
    private JButton a112;
    private JButton a98;
    private JButton a84;
    private JButton a70;
    private JButton a69;
    private JButton a83;
    private JButton a97;
    private JButton a111;
    private JButton a125;
    private JButton a139;
    private JButton a153;
    private JButton a152;
    private JButton a138;
    private JButton a124;
    private JButton a110;
    private JButton a96;
    private JButton a82;
    private JButton a68;
    private JButton a54;
    private JButton a53;
    private JButton a52;
    private JButton a51;
    private JButton a50;
    private JButton a49;
    private JButton a48;
    private JButton a47;
    private JButton a46;
    private JButton a45;
    private JButton a59;
    private JButton a73;
    private JButton a87;
    private JButton a101;
    private JButton a115;
    private JButton a129;
    private JButton a143;
    private JButton a144;
    private JButton a130;
    private JButton a131;
    private JButton a145;
    private JButton a146;
    private JButton a132;
    private JButton a133;
    private JButton a147;
    private JButton a134;
    private JButton a148;
    private JButton a135;
    private JButton a136;
    private JButton a137;
    private JButton a149;
    private JButton a150;
    private JButton a151;
    private JButton a123;
    private JButton a109;
    private JButton a95;
    private JButton a81;
    private JButton a67;
    private JButton a66;
    private JButton a65;
    private JButton a64;
    private JButton a63;
    private JButton a62;
    private JButton a61;
    private JButton a60;
    private JButton a74;
    private JButton a75;
    private JButton a88;
    private JButton a102;
    private JButton a116;
    private JButton a117;
    private JButton a103;
    private JButton a89;
    private JButton a76;
    private JButton a90;
    private JButton a104;
    private JButton a118;
    private JButton a119;
    private JButton a105;
    private JButton a91;
    private JButton a77;
    private JButton a78;
    private JButton a92;
    private JButton a106;
    private JButton a120;
    private JButton a121;
    private JButton a107;
    private JButton a93;
    private JButton a79;
    private JButton a80;
    private JButton a94;
    private JButton a108;
    private JButton a122;
    private JButton a170;
    private JButton a171;
    private JButton a172;
    private JButton a173;
    private JButton a174;
    private JButton a175;
    private JButton a176;
    private JButton a177;
    private JButton a178;
    private JButton a179;
    private JButton a180;
    private JButton a181;
    private JButton a182;
    private JButton a183;
    private JButton a184;
    private JButton a169;
    private JButton a185;
    private JButton a186;
    private JButton a187;
    private JButton a188;
    private JButton a189;
    private JButton a190;
    private JButton a191;
    private JButton a192;
    private JButton a193;
    private JButton a194;
    private JButton a195;
    private JButton a196;
    private JButton a197;
    private JButton a198;
    private JButton a199;
    private JButton a200;
    private JButton regresarButton;
    private JButton reservarButton;
    private JButton reelegirButton;
    private JLabel PrecioLabel;

    public AsientosSala() {
        PELICULAS nueva = new PELICULAS();

        try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
            MongoDatabase baseDeDatos = cliente.getDatabase("Caché");
            MongoCollection<Document> coleccion1 = baseDeDatos.getCollection("CacheBase");
            FindIterable<Document> buscar = coleccion1.find();
            for(Document documento : buscar){
                nueva.setTitulo(documento.getString("titulo"));
                nueva.setSala(documento.getString("sala"));
                nueva.setFecha(documento.getString("fecha"));
                nueva.setHorario(documento.getString("hora"));
            }
        }
        try(MongoClient cliente2 = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
            MongoDatabase baseDeDatos = cliente2.getDatabase("Peliculas");
            MongoCollection<Document> coleccion2 = baseDeDatos.getCollection("Datos_Peliculas");
            FindIterable<Document> buscarPrecio = coleccion2.find();
            for(Document documento : buscarPrecio){
                if((documento.getString("titulo").equals(nueva.getTitulo())) && (documento.getString("fecha")).equals(nueva.getFecha())
                && (documento.getString("sala")).equals(nueva.getSala()) && (documento.getString("hora")).equals(nueva.getHorario())){
                    nueva.setPrecio(documento.getDouble("precio_asiento"));
                }
            }
        }
        try(MongoClient cliente3 =MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
            MongoDatabase baseDeDatos = cliente3.getDatabase("Salas");
            MongoCollection<Document> coleccion3 = baseDeDatos.getCollection("Sala"+nueva.getSala());

            FindIterable<Document> busqueda = coleccion3.find();
            for(Document documento : busqueda){
                if((documento.getString("pelicula")).equals(nueva.getTitulo()) && (documento.getString("fecha")).equals(nueva.getFecha())
                    && (documento.getString("hora").equals(nueva.getHorario()))){
                    if((documento.getString("1")).equals("ocupado")){
                        a1.setBackground(Color.RED);
                        a1.setForeground(Color.BLACK); //boton1
                    }
                    if((documento.getString("2")).equals("ocupado")){
                        a2.setBackground(Color.RED);
                        a2.setForeground(Color.BLACK); //boton2
                    }
                    if((documento.getString("3")).equals("ocupado")){
                        a3.setBackground(Color.RED); //boton3
                        a3.setForeground(Color.BLACK);
                    }
                    if((documento.getString("4")).equals("ocupado")){
                        a4.setBackground(Color.RED); //boton4
                        a4.setForeground(Color.BLACK);
                    }
                    if((documento.getString("5")).equals("ocupado")){
                        a5.setBackground(Color.RED); //boton5
                        a5.setForeground(Color.BLACK);
                    }
                    if((documento.getString("6")).equals("ocupado")){
                        a6.setBackground(Color.RED); // boton6
                        a6.setForeground(Color.BLACK);
                    }
                    if((documento.getString("7")).equals("ocupado")){
                        a7.setBackground(Color.RED); //boton7
                        a7.setForeground(Color.BLACK);
                    }
                    if((documento.getString("8")).equals("ocupado")){
                        a8.setBackground(Color.RED); //boton8
                        a8.setForeground(Color.BLACK);
                    }
                    if((documento.getString("9")).equals("ocupado")){
                        a9.setBackground(Color.RED);
                        a9.setForeground(Color.BLACK);
                    }
                    if((documento.getString("10")).equals("ocupado")){
                        a10.setBackground(Color.RED);
                        a10.setForeground(Color.BLACK);
                    }
                    if((documento.getString("11")).equals("ocupado")){
                        a11.setBackground(Color.RED);
                        a11.setForeground(Color.BLACK);
                    }
                    if((documento.getString("12")).equals("ocupado")){
                        a12.setBackground(Color.RED);
                        a12.setForeground(Color.BLACK);
                    }
                    if((documento.getString("13")).equals("ocupado")){
                        a13.setBackground(Color.RED);
                        a13.setForeground(Color.BLACK);
                    }if((documento.getString("14")).equals("ocupado")){
                        a14.setBackground(Color.RED);
                        a14.setForeground(Color.BLACK);
                    }
                    if((documento.getString("15")).equals("ocupado")){
                        a15.setBackground(Color.RED);
                        a15.setForeground(Color.BLACK);
                    }if((documento.getString("16")).equals("ocupado")){
                        a16.setBackground(Color.RED);
                        a16.setForeground(Color.BLACK);
                    }if((documento.getString("17")).equals("ocupado")){
                        a17.setBackground(Color.RED);
                        a17.setForeground(Color.BLACK);
                    }if((documento.getString("18")).equals("ocupado")){
                        a18.setBackground(Color.RED);
                        a18.setForeground(Color.BLACK);
                    }if((documento.getString("19")).equals("ocupado")){
                        a19.setBackground(Color.RED);
                        a19.setForeground(Color.BLACK);
                    }
                    if((documento.getString("20")).equals("ocupado")){
                        a20.setBackground(Color.RED);
                        a20.setForeground(Color.BLACK);
                    }
                    if((documento.getString("21")).equals("ocupado")){
                        a21.setBackground(Color.RED);
                        a21.setForeground(Color.BLACK);
                    }if((documento.getString("22")).equals("ocupado")){
                        a22.setBackground(Color.RED);
                        a22.setForeground(Color.BLACK);
                    }if((documento.getString("23")).equals("ocupado")){
                        a23.setBackground(Color.RED);
                        a23.setForeground(Color.BLACK);
                    }if((documento.getString("24")).equals("ocupado")){
                        a24.setBackground(Color.RED);
                        a24.setForeground(Color.BLACK);
                    }
                    if((documento.getString("25")).equals("ocupado")){
                        a25.setBackground(Color.RED);
                        a25.setForeground(Color.BLACK);
                    }if((documento.getString("26")).equals("ocupado")){
                        a26.setBackground(Color.RED);
                        a26.setForeground(Color.BLACK);
                    }if((documento.getString("27")).equals("ocupado")){
                        a27.setBackground(Color.RED);
                        a27.setForeground(Color.BLACK);
                    }
                    if((documento.getString("28")).equals("ocupado")){
                        a28.setBackground(Color.RED);
                        a28.setForeground(Color.BLACK);
                    }if((documento.getString("29")).equals("ocupado")){
                        a29.setBackground(Color.RED);
                        a29.setForeground(Color.BLACK);
                    }if((documento.getString("30")).equals("ocupado")){
                        a30.setBackground(Color.RED);
                        a30.setForeground(Color.BLACK);
                    }if((documento.getString("31")).equals("ocupado")){
                        a31.setBackground(Color.RED);
                        a31.setForeground(Color.BLACK);
                    }if((documento.getString("32")).equals("ocupado")){
                        a32.setBackground(Color.RED);
                        a32.setForeground(Color.BLACK);
                    }if((documento.getString("33")).equals("ocupado")){
                        a33.setBackground(Color.RED);
                        a33.setForeground(Color.BLACK);
                    }if((documento.getString("34")).equals("ocupado")){
                        a34.setBackground(Color.RED);
                        a34.setForeground(Color.BLACK);
                    }if((documento.getString("35")).equals("ocupado")){
                        a35.setBackground(Color.RED);
                        a35.setForeground(Color.BLACK);
                    }if((documento.getString("36")).equals("ocupado")){
                        a36.setBackground(Color.RED);
                        a36.setForeground(Color.BLACK);
                    }if((documento.getString("37")).equals("ocupado")){
                        a37.setBackground(Color.RED);
                        a37.setForeground(Color.BLACK);
                    }if((documento.getString("38")).equals("ocupado")){
                        a38.setBackground(Color.RED);
                        a38.setForeground(Color.BLACK);
                    }if((documento.getString("39")).equals("ocupado")){
                        a39.setBackground(Color.RED);
                        a39.setForeground(Color.BLACK);
                    }if((documento.getString("40")).equals("ocupado")){
                        a40.setBackground(Color.RED);
                        a40.setForeground(Color.BLACK);
                    }
                    if((documento.getString("41")).equals("ocupado")){
                        a41.setBackground(Color.RED);
                        a41.setForeground(Color.BLACK);
                    }if((documento.getString("42")).equals("ocupado")){
                        a42.setBackground(Color.RED);
                        a42.setForeground(Color.BLACK);
                    }if((documento.getString("43")).equals("ocupado")){
                        a43.setBackground(Color.RED);
                        a43.setForeground(Color.BLACK);
                    }
                    if((documento.getString("44")).equals("ocupado")){
                        a44.setBackground(Color.RED);
                        a44.setForeground(Color.BLACK);
                    }if((documento.getString("45")).equals("ocupado")){
                        a45.setBackground(Color.RED);
                        a45.setForeground(Color.BLACK);
                    }if((documento.getString("46")).equals("ocupado")){
                        a46.setBackground(Color.RED);
                        a46.setForeground(Color.BLACK);
                    }if((documento.getString("47")).equals("ocupado")){
                        a47.setBackground(Color.RED);
                        a47.setForeground(Color.BLACK);
                    }
                    if((documento.getString("48")).equals("ocupado")){
                        a48.setBackground(Color.RED);
                        a48.setForeground(Color.BLACK);
                    }
                    if((documento.getString("49")).equals("ocupado")){
                        a49.setBackground(Color.RED);
                        a49.setForeground(Color.BLACK);
                    }
                    if((documento.getString("50")).equals("ocupado")){
                        a50.setBackground(Color.RED);
                        a50.setForeground(Color.BLACK);
                    }
                    if((documento.getString("51")).equals("ocupado")){
                        a51.setBackground(Color.RED);
                        a51.setForeground(Color.BLACK);
                    }
                    if((documento.getString("52")).equals("ocupado")){
                        a52.setBackground(Color.RED);
                        a52.setForeground(Color.BLACK);
                    }
                    if((documento.getString("53")).equals("ocupado")){
                        a53.setBackground(Color.RED);
                        a53.setForeground(Color.BLACK);
                    }
                    if((documento.getString("54")).equals("ocupado")){
                        a54.setBackground(Color.RED);
                        a54.setForeground(Color.BLACK);
                    }
                    if((documento.getString("55")).equals("ocupado")){
                        a55.setBackground(Color.RED);
                        a55.setForeground(Color.BLACK);
                    }
                    if((documento.getString("56")).equals("ocupado")){
                        a56.setBackground(Color.RED);
                        a56.setForeground(Color.BLACK);
                    }
                    if((documento.getString("57")).equals("ocupado")){
                        a57.setBackground(Color.RED);
                        a57.setForeground(Color.BLACK);
                    }
                    if((documento.getString("58")).equals("ocupado")){
                        a58.setBackground(Color.RED);
                        a58.setForeground(Color.BLACK);
                    }
                    if((documento.getString("59")).equals("ocupado")){
                        a59.setBackground(Color.RED);
                        a59.setForeground(Color.BLACK);
                    }
                    if((documento.getString("60")).equals("ocupado")){
                        a60.setBackground(Color.RED);
                        a60.setForeground(Color.BLACK);
                    }
                    if((documento.getString("61")).equals("ocupado")){
                        a61.setBackground(Color.RED);
                        a61.setForeground(Color.BLACK);
                    }if((documento.getString("62")).equals("ocupado")){
                        a62.setBackground(Color.RED);
                        a62.setForeground(Color.BLACK);
                    }if((documento.getString("63")).equals("ocupado")){
                        a63.setBackground(Color.RED);
                        a63.setForeground(Color.BLACK);
                    }if((documento.getString("64")).equals("ocupado")){
                        a64.setBackground(Color.RED);
                        a64.setForeground(Color.BLACK);
                    }if((documento.getString("65")).equals("ocupado")){
                        a65.setBackground(Color.RED);
                        a65.setForeground(Color.BLACK);
                    }if((documento.getString("66")).equals("ocupado")){
                        a66.setBackground(Color.RED);
                        a66.setForeground(Color.BLACK);
                    }if((documento.getString("67")).equals("ocupado")){
                        a67.setBackground(Color.RED);
                        a67.setForeground(Color.BLACK);
                    }
                    if((documento.getString("68")).equals("ocupado")){
                        a68.setBackground(Color.RED);
                        a68.setForeground(Color.BLACK);
                    }if((documento.getString("69")).equals("ocupado")){
                        a69.setBackground(Color.RED);
                        a69.setForeground(Color.BLACK);
                    }if((documento.getString("70")).equals("ocupado")){
                        a70.setBackground(Color.RED);
                        a70.setForeground(Color.BLACK);
                    }if((documento.getString("71")).equals("ocupado")){
                        a71.setBackground(Color.RED);
                        a71.setForeground(Color.BLACK);
                    }if((documento.getString("72")).equals("ocupado")){
                        a72.setBackground(Color.RED);
                        a72.setForeground(Color.BLACK);
                    }if((documento.getString("73")).equals("ocupado")){
                        a73.setBackground(Color.RED);
                        a73.setForeground(Color.BLACK);
                    }if((documento.getString("74")).equals("ocupado")){
                        a74.setBackground(Color.RED);
                        a74.setForeground(Color.BLACK);
                    }if((documento.getString("75")).equals("ocupado")){
                        a75.setBackground(Color.RED);
                        a75.setForeground(Color.BLACK);
                    }if((documento.getString("76")).equals("ocupado")){
                        a76.setBackground(Color.RED);
                        a76.setForeground(Color.BLACK);
                    }if((documento.getString("77")).equals("ocupado")){
                        a77.setBackground(Color.RED);
                        a77.setForeground(Color.BLACK);
                    }if((documento.getString("78")).equals("ocupado")){
                        a78.setBackground(Color.RED);
                        a78.setForeground(Color.BLACK);
                    }if((documento.getString("79")).equals("ocupado")){
                        a79.setBackground(Color.RED);
                        a79.setForeground(Color.BLACK);
                    }if((documento.getString("80")).equals("ocupado")){
                        a80.setBackground(Color.RED);
                        a80.setForeground(Color.BLACK);
                    }if((documento.getString("81")).equals("ocupado")){
                        a81.setBackground(Color.RED);
                        a81.setForeground(Color.BLACK);
                    }if((documento.getString("82")).equals("ocupado")){
                        a82.setBackground(Color.RED);
                        a82.setForeground(Color.BLACK);
                    }if((documento.getString("83")).equals("ocupado")){
                        a83.setBackground(Color.RED);
                        a83.setForeground(Color.BLACK);
                    }if((documento.getString("84")).equals("ocupado")){
                        a84.setBackground(Color.RED);
                        a84.setForeground(Color.BLACK);
                    }if((documento.getString("85")).equals("ocupado")){
                        a85.setBackground(Color.RED);
                        a85.setForeground(Color.BLACK);
                    }if((documento.getString("86")).equals("ocupado")){
                        a86.setBackground(Color.RED);
                        a86.setForeground(Color.BLACK);
                    }if((documento.getString("87")).equals("ocupado")){
                        a87.setBackground(Color.RED);
                        a87.setForeground(Color.BLACK);
                    }
                    if((documento.getString("88")).equals("ocupado")){
                        a88.setBackground(Color.RED);
                        a88.setForeground(Color.BLACK);
                    }
                    if((documento.getString("89")).equals("ocupado")){
                        a89.setBackground(Color.RED);
                        a89.setForeground(Color.BLACK);
                    }
                    if((documento.getString("90")).equals("ocupado")){
                        a90.setBackground(Color.RED);
                        a90.setForeground(Color.BLACK);
                    }
                    if((documento.getString("91")).equals("ocupado")){
                        a91.setBackground(Color.RED);
                        a91.setForeground(Color.BLACK);
                    }if((documento.getString("92")).equals("ocupado")){
                        a92.setBackground(Color.RED);
                        a92.setForeground(Color.BLACK);
                    }if((documento.getString("93")).equals("ocupado")){
                        a93.setBackground(Color.RED);
                        a93.setForeground(Color.BLACK);
                    }if((documento.getString("94")).equals("ocupado")){
                        a94.setBackground(Color.RED);
                        a94.setForeground(Color.BLACK);
                    }if((documento.getString("95")).equals("ocupado")){
                        a95.setBackground(Color.RED);
                        a95.setForeground(Color.BLACK);
                    }if((documento.getString("96")).equals("ocupado")){
                        a96.setBackground(Color.RED);
                        a96.setForeground(Color.BLACK);
                    }if((documento.getString("97")).equals("ocupado")){
                        a97.setBackground(Color.RED);
                        a97.setForeground(Color.BLACK);
                    }if((documento.getString("98")).equals("ocupado")){
                        a98.setBackground(Color.RED);
                        a98.setForeground(Color.BLACK);
                    }if((documento.getString("99")).equals("ocupado")){
                        a99.setBackground(Color.RED);
                        a99.setForeground(Color.BLACK);
                    }if((documento.getString("100")).equals("ocupado")){
                        a100.setBackground(Color.RED);
                        a100.setForeground(Color.BLACK);
                    }if((documento.getString("101")).equals("ocupado")){
                        a101.setBackground(Color.RED);
                        a101.setForeground(Color.BLACK);
                    }if((documento.getString("102")).equals("ocupado")){
                        a102.setBackground(Color.RED);
                        a102.setForeground(Color.BLACK);
                    }if((documento.getString("103")).equals("ocupado")){
                        a103.setBackground(Color.RED);
                        a103.setForeground(Color.BLACK);
                    }if((documento.getString("104")).equals("ocupado")){
                        a104.setBackground(Color.RED);
                        a104.setForeground(Color.BLACK);
                    }if((documento.getString("105")).equals("ocupado")){
                        a105.setBackground(Color.RED);
                        a105.setForeground(Color.BLACK);
                    }if((documento.getString("106")).equals("ocupado")){
                        a106.setBackground(Color.RED);
                        a106.setForeground(Color.BLACK);
                    }if((documento.getString("107")).equals("ocupado")){
                        a107.setBackground(Color.RED);
                        a107.setForeground(Color.BLACK);
                    }if((documento.getString("108")).equals("ocupado")){
                        a108.setBackground(Color.RED);
                        a108.setForeground(Color.BLACK);
                    }if((documento.getString("109")).equals("ocupado")){
                        a109.setBackground(Color.RED);
                        a109.setForeground(Color.BLACK);
                    }if((documento.getString("110")).equals("ocupado")){
                        a110.setBackground(Color.RED);
                        a110.setForeground(Color.BLACK);
                    }if((documento.getString("111")).equals("ocupado")){
                        a111.setBackground(Color.RED);
                        a111.setForeground(Color.BLACK);
                    }if((documento.getString("112")).equals("ocupado")){
                        a112.setBackground(Color.RED);
                        a112.setForeground(Color.BLACK);
                    }if((documento.getString("113")).equals("ocupado")){
                        a113.setBackground(Color.RED);
                        a113.setForeground(Color.BLACK);
                    }if((documento.getString("114")).equals("ocupado")){
                        a114.setBackground(Color.RED);
                        a114.setForeground(Color.BLACK);
                    }if((documento.getString("115")).equals("ocupado")){
                        a115.setBackground(Color.RED);
                        a115.setForeground(Color.BLACK);
                    }if((documento.getString("116")).equals("ocupado")){
                        a116.setBackground(Color.RED);
                        a116.setForeground(Color.BLACK);
                    }if((documento.getString("117")).equals("ocupado")){
                        a117.setBackground(Color.RED);
                        a117.setForeground(Color.BLACK);
                    }if((documento.getString("118")).equals("ocupado")){
                        a118.setBackground(Color.RED);
                        a118.setForeground(Color.BLACK);
                    }if((documento.getString("119")).equals("ocupado")){
                        a119.setBackground(Color.RED);
                        a119.setForeground(Color.BLACK);
                    }if((documento.getString("120")).equals("ocupado")){
                        a120.setBackground(Color.RED);
                        a120.setForeground(Color.BLACK);
                    }if((documento.getString("121")).equals("ocupado")){
                        a121.setBackground(Color.RED);
                        a121.setForeground(Color.BLACK);
                    }if((documento.getString("122")).equals("ocupado")){
                        a122.setBackground(Color.RED);
                        a122.setForeground(Color.BLACK);
                    }if((documento.getString("123")).equals("ocupado")){
                        a123.setBackground(Color.RED);
                        a123.setForeground(Color.BLACK);
                    }if((documento.getString("124")).equals("ocupado")){
                        a124.setBackground(Color.RED);
                        a124.setForeground(Color.BLACK);
                    }if((documento.getString("125")).equals("ocupado")){
                        a125.setBackground(Color.RED);
                        a125.setForeground(Color.BLACK);
                    }if((documento.getString("126")).equals("ocupado")){
                        a126.setBackground(Color.RED);
                        a126.setForeground(Color.BLACK);
                    }if((documento.getString("127")).equals("ocupado")){
                        a127.setBackground(Color.RED);
                        a127.setForeground(Color.BLACK);
                    }if((documento.getString("128")).equals("ocupado")){
                        a128.setBackground(Color.RED);
                        a128.setForeground(Color.BLACK);
                    }if((documento.getString("129")).equals("ocupado")){
                        a129.setBackground(Color.RED);
                        a129.setForeground(Color.BLACK);
                    }if((documento.getString("130")).equals("ocupado")){
                        a130.setBackground(Color.RED);
                        a130.setForeground(Color.BLACK);
                    }if((documento.getString("131")).equals("ocupado")){
                        a131.setBackground(Color.RED);
                        a131.setForeground(Color.BLACK);
                    }if((documento.getString("132")).equals("ocupado")){
                        a132.setBackground(Color.RED);
                        a132.setForeground(Color.BLACK);
                    }if((documento.getString("133")).equals("ocupado")){
                        a133.setBackground(Color.RED);
                        a133.setForeground(Color.BLACK);
                    }if((documento.getString("134")).equals("ocupado")){
                        a134.setBackground(Color.RED);
                        a134.setForeground(Color.BLACK);
                    }if((documento.getString("135")).equals("ocupado")){
                        a135.setBackground(Color.RED);
                        a135.setForeground(Color.BLACK);
                    }if((documento.getString("136")).equals("ocupado")){
                        a136.setBackground(Color.RED);
                        a136.setForeground(Color.BLACK);
                    }if((documento.getString("137")).equals("ocupado")){
                        a137.setBackground(Color.RED);
                        a137.setForeground(Color.BLACK);
                    }if((documento.getString("138")).equals("ocupado")){
                        a138.setBackground(Color.RED);
                        a138.setForeground(Color.BLACK);
                    }if((documento.getString("139")).equals("ocupado")){
                        a139.setBackground(Color.RED);
                        a139.setForeground(Color.BLACK);
                    }if((documento.getString("140")).equals("ocupado")){
                        a140.setBackground(Color.RED);
                        a140.setForeground(Color.BLACK);
                    }
                    if((documento.getString("141")).equals("ocupado")){
                        a141.setBackground(Color.RED);
                        a141.setForeground(Color.BLACK);
                    }
                    if((documento.getString("142")).equals("ocupado")){
                        a142.setBackground(Color.RED);
                        a142.setForeground(Color.BLACK);
                    }
                    if((documento.getString("143")).equals("ocupado")){
                        a143.setBackground(Color.RED);
                        a143.setForeground(Color.BLACK);
                    }
                    if((documento.getString("144")).equals("ocupado")){
                        a144.setBackground(Color.RED);
                        a144.setForeground(Color.BLACK);
                    }
                    if((documento.getString("145")).equals("ocupado")){
                        a145.setBackground(Color.RED);
                        a145.setForeground(Color.BLACK);
                    }
                    if((documento.getString("146")).equals("ocupado")){
                        a146.setBackground(Color.RED);
                        a146.setForeground(Color.BLACK);
                    }if((documento.getString("147")).equals("ocupado")){
                        a147.setBackground(Color.RED);
                        a147.setForeground(Color.BLACK);
                    }if((documento.getString("148")).equals("ocupado")){
                        a148.setBackground(Color.RED);
                        a148.setForeground(Color.BLACK);
                    }if((documento.getString("149")).equals("ocupado")){
                        a149.setBackground(Color.RED);
                        a149.setForeground(Color.BLACK);
                    }if((documento.getString("150")).equals("ocupado")){
                        a150.setBackground(Color.RED);
                        a150.setForeground(Color.BLACK);
                    }if((documento.getString("151")).equals("ocupado")){
                        a151.setBackground(Color.RED);
                        a151.setForeground(Color.BLACK);
                    }if((documento.getString("152")).equals("ocupado")){
                        a152.setBackground(Color.RED);
                        a152.setForeground(Color.BLACK);
                    }if((documento.getString("153")).equals("ocupado")){
                        a153.setBackground(Color.RED);
                        a153.setForeground(Color.BLACK);
                    }if((documento.getString("154")).equals("ocupado")){
                        a154.setBackground(Color.RED);
                        a154.setForeground(Color.BLACK);
                    }if((documento.getString("155")).equals("ocupado")){
                        a155.setBackground(Color.RED);
                        a155.setForeground(Color.BLACK);
                    }
                    if((documento.getString("156")).equals("ocupado")){
                        a156.setBackground(Color.RED);
                        a156.setForeground(Color.BLACK);
                    }if((documento.getString("157")).equals("ocupado")){
                        a157.setBackground(Color.RED);
                        a157.setForeground(Color.BLACK);
                    }if((documento.getString("158")).equals("ocupado")){
                        a158.setBackground(Color.RED);
                        a158.setForeground(Color.BLACK);
                    }
                    if((documento.getString("159")).equals("ocupado")){
                        a159.setBackground(Color.RED);
                        a159.setForeground(Color.BLACK);
                    }if((documento.getString("160")).equals("ocupado")){
                        a160.setBackground(Color.RED);
                        a160.setForeground(Color.BLACK);
                    }if((documento.getString("161")).equals("ocupado")){
                        a161.setBackground(Color.RED);
                        a161.setForeground(Color.BLACK);
                    }if((documento.getString("162")).equals("ocupado")){
                        a162.setBackground(Color.RED);
                        a162.setForeground(Color.BLACK);
                    }if((documento.getString("163")).equals("ocupado")){
                        a163.setBackground(Color.RED);
                        a163.setForeground(Color.BLACK);
                    }if((documento.getString("164")).equals("ocupado")){
                        a164.setBackground(Color.RED);
                        a164.setForeground(Color.BLACK);
                    }if((documento.getString("165")).equals("ocupado")){
                        a165.setBackground(Color.RED);
                        a165.setForeground(Color.BLACK);
                    }if((documento.getString("166")).equals("ocupado")){
                        a166.setBackground(Color.RED);
                        a166.setForeground(Color.BLACK);
                    }if((documento.getString("167")).equals("ocupado")){
                        a167.setBackground(Color.RED);
                        a167.setForeground(Color.BLACK);
                    }if((documento.getString("168")).equals("ocupado")){
                        a168.setBackground(Color.RED);
                        a168.setForeground(Color.BLACK);
                    }if((documento.getString("169")).equals("ocupado")){
                        a169.setBackground(Color.RED);
                        a169.setForeground(Color.BLACK);
                    }if((documento.getString("170")).equals("ocupado")){
                        a170.setBackground(Color.RED);
                        a170.setForeground(Color.BLACK);
                    }if((documento.getString("171")).equals("ocupado")){
                        a171.setBackground(Color.RED);
                        a171.setForeground(Color.BLACK);
                    }if((documento.getString("172")).equals("ocupado")){
                        a172.setBackground(Color.RED);
                        a172.setForeground(Color.BLACK);
                    }if((documento.getString("173")).equals("ocupado")){
                        a173.setBackground(Color.RED);
                        a173.setForeground(Color.BLACK);
                    }if((documento.getString("174")).equals("ocupado")){
                        a174.setBackground(Color.RED);
                        a174.setForeground(Color.BLACK);
                    }if((documento.getString("175")).equals("ocupado")){
                        a175.setBackground(Color.RED);
                        a175.setForeground(Color.BLACK);
                    }if((documento.getString("176")).equals("ocupado")){
                        a176.setBackground(Color.RED);
                        a176.setForeground(Color.BLACK);
                    }if((documento.getString("177")).equals("ocupado")){
                        a177.setBackground(Color.RED);
                        a177.setForeground(Color.BLACK);
                    }if((documento.getString("178")).equals("ocupado")){
                        a178.setBackground(Color.RED);
                        a178.setForeground(Color.BLACK);
                    }if((documento.getString("179")).equals("ocupado")){
                        a179.setBackground(Color.RED);
                        a179.setForeground(Color.BLACK);
                    }if((documento.getString("180")).equals("ocupado")){
                        a180.setBackground(Color.RED);
                        a180.setForeground(Color.BLACK);
                    }if((documento.getString("181")).equals("ocupado")){
                        a181.setBackground(Color.RED);
                        a181.setForeground(Color.BLACK);
                    }if((documento.getString("182")).equals("ocupado")){
                        a182.setBackground(Color.RED);
                        a182.setForeground(Color.BLACK);
                    }if((documento.getString("183")).equals("ocupado")){
                        a183.setBackground(Color.RED);
                        a183.setForeground(Color.BLACK);
                    }if((documento.getString("184")).equals("ocupado")){
                        a184.setBackground(Color.RED);
                        a184.setForeground(Color.BLACK);
                    }if((documento.getString("185")).equals("ocupado")){
                        a185.setBackground(Color.RED);
                        a185.setForeground(Color.BLACK);
                    }if((documento.getString("186")).equals("ocupado")){
                        a186.setBackground(Color.RED);
                        a186.setForeground(Color.BLACK);
                    }if((documento.getString("187")).equals("ocupado")){
                        a187.setBackground(Color.RED);
                        a187.setForeground(Color.BLACK);
                    }if((documento.getString("188")).equals("ocupado")){
                        a188.setBackground(Color.RED);
                        a188.setForeground(Color.BLACK);
                    }if((documento.getString("189")).equals("ocupado")){
                        a189.setBackground(Color.RED);
                        a189.setForeground(Color.BLACK);
                    }if((documento.getString("190")).equals("ocupado")){
                        a190.setBackground(Color.RED);
                        a190.setForeground(Color.BLACK);
                    }if((documento.getString("191")).equals("ocupado")){
                        a191.setBackground(Color.RED);
                        a191.setForeground(Color.BLACK);
                    }
                    if((documento.getString("192")).equals("ocupado")){
                        a192.setBackground(Color.RED);
                        a192.setForeground(Color.BLACK);
                    }
                    if((documento.getString("193")).equals("ocupado")){
                        a193.setBackground(Color.RED);
                        a193.setForeground(Color.BLACK);
                    }
                    if((documento.getString("194")).equals("ocupado")){
                        a194.setBackground(Color.RED);
                        a194.setForeground(Color.BLACK);
                    }
                    if((documento.getString("195")).equals("ocupado")){
                        a195.setBackground(Color.RED);
                        a195.setForeground(Color.BLACK);
                    }
                    if((documento.getString("196")).equals("ocupado")){
                        a196.setBackground(Color.RED);
                        a196.setForeground(Color.BLACK);
                    }
                    if((documento.getString("197")).equals("ocupado")){
                        a197.setBackground(Color.RED);
                        a197.setForeground(Color.BLACK);
                    }
                    if((documento.getString("198")).equals("ocupado")){
                        a198.setBackground(Color.RED);
                        a198.setForeground(Color.BLACK);
                    }
                    if((documento.getString("199")).equals("ocupado")){
                        a199.setBackground(Color.RED);
                        a199.setForeground(Color.BLACK);
                    }if((documento.getString("200")).equals("ocupado")){
                        a200.setBackground(Color.RED);
                        a200.setForeground(Color.BLACK);
                    }
                }
            }
        }

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame reservar = new JFrame();
                reservar.setTitle("PoliCine");
                reservar.setContentPane(new ReservaPelicula().MainPanel);
                reservar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reservar.setSize(500, 350);
                reservar.setLocationRelativeTo(null);
                reservar.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                reservar.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a1.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a1.getText()+" ya está seleccionado");
                }else{
                    a1.setBackground(Color.green);
                    a1.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,1";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a2.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a2.getText()+" ya está seleccionado");
                }else{
                    a2.setBackground(Color.green);
                    a2.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,2";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a3.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a3.getText()+" ya está seleccionado");
                }else{
                    a3.setBackground(Color.green);
                    a3.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,3";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a4.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a4.getText()+" ya está seleccionado");
                }else{
                    a4.setBackground(Color.green);
                    a4.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,4";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a5.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a5.getText()+" ya está seleccionado");
                }else{
                    a5.setBackground(Color.green);
                    a5.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,5";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a6.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a6.getText()+" ya está seleccionado");
                }else{
                    a6.setBackground(Color.green);
                    a6.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,6";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a7.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a7.getText()+" ya está seleccionado");
                }else{
                    a7.setBackground(Color.green);
                    a7.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,7";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a8.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a8.getText()+" ya está seleccionado");
                }else{
                    a8.setBackground(Color.green);
                    a8.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,8";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a9.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a9.getText()+" ya está seleccionado");
                }else{
                    a9.setBackground(Color.green);
                    a9.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,9";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a10.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a10.getText()+" ya está seleccionado");
                }else{
                    a10.setBackground(Color.green);
                    a10.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,10";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a11.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a11.getText()+" ya está seleccionado");
                }else{
                    a11.setBackground(Color.green);
                    a11.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,11";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a12.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a12.getText()+" ya está seleccionado");
                }else{
                    a12.setBackground(Color.green);
                    a12.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,12";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a13.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a1.getText()+" ya está seleccionado");
                }else{
                    a13.setBackground(Color.green);
                    a13.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,13";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a14.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a14.getText()+" ya está seleccionado");
                }else{
                    a14.setBackground(Color.green);
                    a14.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,14";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a15.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a15.getText()+" ya está seleccionado");
                }else{
                    a15.setBackground(Color.green);
                    a15.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,15";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a16.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a16.getText()+" ya está seleccionado");
                }else{
                    a16.setBackground(Color.green);
                    a16.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,16";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a17.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a17.getText()+" ya está seleccionado");
                }else{
                    a17.setBackground(Color.green);
                    a17.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,17";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a18.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a18.getText()+" ya está seleccionado");
                }else{
                    a18.setBackground(Color.green);
                    a18.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,18";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a19.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a19.getText()+" ya está seleccionado");
                }else{
                    a19.setBackground(Color.green);
                    a19.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,19";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a20.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a20.getText()+" ya está seleccionado");
                }else{
                    a20.setBackground(Color.green);
                    a20.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,20";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a21.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a21.getText()+" ya está seleccionado");
                }else{
                    a21.setBackground(Color.green);
                    a21.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,21";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a22.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a22.getText()+" ya está seleccionado");
                }else{
                    a22.setBackground(Color.green);
                    a22.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,1";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a23.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a23.getText()+" ya está seleccionado");
                }else{
                    a23.setBackground(Color.green);
                    a23.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,23";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a24.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a24.getText()+" ya está seleccionado");
                }else{
                    a24.setBackground(Color.green);
                    a24.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,24";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a25.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a25.getText()+" ya está seleccionado");
                }else{
                    a25.setBackground(Color.green);
                    a25.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,25";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a26.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a26.getText()+" ya está seleccionado");
                }else{
                    a26.setBackground(Color.green);
                    a26.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,26";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a27.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a27.getText()+" ya está seleccionado");
                }else{
                    a27.setBackground(Color.green);
                    a27.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,27";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a28.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a28.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a28.getText()+" ya está seleccionado");
                }else{
                    a28.setBackground(Color.green);
                    a28.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,28";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a29.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a29.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a29.getText()+" ya está seleccionado");
                }else{
                    a29.setBackground(Color.green);
                    a29.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,29";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a30.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a30.getText()+" ya está seleccionado");
                }else{
                    a30.setBackground(Color.green);
                    a30.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,30";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a31.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a31.getText()+" ya está seleccionado");
                }else{
                    a31.setBackground(Color.green);
                    a31.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,31";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a32.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a32.getText()+" ya está seleccionado");
                }else{
                    a32.setBackground(Color.green);
                    a32.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,32";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a33.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a33.getText()+" ya está seleccionado");
                }else{
                    a33.setBackground(Color.green);
                    a33.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,33";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a34.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a34.getText()+" ya está seleccionado");
                }else{
                    a34.setBackground(Color.green);
                    a34.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,34";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a35.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a35.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a35.getText()+" ya está seleccionado");
                }else{
                    a35.setBackground(Color.green);
                    a35.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,35";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a36.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a36.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a36.getText()+" ya está seleccionado");
                }else{
                    a36.setBackground(Color.green);
                    a36.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,36";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });

        a37.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a37.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a37.getText()+" ya está seleccionado");
                }else{
                    a37.setBackground(Color.green);
                    a37.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,37";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a38.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a38.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a38.getText()+" ya está seleccionado");
                }else{
                    a38.setBackground(Color.green);
                    a38.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,38";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a39.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a39.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a39.getText()+" ya está seleccionado");
                }else{
                    a39.setBackground(Color.green);
                    a39.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,39";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a40.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a40.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a40.getText()+" ya está seleccionado");
                }else{
                    a40.setBackground(Color.green);
                    a40.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,40";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a41.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a41.getText()+" ya está seleccionado");
                }else{
                    a41.setBackground(Color.green);
                    a41.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,41";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a42.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a42.getText()+" ya está seleccionado");
                }else{
                    a42.setBackground(Color.green);
                    a42.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,42";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a43.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a43.getText()+" ya está seleccionado");
                }else{
                    a43.setBackground(Color.green);
                    a43.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,43";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a44.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a44.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a44.getText()+" ya está seleccionado");
                }else{
                    a44.setBackground(Color.green);
                    a44.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,44";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a45.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a45.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a45.getText()+" ya está seleccionado");
                }else{
                    a45.setBackground(Color.green);
                    a45.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,45";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a46.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a46.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a46.getText()+" ya está seleccionado");
                }else{
                    a46.setBackground(Color.green);
                    a46.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,46";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a47.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a47.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a47.getText()+" ya está seleccionado");
                }else{
                    a47.setBackground(Color.green);
                    a47.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,47";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a48.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a48.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a48.getText()+" ya está seleccionado");
                }else{
                    a48.setBackground(Color.green);
                    a48.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,48";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a49.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a49.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a49.getText()+" ya está seleccionado");
                }else{
                    a49.setBackground(Color.green);
                    a49.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,49";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a50.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a50.getText()+" ya está seleccionado");
                }else{
                    a50.setBackground(Color.green);
                    a50.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,50";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a51.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a51.getText()+" ya está seleccionado");
                }else{
                    a51.setBackground(Color.green);
                    a51.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,51";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a52.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a52.getText()+" ya está seleccionado");
                }else{
                    a52.setBackground(Color.green);
                    a52.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,52";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a53.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a53.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a53.getText()+" ya está seleccionado");
                }else{
                    a53.setBackground(Color.green);
                    a53.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,53";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a54.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a54.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a54.getText()+" ya está seleccionado");
                }else{
                    a54.setBackground(Color.green);
                    a54.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,54";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a55.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a55.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a55.getText()+" ya está seleccionado");
                }else{
                    a55.setBackground(Color.green);
                    a55.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,55";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a56.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a56.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a56.getText()+" ya está seleccionado");
                }else{
                    a56.setBackground(Color.green);
                    a56.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,56";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a57.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a57.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a57.getText()+" ya está seleccionado");
                }else{
                    a57.setBackground(Color.green);
                    a57.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,57";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a58.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a58.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a58.getText()+" ya está seleccionado");
                }else{
                    a58.setBackground(Color.green);
                    a58.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,58";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a59.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a59.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a59.getText()+" ya está seleccionado");
                }else{
                    a59.setBackground(Color.green);
                    a59.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,59";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a60.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a60.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a60.getText()+" ya está seleccionado");
                }else{
                    a60.setBackground(Color.green);
                    a60.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,60";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a61.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a61.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a61.getText()+" ya está seleccionado");
                }else{
                    a61.setBackground(Color.green);
                    a61.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,61";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a62.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a62.getText()+" ya está seleccionado");
                }else{
                    a62.setBackground(Color.green);
                    a62.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,62";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a63.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a63.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a63.getText()+" ya está seleccionado");
                }else{
                    a63.setBackground(Color.green);
                    a63.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,63";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a64.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a64.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a64.getText()+" ya está seleccionado");
                }else{
                    a64.setBackground(Color.green);
                    a64.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,64";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a65.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a65.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a65.getText()+" ya está seleccionado");
                }else{
                    a65.setBackground(Color.green);
                    a65.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,65";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a66.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a66.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a66.getText()+" ya está seleccionado");
                }else{
                    a66.setBackground(Color.green);
                    a66.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,66";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a67.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a67.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a67.getText()+" ya está seleccionado");
                }else{
                    a67.setBackground(Color.green);
                    a67.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,67";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a68.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a68.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a68.getText()+" ya está seleccionado");
                }else{
                    a68.setBackground(Color.green);
                    a68.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,68";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a69.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a69.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a69.getText()+" ya está seleccionado");
                }else{
                    a69.setBackground(Color.green);
                    a69.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,69";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a70.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a70.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a70.getText()+" ya está seleccionado");
                }else{
                    a70.setBackground(Color.green);
                    a70.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,70";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a71.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a71.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a71.getText()+" ya está seleccionado");
                }else{
                    a71.setBackground(Color.green);
                    a71.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,71";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a72.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a72.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a72.getText()+" ya está seleccionado");
                }else{
                    a72.setBackground(Color.green);
                    a72.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,72";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a73.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a73.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a73.getText()+" ya está seleccionado");
                }else{
                    a73.setBackground(Color.green);
                    a73.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,73";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a74.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a74.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a74.getText()+" ya está seleccionado");
                }else{
                    a74.setBackground(Color.green);
                    a74.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,74";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a75.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a75.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a75.getText()+" ya está seleccionado");
                }else{
                    a75.setBackground(Color.green);
                    a75.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,75";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a76.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a76.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a76.getText()+" ya está seleccionado");
                }else{
                    a76.setBackground(Color.green);
                    a76.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,76";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a77.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a77.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a77.getText()+" ya está seleccionado");
                }else{
                    a77.setBackground(Color.green);
                    a77.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,77";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a78.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a78.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a78.getText()+" ya está seleccionado");
                }else{
                    a78.setBackground(Color.green);
                    a78.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,78";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a79.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a79.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a79.getText()+" ya está seleccionado");
                }else{
                    a79.setBackground(Color.green);
                    a79.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,79";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a80.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a80.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a80.getText()+" ya está seleccionado");
                }else{
                    a80.setBackground(Color.green);
                    a80.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,80";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a81.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a81.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a81.getText()+" ya está seleccionado");
                }else{
                    a81.setBackground(Color.green);
                    a81.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,81";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a82.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a82.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a82.getText()+" ya está seleccionado");
                }else{
                    a82.setBackground(Color.green);
                    a82.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,82";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a83.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a83.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a83.getText()+" ya está seleccionado");
                }else{
                    a83.setBackground(Color.green);
                    a83.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,83";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a84.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a84.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a84.getText()+" ya está seleccionado");
                }else{
                    a84.setBackground(Color.green);
                    a84.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,84";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a85.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a85.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a85.getText()+" ya está seleccionado");
                }else{
                    a85.setBackground(Color.green);
                    a85.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,85";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a86.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a86.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a86.getText()+" ya está seleccionado");
                }else{
                    a86.setBackground(Color.green);
                    a86.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,86";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a87.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a87.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a87.getText()+" ya está seleccionado");
                }else{
                    a87.setBackground(Color.green);
                    a87.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,87";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a88.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a88.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a88.getText()+" ya está seleccionado");
                }else{
                    a88.setBackground(Color.green);
                    a88.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,88";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a89.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a89.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a89.getText()+" ya está seleccionado");
                }else{
                    a89.setBackground(Color.green);
                    a89.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,89";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a90.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a90.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a90.getText()+" ya está seleccionado");
                }else{
                    a90.setBackground(Color.green);
                    a90.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,90";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a91.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a91.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a91.getText()+" ya está seleccionado");
                }else{
                    a91.setBackground(Color.green);
                    a91.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,91";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a92.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a92.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a92.getText()+" ya está seleccionado");
                }else{
                    a92.setBackground(Color.green);
                    a92.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,92";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a93.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a93.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a93.getText()+" ya está seleccionado");
                }else{
                    a93.setBackground(Color.green);
                    a93.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,93";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a94.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a94.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a94.getText()+" ya está seleccionado");
                }else{
                    a94.setBackground(Color.green);
                    a94.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,94";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a95.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a95.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a95.getText()+" ya está seleccionado");
                }else{
                    a95.setBackground(Color.green);
                    a95.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,95";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a96.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a96.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a96.getText()+" ya está seleccionado");
                }else{
                    a96.setBackground(Color.green);
                    a96.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,96";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a97.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a97.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a97.getText()+" ya está seleccionado");
                }else{
                    a97.setBackground(Color.green);
                    a97.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,97";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a98.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a98.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a98.getText()+" ya está seleccionado");
                }else{
                    a98.setBackground(Color.green);
                    a98.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,98";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a99.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a99.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a99.getText()+" ya está seleccionado");
                }else{
                    a99.setBackground(Color.green);
                    a99.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,99";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a100.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a100.getText()+" ya está seleccionado");
                }else{
                    a100.setBackground(Color.green);
                    a100.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,100";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a101.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a101.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a101.getText()+" ya está seleccionado");
                }else{
                    a101.setBackground(Color.green);
                    a101.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,101";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a102.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a102.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a102.getText()+" ya está seleccionado");
                }else{
                    a102.setBackground(Color.green);
                    a102.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,102";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a103.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a103.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a103.getText()+" ya está seleccionado");
                }else{
                    a103.setBackground(Color.green);
                    a103.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,103";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a104.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a104.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a104.getText()+" ya está seleccionado");
                }else{
                    a104.setBackground(Color.green);
                    a104.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,104";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a105.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a105.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a105.getText()+" ya está seleccionado");
                }else{
                    a105.setBackground(Color.green);
                    a105.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,105";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a106.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a106.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a106.getText()+" ya está seleccionado");
                }else{
                    a106.setBackground(Color.green);
                    a106.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,106";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a107.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a107.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a107.getText()+" ya está seleccionado");
                }else{
                    a107.setBackground(Color.green);
                    a107.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,107";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a108.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a108.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a108.getText()+" ya está seleccionado");
                }else{
                    a108.setBackground(Color.green);
                    a108.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,108";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a109.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a109.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a109.getText()+" ya está seleccionado");
                }else{
                    a109.setBackground(Color.green);
                    a109.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,109";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a110.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a110.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a110.getText()+" ya está seleccionado");
                }else{
                    a110.setBackground(Color.green);
                    a110.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,110";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a111.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a111.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a111.getText()+" ya está seleccionado");
                }else{
                    a111.setBackground(Color.green);
                    a111.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,111";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a112.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a112.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a112.getText()+" ya está seleccionado");
                }else{
                    a112.setBackground(Color.green);
                    a112.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,112";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a113.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a113.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a113.getText()+" ya está seleccionado");
                }else{
                    a113.setBackground(Color.green);
                    a113.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,113";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a114.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a114.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a114.getText()+" ya está seleccionado");
                }else{
                    a114.setBackground(Color.green);
                    a114.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,114";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a115.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a115.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a115.getText()+" ya está seleccionado");
                }else{
                    a115.setBackground(Color.green);
                    a115.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,115";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a116.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a116.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a116.getText()+" ya está seleccionado");
                }else{
                    a116.setBackground(Color.green);
                    a116.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,116";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a117.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a117.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a117.getText()+" ya está seleccionado");
                }else{
                    a117.setBackground(Color.green);
                    a117.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,117";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a118.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a118.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a118.getText()+" ya está seleccionado");
                }else{
                    a118.setBackground(Color.green);
                    a118.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,118";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a119.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a119.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a119.getText()+" ya está seleccionado");
                }else{
                    a119.setBackground(Color.green);
                    a119.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,119";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a120.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a120.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a120.getText()+" ya está seleccionado");
                }else{
                    a120.setBackground(Color.green);
                    a120.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,120";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a121.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a121.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a121.getText()+" ya está seleccionado");
                }else{
                    a121.setBackground(Color.green);
                    a121.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,121";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a122.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a122.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a122.getText()+" ya está seleccionado");
                }else{
                    a122.setBackground(Color.green);
                    a122.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,122";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a123.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a123.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a123.getText()+" ya está seleccionado");
                }else{
                    a123.setBackground(Color.green);
                    a123.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,123";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a124.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a124.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a124.getText()+" ya está seleccionado");
                }else{
                    a124.setBackground(Color.green);
                    a124.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,124";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a125.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a125.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a125.getText()+" ya está seleccionado");
                }else{
                    a125.setBackground(Color.green);
                    a125.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,125";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a126.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a126.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a126.getText()+" ya está seleccionado");
                }else{
                    a126.setBackground(Color.green);
                    a126.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,126";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a127.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a127.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a127.getText()+" ya está seleccionado");
                }else{
                    a127.setBackground(Color.green);
                    a127.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,127";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a128.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a128.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a128.getText()+" ya está seleccionado");
                }else{
                    a128.setBackground(Color.green);
                    a128.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,128";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a129.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a129.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a129.getText()+" ya está seleccionado");
                }else{
                    a129.setBackground(Color.green);
                    a129.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,129";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a130.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a130.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a130.getText()+" ya está seleccionado");
                }else{
                    a130.setBackground(Color.green);
                    a130.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,130";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a131.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a131.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a131.getText()+" ya está seleccionado");
                }else{
                    a131.setBackground(Color.green);
                    a131.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,131";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a132.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a132.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a132.getText()+" ya está seleccionado");
                }else{
                    a132.setBackground(Color.green);
                    a132.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,132";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a133.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a133.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a133.getText()+" ya está seleccionado");
                }else{
                    a133.setBackground(Color.green);
                    a133.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,133";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a134.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a134.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a134.getText()+" ya está seleccionado");
                }else{
                    a134.setBackground(Color.green);
                    a134.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,134";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a135.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a135.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a135.getText()+" ya está seleccionado");
                }else{
                    a135.setBackground(Color.green);
                    a135.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,135";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a136.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a136.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a136.getText()+" ya está seleccionado");
                }else{
                    a136.setBackground(Color.green);
                    a136.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,136";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a137.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a137.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a137.getText()+" ya está seleccionado");
                }else{
                    a137.setBackground(Color.green);
                    a137.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,137";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a138.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a138.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a138.getText()+" ya está seleccionado");
                }else{
                    a138.setBackground(Color.green);
                    a138.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,138";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a139.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a139.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a139.getText()+" ya está seleccionado");
                }else{
                    a139.setBackground(Color.green);
                    a139.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,139";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a140.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a140.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a140.getText()+" ya está seleccionado");
                }else{
                    a140.setBackground(Color.green);
                    a140.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,140";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a141.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a141.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a141.getText()+" ya está seleccionado");
                }else{
                    a141.setBackground(Color.green);
                    a141.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,141";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a142.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a142.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a142.getText()+" ya está seleccionado");
                }else{
                    a142.setBackground(Color.green);
                    a142.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,142";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a143.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a143.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a143.getText()+" ya está seleccionado");
                }else{
                    a143.setBackground(Color.green);
                    a143.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,143";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a144.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a144.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a144.getText()+" ya está seleccionado");
                }else{
                    a144.setBackground(Color.green);
                    a144.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,144";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a145.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a145.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a145.getText()+" ya está seleccionado");
                }else{
                    a145.setBackground(Color.green);
                    a145.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,145";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a146.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a146.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a146.getText()+" ya está seleccionado");
                }else{
                    a146.setBackground(Color.green);
                    a146.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,146";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a147.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a147.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a147.getText()+" ya está seleccionado");
                }else{
                    a147.setBackground(Color.green);
                    a147.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,147";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a148.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a148.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a148.getText()+" ya está seleccionado");
                }else{
                    a148.setBackground(Color.green);
                    a148.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,148";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a149.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a149.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a149.getText()+" ya está seleccionado");
                }else{
                    a149.setBackground(Color.green);
                    a149.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,149";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a150.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a150.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a150.getText()+" ya está seleccionado");
                }else{
                    a150.setBackground(Color.green);
                    a150.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,150";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a151.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a151.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a151.getText()+" ya está seleccionado");
                }else{
                    a151.setBackground(Color.green);
                    a151.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,151";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a152.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a152.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a152.getText()+" ya está seleccionado");
                }else{
                    a152.setBackground(Color.green);
                    a152.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,152";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a153.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a153.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a153.getText()+" ya está seleccionado");
                }else{
                    a153.setBackground(Color.green);
                    a153.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,153";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a154.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a154.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a154.getText()+" ya está seleccionado");
                }else{
                    a154.setBackground(Color.green);
                    a154.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,154";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a155.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a155.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a155.getText()+" ya está seleccionado");
                }else{
                    a155.setBackground(Color.green);
                    a155.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,155";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a156.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a156.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a156.getText()+" ya está seleccionado");
                }else{
                    a156.setBackground(Color.green);
                    a156.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,156";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a157.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a157.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a157.getText()+" ya está seleccionado");
                }else{
                    a157.setBackground(Color.green);
                    a157.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,157";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a158.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a158.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a158.getText()+" ya está seleccionado");
                }else{
                    a158.setBackground(Color.green);
                    a158.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,158";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a159.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a159.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a159.getText()+" ya está seleccionado");
                }else{
                    a159.setBackground(Color.green);
                    a159.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,159";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a160.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a160.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a160.getText()+" ya está seleccionado");
                }else{
                    a160.setBackground(Color.green);
                    a160.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,160";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a161.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a161.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a161.getText()+" ya está seleccionado");
                }else{
                    a161.setBackground(Color.green);
                    a161.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,161";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a162.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a162.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a162.getText()+" ya está seleccionado");
                }else{
                    a162.setBackground(Color.green);
                    a162.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,162";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a163.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a163.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a163.getText()+" ya está seleccionado");
                }else{
                    a163.setBackground(Color.green);
                    a163.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,163";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a164.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a164.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a164.getText()+" ya está seleccionado");
                }else{
                    a164.setBackground(Color.green);
                    a164.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,164";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a165.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a165.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a165.getText()+" ya está seleccionado");
                }else{
                    a165.setBackground(Color.green);
                    a165.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,165";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a166.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a166.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a166.getText()+" ya está seleccionado");
                }else{
                    a166.setBackground(Color.green);
                    a166.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,166";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a167.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a167.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a167.getText()+" ya está seleccionado");
                }else{
                    a167.setBackground(Color.green);
                    a167.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,167";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a168.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a168.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a168.getText()+" ya está seleccionado");
                }else{
                    a168.setBackground(Color.green);
                    a168.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,168";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a169.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a169.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a169.getText()+" ya está seleccionado");
                }else{
                    a169.setBackground(Color.green);
                    a169.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,169";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a170.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a170.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a170.getText()+" ya está seleccionado");
                }else{
                    a170.setBackground(Color.green);
                    a170.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,170";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a171.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a171.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a171.getText()+" ya está seleccionado");
                }else{
                    a171.setBackground(Color.green);
                    a171.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,171";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a172.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a172.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a172.getText()+" ya está seleccionado");
                }else{
                    a172.setBackground(Color.green);
                    a172.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,172";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a173.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a173.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a173.getText()+" ya está seleccionado");
                }else{
                    a173.setBackground(Color.green);
                    a173.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,173";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a174.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a174.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a174.getText()+" ya está seleccionado");
                }else{
                    a174.setBackground(Color.green);
                    a174.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,174";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a175.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a175.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a175.getText()+" ya está seleccionado");
                }else{
                    a175.setBackground(Color.green);
                    a175.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,175";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a176.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a176.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a176.getText()+" ya está seleccionado");
                }else{
                    a176.setBackground(Color.green);
                    a176.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,176";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a177.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a177.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a177.getText()+" ya está seleccionado");
                }else{
                    a177.setBackground(Color.green);
                    a177.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,177";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a178.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a178.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a178.getText()+" ya está seleccionado");
                }else{
                    a178.setBackground(Color.green);
                    a178.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,178";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a179.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a179.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a179.getText()+" ya está seleccionado");
                }else{
                    a179.setBackground(Color.green);
                    a179.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,179";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a180.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a180.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a180.getText()+" ya está seleccionado");
                }else{
                    a180.setBackground(Color.green);
                    a180.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,180";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a181.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a181.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a181.getText()+" ya está seleccionado");
                }else{
                    a181.setBackground(Color.green);
                    a181.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,181";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a182.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a182.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a182.getText()+" ya está seleccionado");
                }else{
                    a182.setBackground(Color.green);
                    a182.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,182";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a183.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a183.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a183.getText()+" ya está seleccionado");
                }else{
                    a183.setBackground(Color.green);
                    a183.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,183";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a184.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a184.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a184.getText()+" ya está seleccionado");
                }else{
                    a184.setBackground(Color.green);
                    a184.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,184";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a185.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a185.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a185.getText()+" ya está seleccionado");
                }else{
                    a185.setBackground(Color.green);
                    a185.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,185";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a186.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a186.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a186.getText()+" ya está seleccionado");
                }else{
                    a186.setBackground(Color.green);
                    a186.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,186";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a187.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a187.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a187.getText()+" ya está seleccionado");
                }else{
                    a187.setBackground(Color.green);
                    a187.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,187";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a188.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a188.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a188.getText()+" ya está seleccionado");
                }else{
                    a188.setBackground(Color.green);
                    a188.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,188";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a189.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a189.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a189.getText()+" ya está seleccionado");
                }else{
                    a189.setBackground(Color.green);
                    a189.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,189";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a190.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a190.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a190.getText()+" ya está seleccionado");
                }else{
                    a190.setBackground(Color.green);
                    a190.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,190";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a191.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a191.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a191.getText()+" ya está seleccionado");
                }else{
                    a191.setBackground(Color.green);
                    a191.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,191";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a192.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a192.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a192.getText()+" ya está seleccionado");
                }else{
                    a192.setBackground(Color.green);
                    a192.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,192";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a193.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a193.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a193.getText()+" ya está seleccionado");
                }else{
                    a193.setBackground(Color.green);
                    a193.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,193";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a194.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a194.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a194.getText()+" ya está seleccionado");
                }else{
                    a194.setBackground(Color.green);
                    a194.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,194";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a195.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a195.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a195.getText()+" ya está seleccionado");
                }else{
                    a195.setBackground(Color.green);
                    a195.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,195";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a196.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a196.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a196.getText()+" ya está seleccionado");
                }else{
                    a196.setBackground(Color.green);
                    a196.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,196";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a197.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a197.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a197.getText()+" ya está seleccionado");
                }else{
                    a197.setBackground(Color.green);
                    a197.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,197";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a198.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a198.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a198.getText()+" ya está seleccionado");
                }else{
                    a198.setBackground(Color.green);
                    a198.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,198";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a199.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a199.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a199.getText()+" ya está seleccionado");
                }else{
                    a199.setBackground(Color.green);
                    a199.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,199";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        a200.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = a200.getBackground();
                if(color.equals(Color.green)){
                    JOptionPane.showMessageDialog(null, "El asiento "+a200.getText()+" ya está seleccionado");
                }else{
                    a200.setBackground(Color.green);
                    a200.setForeground(Color.BLACK);
                    String recoger;
                    recoger=AsientosLabel.getText()+" ,200";
                    AsientosLabel.setText(recoger);
                    double valoractual = Double.parseDouble(PrecioLabel.getText());
                    valoractual+=nueva.getPrecio();
                    PrecioLabel.setText(String.valueOf(valoractual));
                }
            }
        });
        reelegirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a1.setBackground(Color.BLACK);
                a1.setForeground(Color.yellow);
                a2.setBackground(Color.BLACK);
                a2.setForeground(Color.yellow);
                a3.setBackground(Color.BLACK);
                a3.setForeground(Color.yellow);
                a4.setBackground(Color.BLACK);
                a4.setForeground(Color.yellow);
                a5.setBackground(Color.BLACK);
                a5.setForeground(Color.yellow);
                a6.setBackground(Color.BLACK);
                a6.setForeground(Color.yellow);
                a7.setBackground(Color.BLACK);
                a7.setForeground(Color.yellow);
                a8.setBackground(Color.BLACK);
                a8.setForeground(Color.yellow);
                a9.setBackground(Color.BLACK);
                a9.setForeground(Color.yellow);
                a10.setBackground(Color.BLACK);
                a10.setForeground(Color.yellow);
                a11.setBackground(Color.BLACK);
                a11.setForeground(Color.yellow);
                a12.setBackground(Color.BLACK);
                a12.setForeground(Color.yellow);
                a13.setBackground(Color.BLACK);
                a13.setForeground(Color.yellow);
                a14.setBackground(Color.BLACK);
                a14.setForeground(Color.yellow);
                a15.setBackground(Color.BLACK);
                a15.setForeground(Color.yellow);
                a16.setBackground(Color.BLACK);
                a16.setForeground(Color.yellow);
                a17.setBackground(Color.BLACK);
                a17.setForeground(Color.yellow);
                a18.setBackground(Color.BLACK);
                a18.setForeground(Color.yellow);
                a19.setBackground(Color.BLACK);
                a19.setForeground(Color.yellow);
                a20.setBackground(Color.BLACK);
                a20.setForeground(Color.yellow);
                a21.setBackground(Color.BLACK);
                a21.setForeground(Color.yellow);
                a22.setBackground(Color.BLACK);
                a22.setForeground(Color.yellow);
                a23.setBackground(Color.BLACK);
                a23.setForeground(Color.yellow);
                a24.setBackground(Color.BLACK);
                a24.setForeground(Color.yellow);
                a25.setBackground(Color.BLACK);
                a25.setForeground(Color.yellow);
                a26.setBackground(Color.BLACK);
                a26.setForeground(Color.yellow);
                a27.setBackground(Color.BLACK);
                a27.setForeground(Color.yellow);
                a28.setBackground(Color.BLACK);
                a28.setForeground(Color.yellow);
                a29.setBackground(Color.BLACK);
                a29.setForeground(Color.yellow);
                a30.setBackground(Color.BLACK);
                a30.setForeground(Color.yellow);
                a31.setBackground(Color.BLACK);
                a31.setForeground(Color.yellow);
                a32.setBackground(Color.BLACK);
                a32.setForeground(Color.yellow);
                a33.setBackground(Color.BLACK);
                a33.setForeground(Color.yellow);
                a34.setBackground(Color.BLACK);
                a34.setForeground(Color.yellow);
                a35.setBackground(Color.BLACK);
                a35.setForeground(Color.yellow);
                a36.setBackground(Color.BLACK);
                a36.setForeground(Color.yellow);
                a37.setBackground(Color.BLACK);
                a37.setForeground(Color.yellow);
                a38.setBackground(Color.BLACK);
                a38.setForeground(Color.yellow);
                a39.setBackground(Color.BLACK);
                a39.setForeground(Color.yellow);
                a40.setBackground(Color.BLACK);
                a40.setForeground(Color.yellow);
                a41.setBackground(Color.BLACK);
                a41.setForeground(Color.yellow);
                a42.setBackground(Color.BLACK);
                a42.setForeground(Color.yellow);
                a43.setBackground(Color.BLACK);
                a43.setForeground(Color.yellow);
                a44.setBackground(Color.BLACK);
                a44.setForeground(Color.yellow);
                a45.setBackground(Color.BLACK);
                a45.setForeground(Color.yellow);
                a46.setBackground(Color.BLACK);
                a46.setForeground(Color.yellow);
                a47.setBackground(Color.BLACK);
                a47.setForeground(Color.yellow);
                a48.setBackground(Color.BLACK);
                a48.setForeground(Color.yellow);
                a49.setBackground(Color.BLACK);
                a49.setForeground(Color.yellow);
                a50.setBackground(Color.BLACK);
                a50.setForeground(Color.yellow);
                a51.setBackground(Color.BLACK);
                a51.setForeground(Color.yellow);
                a52.setBackground(Color.BLACK);
                a52.setForeground(Color.yellow);
                a53.setBackground(Color.BLACK);
                a53.setForeground(Color.yellow);
                a54.setBackground(Color.BLACK);
                a54.setForeground(Color.yellow);
                a55.setBackground(Color.BLACK);
                a55.setForeground(Color.yellow);
                a56.setBackground(Color.BLACK);
                a56.setForeground(Color.yellow);
                a57.setBackground(Color.BLACK);
                a57.setForeground(Color.yellow);
                a58.setBackground(Color.BLACK);
                a58.setForeground(Color.yellow);
                a59.setBackground(Color.BLACK);
                a59.setForeground(Color.yellow);
                a60.setBackground(Color.BLACK);
                a60.setForeground(Color.yellow);
                a61.setBackground(Color.BLACK);
                a61.setForeground(Color.yellow);
                a62.setBackground(Color.BLACK);
                a62.setForeground(Color.yellow);
                a63.setBackground(Color.BLACK);
                a63.setForeground(Color.yellow);
                a64.setBackground(Color.BLACK);
                a64.setForeground(Color.yellow);
                a65.setBackground(Color.BLACK);
                a65.setForeground(Color.yellow);
                a66.setBackground(Color.BLACK);
                a66.setForeground(Color.yellow);
                a67.setBackground(Color.BLACK);
                a67.setForeground(Color.yellow);
                a68.setBackground(Color.BLACK);
                a68.setForeground(Color.yellow);
                a69.setBackground(Color.BLACK);
                a69.setForeground(Color.yellow);
                a70.setBackground(Color.BLACK);
                a70.setForeground(Color.yellow);
                a71.setBackground(Color.BLACK);
                a71.setForeground(Color.yellow);
                a72.setBackground(Color.BLACK);
                a72.setForeground(Color.yellow);
                a73.setBackground(Color.BLACK);
                a73.setForeground(Color.yellow);
                a74.setBackground(Color.BLACK);
                a74.setForeground(Color.yellow);
                a75.setBackground(Color.BLACK);
                a75.setForeground(Color.yellow);
                a76.setBackground(Color.BLACK);
                a76.setForeground(Color.yellow);
                a77.setBackground(Color.BLACK);
                a77.setForeground(Color.yellow);
                a78.setBackground(Color.BLACK);
                a78.setForeground(Color.yellow);
                a79.setBackground(Color.BLACK);
                a79.setForeground(Color.yellow);
                a80.setBackground(Color.BLACK);
                a80.setForeground(Color.yellow);
                a81.setBackground(Color.BLACK);
                a81.setForeground(Color.yellow);
                a82.setBackground(Color.BLACK);
                a82.setForeground(Color.yellow);
                a83.setBackground(Color.BLACK);
                a83.setForeground(Color.yellow);
                a84.setBackground(Color.BLACK);
                a84.setForeground(Color.yellow);
                a85.setBackground(Color.BLACK);
                a85.setForeground(Color.yellow);
                a86.setBackground(Color.BLACK);
                a86.setForeground(Color.yellow);
                a87.setBackground(Color.BLACK);
                a87.setForeground(Color.yellow);
                a88.setBackground(Color.BLACK);
                a88.setForeground(Color.yellow);
                a89.setBackground(Color.BLACK);
                a89.setForeground(Color.yellow);
                a90.setBackground(Color.BLACK);
                a90.setForeground(Color.yellow);
                a91.setBackground(Color.BLACK);
                a91.setForeground(Color.yellow);
                a92.setBackground(Color.BLACK);
                a92.setForeground(Color.yellow);
                a93.setBackground(Color.BLACK);
                a93.setForeground(Color.yellow);
                a94.setBackground(Color.BLACK);
                a94.setForeground(Color.yellow);
                a95.setBackground(Color.BLACK);
                a95.setForeground(Color.yellow);
                a96.setBackground(Color.BLACK);
                a96.setForeground(Color.yellow);
                a97.setBackground(Color.BLACK);
                a97.setForeground(Color.yellow);
                a98.setBackground(Color.BLACK);
                a98.setForeground(Color.yellow);
                a99.setBackground(Color.BLACK);
                a99.setForeground(Color.yellow);
                a100.setBackground(Color.BLACK);
                a100.setForeground(Color.yellow);
                a101.setBackground(Color.BLACK);
                a101.setForeground(Color.yellow);
                a102.setBackground(Color.BLACK);
                a102.setForeground(Color.yellow);
                a103.setBackground(Color.BLACK);
                a103.setForeground(Color.yellow);
                a104.setBackground(Color.BLACK);
                a104.setForeground(Color.yellow);
                a105.setBackground(Color.BLACK);
                a105.setForeground(Color.yellow);
                a106.setBackground(Color.BLACK);
                a106.setForeground(Color.yellow);
                a107.setBackground(Color.BLACK);
                a107.setForeground(Color.yellow);
                a108.setBackground(Color.BLACK);
                a108.setForeground(Color.yellow);
                a109.setBackground(Color.BLACK);
                a109.setForeground(Color.yellow);
                a110.setBackground(Color.BLACK);
                a110.setForeground(Color.yellow);
                a111.setBackground(Color.BLACK);
                a111.setForeground(Color.yellow);
                a112.setBackground(Color.BLACK);
                a112.setForeground(Color.yellow);
                a113.setBackground(Color.BLACK);
                a113.setForeground(Color.yellow);
                a114.setBackground(Color.BLACK);
                a114.setForeground(Color.yellow);
                a115.setBackground(Color.BLACK);
                a115.setForeground(Color.yellow);
                a116.setBackground(Color.BLACK);
                a116.setForeground(Color.yellow);
                a117.setBackground(Color.BLACK);
                a117.setForeground(Color.yellow);
                a118.setBackground(Color.BLACK);
                a118.setForeground(Color.yellow);
                a119.setBackground(Color.BLACK);
                a119.setForeground(Color.yellow);
                a120.setBackground(Color.BLACK);
                a120.setForeground(Color.yellow);
                a121.setBackground(Color.BLACK);
                a121.setForeground(Color.yellow);
                a122.setBackground(Color.BLACK);
                a122.setForeground(Color.yellow);
                a123.setBackground(Color.BLACK);
                a123.setForeground(Color.yellow);
                a124.setBackground(Color.BLACK);
                a124.setForeground(Color.yellow);
                a125.setBackground(Color.BLACK);
                a125.setForeground(Color.yellow);
                a126.setBackground(Color.BLACK);
                a126.setForeground(Color.yellow);
                a127.setBackground(Color.BLACK);
                a127.setForeground(Color.yellow);
                a128.setBackground(Color.BLACK);
                a128.setForeground(Color.yellow);
                a129.setBackground(Color.BLACK);
                a129.setForeground(Color.yellow);
                a130.setBackground(Color.BLACK);
                a130.setForeground(Color.yellow);
                a131.setBackground(Color.BLACK);
                a131.setForeground(Color.yellow);
                a132.setBackground(Color.BLACK);
                a132.setForeground(Color.yellow);
                a133.setBackground(Color.BLACK);
                a133.setForeground(Color.yellow);
                a134.setBackground(Color.BLACK);
                a134.setForeground(Color.yellow);
                a135.setBackground(Color.BLACK);
                a135.setForeground(Color.yellow);
                a136.setBackground(Color.BLACK);
                a136.setForeground(Color.yellow);
                a137.setBackground(Color.BLACK);
                a137.setForeground(Color.yellow);
                a138.setBackground(Color.BLACK);
                a138.setForeground(Color.yellow);
                a139.setBackground(Color.BLACK);
                a139.setForeground(Color.yellow);
                a140.setBackground(Color.BLACK);
                a140.setForeground(Color.yellow);
                a141.setBackground(Color.BLACK);
                a141.setForeground(Color.yellow);
                a142.setBackground(Color.BLACK);
                a142.setForeground(Color.yellow);
                a143.setBackground(Color.BLACK);
                a143.setForeground(Color.yellow);
                a144.setBackground(Color.BLACK);
                a144.setForeground(Color.yellow);
                a145.setBackground(Color.BLACK);
                a145.setForeground(Color.yellow);
                a146.setBackground(Color.BLACK);
                a146.setForeground(Color.yellow);
                a147.setBackground(Color.BLACK);
                a147.setForeground(Color.yellow);
                a148.setBackground(Color.BLACK);
                a148.setForeground(Color.yellow);
                a149.setBackground(Color.BLACK);
                a149.setForeground(Color.yellow);
                a150.setBackground(Color.BLACK);
                a150.setForeground(Color.yellow);
                a151.setBackground(Color.BLACK);
                a151.setForeground(Color.yellow);
                a152.setBackground(Color.BLACK);
                a152.setForeground(Color.yellow);
                a153.setBackground(Color.BLACK);
                a153.setForeground(Color.yellow);
                a154.setBackground(Color.BLACK);
                a154.setForeground(Color.yellow);
                a155.setBackground(Color.BLACK);
                a155.setForeground(Color.yellow);
                a156.setBackground(Color.BLACK);
                a156.setForeground(Color.yellow);
                a157.setBackground(Color.BLACK);
                a157.setForeground(Color.yellow);
                a158.setBackground(Color.BLACK);
                a158.setForeground(Color.yellow);
                a159.setBackground(Color.BLACK);
                a159.setForeground(Color.yellow);
                a160.setBackground(Color.BLACK);
                a160.setForeground(Color.yellow);
                a161.setBackground(Color.BLACK);
                a161.setForeground(Color.yellow);
                a162.setBackground(Color.BLACK);
                a162.setForeground(Color.yellow);
                a163.setBackground(Color.BLACK);
                a163.setForeground(Color.yellow);
                a164.setBackground(Color.BLACK);
                a164.setForeground(Color.yellow);
                a165.setBackground(Color.BLACK);
                a165.setForeground(Color.yellow);
                a166.setBackground(Color.BLACK);
                a166.setForeground(Color.yellow);
                a167.setBackground(Color.BLACK);
                a167.setForeground(Color.yellow);
                a168.setBackground(Color.BLACK);
                a168.setForeground(Color.yellow);
                a169.setBackground(Color.BLACK);
                a169.setForeground(Color.yellow);
                a170.setBackground(Color.BLACK);
                a170.setForeground(Color.yellow);
                a171.setBackground(Color.BLACK);
                a171.setForeground(Color.yellow);
                a172.setBackground(Color.BLACK);
                a172.setForeground(Color.yellow);
                a173.setBackground(Color.BLACK);
                a173.setForeground(Color.yellow);
                a174.setBackground(Color.BLACK);
                a174.setForeground(Color.yellow);
                a175.setBackground(Color.BLACK);
                a175.setForeground(Color.yellow);
                a176.setBackground(Color.BLACK);
                a176.setForeground(Color.yellow);
                a177.setBackground(Color.BLACK);
                a177.setForeground(Color.yellow);
                a178.setBackground(Color.BLACK);
                a178.setForeground(Color.yellow);
                a179.setBackground(Color.BLACK);
                a179.setForeground(Color.yellow);
                a180.setBackground(Color.BLACK);
                a180.setForeground(Color.yellow);
                a181.setBackground(Color.BLACK);
                a181.setForeground(Color.yellow);
                a182.setBackground(Color.BLACK);
                a182.setForeground(Color.yellow);
                a183.setBackground(Color.BLACK);
                a183.setForeground(Color.yellow);
                a184.setBackground(Color.BLACK);
                a184.setForeground(Color.yellow);
                a185.setBackground(Color.BLACK);
                a185.setForeground(Color.yellow);
                a186.setBackground(Color.BLACK);
                a186.setForeground(Color.yellow);
                a187.setBackground(Color.BLACK);
                a187.setForeground(Color.yellow);
                a188.setBackground(Color.BLACK);
                a188.setForeground(Color.yellow);
                a189.setBackground(Color.BLACK);
                a189.setForeground(Color.yellow);
                a190.setBackground(Color.BLACK);
                a190.setForeground(Color.yellow);
                a191.setBackground(Color.BLACK);
                a191.setForeground(Color.yellow);
                a192.setBackground(Color.BLACK);
                a192.setForeground(Color.yellow);
                a193.setBackground(Color.BLACK);
                a193.setForeground(Color.yellow);
                a194.setBackground(Color.BLACK);
                a194.setForeground(Color.yellow);
                a195.setBackground(Color.BLACK);
                a195.setForeground(Color.yellow);
                a196.setBackground(Color.BLACK);
                a196.setForeground(Color.yellow);
                a197.setBackground(Color.BLACK);
                a197.setForeground(Color.yellow);
                a198.setBackground(Color.BLACK);
                a198.setForeground(Color.yellow);
                a199.setBackground(Color.BLACK);
                a199.setForeground(Color.yellow);
                a200.setBackground(Color.BLACK);
                a200.setForeground(Color.yellow);

                AsientosLabel.setText("");
                PrecioLabel.setText("0");
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame reservar = new JFrame();
                reservar.setTitle("PoliCine");
                reservar.setContentPane(new ReservaPelicula().MainPanel);
                reservar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reservar.setSize(500, 350);
                reservar.setLocationRelativeTo(null);
                reservar.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                reservar.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
    }
}
