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

public class VentasPorPelicula {
    private JComboBox PeliculaBox;
    private JComboBox AnioBox;
    private JComboBox MesBox;
    private JButton cargarButton;
    private JButton regresarButton;
    public JPanel MainPanel;
    private JPanel PanelInfo;
    private JLabel FuncionLabel;
    private JLabel AforoTotalLabel;
    private JLabel AforoVendidoLabel;
    private JLabel precioLabel;
    private JLabel TotalEsperadoLabel;
    private JLabel TotalVendidoLabel;
    private JLabel porcentajeLabel;

    DefaultComboBoxModel peliculaModel = new DefaultComboBoxModel();
    DefaultComboBoxModel anioModel = new DefaultComboBoxModel();
    DefaultComboBoxModel mesModel = new DefaultComboBoxModel();



    public VentasPorPelicula() {
        PeliculaBox.setModel(peliculaModel);
        AnioBox.setModel(anioModel);
        anioModel.addElement("Año");
        MesBox.setModel(mesModel);
        mesModel.addElement("Mes");
        List<String> pelis = new ArrayList<>();
        List<String> anios = new ArrayList<>();
        List<String> mes = new ArrayList<>();

        peliculaModel.addElement("Película");
        try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
            MongoDatabase baseBase = cliente.getDatabase("Peliculas");
            MongoCollection<Document> peliculas = baseBase.getCollection("Datos_Peliculas");
            FindIterable<Document> encontrar = peliculas.find();
            for(Document documento : encontrar){
                pelis.add(documento.getString("titulo"));
            }
            List<String> nuevasPelis = removerduplicados(pelis);
            for(int i=0;i<nuevasPelis.size();i++){
                peliculaModel.addElement(nuevasPelis.get(i));
            }nuevasPelis.clear();
            pelis.clear();
        }

        PeliculaBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelInfo.setVisible(false);
                if(AnioBox.getItemCount()>1){
                    for(int i=0; i<anios.size(); i++){
                        AnioBox.removeItem(anios.get(i));
                    }anios.clear();
                }
                PELICULAS peliVenta = new PELICULAS();
                peliVenta.setTitulo(peliculaModel.getSelectedItem().toString());
                    try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                        MongoDatabase baseBase = cliente.getDatabase("Peliculas");
                        MongoCollection<Document> validacion = baseBase.getCollection("Datos_Peliculas");
                        FindIterable<Document> encontrando = validacion.find();
                        for(Document documento : encontrando){
                            if(documento.getString("titulo").equals(peliVenta.getTitulo())){
                                anios.add(documento.getString("fecha").substring(6,10));
                            }
                        }
                        List<String> nuevasAnios = removerduplicados(anios);
                        for (int i=0; i<nuevasAnios.size();i++){
                            anioModel.addElement(nuevasAnios.get(i));
                        }nuevasAnios.clear();
                    }

            }
        });
        AnioBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(MesBox.getItemCount()>1){
                    for(int i=0; i<mes.size(); i++){
                        MesBox.removeItem(mes.get(i));
                    }mes.clear();
                }
                PELICULAS peliVenta2 = new PELICULAS();
                peliVenta2.setAnio(anioModel.getSelectedItem().toString());
                peliVenta2.setTitulo(peliculaModel.getSelectedItem().toString());
                    try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                        MongoDatabase baseBase = cliente.getDatabase("Peliculas");
                        MongoCollection<Document> validacion2 = baseBase.getCollection("Datos_Peliculas");
                        FindIterable<Document> encontrando = validacion2.find();
                        for(Document documento : encontrando){
                            if(documento.getString("titulo").equals(peliVenta2.getTitulo())
                                    && documento.getString("fecha").substring(6,10).equals(peliVenta2.getAnio())){
                                mes.add(documento.getString("fecha").substring(3,5));
                            }
                        }
                        List<String> nuevosMeses = removerduplicados(mes);
                        for (int i = 0; i< nuevosMeses.size(); i++){
                            mesModel.addElement(nuevosMeses.get(i));
                        }
                        nuevosMeses.clear();
                    }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventas = new JFrame();
                ventas.setTitle("PoliCine");
                ventas.setContentPane(new Ventas().MainPanel);
                ventas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventas.setSize(500, 350);
                ventas.setLocationRelativeTo(null);
                ventas.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                ventas.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PELICULAS peliCargar = new PELICULAS();
                peliCargar.setTitulo(peliculaModel.getSelectedItem().toString());
                peliCargar.setAnio(anioModel.getSelectedItem().toString());
                peliCargar.setMes(mesModel.getSelectedItem().toString());

                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    if (peliCargar.getAnio().equals("Año") && peliCargar.getMes().equals("Mes")){
                        JOptionPane.showMessageDialog(null, "Elija al menos un año");
                    }else{
                        if(peliCargar.getAnio().equals("Año") && !peliCargar.getMes().equals("Mes")){
                            JOptionPane.showMessageDialog(null, "Elija a partir del año");
                        }else{
                            if(!peliCargar.getAnio().equals("Año") && peliCargar.getMes().equals("Mes")){
                                PanelInfo.setVisible(true);
                                int encontrarPeli =0;
                                int asientosVendidos =0;
                                int vecesEncontradas =0;
                                double precio_asiento =0;
                                MongoDatabase mensual = cliente.getDatabase(peliCargar.getAnio());
                                MongoCollection<Document> validacion = mensual.getCollection("Anual");
                                FindIterable<Document> encontrando = validacion.find();
                                for(Document documento : encontrando){
                                    if(documento.getString("titulo").equals(peliCargar.getTitulo())){
                                        encontrarPeli++;
                                    }
                                }
                                FuncionLabel.setText(String.valueOf(encontrarPeli));
                                AforoTotalLabel.setText(String.valueOf(encontrarPeli*200));
                                for(Document documento1 : encontrando){
                                    if(documento1.getString("titulo").equals(peliCargar.getTitulo())){
                                        asientosVendidos+=Integer.parseInt(documento1.getString("asientos_vendidos"));
                                        precio_asiento=documento1.getDouble("precio_asiento");
                                        vecesEncontradas++;
                                    }
                                }
                                double totalEsperado = precio_asiento*200*vecesEncontradas;
                                double totalVendido = precio_asiento*asientosVendidos;
                                double porcentaje = (totalVendido*100)/totalEsperado;
                                AforoVendidoLabel.setText(String.valueOf(asientosVendidos));
                                precioLabel.setText("$"+precio_asiento);
                                TotalEsperadoLabel.setText("$"+String.format("%.2f",totalEsperado));
                                TotalVendidoLabel.setText("$"+String.format("%.2f",totalVendido));
                                porcentajeLabel.setText(String.format("%.2f",porcentaje)+"%");
                            }else{
                                PanelInfo.setVisible(true);
                                int encontrarPeli =0;
                                int asientosVendidos =0;
                                int vecesEncontradas =0;
                                double precio_asiento =0;
                                MongoDatabase anual = cliente.getDatabase(peliCargar.getAnio());
                                MongoCollection<Document> validacion = anual.getCollection(peliCargar.getMes());
                                FindIterable<Document> encontrando = validacion.find();
                                for(Document documento : encontrando){
                                    if(documento.getString("titulo").equals(peliCargar.getTitulo())){
                                        encontrarPeli++;
                                    }
                                }
                                FuncionLabel.setText(String.valueOf(encontrarPeli));
                                AforoTotalLabel.setText(String.valueOf(encontrarPeli*200));
                                for(Document documento1 : encontrando){
                                    if(documento1.getString("titulo").equals(peliCargar.getTitulo())){
                                        asientosVendidos+=Integer.parseInt(documento1.getString("asientos_vendidos"));
                                        precio_asiento=documento1.getDouble("precio_asiento");
                                        vecesEncontradas++;
                                    }
                                }
                                double totalEsperado = precio_asiento*200*vecesEncontradas;
                                double totalVendido = precio_asiento*asientosVendidos;
                                double porcentaje = (totalVendido*100)/totalEsperado;
                                AforoVendidoLabel.setText(String.valueOf(asientosVendidos));
                                precioLabel.setText("$"+precio_asiento);
                                TotalEsperadoLabel.setText("$"+String.format("%.2f",totalEsperado));
                                TotalVendidoLabel.setText("$"+String.format("%.2f",totalVendido));
                                porcentajeLabel.setText(String.format("%.2f",porcentaje)+"%");
                            }
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
