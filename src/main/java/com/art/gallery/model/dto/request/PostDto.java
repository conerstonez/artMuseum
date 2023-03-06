package com.art.gallery.model.dto.request;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String body;
    private ArtWorkDto artWork;
}
