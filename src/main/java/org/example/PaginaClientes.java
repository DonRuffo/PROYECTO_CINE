package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaClientes {
    public JPanel MainPanel;
    private JButton verHorariosButton;
    private JButton reservarPelículaButton;
    private JButton cerrarSesiónButton;
    private JPanel PanelImagen;

    public PaginaClientes() {
        PanelImagen.setLayout(new BorderLayout());
        ImageIcon imagen = new ImageIcon("IMAGENES/ticket.png");
        JLabel ImagenLabel = new JLabel(imagen);
        PanelImagen.add(ImagenLabel, BorderLayout.CENTER);
        cerrarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame confirmar = new JFrame();
                confirmar.setTitle("PoliCine");
                confirmar.setContentPane(new Confirmar2().MainPanel);
                confirmar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                confirmar.setSize(300, 150);
                confirmar.setLocationRelativeTo(null);
                confirmar.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                confirmar.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(cerrarSesiónButton)).dispose();
            }
        });
    }
}
