/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import classes.Client;
import classes.ClientException;
import gestionClasses.GestionClient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Chayma Jenhani
 */
public class ClientController implements Initializable {

    Label label;
    @FXML
    private TableView<Client> tableView;
    @FXML
    private TableColumn<Client, Integer> CINColumn;
    @FXML
    private TableColumn<Client, String> nomColumn;
    @FXML
    private TableColumn<Client, String> prenomColumn;
    @FXML
    private TableColumn<Client, String> adresseColumn;
    @FXML
    private TableColumn<Client, Integer> telColumn;
    @FXML
    private TableColumn<Client, Integer> premisColumn;

    @FXML
    private TextField CINField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField nprenomField;
    @FXML
    private TextField adresseField;
    @FXML
    private TextField telField;
    @FXML
    private TextField numPermisField;
    GestionClient gc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        CINColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("cin"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
        adresseColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("adresse"));
        telColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("tel"));
        premisColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("numPermis"));

        try {
            gc = new GestionClient();
            tableView.getItems().addAll(gc.listeClient());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    public void newClientButtonPushed() throws IOException, ClassNotFoundException, ClientException {
        Client newClient = new Client(Integer.parseInt(CINField.getText()), nomField.getText(), nprenomField.getText(), adresseField.getText(), Integer.parseInt(telField.getText()), Integer.parseInt(numPermisField.getText()));
        //Get all the items from the table as a list, then add the new person tothe list
        tableView.getItems().add(newClient);
        gc = new GestionClient();
        gc.ajouter(newClient);

    }

    @FXML
    private void SuppClient() throws IOException, ClassNotFoundException {
        gc=new GestionClient();
        gc.supprimer(tableView.getSelectionModel().getSelectedItem());
    }
}
