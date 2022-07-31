package com.swp391.lostandfound.DTO.responseDTO;

import java.util.List;

import com.swp391.lostandfound.DTO.ItemAddDTO;
import com.swp391.lostandfound.DTO.PostAddDTO;

import lombok.Data;

@Data
public class LostPostCreateDTO {

    private PostAddDTO postAddDto;
    private List<ItemAddDTO> itemAddDto;

    public LostPostCreateDTO(PostAddDTO postAddDto, List<ItemAddDTO> itemAddDto) {
        this.postAddDto = postAddDto;
        this.itemAddDto = itemAddDto;
    }

}
