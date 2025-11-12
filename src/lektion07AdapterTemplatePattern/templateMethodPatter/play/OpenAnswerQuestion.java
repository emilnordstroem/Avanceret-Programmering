package lektion07AdapterTemplatePattern.templateMethodPatter.play;

import java.util.Scanner;

public class OpenAnswerQuestion extends Question {
    private String question;

    public OpenAnswerQuestion(String question) {
        this.question = question;
    }

    @Override
    protected void displayQuestion() {
        System.out.println("Open Answer: " + question);
    }

    @Override
    protected String getUserAnswer() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Svar på under 280 tegn: ");
        String answer = scan.nextLine();
        return answer;
    }

    @Override
    protected boolean checkAnswer(String answer) {
        return true;
    }

}
