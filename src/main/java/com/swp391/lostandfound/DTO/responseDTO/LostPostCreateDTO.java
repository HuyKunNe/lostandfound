package com.swp391.lostandfound.DTO.responseDTO;

import com.swp391.lostandfound.DTO.ItemAddDTO;
import com.swp391.lostandfound.DTO.PostAddDTO;

import lombok.Data;

@Data
public class LostPostCreateDTO {
    private PostAddDTO postAddDto;
    private ItemAddDTO itemAddDto;

    public LostPostCreateDTO(PostAddDTO postAddDto, ItemAddDTO itemAddDto) {
        this.postAddDto = postAddDto;
        this.itemAddDto = itemAddDto;
    }

}
