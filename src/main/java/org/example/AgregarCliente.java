package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

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
    String llave="Dennis123";
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
                int verificacion=0;
                CLIENTES cli2 = new CLIENTES();
                String contra=ContraField.getText();
                String confirmar = ConfContraField.getText();
                if(CedulaField.getText().length()!=10 || TelefonoField.getText().length()!=10){
                    JOptionPane.showMessageDialog(null,"La cedula y el telefono deben tener 10 dígitos");
                }else{
                    Boolean comprobarCedula=numero(CedulaField.getText());
                    Boolean comprobarTelefono=numero(TelefonoField.getText());
                    Boolean comprobarNombre=letrassinnumeros(NombreField.getText());
                    if (comprobarTelefono==false || comprobarCedula==false ){
                        JOptionPane.showMessageDialog(null,"Ingrese dígitos numéricos en cedula y telefono");
                    }
                    else{
                        if(comprobarNombre==false){
                        JOptionPane.showMessageDialog(null,"Solo se permiten letras en el nombre");
                        }else{
                            if(contra.isEmpty() || confirmar.isEmpty() || NombreField.getText().isEmpty() || TelefonoField.getText().isEmpty()
                                    || CedulaField.getText().isEmpty() || DirecField.getText().isEmpty()){
                                JOptionPane.showMessageDialog(null, "Por favor, rellenar todos los campos");
                            }else{
                                if(contra.equals(confirmar)){
                                    cli2.setNombre(NombreField.getText());
                                    cli2.setCedula(CedulaField.getText());
                                    cli2.setContrasena(ContraField.getText());
                                    String encriptar = Encriptar(ContraField.getText());
                                    cli2.setDireccion(DirecField.getText());
                                    cli2.setEdad(edadModel.getSelectedItem().toString());
                                    cli2.setTelefono(TelefonoField.getText());
                                    try(MongoClient mongoClient = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                                        MongoDatabase Clientes = mongoClient.getDatabase("Clientes");
                                        MongoCollection<Document> RegistroClientes = Clientes.getCollection("Datos_clientes");

                                        FindIterable<Document> verificar=RegistroClientes.find();
                                        for (Document documento : verificar){
                                            if(documento.getString("cedula").equals(cli2.getCedula())){
                                                JOptionPane.showMessageDialog(null,"El cliente con N°cédula: "+cli2.getCedula()+" ya existe");
                                                verificacion=1;
                                                CedulaField.setText("");
                                                NombreField.setText("");
                                                TelefonoField.setText("");
                                                DirecField.setText("");
                                                ContraField.setText("");
                                                ConfContraField.setText("");
                                            }
                                        }
                                        if (verificacion==0){
                                            Document documento= new Document("cedula",cli2.getCedula()).append("nombre",cli2.getNombre())
                                                    .append("edad",cli2.getEdad()).append("telefono",cli2.getTelefono())
                                                    .append("direccion",cli2.getDireccion()).append("contrasena",encriptar);
                                            RegistroClientes.insertOne(documento);
                                            JOptionPane.showMessageDialog(null,"Registro exitoso");
                                            CedulaField.setText("");
                                            NombreField.setText("");
                                            TelefonoField.setText("");
                                            DirecField.setText("");
                                            ContraField.setText("");
                                            ConfContraField.setText("");
                                        }
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, intente de nuevo");
                                    ContraField.setText("");
                                    ConfContraField.setText("");
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
                JFrame gestionarClientes = new JFrame();
                gestionarClientes.setTitle("PoliCine");
                gestionarClientes.setContentPane(new GestionarClientes().MainPanel);
                gestionarClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gestionarClientes.setSize(500, 350);
                gestionarClientes.setLocationRelativeTo(null);
                gestionarClientes.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                gestionarClientes.setIconImage(imagen.getImage());
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

    //función de encriptacion / desencriptacion
    public SecretKeySpec CrearClave(String llave){
        try{
            byte [] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena,16);
            SecretKeySpec llavesecreta = new SecretKeySpec(cadena, "AES");
            return llavesecreta;
        }catch(Exception e){
            return null;
        }
    }

    //encriptar
    public String Encriptar (String encriptar){
        try{
            SecretKeySpec llavesecreta = CrearClave(llave);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, llavesecreta);

            byte [] cadena = encriptar.getBytes("UTF-8");
            byte []  encriptada = cipher.doFinal(cadena);
            String cadena_encriptada = Base64.getEncoder().encodeToString(encriptada);
            return cadena_encriptada;
        }catch(Exception e){
            return "";
        }
    }
}
