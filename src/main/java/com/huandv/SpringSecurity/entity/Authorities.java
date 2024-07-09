package com.huandv.SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Project: SpringSecurity
 * @Date: 6/25/2024 2:06 PM
 * @Author: crist
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name = "id")
    private int authoritiesId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String name;

}
