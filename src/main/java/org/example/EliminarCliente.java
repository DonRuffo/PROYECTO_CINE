package org.example;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarCliente {
    private JTextField CedulaField;
    private JPanel PaneliInfo;
    private JButton eliminarButton;
    private JButton regresarButton;
    private JLabel NombreLabel;
    private JLabel EdadLabel;
    private JLabel TelefonoLabel;
    private JLabel DirecLabel;
    private JButton verButton;
    public JPanel MainPanel;

    public EliminarCliente() {
        Border borde = BorderFactory.createLineBorder(Color.black,2);
        CedulaField.setBorder(borde);
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
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLIENTES clienteEliminar= new CLIENTES();
                clienteEliminar.setCedula(CedulaField.getText());
                try(MongoClient conec = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")) {
                    MongoDatabase base = conec.getDatabase("Clientes");
                    MongoCollection<Document> cliente= base.getCollection("Datos_clientes");
                    Document eliminarlo = new Document("cedula",clienteEliminar.getCedula());
                    DeleteResult resul = cliente.deleteOne(eliminarlo);
                }
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
                CedulaField.setText("");
                NombreLabel.setText("");
                EdadLabel.setText("");
                TelefonoLabel.setText("");
                DirecLabel.setText("");
                PaneliInfo.setVisible(false);
            }
        });
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean comprobarCedula=numero(CedulaField.getText());
                if (CedulaField.getText().length()!=10){
                    JOptionPane.showMessageDialog(null, "La cedula debe tener 10 dígitos");
                }else{
                    if(comprobarCedula == false){
                        JOptionPane.showMessageDialog(null, "Ingrese dígitos numéricos");
                    }else{
                        int iterador=0;
                        CLIENTES clienteVer = new CLIENTES();
                        clienteVer.setCedula(CedulaField.getText());
                        try(MongoClient conec = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                            MongoDatabase peliculas=conec.getDatabase("Clientes");
                            MongoCollection<Document> datos=peliculas.getCollection("Datos_clientes");

                            FindIterable<Document> cliente= datos.find();
                            for (Document documento: cliente){
                                if (documento.getString("cedula").equals(clienteVer.getCedula())){
                                    NombreLabel.setText(documento.getString("nombre"));
                                    EdadLabel.setText(documento.getString("edad"));
                                    TelefonoLabel.setText(documento.getString("telefono"));
                                    DirecLabel.setText(documento.getString("direccion"));
                                    iterador=1;
                                }
                            }
                        }
                        if(iterador==0){
                            JOptionPane.showMessageDialog(null, "El cliente no existe");
                        }else {
                            eliminarButton.setVisible(true);
                            PaneliInfo.setVisible(true);
                        }
                    }
                }
            }
        });
    }
    public boolean numero(String cadena){
        try{
            Long.parseLong(cadena);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
