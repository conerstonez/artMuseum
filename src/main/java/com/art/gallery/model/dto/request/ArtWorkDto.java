package com.art.gallery.model.dto.request;

import com.art.gallery.model.data.Category;
import lombok.Data;

@Data
public class ArtWorkDto {
    private Long id;
    private Category category;
}
