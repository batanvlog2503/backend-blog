package com.javaweb.project.service;


import com.javaweb.project.dto.request.CreatePostRequest;
import com.javaweb.project.dto.response.PostDTO;
import com.javaweb.project.dto.request.UpdatePostRequest;
import com.javaweb.project.dto.response.PostDetailDTO;
import com.javaweb.project.entity.Post;


import java.util.List;
import java.util.Set;

public interface PostService {
    public List<PostDTO> findAllBlogs();
//    public List<PostDTO> findBlogsByTitleOrAuthorName(String title, String authorName);
    public void updateBlogPost(Integer id, UpdatePostRequest request);
    public void deleteBlogPostById(Integer id);
    public PostDTO findBlogById(Integer id);

    public PostDetailDTO getAPostDetail(Integer id);
    public void createNewBlogPost(CreatePostRequest request);
    public List<PostDTO> getAllMyBlog();
    public List<PostDTO> findPostsByTitle(String title);
}
