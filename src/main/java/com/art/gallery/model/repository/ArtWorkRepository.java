package com.art.gallery.model.repository;

import com.art.gallery.model.data.Address;
import com.art.gallery.model.data.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtWorkRepository extends JpaRepository<ArtWork, Long> {
}
