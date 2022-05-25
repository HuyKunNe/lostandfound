package com.swp391.lostandfound.service;

import java.util.List;

import com.swp391.lostandfound.entity.Media;

public interface MediaService {
    List<Media> getAllMedias();

    Media addMedia(Media media);

    Media updateMedia(Media media);

    Media findMediaById(int id);

    boolean deleteMediaById(int id);
}
