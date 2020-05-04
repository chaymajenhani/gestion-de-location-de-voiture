/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import gestionClasses.GestionClient;
import gestionClasses.GestionLocation;
import gestionClasses.GestionVehicule;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Chayma Jenhani
 */
public class StatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Label nbVeh;
    @FXML
    private Label nbCl;
    @FXML
    private Label nbLoc;
    
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            
            GestionVehicule gv = new GestionVehicule();
            GestionClient gc = new GestionClient();
            GestionLocation gl = new GestionLocation();
            nbCl.setText(gc.listeClient().size() + " Clients");
            nbLoc.setText(gl.listeLocation().size() + " Locations");
            nbVeh.setText(gv.listeVehicule().size() + " Vehicules");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
