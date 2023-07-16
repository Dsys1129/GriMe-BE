package com.sparta.grimebe.postlike.controller;

import com.sparta.grimebe.postlike.dto.PostLikeRequestDTO;
import com.sparta.grimebe.postlike.service.PostLikeService;
import com.sparta.grimebe.User.security.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostLikeController {

    private final PostLikeService postLikeService;

    @Autowired
    public PostLikeController(PostLikeService postLikeService){
        this.postLikeService = postLikeService;
    }

    // 게시글 좋아요 메서드
    @PostMapping("/post/like")
    public ResponseEntity<Void> likePost(@RequestBody PostLikeRequestDTO postLikeRequestDTO, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postLikeService.likePost(postLikeRequestDTO.getPostId(), userDetails);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
