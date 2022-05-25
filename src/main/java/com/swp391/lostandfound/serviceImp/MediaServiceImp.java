package com.swp391.lostandfound.serviceImp;

import java.util.List;

import com.swp391.lostandfound.entity.Media;
import com.swp391.lostandfound.repository.MediaRepository;
import com.swp391.lostandfound.service.MediaService;

import org.springframework.stereotype.Service;

@Service
public class MediaServiceImp implements MediaService {

    private MediaRepository mediaRepository;

    public MediaServiceImp(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public List<Media> getAllMedias() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Media addMedia(Media media) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Media updateMedia(Media media) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Media findMediaById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteMediaById(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
