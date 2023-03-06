package com.art.gallery.model.repository;

import com.art.gallery.model.data.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
