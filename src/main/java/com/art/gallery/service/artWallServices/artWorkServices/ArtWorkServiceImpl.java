package com.art.gallery.service.artWallServices.artWorkServices;

import com.art.gallery.model.repository.ArtWorkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArtWorkServiceImpl implements ArtWorkService {

    private final ArtWorkRepository artWorkRepository;

}
