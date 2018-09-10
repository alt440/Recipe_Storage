/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import threads.GetRecipes;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
/**
 *
 * @author user
 */
public class RecipeSearch {

    /**
     * To grab all the GUI formats of the recipes
     */
    
    
    /**
     * This stage will be composed of the recipe objects and their principal attributes
     * (rating, name, image of the recipe, list of name of ingredients)
     * @return the stage for the results of recipes
     */
    //FOR NOW RETURNS ALL EXISTING RECIPES
    public static VBox searchForRecipe(/*ingredients*/){
        
        //the general VBox of the scene
        VBox someVBox = new VBox(10);

        //get the top bar
        someVBox.getChildren().add(TopBar.getTopBar(2));

        StackPane[] recipeObjects = GetRecipes.getRecipesGUIObjects();
        for(int i=0;i<recipeObjects.length;i++){
            someVBox.getChildren().add(recipeObjects[i]);
        }

        return someVBox;
    }
    
    /**
     * This method will set the order of the recipes appearing based on the rating if 
     * their is no ingredients searched, or otherwise with the rating and the ingredients 
     * they possess.
     */
    public static void orderRecipes(){
        
    }
}
