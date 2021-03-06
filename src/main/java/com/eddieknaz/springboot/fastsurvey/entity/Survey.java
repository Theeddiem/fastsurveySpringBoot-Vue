package com.eddieknaz.springboot.fastsurvey.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="surveys")
public class Survey {

    @Id
    @Column(name="uuid")
    private String uuid;

    @Column(name="question")
    private String question;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id")
    @OrderBy("id ASC")
    private List<Option> options  = new ArrayList<>();;

    public Survey(String question, List<Option> options) {
        this.question = question;
        this.options = options;
    }

    public Survey(){ }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "'\n'Survey: {" +
                "id= '" + uuid + '\'' +
                ", question=' " + question + '\'' +
                ", options= " + '\n' +  options +
                '}';
    }
}


