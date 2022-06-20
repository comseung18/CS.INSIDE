package domain;

import java.sql.Timestamp;
import java.util.Date;

public class Post {
    int num;
    String type;
    String title;
    String content;
    String writerName; // 게시글을 작성한 회원의 닉네임.
    String passwd; // 글에 걸린 암호화된 암호, 비회원의 게시글을 수정, 삭제할려면 암호를 쳐야한다. 회원의 게시글이면 null 이 됨.
    Timestamp date; // 글이 작성된 날짜
    Timestamp updateDate; // 수정된 날짜
    int views; // 조회수
    boolean deleted; // 삭제된 게시글인지 여부
    int galleryNum; // 게시글이 어떤 갤러리에 속하는지.
    Integer userNum; // 글을 작성한 회원의 번호, 비회원이 작성한 경우 null 이 될 수 있다.

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getGalleryNum() {
        return galleryNum;
    }

    public void setGalleryNum(int galleryNum) {
        this.galleryNum = galleryNum;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }
}
