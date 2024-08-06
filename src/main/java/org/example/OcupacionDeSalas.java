package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OcupacionDeSalas {
    public JPanel MainPanel;
    private JButton porFechaYFunciónButton;
    private JButton porPelículaButton;
    private JButton regresarButton;
    private JPanel PanelImagen;

    public OcupacionDeSalas() {
        PanelImagen.setLayout(new BorderLayout());
        ImageIcon imagen = new ImageIcon("IMAGENES/CAMARA.png");
        JLabel imagenLabel = new JLabel(imagen);
        PanelImagen.add(imagenLabel, BorderLayout.CENTER);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame estadisticas = new JFrame();
                estadisticas.setTitle("PoliCine");
                estadisticas.setContentPane(new Estadisticas().MainPanel);
                estadisticas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                estadisticas.setSize(500,350);
                estadisticas.setLocationRelativeTo(null);
                estadisticas.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                estadisticas.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        porFechaYFunciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ocupacion = new JFrame();
                ocupacion.setTitle("PoliCine");
                ocupacion.setContentPane(new OcupacionPorFuncion().MainPanel);
                ocupacion.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                ocupacion.setSize(900, 600);
                ocupacion.setLocationRelativeTo(null);
                ocupacion.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                ocupacion.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(porFechaYFunciónButton)).dispose();
            }
        });
    }
}
