package repository;

import model.Answer;
import model.Question;
import model.Topic;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionRepository {

// The following method takes an input for the number of questions you want to make
    public void createQuestions(Session session,Transaction transaction,int number) throws Exception{
        List<Question> questionList = new ArrayList<>();
        for(int i =0; i<number; i++) {
            Question question = new Question();
            String description = this.getUserInput("write your question description");
            question.setDescription(description);
            int topicChoice = Integer.parseInt(this.getUserInput("insert the number for each topic \n" +
                    "1.history \n" +
                    "2.mathematics \n" +
                    "3.geography"));
            if (topicChoice == 1) {
                question.setTopic(Topic.HISTORY);
            } else if (topicChoice == 2) {
                question.setTopic(Topic.MATHEMATICS);
            } else {
                question.setTopic(Topic.GEOGRAPHY);
            }
            int difficultyChoice = Integer.parseInt(this.getUserInput("please specify difficulty level for this question"));
            question.setDifficulty(difficultyChoice);
            questionList.add(question);
        }

            for(Question q : questionList){
                System.out.println(q.getDescription());
                int userChoice = Integer.parseInt(this.getUserInput("how many answers you want to add"));
                List<Answer> answerList = new ArrayList<>();
                for(int b=0;b<userChoice;b++){
                    Answer answer = this.createAnswer();
                    answerList.add(answer);
                    session.persist(answer);

                }
                q.setAnswer(answerList);
                session.persist(q);




            }
            transaction.commit();
            session.close();

        }



    public Answer createAnswer() {
        Answer answer = null;
            String userAnswer = this.getUserInput("please enter your answer");
            answer = new Answer();
            answer.setDescription(userAnswer);

        return answer;
    }

    public void updateQestion(Session session, Transaction transaction, Long questionId, String newDescription)throws Exception{
        Question question = session.load(Question.class,questionId);
        question.setDescription(newDescription);
        session.update(question);
        transaction.commit();
        session.close();


    }

    public void deleteQuestion (Session session,Transaction transaction,Long questionId) throws Exception{
        Question question = session.find(Question.class,questionId);
        session.remove(question);

        transaction.commit();
        session.close();

    }

    public void findQuestion(Session session, Transaction transaction, Long questionId) throws Exception{
        Question question = new Question();
        question= (Question) session.find(Question.class,questionId);
        System.out.println(question);
    }

    private String getUserInput (String message){
        return JOptionPane.showInputDialog(message);
    }
}

