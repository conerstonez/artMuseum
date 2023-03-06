package com.art.gallery.service.artWallServices.artistServices;

import com.art.gallery.model.data.ArtWork;
import com.art.gallery.model.data.Artist;
import com.art.gallery.model.data.Post;
import com.art.gallery.model.dto.request.ArtistRequestDto;
import com.art.gallery.model.dto.request.PostDto;
import com.github.fge.jsonpatch.JsonPatchException;

public interface ArtistService {

    Artist register(ArtistRequestDto artistRequestDto);
    Artist updateArtistProfile(ArtistRequestDto artist, Long artistId) throws JsonPatchException;
    Artist login(String email, String password);
    Post createPost(PostDto post, ArtWork artWork, Long id);
}
