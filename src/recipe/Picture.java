/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 *
 * @author user
 */
public class Picture {
    
    private String URI;//the URI includes the name of the file and its extension
    
    public String getPictureURI(){
        return this.URI;
    }
    
    public void setPictureURI(String URI){
        this.URI = URI;
    }
    
    public void renamePicture(String titleRecipe){
        /*
        Renames the picture to the title of the recipe .jpg to associate the 
        picture to the recipe.
        */
    }
}
