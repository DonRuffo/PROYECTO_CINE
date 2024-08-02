package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionarPeliculas {
    private JButton agregarPelículaButton;
    private JButton cambiarHorariosYSalasButton;
    private JButton eliminarPelículaButton;
    public JPanel MainPanel;
    private JPanel PanelImagen1;
    private JButton regresarButton;

    public GestionarPeliculas() {
        PanelImagen1.setLayout(new BorderLayout());
        ImageIcon imagen1= new ImageIcon("IMAGENES/palomitas.png");
        JLabel imagen1Label = new JLabel(imagen1);
        PanelImagen1.add(imagen1Label, BorderLayout.CENTER);
        agregarPelículaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame agregarPeli= new JFrame();
                agregarPeli.setTitle("PoliCine");
                agregarPeli.setContentPane(new AgregarPelicula().MainPanel);
                agregarPeli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                agregarPeli.setSize(500,350);
                agregarPeli.setLocationRelativeTo(null);
                agregarPeli.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                agregarPeli.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(agregarPelículaButton)).dispose();
            }
        });
        eliminarPelículaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cartelera= new JFrame("PoliCine");
                cartelera.setContentPane(new EliminarDeCartelera().MainPanel);
                cartelera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cartelera.setSize(500,350);
                cartelera.setLocationRelativeTo(null);
                cartelera.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                cartelera.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(eliminarPelículaButton)).dispose();
            }
        });
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
        cambiarHorariosYSalasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame nuevoshorarios = new JFrame();
                nuevoshorarios.setTitle("PoliCine");
                nuevoshorarios.setContentPane(new Cambiar_horarios_salas().MainPanel);
                nuevoshorarios.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                nuevoshorarios.setSize(500, 350);
                nuevoshorarios.setLocationRelativeTo(null);
                nuevoshorarios.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                nuevoshorarios.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(cambiarHorariosYSalasButton)).dispose();
            }
        });
    }
}
