package nju.software.controller.response;

/**
 * Time       : 2019/1/9 8:04 PM
 * Author     : tangdaye
 * Description: /ui/login response
 */
public class LoginResponse {
    private String status;
    private int id;
    private String username;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
