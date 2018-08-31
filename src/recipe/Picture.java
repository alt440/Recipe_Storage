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
/*
Find the way to actually rename the picture.
*/
public class Picture {
    
    private String URI = ".\\src\\recipe_storage\\Pictures";//the URI includes the name of the file and its extension
    private String name = "";
    
    public String getPictureURI(){
        return this.URI;
    }
    
    public void setPictureURI(String URI){
        this.URI = URI;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String titleRecipe){
        /*
        Renames the picture to the title of the recipe .jpg to associate the 
        picture to the recipe.
        */
        this.name = "\\"+titleRecipe+".jpg";
    }
    
    public String getPictureFullURI(){
        return this.URI+this.name;
    }
    
    public String toString(){
        return "Picture full URI: "+URI+name+"\n";
    }
}
