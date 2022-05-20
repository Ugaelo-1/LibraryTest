package loginform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application{

    //This will create a new window with the resource file login_form.fxml. It will then set the title to User Login and decide the window size as well.
        @Override
        public void start(Stage stage) throws Exception {
            System.out.println(getClass());
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("hello-view.fxml"));
            stage.setTitle("User Login");
            stage.setScene(new Scene(root, 800, 500));
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
