package com.teach.me.app.Model;

import com.teach.me.app.Enum.UserType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String name;
    private String email;
    private String contactNumber;
    private String pwd;
    private UserType type;
}
