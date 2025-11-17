package com.javaweb.project.controller;

import com.javaweb.project.dto.request.CreatePostRequest;
import com.javaweb.project.dto.response.PostDTO;
import com.javaweb.project.dto.request.UpdatePostRequest;
import com.javaweb.project.dto.response.PostDetailDTO;
import com.javaweb.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://mysql-oop.vercel.app",
        "https://mysql-oop-git-main-batanvlog2503s-projects.vercel.app"
})
public class PostController {

    // them sua xoa , myblog can dang nhap
    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts")
    public ResponseEntity<List<PostDTO>> getAllBlogPosts() {
        List<PostDTO> blogs = postService.findAllBlogs();
        return new ResponseEntity<>(blogs, org.springframework.http.HttpStatus.OK);
    }

    //
    @GetMapping(value = "/post/{id}")
    public ResponseEntity<PostDTO> getBlogPostById(@PathVariable("id") Integer id) {
        PostDTO blog = postService.findBlogById(id);
        return new ResponseEntity<>(blog, org.springframework.http.HttpStatus.OK);
    }

    @GetMapping(value = "/posts/search")
    public ResponseEntity<List<PostDTO>> findBlosPostByTitle(@RequestParam("title") String title) {
        List<PostDTO> blogs = postService.findPostsByTitle(title);
        return new ResponseEntity<>(blogs, org.springframework.http.HttpStatus.OK);
    }


//    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value="/post/create")
    public  ResponseEntity<String> createBlogPost(@RequestBody CreatePostRequest request) {
        postService.createNewBlogPost(request);
        return new ResponseEntity<>("POST IS CREATED SUCCESSFULLY", org.springframework.http.HttpStatus.CREATED);
    }

    @PutMapping(value="/post/update/{id}")
    public ResponseEntity<String> updateBlogPost(@PathVariable("id") Integer id, @RequestBody UpdatePostRequest request) {
        postService.updateBlogPost(id, request);
        return new ResponseEntity<>("POST IS UPDATED SUCCESSFULLY", org.springframework.http.HttpStatus.OK);
    }

    @DeleteMapping(value="/post/delete/{id}")
    public ResponseEntity<String> deleteBlogPost(@PathVariable("id") Integer id) {
        postService.deleteBlogPostById(id);
        return new ResponseEntity<>("POST IS DELETED SUCCESSFULLY", org.springframework.http.HttpStatus.OK);
    }

    @GetMapping(value= "/post/detail/{id}")
    public ResponseEntity<?> getASinglePostDetail(@PathVariable("id") Integer id) {
        try {
            PostDetailDTO postDetailDTO = postService.getAPostDetail(id);
            if (postDetailDTO == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
            }
            return ResponseEntity.ok(postDetailDTO);
        } catch (Exception e) {
            e.printStackTrace(); // Log lỗi chi tiết
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }


    @GetMapping(value = "/post/myblog")
    public ResponseEntity<Object> getMyBlog() {
        List<PostDTO> postDTOs = postService.getAllMyBlog();
        if(postDTOs.isEmpty()) {
            return ResponseEntity.ok("USER DONT HAVE ANY POST");
        } else {
            return ResponseEntity.ok(postDTOs);
        }
    }

}
