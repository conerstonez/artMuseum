package com.art.gallery.service.artWallServices.artistServices;

import com.art.gallery.model.data.ArtWork;
import com.art.gallery.model.data.Artist;
import com.art.gallery.model.data.Post;
import com.art.gallery.model.dto.request.ArtistRequestDto;
import com.art.gallery.model.dto.request.PostDto;
import com.art.gallery.model.repository.ArtistRepository;
import com.art.gallery.service.artWallServices.postServices.PostService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {


    private final ArtistRepository artistRepository;
    private final PostService postService;
    private final ModelMapper modelMapper;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository, PostService postService) {
        this.artistRepository = artistRepository;
        this.postService = postService;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Artist register(ArtistRequestDto artistRequestDto) {
        return null;
    }

    @Override
    public Artist login(String email, String password) {
        return null;
    }

    @Override
    public Post createPost(PostDto post, ArtWork artWork, Long id) {
        return null;
    }

    @Override
    public Artist updateArtistProfile(ArtistRequestDto artistRequestDto, Long artistId) throws JsonPatchException {
        ObjectMapper mapper = new ObjectMapper();
        Artist artist = artistRepository.getReferenceById(artistId);

        JsonPatch updatePayload = mapper.convertValue(artistRequestDto, JsonPatch.class);
        JsonNode foundNode = mapper.convertValue(artist, JsonNode.class);

        JsonNode updatedNode = updatePayload.apply(foundNode);

        return mapper.convertValue(updatedNode, Artist.class);
    }
}
