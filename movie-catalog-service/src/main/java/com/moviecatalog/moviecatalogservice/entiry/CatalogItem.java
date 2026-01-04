package com.moviecatalog.moviecatalogservice.entiry;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogItem {

    String name;
    String desc;
    int rating;
}
