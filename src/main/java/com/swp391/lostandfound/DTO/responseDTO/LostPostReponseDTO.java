package com.swp391.lostandfound.DTO.responseDTO;

import com.swp391.lostandfound.entity.Item;
import com.swp391.lostandfound.entity.Post;

import lombok.Data;

@Data
public class LostPostReponseDTO {
    private Post post;
    private Item item;

    public LostPostReponseDTO(Post post, Item item) {
        this.post = post;
        this.item = item;
    }

}
