package com.art.gallery.controller;

import com.art.gallery.model.data.Address;
import com.art.gallery.model.data.Artist;
import com.art.gallery.model.data.UserDetails;
import com.art.gallery.model.dto.mapping.ArtWallMapper;
import com.art.gallery.model.dto.mapping.MapToDto;
import com.art.gallery.model.dto.request.ArtistRequestDto;
import com.art.gallery.model.dto.response.ArtistResponseDto;
import com.art.gallery.service.artWallServices.artistServices.ArtistService;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/artist")
public class ArtistController {

    private final ArtistService artistService;
    private final ModelMapper mapper;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
        mapper = new ModelMapper();
    }


    @PostMapping("/register")
    public ResponseEntity<ArtistResponseDto> registerArtist(ArtistRequestDto artist){
        Artist savedArtist = artistService.register(artist);
        ArtistResponseDto savedArtistDto = MapToDto.mapArtistToDto(savedArtist);
        savedArtistDto.setCode(HttpStatus.CREATED);

        return new ResponseEntity<>(savedArtistDto, savedArtistDto.getCode());
    }

    @GetMapping("/login")
    public ResponseEntity<ArtistResponseDto> artistLogin(String email, String Password) {
        Artist artist = artistService.login(email, Password);
        ArtistResponseDto artistResponseDto = MapToDto.mapArtistToDto(artist);
        artistResponseDto.setCode(HttpStatus.OK);

        return new ResponseEntity<>(artistResponseDto, artistResponseDto.getCode());

    }
    @PutMapping("{artistId}")
    public ResponseEntity<ArtistResponseDto> updateArtistProfile(ArtistRequestDto artistRequestDto, Address address,
                                                                @PathVariable(value = "artistId") Long artistId) throws JsonPatchException {

        Artist updatedArtistProfile = artistService.updateArtistProfile(artistRequestDto, artistId);
        ArtistResponseDto updatedDto = MapToDto.mapArtistToDto(updatedArtistProfile);
        updatedDto.setCode(HttpStatus.ACCEPTED);

        return new ResponseEntity<>(updatedDto, updatedDto.getCode());
    }

}
