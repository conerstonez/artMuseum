package com.art.gallery.service.artistService;


import com.art.gallery.model.data.*;
import com.art.gallery.model.dto.request.ArtistRequestDto;
import com.art.gallery.model.dto.request.PostDto;
import com.art.gallery.service.artWallServices.artistServices.ArtistService;
import com.art.gallery.service.artWallServices.categoryServices.CategoryService;
import com.github.fge.jsonpatch.JsonPatchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArtistServiceImplTest {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private CategoryService categoryService;

    ArtistRequestDto artist = new ArtistRequestDto();;
    Address address1 = new Address();

    @BeforeEach
    void setUp() {
        address1.setCity("Sururlere");
        address1.setState("Lagos");
        address1.setStreet("Adeniran-Ogunsanya");
        address1.setCountry("Nigeria");
        address1.setHouseNumber("16, Mba");
        address1.setZipCode("201911");
        address1.setPhoneNumber("08101661863");

        artist.setFirstName("Odunayo");
        artist.setLastName("Falegbe");
        artist.setEmail("f.odunayo34@gmail.com");
        artist.setPassword("password");
        artist.setGender(Gender.FEMALE);
//        artist.setSocialMediaUrl("@smiley");
//        artist.setWebpageUrl("thewebingthings.com");
        artist.setDateOfBirth(1997, 10, 11);
//        artist.setAddress(address1);

    }

    @Test
    void registerArtistTest() {
        ArtistRequestDto artistRequestDto = new ArtistRequestDto();;
        Address address = new Address();

        address.setCity("Ibadan");
        address.setState("Oyo");
        address.setStreet("Odo-Ona");
        address.setCountry("Nigeria");
        address.setHouseNumber("5, Oke-Ayo");
        address.setZipCode("672728");
        address.setPhoneNumber("09064374326");

        artistRequestDto.setFirstName("Ibukun");
        artistRequestDto.setLastName("Olalere");
        artistRequestDto.setEmail("olabukun@gmail.com");
        artistRequestDto.setPassword("secret");
        artistRequestDto.setGender(Gender.MALE);

        artistRequestDto.setDateOfBirth(2000, 8, 21);

        Artist savedArtist = artistService.register(artistRequestDto);
        Artist savedArtist1 = artistService.register(artist);

        assertNotNull(savedArtist);
        assertNotNull(savedArtist.getArtistId());
    }

    @Test
    void artistLoginTest() {
        Artist artistDto = artistService.login("olabukun@gmail.com", "secret");
        assertNotNull(artistDto);
        assertEquals(1, artistDto.getArtistId());
    }

    @Test
    void profileUpdateTest() throws JsonPatchException {
        Artist artist = artistService.login("olabukun@gmail.com", "secret");
        ArtistRequestDto artistDto = new ArtistRequestDto();
        Address newAddress =  new Address();
        newAddress.setPhoneNumber("08038728300");
//        artistDto.setAddress(newAddress);
//        artistService.updateArtistProfile(artistDto, artist.getArtistId());
    }

    @Test
    void createPostTest() {
        Artist artist = artistService.login("olabukun@gmail.com", "secret");
        PostDto post = new PostDto();
        post.setTitle("First Post");
        post.setDescription(".........");
        post.setBody("oro po ...");

        ArtWork artWork = new ArtWork();
        artWork.setCategory(categoryService.getCategoryByName("test name"));

        Post post1 = artistService.createPost(post, artWork, artist.getArtistId());
//        assertEquals(1, artist.getPosts().size());
    }
}