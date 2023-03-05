//James MacAloney

package com.example.groupprojectme;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.io.File;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MCquiz extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //scanner to go through exams.txt
        Scanner scan = new Scanner(new File("exams.txt"));
        scan.useDelimiter(",|\\n");

        //Linking Questions class to create question objects
        Questions[] questions = new Questions[0];

        //while loop to divide the different parts into variables using delimiters and to build Questions object to be stored
        while(scan.hasNext()){
            String question = scan.next();
            String options = scan.next();
            String answer = scan.next();
            Questions newQ = new Questions(question, options, answer);
            questions = addQuestion(questions, newQ);
        }

        GridPane grid = new GridPane();
        //----------------------LABELS/BUTTONS/RADIO-BUTTONS---------------------------------------------
        Label instructions = new Label("You should answer the following questions. Select a single answer from the four choices");

        Label stdNameLbl = new Label("Students Name: ");
        TextField stNameTxt = new TextField();
        Label qLbl = new Label("Questions");

        Label avgMarks = new Label(" ");

            //*********************QUESTIONS 1********************************
        Label q1Lbl = new Label("Q1");
        RadioButton q1A = new RadioButton("q1A");
        RadioButton q1B = new RadioButton("q1B");
        RadioButton q1C = new RadioButton("q1C");
        RadioButton q1D = new RadioButton("q1D");

        //toggle-group and vbox for q1
        ToggleGroup q1Tgl = new ToggleGroup();
        q1A.setToggleGroup(q1Tgl);
        q1B.setToggleGroup(q1Tgl);
        q1C.setToggleGroup(q1Tgl);
        q1D.setToggleGroup(q1Tgl);
        VBox q1 = new VBox();
        q1.getChildren().add(q1Lbl);
        q1.getChildren().add(q1A);
        q1.getChildren().add(q1B);
        q1.getChildren().add(q1C);
        q1.getChildren().add(q1D);
        q1.setSpacing(5);

            //*********************QUESTIONS 2********************************
        Label q2Lbl = new Label("Q2");
        RadioButton q2A = new RadioButton("q2A");
        RadioButton q2B = new RadioButton("q2B");
        RadioButton q2C = new RadioButton("q2C");
        RadioButton q2D = new RadioButton("q2D");

        //toggle-group and vbox for q2
        ToggleGroup q2Tgl = new ToggleGroup();
        q2A.setToggleGroup(q2Tgl);
        q2B.setToggleGroup(q2Tgl);
        q2C.setToggleGroup(q2Tgl);
        q2D.setToggleGroup(q2Tgl);
        VBox q2 = new VBox();
        q2.getChildren().add(q2Lbl);
        q2.getChildren().add(q2A);
        q2.getChildren().add(q2B);
        q2.getChildren().add(q2C);
        q2.getChildren().add(q2D);
        q2.setSpacing(5);

            //*********************QUESTIONS 3********************************
        Label q3Lbl = new Label("Q3");
        RadioButton q3A = new RadioButton("q3A");
        RadioButton q3B = new RadioButton("q3B");
        RadioButton q3C = new RadioButton("q3C");
        RadioButton q3D = new RadioButton("q3D");
        ToggleGroup q3Tgl = new ToggleGroup();

        //toggle-group and vbox for q3
        q3A.setToggleGroup(q3Tgl);
        q3B.setToggleGroup(q3Tgl);
        q3C.setToggleGroup(q3Tgl);
        q3D.setToggleGroup(q3Tgl);
        VBox q3 = new VBox();
        q3.getChildren().add(q3Lbl);
        q3.getChildren().add(q3A);
        q3.getChildren().add(q3B);
        q3.getChildren().add(q3C);
        q3.getChildren().add(q3D);
        q3.setSpacing(5);

            //*********************QUESTIONS 4********************************
        Label q4Lbl = new Label("Q4");
        RadioButton q4A = new RadioButton("q4A");
        RadioButton q4B = new RadioButton("q4B");
        RadioButton q4C = new RadioButton("q4C");
        RadioButton q4D = new RadioButton("q4D");

        //toggle-group and vbox for q4
        ToggleGroup q4Tgl = new ToggleGroup();
        q4A.setToggleGroup(q4Tgl);
        q4B.setToggleGroup(q4Tgl);
        q4C.setToggleGroup(q4Tgl);
        q4D.setToggleGroup(q4Tgl);
        VBox q4 = new VBox();
        q4.getChildren().add(q4Lbl);
        q4.getChildren().add(q4A);
        q4.getChildren().add(q4B);
        q4.getChildren().add(q4C);
        q4.getChildren().add(q4D);
        q4.setSpacing(5);

            //*********************QUESTIONS 5********************************
        Label q5Lbl = new Label("Q5");
        RadioButton q5A = new RadioButton("q5A");
        RadioButton q5B = new RadioButton("q5B");
        RadioButton q5C = new RadioButton("q5C");
        RadioButton q5D = new RadioButton("q5D");

        //toggle-group and vbox for q5
        ToggleGroup q5Tgl = new ToggleGroup();
        q5A.setToggleGroup(q5Tgl);
        q5B.setToggleGroup(q5Tgl);
        q5C.setToggleGroup(q5Tgl);
        q5D.setToggleGroup(q5Tgl);
        VBox q5 = new VBox();
        q5.getChildren().add(q5Lbl);
        q5.getChildren().add(q5A);
        q5.getChildren().add(q5B);
        q5.getChildren().add(q5C);
        q5.getChildren().add(q5D);
        q5.setSpacing(5);

            //*********************BUTTONS************************************
        Button submit = new Button("Submit");
        Button calGrade = new Button("Calculate Grade");
        Button showAvgMarks = new Button("Show Average Marks");
        TextField gradeTxt = new TextField("0/100");
        HBox buttons = new HBox();
        buttons.getChildren().addAll(submit, showAvgMarks, calGrade, gradeTxt);
        buttons.setSpacing(5);

        //-------------------------GRID------------------------------------------
            //Adding things to the grid and formating them
        Scene scene = new Scene(grid);
        stage.setTitle("Multiple Choice Exam");
        grid.setPadding(new Insets(30));
        grid.setVgap(15);
        grid.setHgap(15);

        grid.add(instructions, 0 ,0,3,2);

        grid.add(stdNameLbl, 0, 2);
        grid.add(stNameTxt, 1, 2);
        grid.add(qLbl, 0, 3);

        grid.add(q1, 0, 4);
        grid.add(q2, 0, 5);
        grid.add(q3, 0, 6);
        grid.add(q4, 1, 4);
        grid.add(q5, 1, 5);

        grid.add(avgMarks, 2, 4);

        grid.add(buttons, 0, 7, 3, 1);


        //-------------------------LOADING QUESTIONS WHEN THE WINDOW LOADS-----------------
        Questions[] finalQuestions = questions;

        Random random = new Random();

        //Event for when the window opens
        stage.setOnShowing(windowEvent -> {

            //variables to get question answers
            String q1Ans = "";
            String q2Ans = "";
            String q3Ans = "";
            String q4Ans = "";
            String q5Ans = "";

            //for loop to pick and display questions
            for (int i = 0; i < 5; i++) {
                //random number generator to pick random numbers from 1-20
                int randNum = random.nextInt(20);

                //if statements to print questions at q1, q2, q3, q4 and q5 when i is a certain value
                for (int j = 0; j < i; j++) {
                    q1Lbl.setText("1. " + (finalQuestions[randNum].getQuestion()));     //Prints the questions prompt
                    String allOpt = finalQuestions[randNum].getOptions();               //gets the options from Questions class
                    String[] options = allOpt.split("/");                         //Setting a delimiter to go through the options string and devide them into seperate options
                    q1A.setText(options[0]);                                            //setting first option
                    q1B.setText(options[1]);                                            //setting second option
                    q1C.setText(options[2]);                                            //setting third option
                    q1D.setText(options[3]);                                            //setting fourth option
                    q1Ans = finalQuestions[randNum].getAnswers();
                }




//                if(i == 0){
//                    q1Lbl.setText("1. " + (finalQuestions[randNum].getQuestion()));     //Prints the questions prompt
//                    String allOpt = finalQuestions[randNum].getOptions();               //gets the options from Questions class
//                    String[] options = allOpt.split("/");                         //Setting a delimiter to go through the options string and devide them into seperate options
//                    q1A.setText(options[0]);                                            //setting first option
//                    q1B.setText(options[1]);                                            //setting second option
//                    q1C.setText(options[2]);                                            //setting third option
//                    q1D.setText(options[3]);                                            //setting fourth option
//                    q1Ans = finalQuestions[randNum].getAnswers();                       //getting the answer to the question to check later
//                } else if (i == 1) {
//                    q2Lbl.setText("2. " + (finalQuestions[randNum].getQuestion()));
//                    String allOpt = finalQuestions[randNum].getOptions();
//                    String[] options = allOpt.split("/");
//                    q2A.setText(options[0]);
//                    q2B.setText(options[1]);
//                    q2C.setText(options[2]);
//                    q2D.setText(options[3]);
//                    q2Ans = finalQuestions[randNum].getAnswers();
//
//                } else if (i == 2) {
//                    q3Lbl.setText("3. " + (finalQuestions[randNum].getQuestion()));
//                    String allOpt = finalQuestions[randNum].getOptions();
//                    String[] options = allOpt.split("/");
//                    q3A.setText(options[0]);
//                    q3B.setText(options[1]);
//                    q3C.setText(options[2]);
//                    q3D.setText(options[3]);
//                    q3Ans = finalQuestions[randNum].getAnswers();
//
//                }else if (i == 3){
//                    q4Lbl.setText("4. " + (finalQuestions[randNum].getQuestion()));
//                    String allOpt = finalQuestions[randNum].getOptions();
//                    String[] options = allOpt.split("/");
//                    q4A.setText(options[0]);
//                    q4B.setText(options[1]);
//                    q4C.setText(options[2]);
//                    q4D.setText(options[3]);
//                    q4Ans = finalQuestions[randNum].getAnswers();
//
//                }else {
//                    q5Lbl.setText("5. " + (finalQuestions[randNum].getQuestion()));
//                    String allOpt = finalQuestions[randNum].getOptions();
//                    String[] options = allOpt.split("/");
//                    q5A.setText(options[0]);
//                    q5B.setText(options[1]);
//                    q5C.setText(options[2]);
//                    q5D.setText(options[3]);
//                    q5Ans = finalQuestions[randNum].getAnswers();
//
//                }


            }

            String q1Answer = q1Ans;
            String q2Answer = q2Ans;
            String q3Answer = q3Ans;
            String q4Answer = q4Ans;
            String q5Answer = q5Ans;
            AtomicInteger score = new AtomicInteger(0);         //Score automatic integer to store the store and increase or decrease depending on answers

            //Calculate grade event when pressed it calculates grade
            calGrade.setOnAction(actionEvent -> {
                score.set(0);                                                               //resets score back to zero for next user
                if(isValid(stNameTxt.getText()) && !stNameTxt.getText().isEmpty()){

                    //getting option selections
                    RadioButton q1Choice = (RadioButton) q1Tgl.getSelectedToggle();
                    RadioButton q2Choice = (RadioButton) q2Tgl.getSelectedToggle();
                    RadioButton q3Choice = (RadioButton) q3Tgl.getSelectedToggle();
                    RadioButton q4Choice = (RadioButton) q4Tgl.getSelectedToggle();
                    RadioButton q5Choice = (RadioButton) q5Tgl.getSelectedToggle();

                    //if statement to increase or decrease score is answers are right or wrong
                    if(Objects.equals(q1Answer, q1Choice.getText())){
                        score.addAndGet(20);
                    }else {
                        score.addAndGet(-5);
                    }

                    if(Objects.equals(q2Answer, q2Choice.getText())){
                        score.addAndGet(20);
                    }else {
                        score.addAndGet(-5);
                    }

                    if(Objects.equals(q3Answer, q3Choice.getText())){
                        score.addAndGet(20);
                    }else {
                        score.addAndGet(-5);
                    }

                    if(Objects.equals(q4Answer, q4Choice.getText())){
                        score.addAndGet(20);
                    }else {
                        score.addAndGet(-5);
                    }

                    if(Objects.equals(q5Answer, q5Choice.getText())){
                        score.addAndGet(20);
                    }else {
                        score.addAndGet(-5);
                    }

                    //display score
                    gradeTxt.setText(score + "/100");
                }else{
                    gradeTxt.setText("NOT VALID NAME");
                }
            });

            //submit event when clicked will write student name, options selected and score to results.txt
            submit.setOnAction(actionEvent -> {

                //getting toggle options for this event
                RadioButton q1Choice = (RadioButton) q1Tgl.getSelectedToggle();
                RadioButton q2Choice = (RadioButton) q2Tgl.getSelectedToggle();
                RadioButton q3Choice = (RadioButton) q3Tgl.getSelectedToggle();
                RadioButton q4Choice = (RadioButton) q4Tgl.getSelectedToggle();
                RadioButton q5Choice = (RadioButton) q5Tgl.getSelectedToggle();

                //Try catch to send data to writeToFile function
                try {
                    writeToFile(stNameTxt.getText(), q1Choice.getText(), q2Choice.getText(), q3Choice.getText(), q4Choice.getText(), q5Choice.getText(), score);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                //Clear test for next user
                stNameTxt.setText("");
                q1Choice.setSelected(false);
                q2Choice.setSelected(false);
                q3Choice.setSelected(false);
                q4Choice.setSelected(false);
                q5Choice.setSelected(false);
            });

            //Event for when clicked prints every student name and score
            showAvgMarks.setOnAction(actionEvent -> {
                File resultsFile = new File("results.txt");         //getting file to write to

                //try catch to send data to printResults function
                try {
                    printResults(resultsFile, avgMarks);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        stage.setScene(scene);
        stage.show();

    }

    //Function to print all student names and score
    public static void printResults(File resultsFile, Label avgMarks) throws FileNotFoundException {
        Scanner scanner = new Scanner(resultsFile);
        scanner.useDelimiter(" |\\n");
        StringBuilder results = new StringBuilder();
        while(scanner.hasNext()){
            String name = scanner.next();
            String choices = scanner.next();
            String avg = scanner.next();
            results.append(name).append("  ").append(avg).append("\n");
        }
        avgMarks.setText(results.toString());
    }

    //Function to write test data to results.txt
    public static void writeToFile(String name, String q1Choice, String q2Choice, String q3Choice, String q4Choice, String q5Choice, AtomicInteger score) throws IOException {
        FileWriter fw = new FileWriter("results.txt", true);
        fw.write(name + " " + q1Choice + "|" + q2Choice + "|" + q3Choice + "|" + q4Choice + "|" + q5Choice + " " + score + "\n");
        fw.close();
    }

    //function to check if name given is a valid name and not a number
    private boolean isValid(String name){
        char[] characters = name.toCharArray();
        for(char c : characters){
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    //function to add question data Question class
    private static Questions[] addQuestion(Questions[] questions, Questions newQ){
        Questions[] temp = new Questions[questions.length + 1];
        System.arraycopy(questions,0,temp,0,questions.length);
        temp[temp.length-1] = newQ;
        return temp;
    }

    public static void main(String[] args) {
        launch();
    }


}
