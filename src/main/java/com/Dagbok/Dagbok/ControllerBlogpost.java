package com.Dagbok.Dagbok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerBlogpost {

    @Autowired
    RepositoryBlogpost repositoryBlogpost;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("posts", repositoryBlogpost.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute Blogpost blogpost) {
        // lägg till logik för hidden innan den lägger till-
        repositoryBlogpost.save(blogpost);
        return "redirect:/";
    }

    @GetMapping("/blogg/{id}")
    public String getBlogpost(@PathVariable Integer id, Model model) {
        Blogpost blogpost = new Blogpost();
        blogpost = repositoryBlogpost.findById(id).orElse(null);
        model.addAttribute("blogpost", blogpost);
        return "post";
    }

    @GetMapping("/delete/{id}")
    public String postMethodName(@PathVariable Integer id) {
        repositoryBlogpost.deleteById(id);
        return "redirect:/";
    }

}
