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
    private JTextField EdadField;
    private JButton agregarButton;
    public JPanel MainPanel;
    private JComboBox HorarioBox;
    private JComboBox SalaBox;
    private JComboBox EdadBox;
    private JComboBox DiaBox;

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
        salaModel.addElement("1");
        salaModel.addElement("2");
        salaModel.addElement("3");
        salaModel.addElement("4");
        salaModel.addElement("5");
        salaModel.addElement("6");
        salaModel.addElement("7");
        salaModel.addElement("8");
        salaModel.addElement("9");
        salaModel.addElement("10");
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
                    int numeroSala=Integer.parseInt(salaModel.getSelectedItem().toString());
                    peli1.setSala(numeroSala);
                    peli1.setHorario(horarioModel.getSelectedItem().toString());
                    peli1.setDia(diaModel.getSelectedItem().toString());
                    try(MongoClient cliente= MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                        MongoDatabase peliculas=cliente.getDatabase("Peliculas");
                        MongoCollection<Document> datos=peliculas.getCollection("Datos_Peliculas");
                        System.out.println("CONEXION EXITOSA");
                        FindIterable<Document> documentos= datos.find();
                        for(Document documento:documentos) {
                            if (numeroSala == documento.getInteger("sala") && peli1.getHorario().equals(documento.getString("horario")) && peli1.getDia().equals(documento.getString("dia"))) {
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
                        cliente.close();
                    }
                }
            }
        });
    }
}
