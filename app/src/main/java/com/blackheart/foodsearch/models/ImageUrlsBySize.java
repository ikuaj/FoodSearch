
package com.blackheart.foodsearch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

public class ImageUrlsBySize {

    @SerializedName("90")
    @Expose
    private String _90;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageUrlsBySize() {
    }

    /**
     * 
     * @param _90
     */
    public ImageUrlsBySize(String _90) {
        super();
        this._90 = _90;
    }

    public String get90() {
        return _90;
    }

    public void set90(String _90) {
        this._90 = _90;
    }

}
