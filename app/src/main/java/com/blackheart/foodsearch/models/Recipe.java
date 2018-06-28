
package com.blackheart.foodsearch.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Recipe {

    @SerializedName("imageUrlsBySize")
    @Expose
    private ImageUrlsBySize imageUrlsBySize;
    @SerializedName("sourceDisplayName")
    @Expose
    private String sourceDisplayName;
    @SerializedName("ingredients")
    @Expose
    private List<String> ingredients = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("smallImageUrls")
    @Expose
    private List<String> smallImageUrls = null;
    @SerializedName("recipeName")
    @Expose
    private String recipeName;
    @SerializedName("totalTimeInSeconds")
    @Expose
    private Integer totalTimeInSeconds;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("flavors")
    @Expose
    private Object flavors;
    @SerializedName("rating")
    @Expose
    private Integer rating;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Recipe() {
    }

    /**
     * 
     * @param id
     * @param ingredients
     * @param recipeName
     * @param totalTimeInSeconds
     * @param smallImageUrls
     * @param sourceDisplayName
     * @param flavors
     * @param rating
     * @param attributes
     * @param imageUrlsBySize
     */
    public Recipe(ImageUrlsBySize imageUrlsBySize, String sourceDisplayName, List<String> ingredients, String id, List<String> smallImageUrls, String recipeName, Integer totalTimeInSeconds, Attributes attributes, Object flavors, Integer rating) {
        super();
        this.imageUrlsBySize = imageUrlsBySize;
        this.sourceDisplayName = sourceDisplayName;
        this.ingredients = ingredients;
        this.id = id;
        this.smallImageUrls = smallImageUrls;
        this.recipeName = recipeName;
        this.totalTimeInSeconds = totalTimeInSeconds;
        this.attributes = attributes;
        this.flavors = flavors;
        this.rating = rating;
    }

    public ImageUrlsBySize getImageUrlsBySize() {
        return imageUrlsBySize;
    }

    public void setImageUrlsBySize(ImageUrlsBySize imageUrlsBySize) {
        this.imageUrlsBySize = imageUrlsBySize;
    }

    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    public void setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSmallImageUrls() {
        return smallImageUrls;
    }

    public void setSmallImageUrls(List<String> smallImageUrls) {
        this.smallImageUrls = smallImageUrls;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(Integer totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Object getFlavors() {
        return flavors;
    }

    public void setFlavors(Object flavors) {
        this.flavors = flavors;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
