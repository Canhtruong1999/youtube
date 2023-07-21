package com.example.youtube.controller.api;

import com.example.youtube.enums.TypeVideo;
import com.example.youtube.model.Tag;
import com.example.youtube.model.TagDetail;
import com.example.youtube.model.User;
import com.example.youtube.model.Video;
import com.example.youtube.repository.TagRepository;
import com.example.youtube.repository.UserRepository;
import com.example.youtube.service.TagDetailService;
import com.example.youtube.service.TagService;
import com.example.youtube.service.VideoService;
import com.example.youtube.service.tagDetail.request.TagDetailSaveRequest;
import com.example.youtube.service.video.request.VideoSaveRequest;
import com.example.youtube.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/videos")
public class VideoRestController {
    private final TagRepository tagRepository;
    @Autowired
    private VideoService videoService;
    @Autowired
    private TagDetailService tagDetailService;
    @Autowired
    private TagService tagService;

    @Autowired
    private UserRepository userRepository;

    public VideoRestController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @GetMapping("")
    public ResponseEntity<?> showIndex(){
        List<Video> videoList = videoService.findAll();
        return ResponseEntity.ok(videoList);
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
        video.setDateSubmit(LocalDate.now());
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

}
