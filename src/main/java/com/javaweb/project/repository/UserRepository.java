package com.javaweb.project.repository;

import com.javaweb.project.entity.Post;
import com.javaweb.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username = :username")
    User findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);

    public List<Post> findPostByUsername(String username);
}
