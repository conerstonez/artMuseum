package com.art.gallery.model.repository;


import com.art.gallery.model.data.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminUser, Long> {
}
