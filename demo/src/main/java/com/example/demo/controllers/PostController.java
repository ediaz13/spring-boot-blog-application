package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        // Find the post by Id
        Optional<Post> optionalPost = postService.getOptionalPost(id);

        //if the post exist, then shove it in the ui Model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        } else {
            return "404";
        }
    }
}
