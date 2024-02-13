package it.epicode.U5W2D2.services;

import it.epicode.U5W2D2.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> blogs = new ArrayList<>();

    public List<Blog> getUsers() {
        return this.blogs;
    }

    public Blog findById(int id) {
        Blog blogFound = null;
        for (Blog blog : this.blogs) {
            if (blog.getId() == id) {
                blogFound = blog;
            }
        }
        return blogFound;
    }

    public Blog save(Blog body) {
        Random random = new Random();
        body.setId(random.nextInt(1, 200));
        this.blogs.add(body);
        return body;
    }

    public Blog findByIdAndUpdate(int id, Blog body) {
        Blog found = null;
        for (Blog blog : this.blogs) {
            if (blog.getId() == id) {
                found = blog;
                found.setId(id);
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setCover(body.getCover());
                found.setContenuto(body.getContenuto());
                found.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        return found;

    }

    public void findByIdAndDelete(int id) {

        this.blogs.removeIf(current -> current.getId() == id);
    }
}
