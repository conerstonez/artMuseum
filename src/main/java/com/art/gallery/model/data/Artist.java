package com.art.gallery.model.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artist_generation"
    )
    @SequenceGenerator(
            name = "artist_generation",
            sequenceName = "artist_id_sequence",
            allocationSize = 1,
            initialValue = 101
    )
    private Long artistId;
    private String username;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String webpageUrl;
    private String socialMediaUrl;
    @OneToOne
    private UserDetails userDetails;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Post> posts;
}
