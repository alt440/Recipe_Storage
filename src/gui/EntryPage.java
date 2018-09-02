/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.scene.image.ImageView;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;
import java.lang.Thread;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

/**
 *
 * @author user
 */
public class EntryPage extends Application{
    private static Stage logoStage;
    private static Stage officialStage;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {    
        
        StackPane root = new StackPane();
        /*
        Making the StackPane transparent
        */
        root.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0);" 
        );
        
        /*
        Setting the logo to preserve picture quality and be 
        bigger than the original picture
        */
        Image logo = new Image("file:recipe_hunter_logo.png");
        ImageView logoShow = new ImageView(logo);
        
        logoShow.setFitWidth(300);
        logoShow.setPreserveRatio(true);
        logoShow.setSmooth(true);
        logoShow.setCache(true);
        
        root.getChildren().add(logoShow);
        Scene forLogo = new Scene(root, 400, 400);
        forLogo.setFill(Color.TRANSPARENT);
        
        logoStage = new Stage();
        logoStage.setScene(forLogo);

        logoStage.initStyle(StageStyle.TRANSPARENT);
        logoStage.show();
        
        officialStage = new Stage();
        HBox someHBox = new HBox(10);
        Scene officialScene = new Scene(someHBox, 400, 400);
        
        //showing the logo (it works!!)
        officialStage.getIcons().add(new Image("file:recipe_hunter_logo.png"));
        officialStage.setScene(officialScene);
        
        FillingIngredientList thread = new FillingIngredientList();
        thread.start();
        
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished( event -> switchStages() );
        delay.play();

    }
    
    private static void switchStages(){
        logoStage.close();
        officialStage.show();
    }
}
