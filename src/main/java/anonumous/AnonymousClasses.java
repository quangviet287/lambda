package anonumous;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AnonymousClasses extends Application {

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("hello");
        Button button = new Button();
        button.setText("Say hello");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Hello word");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(button);
        primaryStage.setScene(new Scene(root,500,500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
