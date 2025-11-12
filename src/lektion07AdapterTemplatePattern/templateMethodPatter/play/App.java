package lektion07AdapterTemplatePattern.templateMethodPatter.play;

public class App {

    public static void main(String[] args) {
        // Oprettelse af spørgsmål
        Question[] questions = {
                new MultipleChoiceQuestion("Hvad er hovedstaden i Frankrig?", new String[]{"Paris", "Berlin", "London"}, 0),
                new TrueFalseQuestion("Er jorden rund?", true),
                new OpenAnswerQuestion("Hvordan har du det med Template Method Design Pattern?")
        };

        // Oprettelse af spil og afvikling
        Game game = new QuizGame(questions);
        game.playGame();
    }

}