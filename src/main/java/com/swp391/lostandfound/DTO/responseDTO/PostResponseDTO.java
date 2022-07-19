package com.swp391.lostandfound.DTO.responseDTO;

import com.swp391.lostandfound.entity.Media;
import com.swp391.lostandfound.entity.Post;

import lombok.Data;

@Data
public class PostResponseDTO {
    private Post post;
    private Media media;

    public PostResponseDTO(Post post, Media media) {
        this.post = post;
        this.media = media;
    }

}
