package de.martinsmoviecatalog.martinsmoviecatalogservice;

import de.martinsmoviecatalog.martinsmoviecatalogservice.models.Movie;
import de.martinsmoviecatalog.martinsmoviecatalogservice.models.RatingList;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MovieCatalogService {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    private final WebClient movieInfoWebClient;

    private final WebClient ratingInfoClient;

    public MovieCatalogService(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder=webClientBuilder;
        this.movieInfoWebClient = webClientBuilder.baseUrl("http://movie-info-service").build();
        this.ratingInfoClient = webClientBuilder.baseUrl("http://movie-rating-service").build();
    }

    public Mono<Movie> getMovieInfoRESTCall(String movieId){
        return this.movieInfoWebClient.get().uri("/movies/{movieId}", movieId).retrieve().bodyToMono(Movie.class);
    }

    public Mono<RatingList> getRatingList(String userId){
        return this.ratingInfoClient.get().uri("/ratingdata/users/" + userId).retrieve().bodyToMono(RatingList.class);
    }

}
