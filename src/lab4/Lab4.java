/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;



import java.io.File;
import java.io.IOException;
import static java.lang.Math.log;
import java.math.BigDecimal;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.BigDecimalStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;


/**
 *
 * @author Ada
 */
public class Lab4 extends Application implements Initializable {
    @FXML
    private TableView<Rzecz> tabelka;
    private ObservableList<Rzecz> lista= FXCollections.observableArrayList();
    @FXML
    private TableColumn nazwa;
    @FXML
    private TableColumn cena;
    @FXML
    private TableColumn waluta;
    @FXML
    private TextField nowaNazwa;
    @FXML
    private TextField nowaCena;
    @FXML
    private TextField nowaWaluta;
    @FXML
    private Label komentarze;
    
    

    
    public void start(Stage stage) throws IOException {
        
        stage.setTitle("Menadzer plikow");
        Parent wzor = FXMLLoader.load(getClass().getResource("lab4.fxml"));
        Scene scene = new Scene(wzor);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void dodajProdukt(ActionEvent event){
        BigDecimal liczba = new BigDecimal(nowaCena.getText());
        Rzecz nowy=new Rzecz(nowaNazwa.getText(), liczba,nowaWaluta.getText());
        lista.add(nowy);
        komentarze.setText("Dodano plik");
        
    }
    
    public void usunProdukt(ActionEvent event){
        System.out.printf("Usuwam");
        Rzecz usuwamy=tabelka.getSelectionModel().getSelectedItem();
        lista.remove(usuwamy);
        komentarze.setText("Usunieto plik");
    }
    
    public void zapiszProdukt(ActionEvent event) throws SAXException{   
    
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        FileChooser znajdz1= new FileChooser();
        //File plik1=znajdz1.showOpenDialog(null);
        //System.out.print(plik1.toPath());
        File schemat= new File("C:\\Users\\Ada\\Music\\Lab4\\src\\rzeczy.xsd");
        Source schemaFile = new StreamSource(schemat);
        Schema schema = factory.newSchema(schemaFile);     
        
        
        
        try{
            FileChooser znajdz= new FileChooser();
            File plik=znajdz.showOpenDialog(null);
            JAXBContext context = JAXBContext.newInstance(ObjectFactory.class.getPackage().getName());
            Marshaller marshaller = context.createMarshaller();
            Catalog katalog=new Catalog(lista);
            marshaller.setSchema(schema);
            marshaller.marshal(katalog, plik);
            komentarze.setText("Zapisano liste");
        }
        catch (JAXBException ex){
            komentarze.setText("Nie udalo sie zapisac pliku");
        }       
    }
    
    public void zaladujProdukt(ActionEvent event) throws SAXException{
          SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        FileChooser znajdz1= new FileChooser();
        //File plik1=znajdz1.showOpenDialog(null);
        //System.out.print(plik1.toPath());
        File schemat= new File("C:\\Users\\Ada\\Music\\Lab4\\src\\rzeczy.xsd");
        Source schemaFile = new StreamSource(schemat);
        Schema schema = factory.newSchema(schemaFile);     
        tabelka.setItems(lista);
        try {
            FileChooser znajdz= new FileChooser();
            File plik=znajdz.showOpenDialog(null);
            JAXBContext context = JAXBContext.newInstance(ObjectFactory.class.getPackage().getName());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);
            Catalog katalog = (Catalog) unmarshaller.unmarshal(plik);
            lista.clear();
            lista.addAll(katalog.getRzecz());    
            komentarze.setText("Zaladowano liste");
            
            
            
        } catch (JAXBException ex) {
            komentarze.setText("Problem przy zaladowaniu pliku xml");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
            
     nazwa.setCellFactory(TextFieldTableCell.forTableColumn());
     nazwa.setOnEditCommit(new EventHandler<CellEditEvent<Rzecz, String>>() {
       
            @Override
            public void handle(CellEditEvent<Rzecz, String> t) {
                Rzecz item = t.getRowValue();
                String newName = t.getNewValue();
                item.setNazwaPr(newName);
            }
        });
     
     BigDecimalStringConverter conv = new BigDecimalStringConverter();
     konwerter sprawdz= new konwerter();
     cena.setCellFactory(TextFieldTableCell.forTableColumn(sprawdz));
     cena.setOnEditCommit(new EventHandler<CellEditEvent<Rzecz, BigDecimal>>() {
       
            @Override
            public void handle(CellEditEvent<Rzecz, BigDecimal> t) {
                
                    Rzecz item = t.getRowValue();
                    BigDecimal newPrice = t.getNewValue();
                    item.setCenaPr(newPrice);
                
            }
        });
    
     
     waluta.setCellFactory(TextFieldTableCell.forTableColumn());
     waluta.setOnEditCommit(new EventHandler<CellEditEvent<Rzecz, String>>() {
       
            @Override
            public void handle(CellEditEvent<Rzecz, String> t) {
                Rzecz item = t.getRowValue();
                String newCurrency = t.getNewValue();
                item.setWalutaPr(newCurrency);
            }
        });
    }
}
