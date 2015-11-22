
public class User {
    public enum PHONE_OPERATOR{Play,Tmobile,Plus,Heyah,Other,BAD_OPERATOR}
    private Long id;
    private String name;
    private PHONE_OPERATOR operator;
    private String number;

    public User(Long id, String name, PHONE_OPERATOR operator, String number) {
        this.id = id;
        this.name = name;
        this.number=number;
        this.operator=operator;
    }
    public String returnData(){
        String temp = this.id + "," + this.name + "," + this.operator + "," + this.number;
        return temp;
    }
    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}