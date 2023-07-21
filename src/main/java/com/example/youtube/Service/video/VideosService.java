<<<<<<< HEAD
=======
<<<<<<< HEAD
package com.example.youtube.Service.video;

import com.example.youtube.Service.video.request.VideoSaveRequuest;
import com.example.youtube.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideosService {



        List<Video> getAllVideos();

        Video createVideo(VideoSaveRequuest videoSaveRequuest, MultipartFile imageFile, MultipartFile videoFile) throws IOException;
    }


=======
>>>>>>> cdb2ab4e4228a49b611376911b7bf119020a858e
package com.example.youtube.Service.video;

import com.example.youtube.Service.video.request.VideoSaveRequuest;
import com.example.youtube.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideosService {



        List<Video> getAllVideos();

        Video createVideo(VideoSaveRequuest videoSaveRequuest, MultipartFile imageFile, MultipartFile videoFile) throws IOException;
    }


<<<<<<< HEAD
=======
>>>>>>> b6e282c763f373846fdb22f3c89214c34615ec78
>>>>>>> cdb2ab4e4228a49b611376911b7bf119020a858e
