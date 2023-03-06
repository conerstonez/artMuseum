package com.art.gallery.model.dto.mapping;

import com.art.gallery.model.data.*;
import com.art.gallery.model.dto.request.*;
import com.art.gallery.model.dto.response.ArtistResponseDto;

public class ArtWallMapper {


    public static ArtistResponseDto mapArtist(Artist artist) {
        ArtistResponseDto artistResponseDto = new ArtistResponseDto();
        artistResponseDto.setId(artist.getId());
        artistResponseDto.setFirstName(artist.getFirstName());
        artistResponseDto.setLastName(artist.getLastName());
        artistResponseDto.setEmail(artist.getEmail());
        artistResponseDto.setGender(artist.getGender());
        artistResponseDto.setDateOfBirth(artist.getDateOfBirth());
        artistResponseDto.setWebpageUrl(artist.getWebpageUrl());
        artistResponseDto.setSocialMediaUrl(artist.getSocialMediaUrl());

        return artistResponseDto;
    }
}
