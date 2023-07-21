package com.example.youtube.Service.video;

import com.example.youtube.Service.video.respone.VideoListRespone;
import com.example.youtube.model.Video;
import com.example.youtube.repository.VideoRepository;
import com.example.youtube.utils.AppUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video findById(int id){
        return videoRepository.findById(id);
    }
}
