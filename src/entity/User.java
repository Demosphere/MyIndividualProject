package entity;

/**
 * Created by Michael on 3/14/2016.
 */
public class User {
    String userName;
    String userPass;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }

}
