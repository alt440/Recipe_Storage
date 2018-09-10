/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.lang.StringBuilder;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import recipe.RecipeBuilder;
/**
 *
 * @author user
 */
public class RecipeObjectGUI {
    
    //had to add this parameter because the moment we are adding the top bar the official
    //does not yet exist
    private static int officialSceneWidth = 400;
    
    //number of ingredients shown with the recipe before clicking on it for more details
    private static int ingredientsShown = 4;
    
    //the X,Y coordinate is the middle-left point of the star
    /**
     * This method draws a star attributed for the rating of a recipe
     * @param coorX the leftmost point of the star
     * @param coorY the highest point of the star
     * @param isFilled if the star is filled because the rating is greater
     * @return the star object in a polygon type
     */
    private static Polygon drawStar(double coorX, double coorY, boolean isFilled){
        //     /\
        //   --  --
        //   \    /
        //   / /\ \
        //total of 10 coordinates
        
        double totalLengthOfStarX = 10;
        double totalLengthOfStarY = 10;
        
        double[] allXCoor = new double[10];
        double[] allYCoor = new double[10];
        //total X length is divided in 7
        //points put from left to right
        allXCoor[0]=coorX;
        allXCoor[1]=coorX;
        allXCoor[2]=coorX+totalLengthOfStarX/6;
        allXCoor[3]=coorX+2*(totalLengthOfStarX/6);
        allXCoor[4]=coorX+3*(totalLengthOfStarX/6);
        allXCoor[5]=coorX+3*(totalLengthOfStarX/6);
        allXCoor[6]=coorX+4*(totalLengthOfStarX/6);
        allXCoor[7]=coorX+5*(totalLengthOfStarX/6);
        allXCoor[8]=coorX+totalLengthOfStarX;
        allXCoor[9]=coorX+totalLengthOfStarX;
        
        //points put in the same order as Xs'
        allYCoor[0]=coorY+(totalLengthOfStarY/4);
        allYCoor[1]=coorY+totalLengthOfStarY;
        allYCoor[2]=coorY+2*(totalLengthOfStarY/4);
        allYCoor[3]=coorY+(totalLengthOfStarY/4);
        allYCoor[4]=coorY;
        allYCoor[5]=coorY+3*(totalLengthOfStarY/4);
        allYCoor[6]=coorY+(totalLengthOfStarY/4);
        allYCoor[7]=coorY+2*(totalLengthOfStarY/4);
        allYCoor[8]=coorY+(totalLengthOfStarY/4);
        allYCoor[9]=coorY+totalLengthOfStarY;
        
        //create the polygon. The points that are neighbors must be indicated one
        //after the other. 
        Polygon star = new Polygon(allXCoor[0],allYCoor[0],allXCoor[3],allYCoor[3],
                allXCoor[4],allYCoor[4],allXCoor[6],allYCoor[6],allXCoor[8],allYCoor[8],
                allXCoor[7],allYCoor[7],allXCoor[9],allYCoor[9],allXCoor[5],allYCoor[5],
                allXCoor[1],allYCoor[1],allXCoor[2],allYCoor[2],allXCoor[0],allYCoor[0]);
        star.setStroke(Color.BLACK);
        if(isFilled){
            star.setFill(Color.YELLOW);
        }
        else{
            star.setFill(Color.WHITE);
        }
        return star;
    }
    
    /**
     * Draws a star that is half filled, half empty, because the ratings can be odd numbers.
     * @param coorX Leftmost point of the star
     * @param coorY Highest point of the star
     * @return The left and right polygons representing, together, one whole star.
     */
    private static Polygon[] drawHalfStars(double coorX, double coorY){
        
        double totalLengthOfStarX = 10;
        double totalLengthOfStarY = 10;
        
        //starting with left part
        double[] allXCoor = new double[10];
        double[] allYCoor = new double[10];
        //total X length is divided in 7
        //points put from left to right
        allXCoor[0]=coorX;
        allXCoor[1]=coorX;
        allXCoor[2]=coorX+totalLengthOfStarX/6;
        allXCoor[3]=coorX+2*(totalLengthOfStarX/6);
        allXCoor[4]=coorX+3*(totalLengthOfStarX/6);
        allXCoor[5]=coorX+3*(totalLengthOfStarX/6);
        allXCoor[6]=coorX+4*(totalLengthOfStarX/6);
        allXCoor[7]=coorX+5*(totalLengthOfStarX/6);
        allXCoor[8]=coorX+totalLengthOfStarX;
        allXCoor[9]=coorX+totalLengthOfStarX;
        
        //points put in the same order as Xs'
        allYCoor[0]=coorY+(totalLengthOfStarY/4);
        allYCoor[1]=coorY+totalLengthOfStarY;
        allYCoor[2]=coorY+2*(totalLengthOfStarY/4);
        allYCoor[3]=coorY+(totalLengthOfStarY/4);
        allYCoor[4]=coorY;
        allYCoor[5]=coorY+3*(totalLengthOfStarY/4);
        allYCoor[6]=coorY+(totalLengthOfStarY/4);
        allYCoor[7]=coorY+2*(totalLengthOfStarY/4);
        allYCoor[8]=coorY+(totalLengthOfStarY/4);
        allYCoor[9]=coorY+totalLengthOfStarY;
        
        Polygon[] left_right = new Polygon[2];
        
        left_right[0] = new Polygon(allXCoor[0],allYCoor[0],allXCoor[3],allYCoor[3],
                allXCoor[4],allYCoor[4],allXCoor[5],allYCoor[5],
                allXCoor[1],allYCoor[1],allXCoor[2],allYCoor[2],allXCoor[0],allYCoor[0]);
        left_right[0].setStroke(Color.BLACK);
        left_right[0].setFill(Color.YELLOW);
        
        left_right[1] = new Polygon(allXCoor[4],allYCoor[4],allXCoor[6],allYCoor[6],
                allXCoor[8],allYCoor[8],allXCoor[7],allYCoor[7],allXCoor[9],allYCoor[9],
                allXCoor[5],allYCoor[5],allXCoor[4],allYCoor[4]);
        left_right[1].setStroke(Color.BLACK);
        left_right[1].setFill(Color.WHITE);
        
        return left_right;
    }
    
