/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author daniel.constantin
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
      
       Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        
       Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Business Simulator");
        stage.show();
    }
public void changeScene(Scene scene, String title){
    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
