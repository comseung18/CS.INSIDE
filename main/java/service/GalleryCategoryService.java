package service;

import domain.GalleryCategory;

import java.util.List;

public interface GalleryCategoryService {
    boolean createGalleryCategory(GalleryCategory galleryCategory);
    List<GalleryCategory> getAllGalleryCategories();
    GalleryCategory getGalleryCategoryByName(String name);
}
