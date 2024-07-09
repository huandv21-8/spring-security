package com.huandv.SpringSecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * @Description:
 * @Project: SpringSecurity
 * @Date: 6/25/2024 2:00 PM
 * @Author: crist
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "user_id")
    private int userId;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private String role;

    @Column(name = "create_dt")
    private String createDt;

    @JsonIgnore // sẽ bỏ thuộc tính authorities này trong quá trình chuyển đổi giữa đối tượng Java và JSON
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Authorities> authorities;
}
