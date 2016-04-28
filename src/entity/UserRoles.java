package entity;

/**
 * Created by Michael on 3/14/2016.
 */
public class UserRoles {

    String userName;
    String roleName;

    public UserRoles() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
