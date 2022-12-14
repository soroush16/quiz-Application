package model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name ="Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name ="topic")
    private Topic topic;
    private int difficulty;
    @OneToMany
    @JoinColumn(name = "Question_id")
    private List<Answer> answer;

    public Question (){

    }

    public Question(Long id, String description, Topic topic, List<Answer> answer) {
        this.questionId = id;
        this.description = description;
        this.topic = topic;
        this.answer = answer;
    }

    public Question(String description, Topic topic,int difficulty, List<Answer> answer) {
        this.description = description;
        this.topic = topic;
        this.difficulty = difficulty;
        this.answer = answer;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getDescription() {
        return description;
    }

    public Topic getTopic() {
        return topic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return  questionId +
                  description +" ?"+ '\'' +
                ", topic= " + topic +
                ", difficulty: "+difficulty+ " /5"+
                ", answer=" + answer
                ;
    }
}
