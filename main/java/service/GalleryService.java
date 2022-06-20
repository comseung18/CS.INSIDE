package service;


import domain.Gallery;

import java.util.List;

public interface GalleryService {
    boolean createGallery(Gallery newGallery);
    List<Gallery> getAllGalleries();
}
