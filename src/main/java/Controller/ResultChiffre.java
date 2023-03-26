package Controller;

import fr.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultChiffre implements Initializable {

    @FXML private Label resultLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//Affichage de la valeur de résultat
        resultLabel.setText(StartApplication.m.getResultat().toString());
    }

}
