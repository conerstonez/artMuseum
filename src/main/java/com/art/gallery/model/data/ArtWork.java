package com.art.gallery.model.data;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtWork {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "art_generation"
    )
    @SequenceGenerator(
            name = "art_generation",
            sequenceName = "art_id_sequence",
            allocationSize = 1,
            initialValue = 1001
    )
    @Column(insertable = false, updatable = false)
    private Long id;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "artWork")
    private Post post;
    private Rating rating;
}
