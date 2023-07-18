package com.example.youtube.Service.video;

import com.example.youtube.Service.video.respone.VideoListRespone;
import com.example.youtube.repository.VideoRepository;
import com.example.youtube.utils.AppUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }
//    public Page<VideoListRespone> showVideo(String search, Pageable pageable){
//        search  = "%" + search + "%";
//        return videoRepository.findByTitleContainingOrUser_Username(search,search,pageable)
//                .map(video -> {
//                    var response = AppUtils.mapper.map(video, VideoListRespone.class);
//                    response.ser(product.getCategory().getName());
//                    return response;
//                });
//    }
}
