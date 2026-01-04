package com.moviecatalog.ratingdataservice.pojo;

import com.moviecatalog.ratingdataservice.entity.RatingData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {
    private List<RatingData> ratingList;
}
