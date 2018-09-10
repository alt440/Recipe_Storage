/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Scene;
/**
 * This class can be used by any other class to include the top of the scene which
 * allows the selection of a section of the application.
 * @author user
 */
public class TopBar {
    //had to add this parameter because the moment we are adding the top bar the official
    //does not yet exist
    private static double officialSceneWidth = Constants.getWidthScene();
    //creating uniform stroke width
    private static int strokeWidth = 1;
    
    //the top bar
    private static HBox topBarSearch;
    private static HBox topBarRecipe;
    private static HBox topBarWeek;
    private static HBox topBarManage;
    
    /**
     * Method that creates the top bar for the specified tab, numerized from 1 to 4.
     * @param Describes the class calling the method. 1 is for the search tab, 2
     * is for the recipe tab, 3 for the week schedule tab, and 4 is for the manage
     * fridge tab.
     * @return The HBox of the top bar
     */
    public static HBox getTopBar(int classNb){
        /*switch(classNb){
            case 1: if(topBarSearch!=null) return topBarSearch;break;
            case 2: if(topBarRecipe!=null) return topBarRecipe;break;
            case 3: if(topBarWeek!=null) return topBarWeek;break;
            case 4: if(topBarManage!=null) return topBarManage;break;
        }*/
            
            HBox topBar = new HBox(0);

            //first section: Search
            Rectangle searchSection = new Rectangle(officialSceneWidth/4,20);
            searchSection.setStrokeWidth(strokeWidth);
            Text searchText = new Text("Search");
            searchText.setMouseTransparent(true);
            StackPane search_text = new StackPane();
            search_text.getChildren().addAll(searchSection, searchText);
        
            //No stroke for this one because it is the first section opened.
            searchSection.setFill(Color.WHITE);
        
        
            //second section: Recipes related to search
            Rectangle suggestedRecipes = new Rectangle(officialSceneWidth/4,20);
            suggestedRecipes.setStroke(Color.BLACK);
            suggestedRecipes.setFill(Color.WHITE);
            suggestedRecipes.setStrokeWidth(strokeWidth);
            Text suggestedText = new Text("Suggested Recipes");
            suggestedText.setMouseTransparent(true);
            StackPane suggested_text = new StackPane();
            suggested_text.getChildren().addAll(suggestedRecipes, suggestedText);
        
            //third section: Schedule of recipes for the week
            Rectangle scheduleWeek = new Rectangle(officialSceneWidth/4, 20);
            scheduleWeek.setStroke(Color.BLACK);
            scheduleWeek.setFill(Color.WHITE);
            scheduleWeek.setStrokeWidth(strokeWidth);
            Text scheduleText = new Text("Week Schedule");
            scheduleText.setMouseTransparent(true);
            StackPane schedule_text = new StackPane();
            schedule_text.getChildren().addAll(scheduleWeek, scheduleText);
        
            //Fourth section: Manage Fridge
            Rectangle manageFridge = new Rectangle(officialSceneWidth/4, 20);
            manageFridge.setStroke(Color.BLACK);
            manageFridge.setFill(Color.WHITE);
            manageFridge.setStrokeWidth(strokeWidth);
            Text manageText = new Text("Manage Fridge");
            manageText.setMouseTransparent(true);
            StackPane manage_text = new StackPane();
            manage_text.getChildren().addAll(manageFridge, manageText);
        
            //all buttons activated apart from the first tab
            switch (classNb) {
                case 1:
                    //stokes for this tab
                    //because this tab is opened, make the stroke not appear
                    searchSection.setStroke(Color.WHITE);
                        
                    //to make these tabs seem closed, mark them with a stroke
                    suggestedRecipes.setStroke(Color.BLACK);
                    scheduleWeek.setStroke(Color.BLACK);
                    manageFridge.setStroke(Color.BLACK);
                    suggestedRecipes.setOnMouseClicked(e->{
                        //loading the appropriate scene into the stage and show
                        EntryPage.getOfficialScene().setRoot(RecipeSearch.searchForRecipe());
                        EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        EntryPage.getOfficialStage().show();
                    }); scheduleWeek.setOnMouseClicked(e->{
                        //loading the appropriate scene into the stage and show
                        //EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        //EntryPage.getOfficialStage().show();
                    }); manageFridge.setOnMouseClicked(e->{
                        //loading the appropriate scene into the stage and show
                        //EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        //EntryPage.getOfficialStage().show();
                    }); topBar.getChildren().addAll(search_text, suggested_text, schedule_text, 
                            manage_text);
                    topBarSearch = topBar;
                    return topBarSearch;
                case 2:
                    //because this tab is opened, make the stroke not appear
                    suggestedRecipes.setStroke(Color.WHITE);
                        
                    //to make these tabs seem closed, mark them with a stroke
                    searchSection.setStroke(Color.BLACK);
                    scheduleWeek.setStroke(Color.BLACK);
                    manageFridge.setStroke(Color.BLACK);
                    searchSection.setOnMouseClicked(e->{
                        EntryPage.getOfficialScene().setRoot(EntryPage.getOfficialScreenPane());
                        EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        EntryPage.getOfficialStage().show();
                    }); scheduleWeek.setOnMouseClicked(e->{
                        //loading the appropriate scene into the stage and show
                        //EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        //EntryPage.getOfficialStage().show();
                    }); manageFridge.setOnMouseClicked(e->{
                        //loading the appropriate scene into the stage and show
                        //EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        //EntryPage.getOfficialStage().show();
                    }); topBar.getChildren().addAll(search_text, suggested_text, schedule_text, 
                            manage_text);
                    topBarRecipe = topBar;
                    return topBarRecipe;
                case 3: 
                    //because this tab is opened, make the stroke not appear
                    scheduleWeek.setStroke(Color.WHITE);
                        
                    //to make these tabs seem closed, mark them with a stroke
                    searchSection.setStroke(Color.BLACK);
                    suggestedRecipes.setStroke(Color.BLACK);
                    manageFridge.setStroke(Color.BLACK);
                    searchSection.setOnMouseClicked(e->{
                        EntryPage.getOfficialScene().setRoot(EntryPage.getOfficialScreenPane());
                        EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        EntryPage.getOfficialStage().show();
                    }); suggestedRecipes.setOnMouseClicked(e->{
                        //loading the appropriate scene into the stage and show
                        
                        EntryPage.getOfficialScene().setRoot(RecipeSearch.searchForRecipe());
                        EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        EntryPage.getOfficialStage().show();
                    }); manageFridge.setOnMouseClicked(e->{
                        //loading the appropriate scene into the stage and show
                        //EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        //EntryPage.getOfficialStage().show();
                    }); topBar.getChildren().addAll(search_text, suggested_text, schedule_text, 
                            manage_text);
                    topBarWeek = topBar; 
                    return topBarWeek;
                case 4:
                    //because this tab is opened, make the stroke not appear
                    manageFridge.setStroke(Color.WHITE);
                        
                    //to make these tabs seem closed, mark them with a stroke
                    searchSection.setStroke(Color.BLACK);
                    suggestedRecipes.setStroke(Color.BLACK);
                    scheduleWeek.setStroke(Color.BLACK);
                    searchSection.setOnMouseClicked(e->{
                        EntryPage.getOfficialScene().setRoot(EntryPage.getOfficialScreenPane());
                        EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        EntryPage.getOfficialStage().show();
                    }); suggestedRecipes.setOnMouseClicked(e->{
                        //loading the appropriate scene into the stage and show
                        EntryPage.getOfficialScene().setRoot(RecipeSearch.searchForRecipe());
                        EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        EntryPage.getOfficialStage().show();
                    }); scheduleWeek.setOnMouseClicked(e->{
                        //loading the appropriate scene into the stage and show
                        //EntryPage.getOfficialStage().setScene(EntryPage.getOfficialScene());
                        //EntryPage.getOfficialStage().show();
                    }); topBar.getChildren().addAll(search_text, suggested_text, 
                            schedule_text, manage_text);
                    topBarManage = topBar; 
                    return topBar;
            }

            System.err.println("ERROR: No valid class selected @TopBar class");
            //topBar.getChildren().addAll(search_text, suggested_text, schedule_text, manage_text);

        return topBar;
        
    }

}
