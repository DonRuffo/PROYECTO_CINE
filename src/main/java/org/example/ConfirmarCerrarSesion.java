package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmarCerrarSesion {
    private JButton siButton;
    private JButton noButton;
    public JPanel MainPanel;

    public ConfirmarCerrarSesion() {
        siButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JFrame) SwingUtilities.getWindowAncestor(siButton)).dispose();
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
                JFrame paginaAdministrador = new JFrame();
                paginaAdministrador.setTitle("PoliCine");
                paginaAdministrador.setContentPane(new PaginaAdministrador().PanelPaginaAdmin);
                paginaAdministrador.setSize(500, 300);
                paginaAdministrador.setLocationRelativeTo(null);
                paginaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paginaAdministrador.setVisible(true);
                ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
                paginaAdministrador.setIconImage(imagen.getImage());
                ((JFrame) SwingUtilities.getWindowAncestor(noButton)).dispose();
            }
        });
    }
}
