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

    public GestionarPeliculas() {
        PanelImagen1.setLayout(new BorderLayout());
        ImageIcon imagen1= new ImageIcon("IMAGENES/palomitas.png");
        JLabel imagen1Label = new JLabel(imagen1);
        PanelImagen1.add(imagen1Label, BorderLayout.CENTER);
        agregarPelículaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame agregarPeli= new JFrame();
                agregarPeli.setTitle("Agregar Película");
                agregarPeli.setContentPane(new AgregarPelicula().MainPanel);
                agregarPeli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                agregarPeli.setSize(500,350);
                agregarPeli.setLocationRelativeTo(null);
                agregarPeli.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(agregarPelículaButton)).dispose();
            }
        });
    }
}
