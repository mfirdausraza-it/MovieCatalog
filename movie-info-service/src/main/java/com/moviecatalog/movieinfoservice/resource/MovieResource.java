package com.moviecatalog.movieinfoservice.resource;

import com.moviecatalog.movieinfoservice.entity.MovieInfo;
import com.moviecatalog.movieinfoservice.movie.MovieList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieResource {

    @Value("${api.key}")
    String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{movieId}")
    public MovieInfo getMovieById(@PathVariable String movieId){
        log.info("Movie info retrieved for movieId {}", movieId);
        return MovieList.getAllMovie().stream().filter(a->a.getMovieId().equalsIgnoreCase(movieId)).findFirst().get();
    }
}
