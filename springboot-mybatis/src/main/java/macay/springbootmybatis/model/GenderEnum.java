package macay.springbootmybatis.model;

/**
 * @ClassName: GenderEnum
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/4 10:48 上午
 */
public enum GenderEnum {
    MALE("1", "男"),
    FEMALE("2", "女");



    private String code;

    private String type;

    GenderEnum(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String getName(String index) {
        for (GenderEnum gender : GenderEnum.values()) {
            if (gender.code.equals(index)) {
                return gender.type;
            }
        }
        return null;
    }
}
