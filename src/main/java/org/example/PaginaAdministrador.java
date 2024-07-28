package org.example;

import javax.management.remote.JMXConnectorFactory;
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
    private JButton cerrarSesiónButton;

    public PaginaAdministrador() {
        PanelImagen1.setLayout(new BorderLayout());
        String imagen="IMAGENES/CINEMA.png";
        ImageIcon iconImage = new ImageIcon(imagen);
        JLabel labelImage = new JLabel(iconImage);
        PanelImagen1.add(labelImage, BorderLayout.CENTER);
        gestionarPelículasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionPeliculas = new JFrame();
                gestionPeliculas.setTitle("PoliCine");
                gestionPeliculas.setContentPane(new GestionarPeliculas().MainPanel);
                gestionPeliculas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                gestionPeliculas.setSize(500, 300);
                gestionPeliculas.setLocationRelativeTo(null);
                gestionPeliculas.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                gestionPeliculas.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(gestionarPelículasButton)).dispose();
            }
        });
        cerrarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame confirmar = new JFrame();
                confirmar.setTitle("PoliCine");
                confirmar.setContentPane(new ConfirmarCerrarSesion().MainPanel);
                confirmar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                confirmar.setSize(300, 150);
                confirmar.setLocationRelativeTo(null);
                confirmar.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                confirmar.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(cerrarSesiónButton)).dispose();
            }
        });
        gestionarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionarClientes = new JFrame();
                gestionarClientes.setTitle("PoliCine");
                gestionarClientes.setContentPane(new GestionarClientes().MainPanel);
                gestionarClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gestionarClientes.setSize(500, 300);
                gestionarClientes.setLocationRelativeTo(null);
                gestionarClientes.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                gestionarClientes.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(gestionarClientesButton)).dispose();
            }
        });
    }
}
