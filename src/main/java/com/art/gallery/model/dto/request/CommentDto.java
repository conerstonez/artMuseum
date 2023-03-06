package com.art.gallery.model.dto.request;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private PostDto postDto;
    private String title;
    private String body;
}
