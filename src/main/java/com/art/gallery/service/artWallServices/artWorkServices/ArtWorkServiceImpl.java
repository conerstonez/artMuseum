package com.art.gallery.service.artWallServices.artWorkServices;

import com.art.gallery.model.repository.ArtWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtWorkServiceImpl implements ArtWorkService {
    private final ArtWorkRepository artWorkRepository;

    @Autowired
    public  ArtWorkServiceImpl(ArtWorkRepository artWorkRepository) {
        this.artWorkRepository = artWorkRepository;
    }

}
