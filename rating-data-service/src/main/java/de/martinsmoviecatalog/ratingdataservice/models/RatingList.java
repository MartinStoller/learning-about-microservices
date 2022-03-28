package de.martinsmoviecatalog.ratingdataservice.models;

import java.util.List;

// Returning Lists is not optimal becuase of Scaleability(We might wanna have functions which return a list right now to return additional information.
//if we wrap that List in a class we can in this case simply add another attribut to our class. This is not possible if we return a List directly.
//Also our WebClient needs to know a class in which it should parse our response and this class cannot be generic like a List (there are workarounds, but best to simply avoid the issue)
public class RatingList {
    private List<Rating> ratingList;

    public RatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
