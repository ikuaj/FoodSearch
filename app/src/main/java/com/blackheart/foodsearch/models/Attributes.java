
package com.blackheart.foodsearch.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


public class Attributes {

    @SerializedName("course")
    @Expose
    private List<String> course = null;
    @SerializedName("cuisine")
    @Expose
    private List<String> cuisine = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attributes() {
    }

    /**
     * 
     * @param course
     * @param cuisine
     */
    public Attributes(List<String> course, List<String> cuisine) {
        super();
        this.course = course;
        this.cuisine = cuisine;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public List<String> getCuisine() {
        return cuisine;
    }

    public void setCuisine(List<String> cuisine) {
        this.cuisine = cuisine;
    }

}
