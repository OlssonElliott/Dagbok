package com.Dagbok.Dagbok;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerBlogpost {

    @Autowired
    RepositoryBlogpost repositoryBlogpost;

    @GetMapping("/") // gå till main page
    public String getIndex(Model model) {
        model.addAttribute("posts", repositoryBlogpost.notFutureDate(LocalDate.now()));
        return "index";
    }

    @PostMapping("/add") // lägg till post
    public String addPost(@ModelAttribute Blogpost blogpost) {
        if (blogpost.getDate() == null) {
            blogpost.setDate(LocalDate.now());
        }
        if (blogpost.getRubrik() != "" && blogpost.getText() != "") {
            System.out.println(blogpost.getText());
            repositoryBlogpost.save(blogpost);
        }
        return "redirect:/";
    }

    @GetMapping("/blogg/{id}") // visa post
    public String getPost(@PathVariable Integer id, Model model) {
        Blogpost blogpost = new Blogpost();
        blogpost = repositoryBlogpost.findById(id).orElse(null);
        model.addAttribute("blogpost", blogpost);
        return "post";
    }

    @GetMapping("/delete/{id}") // ta bort bost
    public String deletePost(@PathVariable Integer id) {
        repositoryBlogpost.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}") // uppdatera post
    public String editPost(@PathVariable Integer id, @ModelAttribute Blogpost updatedBlogpost) {
        Blogpost oldPost = repositoryBlogpost.findById(id).orElse(null);
        if (oldPost != null) {
            oldPost.setRubrik(updatedBlogpost.getRubrik());
            oldPost.setText(updatedBlogpost.getText());
            oldPost.setDate(updatedBlogpost.getDate());
            repositoryBlogpost.save(oldPost);
        }
        return "redirect:/blogg/" + id;
    }

    @GetMapping("/filter") // filtrera efter datum
    public String getMethodName(Model model,
            // required = false eftersom sidan kraschar vid null.
            @RequestParam(value = "from", required = false) LocalDate from,
            @RequestParam(value = "to", required = false) LocalDate to) {
        // felhantering vid null
        if (from == null) {
            from = LocalDate.now();
        }
        if (to == null) {
            to = LocalDate.now();
        }

        model.addAttribute("posts", repositoryBlogpost.filteredDates(from, to));
        return "index";
    }
}
