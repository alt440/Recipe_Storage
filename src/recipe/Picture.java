/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 * This class is used to handle the picture (if any) associated with the recipe.
 * It handles the URI to know the path to the picture and renames the picture
 * to better associate the pictures with the right recipe.
 * @author user
 */

import java.io.File;
/*
Find the way to actually rename the picture.
*/
public class Picture {
    
    private String URI = ".\\src\\recipe_storage\\Pictures";//the URI includes the name of the file and its extension
    private String name = "";
    
    /**
     * Returns the path to the pictures for the recipes.
     * @return Path to pictures.
     */
    public String getPictureURI(){
        return this.URI;
    }
    
    /**
     * Sets the path to the pictures for the recipes.
     * @param URI New URI to be set.
     */
    public void setPictureURI(String URI){
        this.URI = URI;
    }
    
    /**
     * Returns the name of the picture
     * @return String representing the name of the picture.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Sets the name of the picture
     * @param titleRecipe The title of the recipe, used to set the name of the picture.
     * @param picture The picture file that is going to be renamed to the title of the recipe.
     */
    public void setName(String titleRecipe, File picture){
        /*
        Renames the picture to the title of the recipe .jpg to associate the 
        picture to the recipe.
        */
        
        this.name = "\\"+titleRecipe+".jpg";
        File pictureRenamed = new File(this.URI+this.name);
        picture.renameTo(pictureRenamed);
        
    }
    
    /**
     * Returns the full path to the picture, which also includes the name of the picture file
     * @return String representing the full path to the file.
     */
    public String getPictureFullURI(){
        return this.URI+this.name;
    }
    
    /**
     * String representation of the picture, having both URI and name of the picture.
     * @return String representing the picture object.
     */
    public String toString(){
        return "Picture full URI: "+URI+name+"\n";
    }
}
