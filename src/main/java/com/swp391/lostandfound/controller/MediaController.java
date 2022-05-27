package com.swp391.lostandfound.controller;

import com.swp391.lostandfound.DTO.MediaAddDTO;
import com.swp391.lostandfound.DTO.MediaUpdateDTO;
import com.swp391.lostandfound.dataFormat.ListMedias;
import com.swp391.lostandfound.dataFormat.MediaData;
import com.swp391.lostandfound.service.MediaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MediaController {

    private MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping("/medias")
    ListMedias getAllMedias() {
        ListMedias media = new ListMedias();
        media.setData(mediaService.getAllMedias());
        if (media.getData().isEmpty()) {
            media.setMessage("List is empty");
            media.setStatus("Success");
        } else {
            media.setMessage("Get all medias enable successfully");
            media.setStatus("Success");
        }
        return media;
    }

    @GetMapping("/medias/{id}")
    MediaData findMediaById(@PathVariable int id) {
        MediaData mediaData = new MediaData();
        mediaData.setMedia(mediaService.findMediaById(id));
        if (mediaData.getMedia() != null) {
            mediaData.setMessage("Find media successfully");
            mediaData.setStatus("Success");
        } else {
            mediaData.setMessage("Media is not exist");
            mediaData.setStatus("Fail");
        }
        return mediaData;
    }

    @PostMapping("/medias")
    MediaData addMedia(MediaAddDTO mediaAddDTO) {
        MediaData media = new MediaData();
        media.setMedia(mediaService.addMedia(mediaAddDTO));
        if (media.getMedia() != null) {
            media.setMessage("Add Media successfully");
            media.setStatus("Success");
        } else {
            media.setMessage("Add Failed");
            media.setStatus("Fail");
        }
        return media;
    }

    @PutMapping("/medias/edit/{id}")
    MediaData updateMedia(@PathVariable int id, MediaUpdateDTO mediaUpdateDTO) {
        MediaData media = new MediaData();
        media.setMedia(mediaService.updateMedia(id, mediaUpdateDTO));
        if (media.getMedia() != null) {
            media.setMessage("Update Media successfully");
            media.setStatus("Success");
        } else {
            media.setMessage("Update Failed");
            media.setStatus("Fail");
        }
        return media;
    }

    @DeleteMapping("/medias/{id}")
    MediaData deleteMediaById(@PathVariable int id) {
        MediaData mediaData = new MediaData();
        if (mediaService.deleteMediaById(id)) {
            mediaData.setMessage("Delete Media successfully");
            mediaData.setStatus("Success");
        } else {
            mediaData.setMessage("Delete Failed");
            mediaData.setStatus("Fail");
        }
        return mediaData;
    }
}
