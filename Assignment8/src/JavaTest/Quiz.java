/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaTest;

/**
 *
 * @author e1500943
 */
public class Quiz {

    private String question, answer;

    public Quiz(String q, String a) {
        question = q;
        answer = a;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    //Other method
    public boolean check(String a) {
        return a.equalsIgnoreCase(answer);

    }

    

}
