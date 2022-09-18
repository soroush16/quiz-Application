package repository;

import model.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.List;

public class QuizRepository {

    public int makeNewQuiz (Session session, Transaction transaction){
        System.out.println("welcome to this quiz ,please enter your answer to each question, every right answer will give you one point");
        List<Question> questions = session.createQuery("FROM Question ",Question.class).list();
        int score= 0;
        for(Question q: questions){
            System.out.println(q.getDescription()+ "  " +q.getAnswer().size() +" answers are required for this question");
            int correctAnswers = 0;
            for(int i=0;i<q.getAnswer().size(); i++){
                String userAnswer = this.getUserInput("write your answer");

                for(int b=0;b< q.getAnswer().size(); b++){
                    if(userAnswer.equalsIgnoreCase(q.getAnswer().get(b).getDescription())){
                        correctAnswers++;
                    }
                }

                }
            if(correctAnswers==q.getAnswer().size()){
                score++;

            }

        }
        session.close();
        return score;
    }

    private String getUserInput(String message){
        return JOptionPane.showInputDialog(message);
    }

}
