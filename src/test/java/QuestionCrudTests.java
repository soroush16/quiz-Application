import model.Answer;
import model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;
import repository.QuestionRepository;
import repository.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class QuestionCrudTests {
    private static SessionFactory sessionFactory;
    private  Session session;
    private Transaction transaction;

    @BeforeAll
    static void setupSessionFactory() throws Exception{
        sessionFactory = SessionManager.getFactory();
    }

    @AfterAll
    static void closeSessionFactory () throws Exception {
        sessionFactory.close();
    }

    @BeforeEach
      void setupSession () throws Exception{
        session = sessionFactory.openSession();
    }

    @AfterEach
     void closeSession() throws Exception{
        session.close();
    }

    @Test
    void testCreateQuestion(){
        transaction =session.beginTransaction();
        Question question = new Question();
        question.setDescription("are you ok?");
        List<Answer> answerList = new ArrayList<>();
        Answer answer = new Answer();
        answer.setDescription("so so");
        answerList.add(answer);
        question.setAnswer(answerList);
        session.persist(answer);
        Long questionSuccesfulyAdded = (Long) session.save(question);
        transaction.commit();
        Assertions.assertTrue(questionSuccesfulyAdded>0);
    }

    @Test
    void testUpdateQuestion(){
        transaction = session.beginTransaction();
        Question question = session.find(Question.class,1l);
        question.setDescription("is it winter now?");
        session.merge(question);
        transaction.commit();
        Question newQuestion = session.find(Question.class,1l);
        Assertions.assertEquals(newQuestion.getDescription(),question.getDescription());

    }

    @Test
    void testQuestionList(){
        transaction = session.beginTransaction();
        List<Question> allQuestionFromDB =  session.createQuery("FROM Question ",Question.class).getResultList();
        transaction.commit();

        Assertions.assertFalse(allQuestionFromDB.isEmpty());
    }

    @Test void testDeleteQuestion (){
        transaction = session.beginTransaction();
        Question question = session.find(Question.class,1l);
        session.remove(question);
        transaction.commit();
        Question deletedQuestion = session.find(Question.class,1l);
        Assertions.assertNull(deletedQuestion);
    }



}
