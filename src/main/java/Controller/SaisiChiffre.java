package Controller;

import fr.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SaisiChiffre {

    @FXML private TextField numberLabel1;
    @FXML private TextField numberLabel2;

    @FXML private Label errorLabel;
    @FXML protected void onCalculButtonClick(){
        try{
            StartApplication.m.testValeur(numberLabel1.getText(),numberLabel2.getText());
            StartApplication.m.calculNombreParfait(numberLabel1.getText(),numberLabel2.getText());
            errorLabel.setText("");
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("ResultView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Résultat");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            errorLabel.setText(e.toString());
            e.printStackTrace();
        }
    }
}
