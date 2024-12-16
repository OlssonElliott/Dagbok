package com.Dagbok.Dagbok;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerBlogpost {

    @Autowired
    RepositoryBlogpost repositoryBlogpost;

    @GetMapping("/")
    public String getIndex() {
        System.out.println(repositoryBlogpost.findAll());

        return "index";
    }

    @GetMapping("/add")
    public String addPost() {

        // Blogpost blogpost = new Blogpost();
        // blogpost.setDate(LocalDate.now());
        // blogpost.setIsHiddenInFuture(0);
        // blogpost.setRubrik("TestRubrik");
        // blogpost.setText("lorem ipsum deluxe times tusen");
        // repositoryBlogpost.save(blogpost);

        return "redirect:/";
    }
}
