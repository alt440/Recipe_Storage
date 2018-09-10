/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.EventType;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
/**
 *
 * @author user
 */
public class IngredientSearchedObject {
    private Text nameIngredient;
    private Button buttonIngredient;
    private ImageView xImage = new ImageView(new Image("file:X.png"));
    private StackPane container;
    
    public IngredientSearchedObject(String nameIngredientString){
        
        nameIngredient = new Text();
        buttonIngredient = new Button();
        
        //features of the X icon
        xImage.setFitWidth(10);
        //xImage.setFitHeight(10);
        //to preserve the same crisp image even if the image is resized
        xImage.setPreserveRatio(true);
        xImage.setSmooth(true);
        xImage.setCache(true);
        
        HBox text_img = new HBox(5);
        nameIngredient.setText(nameIngredientString);
        
        //name is a little above button
        //nameIngredient.setTranslateY(5);
        
        //to be able to click on it
        nameIngredient.setMouseTransparent(true);
        text_img.getChildren().add(nameIngredient);
        
        //image is a little above button
        xImage.setTranslateY(5);
        //to be able to click on it
        xImage.setMouseTransparent(true);
        /*xImage.setOnMouseClicked(e->{
            //send request to flowpane for deletion
            System.out.println("REMOVED INGREDIENT!");
            EntryPage.getIngredientsInSearchPane().getChildren().remove(this.container);
            EntryPage.decreaseNumberIngredientSearched();
        });*/
        text_img.getChildren().add(xImage);
        
        buttonIngredient.setGraphic(text_img);

        container = new StackPane();
        
        //to be able to click on it
        //container.setMouseTransparent(true);
        /*container.setOnMouseClicked(e->{
            System.out.println("REMOVED INGREDIENT!");
        });*/
        
        container.getChildren().add(buttonIngredient);
        container.getChildren().add(text_img);
        
        buttonIngredient.setOnMouseClicked(e->{
            //send request to flowpane for deletion
            System.out.println("REMOVED INGREDIENT! @IngredientSearchedObject");
            EntryPage.getIngredientsInSearchPane().getChildren().remove(this.container);
            EntryPage.decreaseNumberIngredientSearched();
        });
    }
    
    public StackPane getContainer(){
        return container;
    }
    
    public String getNameIngredient(){
        return nameIngredient.getText();
    }
}
