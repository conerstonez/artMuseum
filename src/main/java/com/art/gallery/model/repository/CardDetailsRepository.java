package com.art.gallery.model.repository;

import com.art.gallery.model.data.Address;
import com.art.gallery.model.data.CardDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDetailsRepository extends JpaRepository<CardDetail, Long> {
}
