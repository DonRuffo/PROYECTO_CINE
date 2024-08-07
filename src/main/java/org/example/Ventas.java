package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventas {
    public JPanel MainPanel;
    private JButton porFechaYFuncionButton;
    private JButton porPeliculaButton;
    private JButton regresarButton;
    private JPanel PanelImagen;

    public Ventas(){
        PanelImagen.setLayout(new BorderLayout());
        ImageIcon imagen = new ImageIcon("IMAGENES/ALTAVOZ.png");
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
        porFechaYFuncionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventasFuncion = new JFrame();
                ventasFuncion.setTitle("PoliCine");
                ventasFuncion.setContentPane(new VentasPorFuncion().Paneldos);
                ventasFuncion.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                ventasFuncion.setSize(900,600);
                ventasFuncion.setLocationRelativeTo(null);
                ventasFuncion.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                ventasFuncion.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(porFechaYFuncionButton)).dispose();
            }
        });
        porPeliculaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame porPeli = new JFrame();
                porPeli.setTitle("PoliCine");
                porPeli.setContentPane(new VentasPorPelicula().MainPanel);
                porPeli.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                porPeli.setSize(750,500);
                porPeli.setLocationRelativeTo(null);
                porPeli.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                porPeli.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(porPeliculaButton)).dispose();
            }
        });
    }
}
