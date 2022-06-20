package repository;

import domain.GalleryCategory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GalleryCategoryMapper {

    List<GalleryCategory> getAllGalleryCategories();
    int insertGalleryCategory(GalleryCategory newGalleryCategory) throws DuplicateKeyException;

    GalleryCategory getGalleryCategoryByName(String name);


}
