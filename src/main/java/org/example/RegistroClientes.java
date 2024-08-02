package org.example;
import com.mongodb.client.*;
import org.bson.Document;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroClientes {
    private JTextField CedulaRegis;
    private JTextField NombreRegis;
    private JTextField TelefonoRegis;
    private JTextField DireccionRegis;
    private JButton registrarButton;
    private JPasswordField ContrasenaRegis;
    public JPanel MainPanel;
    private JPasswordField ConfContraRegis;
    private JButton regresarButton;
    private JComboBox EdadBox;

    DefaultComboBoxModel edadModel = new DefaultComboBoxModel();
    public RegistroClientes() {

        EdadBox.setModel(edadModel);
        for (int i=18; i<=100; i++){
            edadModel.addElement(i);
        }
        Border borde = BorderFactory.createLineBorder(Color.black,2);
        CedulaRegis.setBorder(borde);
        NombreRegis.setBorder(borde);
        TelefonoRegis.setBorder(borde);
        DireccionRegis.setBorder(borde);
        ContrasenaRegis.setBorder(borde);
        ConfContraRegis.setBorder(borde);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CLIENTES cli2 = new CLIENTES();
                String contra=ContrasenaRegis.getText();
                String confirmar = ConfContraRegis.getText();
                if(contra.isEmpty() || confirmar.isEmpty() || NombreRegis.getText().isEmpty() || TelefonoRegis.getText().isEmpty() || CedulaRegis.getText().isEmpty() || DireccionRegis.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellenar todos los campos");
                }else{
                    if(CedulaRegis.getText().length() != 10 || TelefonoRegis.getText().length() != 10){
                        JOptionPane.showMessageDialog(null, "La cedula y el telefono deben tener 10 dígitos");
                    }else{
                        Boolean comprobarCedula=numero(CedulaRegis.getText());
                        Boolean comprobarTelefono=numero(TelefonoRegis.getText());
                        Boolean comprobarNombre=letrassinnumeros(NombreRegis.getText());
                        if(comprobarCedula==false || comprobarTelefono==false){
                            JOptionPane.showMessageDialog(null, "Ingrese dígitos numéricos en cedula y telefono");
                        }else{
                            if(comprobarNombre==false){
                                JOptionPane.showMessageDialog(null, "Solo se permiten letras en el nombre");
                            }else{
                                if(contra.equals(confirmar)){
                                    cli2.setNombre(NombreRegis.getText());
                                    cli2.setCedula(CedulaRegis.getText());
                                    cli2.setContrasena(ContrasenaRegis.getText());
                                    cli2.setDireccion(DireccionRegis.getText());
                                    cli2.setEdad(edadModel.getSelectedItem().toString());
                                    cli2.setTelefono(TelefonoRegis.getText());
                                    try(MongoClient mongoClient = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                                        MongoDatabase Clientes = mongoClient.getDatabase("Clientes");
                                        MongoCollection<Document> RegistroClientes = Clientes.getCollection("Datos_clientes");
                                        FindIterable<Document> RegistroCliente = RegistroClientes.find();
                                        int verificar=0;
                                        for(Document buscar : RegistroCliente){
                                            if(buscar.getString("cedula").equals(cli2.getCedula())){
                                                JOptionPane.showMessageDialog(null, "El cliente con N°cédula: "+cli2.getCedula()+" ya existe");
                                                verificar=1;
                                                CedulaRegis.setText("");
                                                NombreRegis.setText("");
                                                TelefonoRegis.setText("");
                                                DireccionRegis.setText("");
                                                ContrasenaRegis.setText("");
                                                ConfContraRegis.setText("");
                                            }
                                        }
                                        if(verificar==0) {
                                            Document documento = new Document("cedula", cli2.getCedula()).append("nombre", cli2.getNombre())
                                                    .append("edad", cli2.getEdad()).append("telefono", cli2.getTelefono())
                                                    .append("direccion", cli2.getDireccion()).append("contrasena", cli2.getContrasena());
                                            RegistroClientes.insertOne(documento);
                                            JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                            CedulaRegis.setText("");
                                            NombreRegis.setText("");
                                            TelefonoRegis.setText("");
                                            DireccionRegis.setText("");
                                            ContrasenaRegis.setText("");
                                            ConfContraRegis.setText("");
                                        }
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, intente de nuevo");
                                    ContrasenaRegis.setText("");
                                    ConfContraRegis.setText("");
                                }
                            }
                        }
                    }
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame login = new JFrame();
                login.setContentPane(new Login().PanelLoign);
                login.setTitle("PoliCine");
                login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                login.setSize(500,350);
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                login.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
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
    public boolean letrassinnumeros(String cadena){
        for(int i=0; i<cadena.length();i++){
            if(Character.isDigit(cadena.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
