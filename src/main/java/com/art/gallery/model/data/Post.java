package com.art.gallery.model.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String body;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "post", orphanRemoval = true, cascade = jakarta.persistence.CascadeType.ALL)
    private List<Comment> comments;
    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "artWork_id", referencedColumnName = "id")
    private ArtWork artWork;

}
