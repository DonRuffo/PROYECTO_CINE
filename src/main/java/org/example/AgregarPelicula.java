package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarPelicula {
    private JTextField TituloField;
    private JTextField CateegoriaField;
    private JTextField PrecioField;
    private JButton agregarButton;
    public JPanel MainPanel;
    private JComboBox HorarioBox;
    private JComboBox SalaBox;
    private JComboBox EdadBox;
    private JComboBox DiaBox;
    private JButton regresarButton;

    DefaultComboBoxModel horarioModel=new DefaultComboBoxModel();
    DefaultComboBoxModel salaModel=new DefaultComboBoxModel();
    DefaultComboBoxModel edadModel=new DefaultComboBoxModel();
    DefaultComboBoxModel diaModel=new DefaultComboBoxModel();


    public AgregarPelicula() {
        HorarioBox.setModel(horarioModel);
        horarioModel.addElement("12:00");
        horarioModel.addElement("15:00");
        horarioModel.addElement("18:00");
        horarioModel.addElement("21:00");
        SalaBox.setModel(salaModel);

        for(int i=0; i<=10; i++){
            salaModel.addElement(i);
        }

        EdadBox.setModel(edadModel);
        edadModel.addElement("Familiar");
        edadModel.addElement("+15");
        edadModel.addElement("+18");
        DiaBox.setModel(diaModel);
        diaModel.addElement("Lunes");
        diaModel.addElement("Martes");
        diaModel.addElement("Miércoles");
        diaModel.addElement("Jueves");
        diaModel.addElement("Viernes");
        diaModel.addElement("Sábado");
        diaModel.addElement("Domingo");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ident=0;
                if (TituloField.getText().isEmpty() || CateegoriaField.getText().isEmpty() || PrecioField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos");
                }else{
                    PELICULAS peli1 = new PELICULAS();
                    peli1.setTitulo(TituloField.getText());
                    peli1.setCategoria(CateegoriaField.getText());
                    peli1.setPrecio(Float.parseFloat(PrecioField.getText()));
                    peli1.setRestriccion(edadModel.getSelectedItem().toString());
                    peli1.setSala(salaModel.getSelectedItem().hashCode());
                    peli1.setHorario(horarioModel.getSelectedItem().toString());
                    peli1.setDia(diaModel.getSelectedItem().toString());
                    try(MongoClient cliente= MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                        MongoDatabase peliculas=cliente.getDatabase("Peliculas");
                        MongoCollection<Document> datos=peliculas.getCollection("Datos_Peliculas");
                        System.out.println("CONEXION EXITOSA");
                        FindIterable<Document> documentos= datos.find();
                        for(Document documento:documentos) {
                            if (peli1.getSala() == documento.getInteger("sala") && peli1.getHorario().equals(documento.getString("horario")) && peli1.getDia().equals(documento.getString("dia"))) {
                                ident = 1;
                            }
                        }
                        if (ident==1){
                            JOptionPane.showMessageDialog(null,"El horario "+peli1.getHorario()+" en la sala "+peli1.getSala()+" está ocupado."
                                    +" Seleccione otro horario, sala o día");
                        }else{
                            Document insercion=new Document("titulo",peli1.getTitulo()).append("categoria",peli1.getCategoria())
                                    .append("horario",peli1.getHorario()).append("sala", peli1.getSala())
                                    .append("precio_asiento", peli1.getPrecio()).append("restriccion_edad",peli1.getRestriccion())
                                    .append("dia",peli1.getDia());
                            datos.insertOne(insercion);
                            JOptionPane.showMessageDialog(null,"Registro Exitoso");
                            TituloField.setText("");
                            CateegoriaField.setText("");
                            PrecioField.setText("");
                            ident=0;
                        }
                    }
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionPeliculas = new JFrame();
                gestionPeliculas.setTitle("Gestionar Peliculas");
                gestionPeliculas.setContentPane(new GestionarPeliculas().MainPanel);
                gestionPeliculas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                gestionPeliculas.setSize(500, 300);
                gestionPeliculas.setLocationRelativeTo(null);
                gestionPeliculas.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
    }
}
