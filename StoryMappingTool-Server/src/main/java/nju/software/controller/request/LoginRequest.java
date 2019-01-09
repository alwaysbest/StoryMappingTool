package nju.software.controller.request;

/**
 * Time       : 2019/1/9 7:55 PM
 * Author     : tangdaye
 * Description: /ui/login req
 */
public class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
