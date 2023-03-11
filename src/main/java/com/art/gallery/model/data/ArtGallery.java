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

public class ArtGallery {
    @Id
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
    private Long artGalleryId;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;
    @OneToOne
    private UserDetails userDetails;
}
