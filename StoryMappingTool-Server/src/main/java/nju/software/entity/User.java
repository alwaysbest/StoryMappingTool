package nju.software.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Time       : 2019/1/8 7:30 PM
 * Author     : tangdaye
 * Description: 用户实体类
 */
@Data
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

}
