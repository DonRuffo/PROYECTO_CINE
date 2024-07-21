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

    public RegistroClientes() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(MongoClient mongoClient = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase Clientes = mongoClient.getDatabase("Clientes");
                    MongoCollection<Document> RegistroClientes = Clientes.getCollection("Datos_clientes");

                }
            }
        });
    }
}
