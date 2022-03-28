package de.martinsmoviecatalog.martinsmoviecatalogservice;

import de.martinsmoviecatalog.martinsmoviecatalogservice.models.CatalogItem;
import de.martinsmoviecatalog.martinsmoviecatalogservice.models.Movie;
import de.martinsmoviecatalog.martinsmoviecatalogservice.models.Rating;
import de.martinsmoviecatalog.martinsmoviecatalogservice.models.RatingList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    private final MovieCatalogService service;

    public MovieCatalogController(MovieCatalogService service){
        this.service = service;
    }

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){
        //Get IDs of all rated movies by user (for now lets hardcode this data)
        Mono<RatingList> ratings = service.getRatingList("abc");
        //for each movie the user has rated, call movie info service to get details
        return ratings.block().getRatingList().stream().map(rating -> {

            Movie movieInfo = service.getMovieInfoRESTCall(rating.getMovieId()).block();

            return new CatalogItem(movieInfo.getMovieName(), "some description", rating.getRating());

        }).collect(Collectors.toList());
    }
}
