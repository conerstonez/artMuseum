package com.art.gallery.model.dto.mapping;

import com.art.gallery.model.data.Artist;
import com.art.gallery.model.dto.request.ArtistRequestDto;

public class ArtWallMapper {

    public static Artist mapArtist(ArtistRequestDto artistRequestDto) {
        Artist artist = new Artist();
        artist.setUsername(artistRequestDto.getUsername());
        artist.getUserDetails().setName(artistRequestDto.getFirstName() + " " + artistRequestDto.getLastName());
        artist.getUserDetails().setEmail(artistRequestDto.getEmail());
        artist.getUserDetails().setPassword(artistRequestDto.getPassword());
        artist.setGender(artistRequestDto.getGender());
        artist.setDateOfBirth(artistRequestDto.getDateOfBirth());

        return artist;
    }
}
