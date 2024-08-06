package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;


public class Login {
    private JTextField UsuarioField;
    private JComboBox PerfilBox;
    private JButton iniciarSesiónButton;
    private JPasswordField ContraField;
    private JButton registrarseButton;
    public JPanel PanelLoign;

    DefaultComboBoxModel perfil= new DefaultComboBoxModel();

    public Login() {
        System.out.println("IMPRIME PTM");
        PerfilBox.setModel(perfil);
        Border borde = BorderFactory.createLineBorder(Color.black);
        UsuarioField.setBorder(borde);
        ContraField.setBorder(borde);
        perfil.addElement("Administrador");
        perfil.addElement("Cliente");
        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario=perfil.getSelectedItem().toString();
                System.out.println("CONECTADO");
                if(UsuarioField.getText().isEmpty() || ContraField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese sus datos por favor");
                }else {

                    if (usuario.equals("Administrador")) {
                        try (MongoClient clienteMongo = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")) {
                            MongoDatabase Administradores = clienteMongo.getDatabase("Administradores");
                            MongoCollection<Document> datos = Administradores.getCollection("Datos_administrador");
                            FindIterable<Document> documentos = datos.find();
                            ADMINISTRADORES adm1 = new ADMINISTRADORES();
                            adm1.setNombre(UsuarioField.getText());
                            adm1.setContrasena(ContraField.getText());
                            int identificador = 0;
                            for (Document documento : documentos) {
                                if (documento.getString("nombre").equals(adm1.getNombre()) && documento.getString("contrasena").equals(adm1.getContrasena())) {
                                    identificador = 1;
                                    JFrame paginaAdministrador = new JFrame();
                                    paginaAdministrador.setTitle("PoliCine");
                                    paginaAdministrador.setContentPane(new PaginaAdministrador().PanelPaginaAdmin);
                                    paginaAdministrador.setSize(500, 350);
                                    paginaAdministrador.setLocationRelativeTo(null);
                                    paginaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    paginaAdministrador.setVisible(true);
                                    ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                                    paginaAdministrador.setIconImage(imagen.getImage());
                                    ((JFrame) SwingUtilities.getWindowAncestor(iniciarSesiónButton)).dispose();
                                }
                            }
                            if (identificador == 0) {
                                JOptionPane.showMessageDialog(null, "Error de credenciales, intente de nuevo");
                                UsuarioField.setText("");
                                ContraField.setText("");
                            }
                            identificador = 0;
                        }
                    } else if (usuario.equals("Cliente")) {
                        try (MongoClient mongoCliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")) {
                            MongoDatabase clientes = mongoCliente.getDatabase("Clientes");
                            MongoCollection<Document> datos = clientes.getCollection("Datos_clientes");

                            FindIterable<Document> documentos = datos.find();
                            CLIENTES cli1 = new CLIENTES();
                            cli1.setNombre(UsuarioField.getText());
                            cli1.setContrasena(ContraField.getText());
                            for (Document documento : documentos) {
                                if (documento.getString("nombre").equals(cli1.getNombre()) && documento.getString("contrasena").equals(cli1.getContrasena())) {
                                    JFrame paginaClientes = new JFrame();
                                    paginaClientes.setTitle("PoliCine");
                                    paginaClientes.setContentPane(new PaginaClientes().MainPanel);
                                    paginaClientes.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                    paginaClientes.setSize(500, 350);
                                    paginaClientes.setLocationRelativeTo(null);
                                    paginaClientes.setVisible(true);
                                    ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                                    paginaClientes.setIconImage(imagen.getImage());
                                    ((JFrame) SwingUtilities.getWindowAncestor(iniciarSesiónButton)).dispose();
                                }
                            }
                        }
                    }


                }
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registroClientes = new JFrame();
                registroClientes.setTitle("PoliCine");
                registroClientes.setContentPane(new RegistroClientes().MainPanel);
                registroClientes.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                registroClientes.setSize(500,350);
                registroClientes.setLocationRelativeTo(null);
                registroClientes.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                registroClientes.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(registrarseButton)).dispose();
            }
        });
    }
}


