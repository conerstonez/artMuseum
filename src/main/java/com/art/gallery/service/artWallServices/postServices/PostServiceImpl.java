package com.art.gallery.service.artWallServices.postServices;

import com.art.gallery.model.data.ArtWork;
import com.art.gallery.model.data.Post;
import com.art.gallery.model.dto.mapping.ArtWallMapper;
import com.art.gallery.model.dto.request.ArtWorkDto;
import com.art.gallery.model.dto.request.PostDto;
import com.art.gallery.model.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper mapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public Post createPost(PostDto postDto, ArtWork artWork) {
        Post post = mapper.map(postDto, Post.class);
        post.setArtWork(artWork);

        return postRepository.save(post);
    }
}
