package com.moviecatalog.movieinfoservice.movie;

import com.moviecatalog.movieinfoservice.entity.MovieInfo;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


public class MovieList {

    public static List<MovieInfo> getAllMovie(){
        return Arrays.asList(
                new MovieInfo("jwn","Jawan"),
                new MovieInfo("tnc","Titanic")
        );
    }
}
