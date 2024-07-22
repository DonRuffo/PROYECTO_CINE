package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaAdministrador {
    private JButton gestionarPelículasButton;
    private JButton estadísticasButton;
    private JButton gestionarClientesButton;
    public JPanel PanelPaginaAdmin;
    private JPanel PanelImagen1;

    public PaginaAdministrador() {
        PanelImagen1.setLayout(new BorderLayout());
        String imagen="IMAGENES/CINEMA.png";
        ImageIcon iconImage = new ImageIcon(imagen);
        JLabel labelImage = new JLabel(iconImage);
        PanelImagen1.add(labelImage, BorderLayout.BEFORE_FIRST_LINE);
        gestionarPelículasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionPeliculas = new JFrame();
                gestionPeliculas.setTitle("Gestionar Peliculas");
                gestionPeliculas.setContentPane(new GestionarPeliculas().MainPanel);
                gestionPeliculas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                gestionPeliculas.setSize(500, 300);
                gestionPeliculas.setLocationRelativeTo(null);
                gestionPeliculas.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(gestionarPelículasButton)).dispose();
            }
        });
    }
}
