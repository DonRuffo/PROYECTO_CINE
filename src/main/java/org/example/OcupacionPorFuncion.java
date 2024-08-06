package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OcupacionPorFuncion {
    public JPanel MainPanel;
    private JComboBox AnioBox1;
    private JComboBox MesBox1;
    private JComboBox DiaBox1;
    private JComboBox HoraBox1;
    private JComboBox SalaBox;
    private JComboBox AnioBox2;
    private JComboBox MesBox2;
    private JComboBox DiaBox2;
    private JComboBox HoraBox2;
    private JPanel PanelFuncion;
    private JPanel PanelSala;
    private JButton cargarFecha;
    private JButton cargarSala;
    private JLabel AnioLabel;
    private JLabel MesLabel;
    private JLabel DiaLabel;
    private JLabel HoraLabel;
    private JLabel VendidosLabel;
    private JLabel TotalLabel;
    private JLabel PorcentajeLabel;
    private JLabel SalaLabel2;
    private JLabel AnioLabel2;
    private JLabel MesLabel2;
    private JLabel DiaLabel2;
    private JLabel HoraLabel2;
    private JLabel VendidosLabel2;
    private JLabel TotalLabel2;
    private JLabel PorcentajeLabel2;

    //Para función
    DefaultComboBoxModel horaModel =new DefaultComboBoxModel();
    DefaultComboBoxModel diaModel=new DefaultComboBoxModel();
    DefaultComboBoxModel mesModel=new DefaultComboBoxModel();
    DefaultComboBoxModel anioModel =new DefaultComboBoxModel();

    //Para Sala
    DefaultComboBoxModel mesModelSala=new DefaultComboBoxModel();
    DefaultComboBoxModel salaModel=new DefaultComboBoxModel();
    DefaultComboBoxModel anioModelSala =new DefaultComboBoxModel();
    DefaultComboBoxModel diaModelSala=new DefaultComboBoxModel();
    DefaultComboBoxModel horaModelSala=new DefaultComboBoxModel();

    public OcupacionPorFuncion() {
        HoraBox1.setModel(horaModel);
        horaModel.addElement("Hora");
        horaModel.addElement("12:00");
        horaModel.addElement("15:00");
        horaModel.addElement("18:00");
        horaModel.addElement("21:00");

        HoraBox2.setModel(horaModelSala);
        horaModelSala.addElement("Hora");
        horaModelSala.addElement("12:00");
        horaModelSala.addElement("15:00");
        horaModelSala.addElement("18:00");
        horaModelSala.addElement("21:00");

        SalaBox.setModel(salaModel);
        salaModel.addElement("Sala");
        for(int i=1; i<=10; i++){
            salaModel.addElement(i);
        }

        AnioBox1.setModel(anioModel);
        anioModel.addElement("Año");
        anioModel.addElement("2024");
        anioModel.addElement("2025");

        AnioBox2.setModel(anioModelSala);
        anioModelSala.addElement("Año");
        anioModelSala.addElement("2024");
        anioModelSala.addElement("2025");

        MesBox1.setModel(mesModel);
        mesModel.addElement("Mes");
        for(int i=1; i<=9; i++){
            mesModel.addElement("0"+i);
        }
        mesModel.addElement("10");
        mesModel.addElement("11");
        mesModel.addElement("12");

        MesBox2.setModel(mesModelSala);
        mesModelSala.addElement("Mes");
        for(int i=1; i<=9; i++){
            mesModelSala.addElement("0"+i);
        }
        mesModelSala.addElement("10");
        mesModelSala.addElement("11");
        mesModelSala.addElement("12");

        DiaBox1.setModel(diaModel);
        diaModel.addElement("Día");
        for(int j=1; j<=9; j++){
            diaModel.addElement("0"+j);
        }
        for(int i=10; i<=31; i++){
            diaModel.addElement(i);
        }

        DiaBox2.setModel(diaModelSala);
        diaModelSala.addElement("Día");
        for(int j=1; j<=9; j++){
            diaModelSala.addElement("0"+j);
        }
        for(int i=10; i<=31; i++){
            diaModelSala.addElement(i);
        }

        MesBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PELICULAS peliMes1 =new PELICULAS();
                peliMes1.setMes(mesModel.getSelectedItem().toString());
                peliMes1.setAnio(anioModel.getSelectedItem().toString());
                if(peliMes1.getMes().equals("01") || peliMes1.getMes().equals("03") || peliMes1.getMes().equals("05")
                        || peliMes1.getMes().equals("07") || peliMes1.getMes().equals("08") || peliMes1.getMes().equals("10")
                        || peliMes1.getMes().equals("12")){
                    DiaBox1.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=31; i++){
                        diaModel.addElement(i);
                    }
                }else if(peliMes1.getMes().equals("04") || peliMes1.getMes().equals("06") || peliMes1.getMes().equals("09")
                        || peliMes1.getMes().equals("11")){
                    DiaBox1.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=30; i++){
                        diaModel.addElement(i);
                    }
                }else if(peliMes1.getMes().equals("02") && peliMes1.getAnio().equals("2024")){
                    DiaBox1.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=29; i++){
                        diaModel.addElement(i);
                    }
                }else if(peliMes1.getAnio().equals("2025") && peliMes1.getMes().equals("02")){
                    DiaBox1.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=28; i++){
                        diaModel.addElement(i);
                    }
                }
            }
        });
        MesBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PELICULAS peliMes2 =new PELICULAS();
                peliMes2.setMes(mesModelSala.getSelectedItem().toString());
                peliMes2.setAnio(anioModelSala.getSelectedItem().toString());
                if(peliMes2.getMes().equals("01") || peliMes2.getMes().equals("03") || peliMes2.getMes().equals("05")
                        || peliMes2.getMes().equals("07") || peliMes2.getMes().equals("08") || peliMes2.getMes().equals("10")
                        || peliMes2.getMes().equals("12")){
                    DiaBox2.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=31; i++){
                        diaModel.addElement(i);
                    }
                }else if(peliMes2.getMes().equals("04") || peliMes2.getMes().equals("06") || peliMes2.getMes().equals("09")
                        || peliMes2.getMes().equals("11")){
                    DiaBox2.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=30; i++){
                        diaModel.addElement(i);
                    }
                }else if(peliMes2.getMes().equals("02") && peliMes2.getAnio().equals("2024")){
                    DiaBox2.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=29; i++){
                        diaModel.addElement(i);
                    }
                }else if(peliMes2.getAnio().equals("2025") && peliMes2.getMes().equals("02")){
                    DiaBox2.removeAllItems();
                    for(int j=1; j<=9; j++){
                        diaModel.addElement("0"+j);
                    }
                    for(int i=10; i<=28; i++){
                        diaModel.addElement(i);
                    }
                }
            }
        });


        cargarFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PELICULAS peliCarga = new PELICULAS();
                peliCarga.setAnio(anioModel.getSelectedItem().toString());
                peliCarga.setMes(mesModel.getSelectedItem().toString());
                peliCarga.setDia(diaModel.getSelectedItem().toString());
                peliCarga.setHorario(horaModel.getSelectedItem().toString());

                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    if(peliCarga.getAnio().equals("Año") && peliCarga.getMes().equals("Mes") && peliCarga.getDia().equals("Día")
                        && peliCarga.getHorario().equals("Hora")){
                        JOptionPane.showMessageDialog(null, "Seleccione al menos el año");
                    }else{
                        if(!peliCarga.getAnio().equals("Año")){
                            int contadorDeAsientosVendidos =0;
                            int contadorDeElementos =0;
                            MongoDatabase anual = cliente.getDatabase(peliCarga.getAnio());
                            MongoCollection<Document> collection = anual.getCollection("Anual");
                            FindIterable<Document> iterable = collection.find();
                            for(Document documento : iterable){
                                contadorDeAsientosVendidos +=Integer.parseInt(documento.getString("asientos_vendidos"));
                                contadorDeElementos++;
                            }
                            int asientosTotales=contadorDeElementos*200;
                            double porcentajeVentas = (contadorDeAsientosVendidos*100)/asientosTotales;
                            PanelFuncion.setVisible(true);
                            AnioLabel.setText("Año: "+peliCarga.getAnio());
                            VendidosLabel.setText("Asientos vendidos: "+contadorDeAsientosVendidos);
                            TotalLabel.setText("Asientos totales: "+asientosTotales);
                            PorcentajeLabel.setText("Porcentaje de ocupación: "+porcentajeVentas+"%");
                        }
                        if(!peliCarga.getAnio().equals("Año") && !peliCarga.getMes().equals("Mes")){
                            int contadorDeAsientosVendidos =0;
                            int contadorDeElementos =0;
                            MongoDatabase mensual = cliente.getDatabase(peliCarga.getAnio());
                            MongoCollection<Document> colleccionMes = mensual.getCollection(peliCarga.getMes());
                            FindIterable<Document> busquedaMes = colleccionMes.find();
                            for(Document documento : busquedaMes){
                                contadorDeAsientosVendidos +=Integer.parseInt(documento.getString("asientos_vendidos"));
                                contadorDeElementos++;
                            }
                            int asientosTotales=contadorDeElementos*200;
                            double porcentajeVentas = (contadorDeAsientosVendidos*100)/asientosTotales;
                            PanelFuncion.setVisible(true);
                            AnioLabel.setText("Año: "+peliCarga.getAnio());
                            MesLabel.setText("Mes: "+MesNombre(peliCarga));
                            VendidosLabel.setText("Asientos vendidos: "+contadorDeAsientosVendidos);
                            TotalLabel.setText("Asientos totales: "+asientosTotales);
                            PorcentajeLabel.setText("Porcentaje de ocupación: "+porcentajeVentas+"%");
                        }
                        if(!peliCarga.getAnio().equals("Año") && !peliCarga.getMes().equals("Mes")
                            && !peliCarga.getDia().equals("Día")){
                            int contadorDeAsientosVendidos =0;
                            int contadorDeElementos =0;
                            MongoDatabase mensual = cliente.getDatabase(peliCarga.getAnio());
                            MongoCollection<Document> colleccionDia = mensual.getCollection(peliCarga.getMes());
                            FindIterable<Document> busquedaDia = colleccionDia.find();
                            for(Document documento : busquedaDia){
                                if((documento.getString("fecha").substring(0,2)).equals(peliCarga.getDia())){
                                    contadorDeAsientosVendidos +=Integer.parseInt(documento.getString("asientos_vendidos"));
                                    contadorDeElementos++;
                                }
                            }
                            int asientosTotales=contadorDeElementos*200;
                            double porcentajeVentas = (contadorDeAsientosVendidos*100)/asientosTotales;
                            PanelFuncion.setVisible(true);
                            AnioLabel.setText("Año: "+peliCarga.getAnio());
                            MesLabel.setText("Mes: "+MesNombre(peliCarga));
                            DiaLabel.setText("Dia: "+peliCarga.getDia());
                            VendidosLabel.setText("Asientos vendidos: "+contadorDeAsientosVendidos);
                            TotalLabel.setText("Asientos totales: "+asientosTotales);
                            PorcentajeLabel.setText("Porcentaje de ocupación: "+porcentajeVentas+"%");
                        }
                        if(!peliCarga.getAnio().equals("Año") && !peliCarga.getMes().equals("Mes")
                                && !peliCarga.getDia().equals("Día") && !peliCarga.getHorario().equals("Hora")){
                            int contadorDeAsientosVendidos =0;
                            int contadorDeElementos =0;
                            MongoDatabase mensual = cliente.getDatabase(peliCarga.getAnio());
                            MongoCollection<Document> colleccionHora = mensual.getCollection(peliCarga.getMes());
                            FindIterable<Document> busquedaHora = colleccionHora.find();
                            for(Document documento : busquedaHora){
                                if((documento.getString("fecha").substring(0,2)).equals(peliCarga.getDia())){
                                    if(documento.getString("hora").equals(peliCarga.getHorario())){
                                        contadorDeAsientosVendidos +=Integer.parseInt(documento.getString("asientos_vendidos"));
                                        contadorDeElementos++;
                                    }
                                }
                            }
                            int asientosTotales=contadorDeElementos*200;
                            double porcentajeVentas = (contadorDeAsientosVendidos*100)/asientosTotales;
                            PanelFuncion.setVisible(true);
                            AnioLabel.setText("Año: "+peliCarga.getAnio());
                            MesLabel.setText("Mes: "+MesNombre(peliCarga));
                            DiaLabel.setText("Dia: "+peliCarga.getDia());
                            HoraLabel.setText("Hora: "+peliCarga.getHorario());
                            VendidosLabel.setText("Asientos vendidos: "+contadorDeAsientosVendidos);
                            TotalLabel.setText("Asientos totales: "+asientosTotales);
                            PorcentajeLabel.setText("Porcentaje de ocupación: "+porcentajeVentas+"%");
                        }
                    }


                }
            }
        });
    }
    public String MesNombre(PELICULAS objeto){
        String nombre = "";
        if(objeto.getMes().equals("01")){
            nombre="Enero";
        }
        else if(objeto.getMes().equals("02")){
            nombre="Febrero";
        }
        else if(objeto.getMes().equals("03")){
            nombre="Marzo";
        }
        else if(objeto.getMes().equals("04")){
            nombre="Abril";
        }
        else if(objeto.getMes().equals("05")){
            nombre="Mayo";
        }
        else if(objeto.getMes().equals("06")){
            nombre="Junio";
        }
        else if(objeto.getMes().equals("07")){
            nombre="Julio";
        }
        else if(objeto.getMes().equals("08")){
            nombre="Agosto";
        }
        else if(objeto.getMes().equals("09")){
            nombre="Septiembre";
        }
        else if(objeto.getMes().equals("10")){
            nombre="Octubre";
        }
        else if(objeto.getMes().equals("11")){
            nombre="Noviembre";
        }
        else if(objeto.getMes().equals("12")){
            nombre="Diciembre";
        }
        return nombre;
    }
}
