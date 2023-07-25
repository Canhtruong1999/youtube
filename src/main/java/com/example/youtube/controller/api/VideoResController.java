
package com.example.youtube.controller.api;

import com.example.youtube.Service.AuthService;
import com.example.youtube.Service.video.VideoService;
import com.example.youtube.Service.video.request.VideoSaveRequest;
import com.example.youtube.enums.TypeVideo;
import com.example.youtube.model.Tag;
import com.example.youtube.model.TagDetail;
import com.example.youtube.model.User;
import com.example.youtube.model.Video;
import com.example.youtube.repository.TagRepository;
import com.example.youtube.repository.UserRepository;
import com.example.youtube.repository.VideoRepository;
import com.example.youtube.Service.TagDetailService;
import com.example.youtube.Service.TagService;

import com.example.youtube.Service.tagDetail.request.TagDetailSaveRequest;
import com.example.youtube.utils.AppUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/videos")
public class VideoResController {
    private final TagRepository tagRepository;
    private VideoService videoService;

    private TagDetailService tagDetailService;

    private TagService tagService;


    private UserRepository userRepository;
    private final VideoRepository videoRepository;
    public final AuthService authService;

    public VideoResController(TagRepository tagRepository, VideoService videoService, TagDetailService tagDetailService, TagService tagService, UserRepository userRepository, VideoRepository videoRepository, AuthService authService) {
        this.tagRepository = tagRepository;
        this.videoService = videoService;
        this.tagDetailService = tagDetailService;
        this.tagService = tagService;
        this.userRepository = userRepository;
        this.videoRepository = videoRepository;
        this.authService = authService;
    }

 
    @GetMapping
    public List<Video> showSearch() {
        List<Video> videos = new ArrayList<>();
        try {
            User user = authService.findByName(authService.getCurrentUser());
            List<Object[]> a = videoRepository.findTopTwoTagsByUserId(user.getId());
            List<Integer> b = videoRepository.findVideoIdsByTagTitle((String) a.get(0)[0], (String) a.get(1)[0]);
            for (var item : b) {
                videos.add(videoRepository.findById(item.intValue()));
            }
            return videos;
        } catch (Exception e) {
            return videoRepository.findAll();
        }
    }
    @GetMapping("/create")
    public ResponseEntity<?> showCreate(){
        List<Tag> tagList = tagService.findAll();
        return ResponseEntity.ok(tagList);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(Authentication authentication,
                                    @RequestBody VideoSaveRequest videoSaveRequest){
        String name = authentication.getName();
        User user = userRepository.findByUsernameIgnoreCaseOrEmailIgnoreCaseOrPhone(name,name,name).get();
        Video video = AppUtils.mapper.map(videoSaveRequest, Video.class);
        video.setUser(user);
        videoSaveRequest.getTagDetails();
        List<TagDetail> tags = new ArrayList<>();
        for (TagDetailSaveRequest tagReq : videoSaveRequest.getTagDetails()) {
            TagDetail tagDetail = new TagDetail();
            Tag tag = tagService.findById(Integer.parseInt(tagReq.getTag()));
            tagDetail.setTag(tag);
            tagDetail.setVideo(video);
            tags.add(tagDetail);
        }
        video.setTagDetails(tags);
        video.setTypeVideo(TypeVideo.VIDEO);
        video.setDateSubmit(LocalDateTime.now());
//        TagDetail tagDetailCreate = tagDetailService.create(tagDetail);
//        tagDetailCreate.getId();
      videoService.create(video);

        return ResponseEntity.ok("Create ok");
    }

    @GetMapping("/edit")
    public ResponseEntity<?> showEdit(@RequestParam int id){
        Video video = videoService.findById(id);
        List<Tag> tagList = tagService.findAll();
        Map<Object, String> map = new HashMap<>();
        map.put(video,"video");
        map.put(tagList,"tag");
        return ResponseEntity.ok(map);
    }
    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody Video video){
        videoService.update(video);
        return ResponseEntity.ok("edit");
    }
    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        videoService.delete(id);
        return ResponseEntity.ok("delete");
    }

    @GetMapping("/findtitle")
    public ResponseEntity<?> findByTitleOrUsername(@RequestParam String search){
        List<Video> videoList = videoService.findByTitleContainingOrUsername(search, search);
        return ResponseEntity.ok(videoList);
    }
    @GetMapping("/tag/{id}")

//    public ResponseEntity<?> getTagById(@PathVariable int id){

    public ResponseEntity<?> showTags(@PathVariable int id){

//        Tag tag = tagService.findById(id);
        List<Video> videos = videoService.findVideosByTagId(id);

        return ResponseEntity.ok(videos);
    }

    @GetMapping("/tags")
    public ResponseEntity<?> getTags(){
        List<Tag> tagList = tagService.findAll();

        return ResponseEntity.ok(tagList);}

    @GetMapping("getVideoLiked")
    public ResponseEntity<?> getVideoLiked(){
        User user=  authService.findByName(authService.getCurrentUser());
        if(user!=null){
            List<Video> videos= videoService.findVideoUserLiked(user.getId());
            return ResponseEntity.ok(videos);
        }
        return null;

    }
}
