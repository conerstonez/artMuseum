package com.art.gallery.service.artWallServices.artistServices;

import com.art.gallery.model.data.ArtWork;
import com.art.gallery.model.data.Artist;
import com.art.gallery.model.data.Post;
import com.art.gallery.model.data.User;
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
        Artist newArtist = modelMapper.map(artistRequestDto, Artist.class);
        return artistRepository.save(newArtist);
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

//    @Override
//    public List<ArtistDto> getAllArtists() {
//        List<Artist> artists = new ArrayList<>(artistRepository.findAll());
//
//        List<ArtistDto> artistDtos = artists.stream().map(MapToDto::mapArtistToDto)
//                                    .collect(Collectors.toList());
//        artistDtos.forEach(artistDto -> artistDto.setCode(HttpStatus.OK));
//
//        return artistDtos;
//    }

    @Override
    public Artist login(String email, String password) {
        Artist foundArtist = artistRepository.findArtistByEmail(email);
        if (foundArtist.getPassword().equals(password)) return foundArtist;

        return null;
    }

    @Override
    public Post createPost(PostDto post, ArtWork artWork, Long id) {
        User artist = artistRepository.getReferenceById(id);

        return postService.createPost(post, artWork);
    }
}
