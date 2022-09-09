package model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity(name ="answers")
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private boolean isCorrect;


    public Answer (){

    }

    public Answer(Long id, String description, boolean isCorrect) {
        this.id = id;
        this.description = description;
        this.isCorrect = isCorrect;
    }

    public Answer(String description, boolean isCorrect) {
        this.description = description;
        this.isCorrect = isCorrect;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
