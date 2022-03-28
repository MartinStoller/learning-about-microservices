package de.martinsmoviecatalog.ratingdataservice.controller;

import de.martinsmoviecatalog.ratingdataservice.models.Rating;
import de.martinsmoviecatalog.ratingdataservice.models.RatingList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratingdata")
public class RatingDataController {

    @RequestMapping("{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 92);
    }

    @RequestMapping("users/{userId}")
    public RatingList getUserRatings(@PathVariable("userId") String userId){
        return new RatingList(List.of(
                new Rating("888", 75),
                new Rating("999", 81))
        );
    }
}
