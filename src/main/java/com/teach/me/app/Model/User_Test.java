package com.teach.me.app.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_test")
public class User_Test implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userTestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
}
