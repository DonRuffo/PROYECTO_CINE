package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estadisticas {
    public JPanel MainPanel;
    private JButton ventasButton;
    private JButton ocupacionDeSalasButton;
    private JPanel PanelImagen;
    private JButton regresarButton;

    public Estadisticas(){
        PanelImagen.setLayout(new BorderLayout());
        ImageIcon imagen = new ImageIcon("IMAGENES/Palomitas3D.png");
        JLabel imagenLabel = new JLabel(imagen);
        PanelImagen.add(imagenLabel, BorderLayout.CENTER);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame paginaAdministrador = new JFrame();
                paginaAdministrador.setTitle("PoliCine");
                paginaAdministrador.setContentPane(new PaginaAdministrador().PanelPaginaAdmin);
                paginaAdministrador.setSize(500, 350);
                paginaAdministrador.setLocationRelativeTo(null);
                paginaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paginaAdministrador.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                paginaAdministrador.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventas = new JFrame();
                ventas.setTitle("PoliCine");
                ventas.setContentPane(new Ventas().MainPanel);
                ventas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventas.setSize(500, 350);
                ventas.setLocationRelativeTo(null);
                ventas.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                ventas.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(ventasButton)).dispose();
            }
        });
        ocupacionDeSalasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ocupacion = new JFrame();
                ocupacion.setTitle("PoliCine");
                ocupacion.setContentPane(new OcupacionDeSalas().MainPanel);
                ocupacion.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                ocupacion.setSize(500, 350);
                ocupacion.setLocationRelativeTo(null);
                ocupacion.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                ocupacion.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(ocupacionDeSalasButton)).dispose();
            }
        });
    }
}
