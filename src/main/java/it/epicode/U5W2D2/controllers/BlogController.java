package it.epicode.U5W2D2.controllers;

import it.epicode.U5W2D2.entities.Blog;
import it.epicode.U5W2D2.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogsService;

    @GetMapping("")
    public List<Blog> getBlogs() {
        return blogsService.getUsers();
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable int id) {
        return blogsService.findById(id);
    }

    @PostMapping("")
    public Blog saveNewBook(@RequestBody Blog body) {
        return blogsService.save(body);
    }

    @PutMapping("/{id}")
    public Blog findByIdAndUpdate(@PathVariable int id, @RequestBody Blog body) {
        return blogsService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    public void findByIdAndDelete(@PathVariable int id) {
        blogsService.findByIdAndDelete(id);
    }
}
