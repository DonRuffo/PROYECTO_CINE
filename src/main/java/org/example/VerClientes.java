package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerClientes {
    public JPanel MainPanel;
    private JScrollPane Scroll;
    private JButton regresarButton;
    Object [][] datos={{"1234567890", "Dennis", "0987654321", "21", "El Conde"}};
    Object[][] datos1 = new Object[4][5];
    public VerClientes() {
        int iterador=0;

        String [] cabecera = {"Cedula","Nombre","Telefono","Edad","Direccion"};
        try(MongoClient conexion = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
            MongoDatabase datab = conexion.getDatabase("Clientes");
            MongoCollection<Document> coleccion = datab.getCollection("Datos_clientes");
            FindIterable<Document> busqueda = coleccion.find();
            for(Document busquedaDato : busqueda){
                datos1[iterador][0] = busquedaDato.getString("cedula");
                datos1[iterador][1] = busquedaDato.getString("nombre");
                datos1[iterador][2] = busquedaDato.getString("telefono");
                datos1[iterador][3] = busquedaDato.getString("edad");
                datos1[iterador][4] = busquedaDato.getString("direccion");
                iterador+=1;
            }
        }
        DefaultTableModel modelo = new DefaultTableModel(datos1, cabecera){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tabla = new JTable(modelo);
        Scroll.setViewportView(tabla);
        Scroll.getViewport().setBackground(Color.green);
        tabla.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tabla.setBackground(Color.WHITE);
        tabla.setRowSelectionAllowed(false);
        tabla.setCellSelectionEnabled(true);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionarClientes = new JFrame();
                gestionarClientes.setTitle("PoliCine");
                gestionarClientes.setContentPane(new GestionarClientes().MainPanel);
                gestionarClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gestionarClientes.setSize(500, 300);
                gestionarClientes.setLocationRelativeTo(null);
                gestionarClientes.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
    }
}
