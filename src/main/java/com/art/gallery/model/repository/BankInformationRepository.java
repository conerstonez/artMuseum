package com.art.gallery.model.repository;

import com.art.gallery.model.data.BankInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankInformationRepository extends JpaRepository<BankInformation, Long> {
}
