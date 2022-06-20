package controller;

import domain.Gallery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.GalleryService;

import java.util.List;

@RestController
public class GalleryRestController {

    GalleryService galleryService;
    public GalleryRestController(GalleryService galleryService)
    {
        this.galleryService = galleryService;
    }

    @GetMapping("/galleries")
    public List<Gallery> allUsers()
    {
        return galleryService.getAllGalleries();
    }

    @PostMapping("/gallery")
    public boolean createGallery(@RequestBody Gallery newGallery)
    {
        return galleryService.createGallery(newGallery);
    }
}
