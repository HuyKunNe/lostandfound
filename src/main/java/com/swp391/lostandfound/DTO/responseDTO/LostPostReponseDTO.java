package com.swp391.lostandfound.DTO.responseDTO;

import java.util.List;

import com.swp391.lostandfound.entity.Item;
import com.swp391.lostandfound.entity.Post;

import lombok.Data;

@Data
public class LostPostReponseDTO {
    private Post post;
    private List<Item> listItem;

    public LostPostReponseDTO(Post post, List<Item> item) {
        this.post = post;
        this.listItem = item;
    }

    public LostPostReponseDTO() {
    }

}
