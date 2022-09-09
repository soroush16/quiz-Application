package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizFunctions {

    public List<Question> addSomeQuestions(int number){
        List<Question> questionList = new ArrayList<>();
        for(int i =0; i<number; i++){
            Scanner scanner = new Scanner(System.in);
            Question question = new Question();
            System.out.println("write your question description");
            String description = scanner.nextLine();
            question.setDescription(description);
            System.out.println( "insert the number for each topic \n" +
                    "1.history \n" +
                    "2.mathematics \n" +
                    "3.geography");
            int topicChoice = Integer.parseInt(scanner.nextLine());
            if(topicChoice==1){
                question.setTopic(Topic.HISTORY);
            }else if(topicChoice==2){
                question.setTopic(Topic.MATHEMATICS);
            }else {
                question.setTopic(Topic.GEOGRAPHY);
            }
            questionList.add(question);

            /*
            System.out.println("please declare number of answers for this question");
            int numberOfAnswers= scanner.nextInt();
            List<Answer> answerList = new ArrayList<>();
                answerList.add(QuizFunctions.makeAnswer(numberOfAnswers));
                question.setAnswer(answerList);
                questionList.add(question);

             */



        }
        return questionList;
    }

    public Answer makeAnswer (int number) {
        Scanner scanner = new Scanner(System.in);
        Answer answer = null;
        for (int b = 0; b < number; b++) {
            String userAnswer = scanner.nextLine();
            answer = new Answer();
            answer.setDescription(userAnswer);
        }
        return answer;
    }
}
