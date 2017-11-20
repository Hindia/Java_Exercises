/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author e1500943
 */
public class QuizCollection {

    private final ArrayList<Quiz> questions = new ArrayList<>();
    private int x, max;

    public void readQuestions() {
        
    ClassLoader cl = this.getClass().getClassLoader();
    URL url = cl.getResource("JavaTest/quiz.txt");
    try (InputStream in = url.openStream();
        BufferedReader input = new BufferedReader(new InputStreamReader(in))){
        String line;
            while ((line = input.readLine()) != null) {
                for (int i = 0; i < 4; i++) {
                    line = line + "\n" + input.readLine();
                }
                String answer = input.readLine();
                questions.add(new Quiz(line, answer));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void setMax(int max) {
        this.max = max;
    }

    public ArrayList<Quiz> getQuestions() {
        return questions;
    }

    public int getX() {
        return x;
    }

    public String RandQuestion() {
        Random r = new Random();
        x = r.nextInt((this.max - 0) + 1) + 0;
        return questions.get(x).getQuestion();
    }

}
