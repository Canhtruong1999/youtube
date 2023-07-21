package com.example.youtube.Service.video;

<<<<<<< HEAD
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
=======
import com.example.youtube.Service.video.request.VideoSaveRequuest;
import com.example.youtube.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    List<Video> getAllVideos();

    Video createVideo(VideoSaveRequuest videoSaveRequuest, MultipartFile imageFile, MultipartFile videoFile) throws IOException;
}
>>>>>>> 7c667d3c67148b43737870b10785f127b30e4442
