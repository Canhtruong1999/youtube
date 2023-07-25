<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630

package com.example.youtube.model;

import com.example.youtube.enums.TypeVideo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Enumerated(EnumType.STRING)
    private TypeVideo typeVideo;
    private LocalDateTime dateSubmit;
    private String video;
    private String img;
    private String Description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "video",cascade =CascadeType.ALL)
    @JsonIgnore
    private List<TagDetail> tagDetails;
    private String imageUrl;
    private String videoUrl;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
    private int viewCount;
    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}

<<<<<<< HEAD
=======
=======

package com.example.youtube.model;

import com.example.youtube.enums.TypeVideo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Enumerated(EnumType.STRING)
    private TypeVideo typeVideo;
    private LocalDateTime dateSubmit;
    private String video;
    private String img;
    private String Description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "video",cascade =CascadeType.ALL)
    @JsonIgnore
    private List<TagDetail> tagDetails;
    @OneToMany(mappedBy = "video",cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;

}

>>>>>>> a0ec43957822d9d53a48f41f02e2920eba66559e
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
