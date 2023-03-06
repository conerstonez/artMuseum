package com.art.gallery.service.artWallServices.postServices;

import com.art.gallery.model.data.ArtWork;
import com.art.gallery.model.data.Post;
import com.art.gallery.model.dto.request.ArtWorkDto;
import com.art.gallery.model.dto.request.PostDto;

public interface PostService {

    Post createPost(PostDto post, ArtWork artWork);
}
