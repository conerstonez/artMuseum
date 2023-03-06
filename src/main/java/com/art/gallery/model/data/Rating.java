package com.art.gallery.model.data;

public enum Rating {
    BAD(1),
    SATISFACTORY(2),
    GOOD(3),
    EXCELLENT(4);
    private final int rating;

    public int getRating(){
        return rating;
    }
    Rating(int rating){
        this.rating=rating;
    }
}
