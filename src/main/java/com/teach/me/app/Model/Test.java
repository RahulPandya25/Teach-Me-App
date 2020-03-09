package com.teach.me.app.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "test")
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testId;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    private String cheat_sheet;

    @NotNull
    private long totalTime;
    @NotNull
    private long numberOfQuest;
    private String reference;

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCheat_sheet() {
        return cheat_sheet;
    }

    public void setCheat_sheet(String cheat_sheet) {
        this.cheat_sheet = cheat_sheet;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public long getNumberOfQuest() {
        return numberOfQuest;
    }

    public void setNumberOfQuest(long numberOfQuest) {
        this.numberOfQuest = numberOfQuest;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", user=" + user +
                ", cheat_sheet='" + cheat_sheet + '\'' +
                ", totalTime=" + totalTime +
                ", numberOfQuest=" + numberOfQuest +
                ", reference='" + reference + '\'' +
                '}';
    }
}
