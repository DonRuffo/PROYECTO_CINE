package org.example;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        JFrame login = new JFrame();
        login.setContentPane(new Login().PanelLoign);
        login.setTitle("Inicio de sesión");
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setSize(500,300);
        login.setLocationRelativeTo(null);
        login.setVisible(true);

    }
}