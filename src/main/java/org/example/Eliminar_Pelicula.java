package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bson.Document;

public class Eliminar_Pelicula {
    private JButton CarteleraButton;
    private JButton SalaButton;
    private JPanel PanelImagen1;
    private JPanel PanelImagen2;
    public JPanel MainPanel;

    public Eliminar_Pelicula(){
        PanelImagen1.setLayout(new BorderLayout());
        ImageIcon imagen1= new ImageIcon("IMAGENES/Mascaras_Cine.png");
        JLabel imagen1Label = new JLabel(imagen1);
        imagen1Label.setHorizontalAlignment(SwingConstants.CENTER);
        imagen1Label.setVerticalAlignment(SwingConstants.CENTER);
        PanelImagen1.add(imagen1Label, BorderLayout.CENTER);

        PanelImagen2.setLayout(new BorderLayout());
        ImageIcon imagen2= new ImageIcon("IMAGENES/Silla_Director.png");
        JLabel imagen2Label = new JLabel(imagen2);
        imagen2Label.setHorizontalAlignment(SwingConstants.CENTER);
        imagen2Label.setVerticalAlignment(SwingConstants.CENTER);
        PanelImagen2.add(imagen2Label, BorderLayout.CENTER);
        CarteleraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cartelera= new JFrame("Cartelera");
                cartelera.setContentPane(new EliminarDeCartelera().MainPanel);
                cartelera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cartelera.setSize(500,300);
                cartelera.setLocationRelativeTo(null);
                cartelera.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(CarteleraButton)).dispose();
            }
        });
    }

}
