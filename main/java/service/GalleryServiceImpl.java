package service;

import domain.Gallery;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import repository.GalleryMapper;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService{

    GalleryMapper galleryMapper;
    public GalleryServiceImpl(GalleryMapper galleryMapper)
    {
        this.galleryMapper = galleryMapper;
    }

    @Override
    public boolean createGallery(Gallery newGallery) {
        try
        {
            galleryMapper.insertGallery(newGallery);
        }
        // 갤러리 이름이 중복되어 삽입에 실패할 경우
        catch (DuplicateKeyException exception)
        {
            return false;
        }
        return true;
    }

    @Override
    public List<Gallery> getAllGalleries() {
        return galleryMapper.getAllGalleries();
    }
}
