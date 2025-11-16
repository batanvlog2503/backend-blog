package com.javaweb.project.service;

import com.javaweb.project.dto.request.CommentRequestDTO;

public interface CommentService {
    public void addCommentToPost(Integer postId, CommentRequestDTO commentRequestDTO);
    public void deleteComment(Integer id);
}
