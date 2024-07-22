package org.example;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroClientes {
    private JTextField CedulaRegis;
    private JTextField NombreRegis;
    private JTextField EdadRegis;
    private JTextField TelefonoRegis;
    private JTextField DireccionRegis;
    private JButton registrarButton;
    private JPasswordField ContrasenaRegis;
    public JPanel PanelRegistroCli;
    private JPasswordField ConfContraRegis;
    private JButton regresarButton;

    public RegistroClientes() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLIENTES cli2 = new CLIENTES();
                String contra=ContrasenaRegis.getText();
                String confirmar = ConfContraRegis.getText();
                if(contra.isEmpty() || confirmar.isEmpty() || NombreRegis.getText().isEmpty() || EdadRegis.getText().isEmpty() || TelefonoRegis.getText().isEmpty() || CedulaRegis.getText().isEmpty() || DireccionRegis.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellenar todos los campos");
                }else{
                    if(contra.equals(confirmar)){
                        cli2.setNombre(NombreRegis.getText());
                        cli2.setCedula(CedulaRegis.getText());
                        cli2.setContrasena(ContrasenaRegis.getText());
                        cli2.setDireccion(DireccionRegis.getText());
                        cli2.setEdad(Integer.parseInt(EdadRegis.getText()));
                        cli2.setTelefono(TelefonoRegis.getText());
                        try(MongoClient mongoClient = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                            MongoDatabase Clientes = mongoClient.getDatabase("Clientes");
                            MongoCollection<Document> RegistroClientes = Clientes.getCollection("Datos_clientes");
                            Document documento= new Document("cedula",cli2.getCedula()).append("nombre",cli2.getNombre())
                                    .append("edad",cli2.getEdad()).append("telefono",cli2.getTelefono())
                                    .append("direccion",cli2.getDireccion()).append("contrasena",cli2.getContrasena());
                            RegistroClientes.insertOne(documento);
                            System.out.println("Registro exitoso");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, intente de nuevo");
                        ContrasenaRegis.setText("");
                        ConfContraRegis.setText("");
                    }
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame login = new JFrame();
                login.setContentPane(new Login().PanelLoign);
                login.setTitle("Inicio de sesión");
                login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                login.setSize(500,300);
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
    }
}
