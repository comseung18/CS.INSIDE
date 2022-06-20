package repository;

import domain.Gallery;
import domain.Post;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GalleryMapper {
    List<Gallery> getAllGalleries();
    // 특정 카테고리에 속한 갤러리들을 조회
    List<Gallery> getGalleriesByCategoryNum(int num);

    int insertGallery(Gallery newGallery) throws DuplicateKeyException;

    // 특정 갤러리에 속한 게시글들의 간략한 정보 조회
    // 간략한 정보: 제목, 작성자, 조회수, 작성일, 게시글타입
    List<Post> getSimpleInfoPostsByGalleryNum(int num);

    // 게시글작성
    int insertPost(Post newPost);
}
