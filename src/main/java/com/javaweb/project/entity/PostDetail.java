package com.javaweb.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post_details")
public class PostDetail {

    @Id
    @Column(name = "post_id")
    private Integer id;

    @Column(name = "post_introduction", columnDefinition = "TEXT")
    private String introduction;

    @Column(name = "post_content", columnDefinition = "TEXT", nullable = false)
    private String contentDetail; // thanh Content Detail

    @Column(name = "post_end_content", columnDefinition = "TEXT", nullable = false)
    private String endContent;

    @Column(name = "post_img", columnDefinition = "TEXT" ,nullable = false)
    private String img;

    @Column(name = "post_link",columnDefinition = "TEXT", nullable = false)
    private String link;

    @OneToOne
    @MapsId // Map id voi Post
    @JoinColumn(name = "post_id")
    private Post post;
}
