package com.moviecatalog.ratingdataservice.resource;

import com.moviecatalog.ratingdataservice.entity.RatingData;
import com.moviecatalog.ratingdataservice.pojo.Ratings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
@Slf4j
public class RatingDataResource {

    @GetMapping("/{movieId}")
    public RatingData getRating(@PathVariable String movieId){
        return new RatingData(movieId,4);
    }

    @GetMapping("/user/{userId}")
    public Ratings getRat(@PathVariable String userId){
        log.info("User info retrieved for userId {}", userId);
        Ratings ratings = new Ratings();
        List<RatingData> ratingDataList = Arrays.asList(
                new RatingData("jwn", 5),
                new RatingData("tnc", 5)
        );
         ratings.setRatingList(ratingDataList);
         return ratings;
    }

}
