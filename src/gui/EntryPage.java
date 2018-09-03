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
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.scene.image.ImageView;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.util.Duration;
import javafx.scene.text.Text;
import java.util.LinkedList;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;

import recipe.RecipeBuilder;
import recipe_storage.AllIngredients;
/*
TEXT NOT CLICKABLE!
*/
/**
 *
 * @author user
 */
public class EntryPage extends Application{
    private static Stage logoStage;
    private static Stage officialStage;
    private static LinkedList<RecipeBuilder> recipes;
    private static String[] suggestions = new String[5];//give 5 suggestions to what user types
    private static Rectangle[] suggestionRect = new Rectangle[5];
    private static StackPane[] rect_textPanes = new StackPane[5];
    private static Text[] suggestionTexts = new Text[5];
    private static VBox suggestionRectangles = new VBox(0);
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {    
        
        //define the logo stage
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
        //to preserve the same crisp image even if the image is resized
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
        
        
        //define the official stage
        officialStage = new Stage();
        VBox someVBox = new VBox(10);
        someVBox.setAlignment(Pos.CENTER);
        
        
        Text enterInfo = new Text("Enter the ingredients below:");
        TextField ingredientsEntered = new TextField();
        
        ingredientsEntered.textProperty().addListener((obs, oldVal, newVal) -> {
            //take newVal to search for ingredients related to what is typed
            //empty the VBox of suggestions first
            suggestionRectangles.getChildren().clear();
            
            /*
            Look for possibilities. If none, the VBox is not visible.
            Otherwise, it is visible and shows the number of results, up to 5.
            */
            System.out.println("NEW VAL: "+newVal);
            System.out.println("OLD VAL: "+oldVal);
            if(!AllIngredients.getIngredientBeginningWith(newVal).isEmpty() &&!newVal.equals("")){
                ArrayList<String> suggests = AllIngredients.getIngredientBeginningWith(newVal);
                
                /*
                Text suggestions under the textfield. Show only if input in textfield.
                If user clicks elsewhere they are removed (setVisible(false)).
                */
                
                for(int i=0;i<suggests.size();i++){
                    if(i<=4){
                        suggestions[i]=suggests.get(i);
                        System.out.println(suggestions[i]);
                        //code to create the rectangles
                        rect_textPanes[i] = new StackPane();
                        rect_textPanes[i].setLayoutX(ingredientsEntered.getLayoutX());
                        rect_textPanes[i].setLayoutY(ingredientsEntered.getLayoutY());
                        suggestionTexts[i] = new Text(suggestions[i]);
                        
                        //this method allows the mouse click to work even if over text
                        suggestionTexts[i].setMouseTransparent(true);
            
                        suggestionRect[i]= new Rectangle(ingredientsEntered.getWidth(), ingredientsEntered.getHeight());
                        suggestionRect[i].setFill(Color.WHITE);
                        
                        
                        rect_textPanes[i].getChildren().add(suggestionRect[i]);
                        rect_textPanes[i].getChildren().add(suggestionTexts[i]);
                        final String suggestionContent = suggestions[i];
                        suggestionRect[i].setOnMouseClicked(e->{
                            ingredientsEntered.setText(suggestionContent);
                            suggestionRectangles.setVisible(false);
                        });
                        /*
                        BUG: TEXT NOT CLICKABLE!!!
                        */
                        suggestionRectangles.getChildren().add(rect_textPanes[i]);
                    }
                    else{
                        break;
                    }
                }
                suggestionRectangles.setVisible(true);
            }
            else{
                suggestionRectangles.setVisible(false);
            }
        });
        
        //to control position of the suggestions (VBox controls children position)
        Pane surroundSuggestions = new Pane();
        surroundSuggestions.getChildren().add(suggestionRectangles);
        surroundSuggestions.setLayoutX(ingredientsEntered.getLayoutX());
        surroundSuggestions.setLayoutY(ingredientsEntered.getLayoutY()+10);
        
        VBox ingredientsSuggest_TextField = new VBox(0);
        ingredientsSuggest_TextField.getChildren().add(ingredientsEntered);
        ingredientsSuggest_TextField.getChildren().add(surroundSuggestions);
        
        
        HBox takingInput = new HBox(10);
        Button addIngredient = new Button("Add Ingredient");
        addIngredient.setOnAction(e->{
            addIngredientEvent(ingredientsEntered.getText());
        });
        
        takingInput.getChildren().add(ingredientsSuggest_TextField);
        takingInput.getChildren().add(addIngredient);
        
        someVBox.getChildren().add(enterInfo);
        someVBox.getChildren().add(takingInput);
        someVBox.getChildren().add(suggestionRectangles);
        Scene officialScene = new Scene(someVBox, 400, 400);
        
        //showing the logo (it works!!)
        officialStage.getIcons().add(new Image("file:recipe_hunter_logo.png"));
        officialStage.setScene(officialScene);
        officialStage.setTitle("Recipe Hunter 1.0");
        
        FillingIngredientList thread = new FillingIngredientList();
        thread.start();
        
        GetRecipes recipeInit = new GetRecipes();
        recipeInit.start();
        
        //grabbing the list of recipes
        recipes = GetRecipes.recipes;
        
        //
        
        //to transition from one scene to the other
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished( event -> switchStages() );
        delay.play();
        
        

    }
    
    private static void switchStages(){
        logoStage.close();
        officialStage.show();
    }
    
    private static String addIngredientEvent(String input){
        if(!AllIngredients.getIngredientBeginningWith(input).isEmpty()){
            //add the ingredient to the list of results
            return AllIngredients.getIngredientBeginningWith(input).get(0);
        }
        else{
            //show message of error
            Stage messageError = new Stage();
            messageError.initStyle(StageStyle.TRANSPARENT);
            HBox withText = new HBox(10);
            Text textError = new Text("There are no ingredients\nthat match your input");
            withText.getChildren().add(textError);            
            
            Scene messageErrorScene = new Scene(withText, 200,40);
            messageErrorScene.setFill(Color.TRANSPARENT);
            messageError.setScene(messageErrorScene);
            
            //the animation of the error
            Timeline timeline = new Timeline();
            KeyFrame key = new KeyFrame(Duration.millis(2000),
                           new KeyValue (messageError.getScene().getRoot().opacityProperty(), 0)); 
            timeline.getKeyFrames().add(key);   
            timeline.setOnFinished((ae) -> messageError.close()); 
            timeline.play();
            messageError.show();
            return "";
        }
    }
}
