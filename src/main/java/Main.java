import model.Answer;
import model.Question;
import model.QuizFunctions;
import model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        QuizFunctions quizFunctions = new QuizFunctions();
        List<Question> questions = quizFunctions.addSomeQuestions(1);
        for(Question q : questions){
            System.out.println(q.getDescription());
            Scanner scanner = new Scanner(System.in);
            System.out.println("how many answers you want to add");
            int userChoice = Integer.parseInt(scanner.nextLine());
            List<Answer> answerList = new ArrayList<>();
                for(int i=0;i<userChoice;i++){

                    Answer answer = new Answer();
                    System.out.println("please enter your answer");
                    String answerDescription = scanner.nextLine();
                    answer.setDescription(answerDescription);
                    answerList.add(answer);
                    session.persist(answer);

                }
                q.setAnswer(answerList);
                session.persist(q);


        }

        transaction.commit();

    }
}
