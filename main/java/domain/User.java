package domain;

public class User {
    private int num;
    private String id;
    private String passwd;
    private String nickname;
    private String email;
    private Boolean fixedName;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFixedName() {
        return fixedName;
    }

    public void setFixedName(Boolean fixedName) {
        this.fixedName = fixedName;
    }

    public boolean IsValidNewUser()
    {
        // 아이디나 비밀번호, 닉네임의 조건에 따라서 추가될 수 있음.
        return true;
    }
}