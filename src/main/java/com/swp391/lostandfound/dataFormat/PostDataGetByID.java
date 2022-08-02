package com.swp391.lostandfound.dataFormat;

import com.swp391.lostandfound.DTO.responseDTO.GetPostByIDResponse;
import com.swp391.lostandfound.entity.Post;
import lombok.Data;
@Data
public class PostDataGetByID {
        private String message;
        private GetPostByIDResponse post;
        private String status;
}
