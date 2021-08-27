package ru.less5.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data

@AllArgsConstructor
@NoArgsConstructor
@With
@ToString

public class Product {

    Integer id;

    String title;

    Integer price;

    String categoryTitle;
}


