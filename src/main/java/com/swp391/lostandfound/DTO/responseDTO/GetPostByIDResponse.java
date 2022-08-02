package com.swp391.lostandfound.DTO.responseDTO;

import com.swp391.lostandfound.entity.Post;
import com.swp391.lostandfound.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetPostByIDResponse {
    private int id;
    private String name;
    private String dateCreate;
    private String location;
    private String description;
    private int status;
    private int type;
    private String chestName;
    private User userReturn;

    public GetPostByIDResponse(Post post){
        this.id = post.getId();
        this.name = post.getName();
        this.dateCreate = post.getDateCreate();
        this.location = post.getLocation();
        this.description = post.getDescription();
        this.status = post.getStatus();
        this.type = post.getType();
        this.userReturn = post.getUserReturn();
    }
}
