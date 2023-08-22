package com.ld.digitallibrary.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "group_list")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<Group> groupList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Item> itemList;
}
