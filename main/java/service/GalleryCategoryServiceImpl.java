package service;

import domain.GalleryCategory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import repository.GalleryCategoryMapper;

import java.util.List;

@Service
public class GalleryCategoryServiceImpl implements GalleryCategoryService {

    GalleryCategoryMapper galleryCategoryMapper;
    public GalleryCategoryServiceImpl(GalleryCategoryMapper galleryCategoryMapper)
    {
        this.galleryCategoryMapper = galleryCategoryMapper;
    }

    @Override
    public boolean createGalleryCategory(GalleryCategory galleryCategory) {
        try
        {
            galleryCategoryMapper.insertGalleryCategory(galleryCategory);
        }
        // 카테고리 이름이 중복되어 삽입에 실패한 경우
        catch (DuplicateKeyException e)
        {
            return false;
        }
        return true;
    }

    @Override
    public List<GalleryCategory> getAllGalleryCategories() {
        return galleryCategoryMapper.getAllGalleryCategories();
    }

    @Override
    public GalleryCategory getGalleryCategoryByName(String name) {
        return galleryCategoryMapper.getGalleryCategoryByName(name);
    }
}
