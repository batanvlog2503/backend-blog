package com.javaweb.project.dto.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDTO {
    private Integer id;
    private String contentComment;
    private UserDTO userDTO;
}
