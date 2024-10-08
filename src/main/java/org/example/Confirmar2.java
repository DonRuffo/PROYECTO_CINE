package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Confirmar2 {
    private JButton siButton;
    private JButton noButton;
    public JPanel MainPanel;

    public Confirmar2() {
        siButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase sesion = cliente.getDatabase("CacheSesion");
                    MongoCollection<Document> clienteActual = sesion.getCollection("ClienteActual");

                    //Eliminando el cliente
                    clienteActual.deleteMany(new Document());

                }

                JFrame login = new JFrame();
                login.setContentPane(new Login().PanelLoign);
                login.setTitle("PoliCine");
                login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                login.setSize(500,300);
                login.setMinimumSize(new Dimension(500,300));
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                login.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(siButton)).dispose();
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame paginaClientes = new JFrame();
                paginaClientes.setTitle("PoliCine");
                paginaClientes.setContentPane(new PaginaClientes().MainPanel);
                paginaClientes.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                paginaClientes.setSize(500, 300);
                paginaClientes.setLocationRelativeTo(null);
                paginaClientes.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                paginaClientes.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(noButton)).dispose();
            }
        });
    }
}
