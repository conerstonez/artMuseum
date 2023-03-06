package com.art.gallery.model.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ArtGallery extends User{

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @Override
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artGallery_generation"
    )
    @SequenceGenerator(
            name = "artGallery_generation",
            sequenceName = "artGallery_id_sequence",
            allocationSize = 100,
            initialValue = 10101
    )
    public void setId(Long id) {
        super.setId(id);
    }
}
