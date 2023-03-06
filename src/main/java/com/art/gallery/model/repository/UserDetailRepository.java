package com.art.gallery.model.repository;

import com.art.gallery.model.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<User, Long> {
}
