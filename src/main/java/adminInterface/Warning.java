package adminInterface;

import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Warning {

    public void alertMessage(javafx.scene.control.Alert.AlertType alertType, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(alertType);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean alertConfirmation(String message) {
        Boolean okPressed = false;
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(message);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            okPressed = true;
        }
        return okPressed;
    }

}



