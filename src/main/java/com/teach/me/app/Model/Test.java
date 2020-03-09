package com.teach.me.app.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test")
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    private String cheat_sheet;
    private long totalTime;
    private long numberOfQuest;
    private String reference;


}
