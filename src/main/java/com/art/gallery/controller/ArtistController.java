package com.art.gallery.controller;

import com.art.gallery.model.data.Address;
import com.art.gallery.model.data.Artist;
import com.art.gallery.model.data.User;
import com.art.gallery.model.dto.mapping.ArtWallMapper;
import com.art.gallery.model.dto.request.ArtistRequestDto;
import com.art.gallery.model.dto.request.UserDetailDto;
import com.art.gallery.model.dto.response.ArtistResponseDto;
import com.art.gallery.service.artWallServices.artistServices.ArtistService;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/artist")
@AllArgsConstructor
public class ArtistController {

    private final ArtistService artistService;


    @PostMapping("/register")
    public ResponseEntity<ArtistResponseDto> registerArtist(ArtistRequestDto artist){
        User savedArtist = artistService.register(artist);
        ArtistResponseDto savedArtistDto = ArtWallMapper.mapArtist((Artist) savedArtist);
        savedArtistDto.setCode(HttpStatus.CREATED);

        return new ResponseEntity<>(savedArtistDto, savedArtistDto.getCode());
    }

    @GetMapping("/login")
    public ResponseEntity<ArtistResponseDto> artistLogin(String email, String Password) {
        User artist = artistService.login(email, Password);
        ArtistResponseDto artistResponseDto = ArtWallMapper.mapArtist((Artist) artist);
        artistResponseDto.setCode(HttpStatus.OK);

        return new ResponseEntity<>(artistResponseDto, artistResponseDto.getCode());

    }
    @PutMapping("{artistId}")
    public ResponseEntity<ArtistResponseDto> updateArtistProfile(ArtistRequestDto artistRequestDto, UserDetailDto userDetailDto, Address address,
                                                                @PathVariable(value = "artistId") Long artistId) throws JsonPatchException {

        User updatedArtistProfile = artistService.updateArtistProfile(artistRequestDto, artistId);
        ArtistResponseDto updatedDto = ArtWallMapper.mapArtist((Artist) updatedArtistProfile);
        updatedDto.setCode(HttpStatus.ACCEPTED);

        return new ResponseEntity<>(updatedDto, updatedDto.getCode());
    }


}
