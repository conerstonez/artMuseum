package com.art.gallery.model.repository;

import com.art.gallery.model.data.Address;
import com.art.gallery.model.data.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository  extends JpaRepository<Buyer, Long> {
}
