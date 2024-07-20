package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JTextField UsuarioField;
    private JComboBox PerfilBox;
    private JButton iniciarSesiónButton;
    private JPasswordField ContraField;
    private JButton registrarseButton;
    public JPanel PanelLoign;

    DefaultComboBoxModel perfil= new DefaultComboBoxModel();

    public Login() {
        PerfilBox.setModel(perfil);
        perfil.addElement("Administrador");
        perfil.addElement("Cliente");
        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}


