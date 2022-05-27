package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.DTO.MediaAddDTO;
import com.swp391.lostandfound.DTO.MediaUpdateDTO;
import com.swp391.lostandfound.entity.Media;

public interface MediaService {
    List<Media> getAllMedias();

    Media addMedia(MediaAddDTO mediaAddDTO);

    Media updateMedia(int id, MediaUpdateDTO mediaUpdateDTO);

    Media findMediaById(int id);

    boolean deleteMediaById(int id);
}
