package com.art.gallery.model.repository;

import com.art.gallery.model.data.ArtGallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtGalleryRepository extends JpaRepository<ArtGallery, Long> {
}
