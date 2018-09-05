package com.mushy.beer;

public class Beer {

    private String name;
    private String style;
    private String brewery;
    private float abv;
    private int ibu;
    private String comments;
    private float rating;

    public Beer (String name) {

        this.name = name;
        this.style = "";
        this.brewery = "";
        this.abv = 0;
        this.ibu = 0;
        this.comments = "";
        this.rating = 0;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getStyle () {
        return style;
    }

    public void setStyle (String style) {
        this.style = style;
    }

    public String getBrewery () {
        return brewery;
    }

    public void setBrewery (String brewery) {
        this.brewery = brewery;
    }

    public float getAbv () {
        return abv;
    }

    public void setAbv (float abv) {
        this.abv = abv;
    }

    public int getIbu () {
        return ibu;
    }

    public void setIbu (int ibu) {
        this.ibu = ibu;
    }

    public String getComments () {
        return comments;
    }

    public void setComments (String comments) {
        this.comments = comments;
    }

    public float getRating () {
        return rating;
    }

    public void setRating (float rating) {
        this.rating = rating;
    }
}
