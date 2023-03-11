package com.art.gallery.model.repository;

import com.art.gallery.model.data.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Artist findArtistByUserDetailsEmail(String userEmail);

}
