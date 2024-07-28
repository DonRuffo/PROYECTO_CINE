package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarCliente {
    public JPanel MainPanel;
    private JTextField CedulaField;
    private JTextField NombreField;
    private JComboBox EdadBox;
    private JTextField TelefonoField;
    private JTextField DirecField;
    private JPasswordField ContraField;
    private JPasswordField ConfContraField;
    private JButton registrarButton;
    private JButton regresarButton;
    
    DefaultComboBoxModel edadModel = new DefaultComboBoxModel();
    
    public AgregarCliente() {
        EdadBox.setModel(edadModel);
        for (int i=18; i<=100; i++){
            edadModel.addElement(i);
        }
        Border borde = BorderFactory.createLineBorder(Color.black,2);
        CedulaField.setBorder(borde);
        NombreField.setBorder(borde);
        TelefonoField.setBorder(borde);
        DirecField.setBorder(borde);
        ContraField.setBorder(borde);
        ConfContraField.setBorder(borde);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLIENTES cli2 = new CLIENTES();
                String contra=ContraField.getText();
                String confirmar = ConfContraField.getText();
                if(contra.isEmpty() || confirmar.isEmpty() || NombreField.getText().isEmpty() || TelefonoField.getText().isEmpty()
                        || CedulaField.getText().isEmpty() || DirecField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellenar todos los campos");
                }else{
                    if(contra.equals(confirmar)){
                        cli2.setNombre(NombreField.getText());
                        cli2.setCedula(CedulaField.getText());
                        cli2.setContrasena(ContraField.getText());
                        cli2.setDireccion(DirecField.getText());
                        cli2.setEdad(edadModel.getSelectedItem().toString());
                        cli2.setTelefono(TelefonoField.getText());
                        try(MongoClient mongoClient = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                            MongoDatabase Clientes = mongoClient.getDatabase("Clientes");
                            MongoCollection<Document> RegistroClientes = Clientes.getCollection("Datos_clientes");
                            Document documento= new Document("cedula",cli2.getCedula()).append("nombre",cli2.getNombre())
                                    .append("edad",cli2.getEdad()).append("telefono",cli2.getTelefono())
                                    .append("direccion",cli2.getDireccion()).append("contrasena",cli2.getContrasena());
                            RegistroClientes.insertOne(documento);
                            System.out.println("Registro exitoso");
                            CedulaField.setText("");
                            NombreField.setText("");
                            TelefonoField.setText("");
                            DirecField.setText("");
                            ContraField.setText("");
                            ConfContraField.setText("");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, intente de nuevo");
                        ContraField.setText("");
                        ConfContraField.setText("");
                    }
                }
            }
        });
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
