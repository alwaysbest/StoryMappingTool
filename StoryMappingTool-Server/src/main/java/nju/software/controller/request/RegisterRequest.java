package nju.software.controller.request;

/**
 * Time       : 2019/1/9 9:11 PM
 * Author     : tangdaye
 * Description: /ui/register request
 */
public class RegisterRequest {
    private String email;
    private String username;
    private String password;
    private String code;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
