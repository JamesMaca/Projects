//James MacAloney - 101362896

package com.example.groupprojectme;

public class Questions {

    public String question;
    public String options;
    public String answers;

    public Questions(String question, String options, String answers){
        this.question = question;
        this.options = options;
        this.answers = answers;
    }

    public Questions() {

    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }



    public String getOptions(){
        return options;
    }

    public void setOptions(String option){
        this.options = option;
    }

    public String getAnswers(){
        return answers;
    }

    public void setAnswers(String answer){
        this.answers = answer;
    }

    public String toString(){
        return question + "\n" +
                options + "\n" +
                answers;
    }

}
