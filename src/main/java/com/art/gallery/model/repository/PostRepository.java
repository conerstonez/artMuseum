package com.art.gallery.model.repository;

import com.art.gallery.model.data.Address;
import com.art.gallery.model.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
