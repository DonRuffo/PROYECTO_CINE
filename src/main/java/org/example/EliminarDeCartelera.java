package org.example;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import java.util.LinkedHashSet;
import javax.swing.*;
import java.util.Set;

public class EliminarDeCartelera {
    private JComboBox SeleccionBox;
    private JButton eliminarButton;
    public JPanel MainPanel;
    DefaultComboBoxModel seleccionModel = new DefaultComboBoxModel();

    public EliminarDeCartelera() {
        SeleccionBox.setModel(seleccionModel);
        List<String> pelis = new ArrayList<>();
        try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
            MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
            MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

            FindIterable<Document> documento=coleccion.find();
            for(Document documento2 : documento){
                pelis.add(documento2.getString("titulo"));
            }
            cliente.close();
        }
        List<String> pelisnuevas = removerduplicados(pelis);
        for(int i=0;i<=pelisnuevas.size()-1;i++){
            seleccionModel.addElement(pelisnuevas.get(i));
        }
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(MongoClient cliente = MongoClients.create("mongodb+srv://dennisdiaz407:YFwh8BtJwwH0kZxa@cluster0.ayc0dwi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")){
                    MongoDatabase baseDeDatos = cliente.getDatabase("Peliculas");
                    MongoCollection<Document> coleccion=baseDeDatos.getCollection("Datos_Peliculas");

                    Document filtro = new Document("titulo",seleccionModel.getSelectedItem().toString());
                    DeleteResult resultado=coleccion.deleteMany(filtro);
                    String elimnado=seleccionModel.getSelectedItem().toString();
                    JOptionPane.showMessageDialog(null, "Pelicula " +elimnado+" elimnada con éxito");
                    SeleccionBox.removeItem(elimnado);
                    cliente.close();
                }
            }
        });
    }
    public static <T> List<T> removerduplicados(List<T> lista){
        Set<T> set= new LinkedHashSet<>(lista);
        return new ArrayList<>(set);
    }
}
