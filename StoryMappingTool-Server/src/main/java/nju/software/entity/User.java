package nju.software.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Time       : 2019/1/8 7:30 PM
 * Author     : tangdaye
 * Description: 用户实体类
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name = "verification_code")
    private String verificationCode;

    public User() {
    }

    public User(String email, String username, String passwd, Date createAt, Date lastLogin, String verificationCode) {
        this.email = email;
        this.username = username;
        this.passwd = passwd;
        this.createAt = createAt;
        this.lastLogin = lastLogin;
        this.verificationCode = verificationCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", createAt=" + createAt +
                ", lastLogin=" + lastLogin +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}
