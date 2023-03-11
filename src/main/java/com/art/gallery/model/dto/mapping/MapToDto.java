package com.art.gallery.model.dto.mapping;

import com.art.gallery.model.data.Artist;
import com.art.gallery.model.dto.response.ArtistResponseDto;

public class MapToDto {

    public static ArtistResponseDto mapArtistToDto(Artist artist){
        ArtistResponseDto artistResponseDto = new ArtistResponseDto();
        artistResponseDto.setId(artist.getArtistId());
        artistResponseDto.setName(artist.getUserDetails().getName());
        artistResponseDto.setUsername(artist.getUsername());
        artistResponseDto.setEmail(artist.getUserDetails().getEmail());
        artistResponseDto.setGender(artist.getGender());
        artistResponseDto.setDateOfBirth(artist.getDateOfBirth());
        artistResponseDto.setWebpageUrl(artist.getWebpageUrl());
        artistResponseDto.setSocialMediaUrl(artist.getSocialMediaUrl());

        return artistResponseDto;
    }

}
