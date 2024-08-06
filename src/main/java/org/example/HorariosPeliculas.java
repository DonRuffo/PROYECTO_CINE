package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

public class HorariosPeliculas {
    public JPanel MainPanel;
    private JScrollPane ScrollTabla;
    private JButton regresarButton;


    public HorariosPeliculas() {
        int iterador=0; //navegar en el objeto
        int contador=0; //contar  los datos en la base
        String [] cabecera = {"Título","Categoría","Restricción_Edad","Fecha","Sala", "Hora", "Precio ($)"};

        try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
            MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
            MongoCollection<Document> coleccion = baseDeDatos.getCollection("Datos_Peliculas");

            FindIterable<Document> encontrar = coleccion.find();
            for(Document indexador : encontrar){
               contador++;
            }
            Object [][] datos = new Object[contador][7];
            for(Document incrustarDatos : encontrar){
                datos[iterador][0]=incrustarDatos.getString("titulo");
                datos[iterador][1]=incrustarDatos.getString("categoria");
                datos[iterador][2]=incrustarDatos.getString("restriccion_edad");
                datos[iterador][3]=incrustarDatos.getString("fecha");
                datos[iterador][4]=incrustarDatos.getString("sala");
                datos[iterador][5]=incrustarDatos.getString("hora");
                datos[iterador][6]=incrustarDatos.getDouble("precio_asiento");
                iterador++;
            }
            Arrays.sort(datos, new Comparator<Object[]>() {
                @Override
                public int compare(Object[] fila1, Object[] fila2) {
                    return fila1[0].toString().compareTo(fila2[0].toString());
                }
            });

            DefaultTableModel model = new DefaultTableModel(datos, cabecera){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable tablaDatos= new JTable(model);
            ScrollTabla.setViewportView(tablaDatos);
            ScrollTabla.getViewport().setBackground(Color.getHSBColor(54,34,12));
            tablaDatos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
            tablaDatos.setBackground(Color.WHITE);
            tablaDatos.setRowSelectionAllowed(false);
            tablaDatos.setCellSelectionEnabled(true);
        }

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
    }

}
