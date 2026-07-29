package quiz.aplicacao.geral;

import quiz.framework.core.Quiz;
import quiz.framework.factory.QuizFactory;

// Aplicação 2: Quiz de Conhecimentos Gerais em console, usando o mesmo
// quiz.framework da Aplicação 1 (Swing), sem duplicar nada do framework.
public class MainGeral {

    public static void main(String[] args) {
        QuizFactory factory = new GeralQuizFactory();
        Quiz quiz = factory.criar();
        quiz.iniciar();
    }
}
