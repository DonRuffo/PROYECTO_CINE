package org.example;

import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


/**
* Clase principal
* */
public class Main {
    public static void main(String[] args) {
        JFrame login = new JFrame();
        login.setContentPane(new Login().PanelLoign);
        login.setTitle("PoliCine");
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setSize(500,350);
        login.setMinimumSize(new Dimension(500,300));
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        ImageIcon imagen = new ImageIcon("IMAGENES/POLICINE_ICON.png");
        login.setIconImage(imagen.getImage());
    }
}