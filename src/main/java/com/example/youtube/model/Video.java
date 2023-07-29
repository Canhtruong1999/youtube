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
    private String imageUrl;
    private String vid1eoUrl;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setVid1eoUrl(String vid1eoUrl) {
        this.vid1eoUrl = vid1eoUrl;
    }

    public String getVid1eoUrl() {
        return vid1eoUrl;
    }
}