    /**
     * Gets the list of stars that represent the rating of the recipe in the form of a HBox
     * @param rating The rating of the recipe on 10
     * @return HBox with all the stars in it.
     */
    private static HBox getRating(int rating){
        
        int starsLeft = 5;
        
        //fail safe measure
        if(rating>10)
            rating = 10;
        //if a half star needs to be drawn, then we need to add an extra space
        //to array because the half star method returns two polygons.
        if(rating%2==1)
            starsLeft++;

        Polygon[] allStars = new Polygon[starsLeft];
              
        int index = 0;
        while(rating>=2&&index<allStars.length){
            allStars[index]=drawStar(0, 0, true);
            rating-=2;
            starsLeft--;
            index++;
        }
        
        //prefer to add the half star here to keep the order of the stars in
        //the array right from the start.
        if(rating==1){
            Polygon[] halfStar = drawHalfStars(0, 0);
            allStars[index]=halfStar[0];
            index++;
            allStars[index]=halfStar[1];
            index++;
            starsLeft--;
        }
        while(starsLeft>0&&index<allStars.length){
            allStars[index]=drawStar(0, 0, false);
            starsLeft--;
        }
        
        HBox ratingBox = new HBox(0);
        for(int i=0;i<allStars.length;i++){
            ratingBox.getChildren().add(allStars[i]);
        }
        
        return ratingBox;
    }
    
    public static StackPane getRecipeObject(RecipeBuilder recipe){

        Text titleRecipe = new Text(recipe.getTitle());
        
        //top of object. not a good idea if title is too long. have to rethink this.
        HBox topObjectRecipe = new HBox(20);
        topObjectRecipe.getChildren().addAll(titleRecipe, 
                getRating(recipe.getRating()));
        
        //giving some information about the ingredients
        FlowPane listIngredients = new FlowPane();
        
        StringBuilder ingredientsString = new StringBuilder(recipe.getIngredients().get(0).getIngredientName());
        
        //because we already have one ingredient, start i at 1.
        for(int i=1;i<ingredientsShown && i<recipe.getIngredients().size();i++){
            ingredientsString.append(", "+recipe.getIngredients().get(i).getIngredientName());
        }
        
        int ingredientsNotListed = recipe.getIngredients().size()-ingredientsShown;
        ingredientsString.append(" (and "+(ingredientsNotListed>=0?ingredientsNotListed:0)+" more)");
        
        //System.out.println(ingredientsString.toString());
        Text ingredientsText = new Text(ingredientsString.toString());
        
        listIngredients.getChildren().add(ingredientsText);
        
        //setting the picture of the recipe
        Image recipePic = new Image("file:"+recipe.getPictureFullURI());
        ImageView showRecipePic = new ImageView(recipePic);
        
        //setting dimensions
        showRecipePic.setFitHeight(50.0);
        showRecipePic.setFitWidth(50.0);
        showRecipePic.setSmooth(true);
        showRecipePic.setCache(true);
        
        //setting the pane
        HBox pic_ingredients = new HBox(10);
        pic_ingredients.getChildren().addAll(showRecipePic, listIngredients);
        
        VBox wholeObject = new VBox(10);
        wholeObject.setAlignment(Pos.CENTER);
        //wholeObject.setTranslateX(50);
        wholeObject.getChildren().addAll(topObjectRecipe, pic_ingredients);
        
        //putting the rectangle behind it
        Rectangle aroundObject = new Rectangle(officialSceneWidth, 80, Color.WHITE);
        aroundObject.setStroke(Color.BLACK);
        
        //assembling both rectangle and wholeObject one on top of each other
        StackPane rect_wholeObject = new StackPane();
        rect_wholeObject.getChildren().addAll(aroundObject, wholeObject);

        
        return rect_wholeObject;
    }
}
