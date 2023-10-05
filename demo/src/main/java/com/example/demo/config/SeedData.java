package com.example.demo.config;

import com.example.demo.models.Post;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0) {
            Post post1 = new Post();
            post1.setTitle("Nice Title Post 1");
            post1.setBody("Nice Body Post 1");

            Post post2 = new Post();
            post2.setTitle("Nice Title Post 2");
            post2.setBody("Nice Body Post 2");

            postService.save(post1);
            postService.save(post2);
        }
    }

}
