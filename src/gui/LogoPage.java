/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author user
 */
public class LogoPage extends Thread{
    private static ReentrantLock lock = new ReentrantLock();
    
    public void run(){
        lock.lock();
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
        
        Stage logoStage = new Stage();
        logoStage.setScene(forLogo);

        logoStage.initStyle(StageStyle.TRANSPARENT);
        EntryPage.setLogoStage(logoStage);
        logoStage.show();
        lock.unlock();
    }
    
    public static boolean isLockLocked(){
        return lock.isLocked();
    }
}
