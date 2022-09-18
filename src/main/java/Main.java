import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.QuestionRepository;
import repository.QuizRepository;
import repository.SessionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Session session = SessionManager.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        QuestionRepository questionRepository = new QuestionRepository();
        QuizRepository quizRepository = new QuizRepository();

        try{

        //questionRepository.createQuestions(session,transaction,2);
            System.out.println("your score is " + quizRepository.makeNewQuiz(session,transaction));

        //questionRepository.deleteQuestion(session,transaction,1l);
        //questionRepository.findQuestion(session,transaction,1l);

    }catch(Exception exception){
            System.out.println(exception.getClass() +" : "+exception.getMessage());
        }

        }

}
