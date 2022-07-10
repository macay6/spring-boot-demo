package macay.springbootmybatis.model;

/**
 * @ClassName: User
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/4 9:57 上午
 */
public class User {

    private Long id;

    private String name;

    private  String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
