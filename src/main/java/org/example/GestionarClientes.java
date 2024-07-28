package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionarClientes {
    public JPanel MainPanel;
    private JButton agregarClienteButton;
    private JButton eliminarClienteButton;
    private JButton verClientesButton;
    private JPanel PanelImagen;
    private JButton regresarButton;

    public GestionarClientes() {
        PanelImagen.setLayout(new BorderLayout());
        ImageIcon imagen = new ImageIcon("IMAGENES/Palomas_refresco.png");
        JLabel imagenLabel = new JLabel(imagen);
        PanelImagen.add(imagenLabel, BorderLayout.CENTER);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame paginaAdministrador = new JFrame();
                paginaAdministrador.setTitle("PoliCine");
                paginaAdministrador.setContentPane(new PaginaAdministrador().PanelPaginaAdmin);
                paginaAdministrador.setSize(500, 300);
                paginaAdministrador.setLocationRelativeTo(null);
                paginaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paginaAdministrador.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        agregarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registroClientes = new JFrame();
                registroClientes.setTitle("PoliCine");
                registroClientes.setContentPane(new AgregarCliente().MainPanel);
                registroClientes.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                registroClientes.setSize(500,350);
                registroClientes.setLocationRelativeTo(null);
                registroClientes.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(agregarClienteButton)).dispose();
            }
        });
        eliminarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame eliminarCliente = new JFrame();
                eliminarCliente.setTitle("PoliCine");
                eliminarCliente.setContentPane(new EliminarCliente().MainPanel);
                eliminarCliente.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                eliminarCliente.setSize(500,350);
                eliminarCliente.setLocationRelativeTo(null);
                eliminarCliente.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(eliminarClienteButton)).dispose();
            }
        });
        verClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame verCliente = new JFrame();
                verCliente.setTitle("PoliCine");
                verCliente.setContentPane(new VerClientes().MainPanel);
                verCliente.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                verCliente.setSize(550,350);
                verCliente.setLocationRelativeTo(null);
                verCliente.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(verClientesButton)).dispose();
            }
        });
    }
}
