package adminInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import static bookSearch.DatabaseConnection.getConnection;

public class ManageController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showList();
    }

    @FXML
    public void handleButtonAction(ActionEvent event){

        if(event.getSource() == btnInsert){
            insert();
        }
        if(event.getSource() == btnUpdate){
            update();
        }
        if(event.getSource() == btnDelete){
            delete();
        }

    }

    public void handleMouseAction(javafx.scene.input.MouseEvent mouseEvent) {


    }

    public boolean confirmationAlert(){
        Boolean okToDelete = false;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Are you sure you want to delete?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            okToDelete = true;
        }
        return okToDelete;
    }

    public void clearTextfields(){

    }

    void showList(){

    }

    boolean isFieldEmpty(String string){
        boolean isFieldEmpty = false;
        if(string.isEmpty() || string == null) {
            isFieldEmpty = true;
        }
        return isFieldEmpty;
    }

    public void emptyFieldAlert(String field){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(field + " can't be empty. Please add a " + field + " or select a row to update.");
        alert.showAndWait();
    }

    public void insert(){

        try {
            Statement statement = getConnection().getDBConnection().createStatement();

            showList();


        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public void update(){

        try{
            Statement statement = getConnection().getDBConnection().createStatement();

            clearTextfields();
            showList();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public void delete(){

        try{
            Statement statement = getConnection().getDBConnection().createStatement();

            showList();


        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    public void switchBackToAdminStart(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        Scene scene;

        root = FXMLLoader.load(getClass().getResource("AdminStart.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 700, 400);
        stage.setScene(scene);
        stage.show();
    }

}

