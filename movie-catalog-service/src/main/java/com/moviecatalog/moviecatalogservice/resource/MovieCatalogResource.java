package com.moviecatalog.moviecatalogservice.resource;

import com.moviecatalog.moviecatalogservice.entiry.CatalogItem;
import com.moviecatalog.moviecatalogservice.entiry.MovieInfo;
import com.moviecatalog.moviecatalogservice.entiry.RatingData;
import com.moviecatalog.moviecatalogservice.entiry.Ratings;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getDataByUserId(@PathVariable String userId) {
        log.info("Inside getDataByUserId method of MovieCatalogResource for userId : {}", userId);
        List<CatalogItem> catalogItems = new ArrayList<>();
        Ratings ratingData = restTemplate.getForObject("http://rating-data-service/rating/user/abc", Ratings.class);
        if (ratingData != null) {
            log.info("Rating data retrieved from rating-data-service : {}", ratingData);
        }
        for( RatingData rating : ratingData.getRatingList()) {
            MovieInfo movieInfo = restTemplate.getForObject("http://movie-info-service/movie/" + rating.getMovieId(), MovieInfo.class);
            if (movieInfo != null) {
                log.info("Movie info retrieved from movie-info-service for movieId {}: {}", rating.getMovieId(), movieInfo);
                CatalogItem catalogItem = new CatalogItem(movieInfo.getMovieName(), "Test Desc", rating.getRating());
                catalogItems.add(catalogItem);
            }
        }
        /*
            MovieInfo movieInfo = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movie/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(MovieInfo.class)
                    .block();
            */
        log.info("Exiting getDataByUserId method of MovieCatalogResource for userId : {}", userId);
        return catalogItems;
    }
}
