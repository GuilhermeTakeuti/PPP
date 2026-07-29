package quiz.aplicacao.programacao;

import quiz.framework.core.Quiz;
import quiz.framework.factory.QuizFactory;

// Aplicação 1: Quiz de Programação com interface Swing, usando o mesmo
// quiz.framework da Aplicação 2 (console).
public class MainProgramacao {

    public static void main(String[] args) {
        QuizFactory factory = new ProgramacaoQuizFactory();
        Quiz quiz = factory.criar();

        // O motor do quiz (Template Method) roda em thread separada da
        // Event Dispatch Thread, pois capturarResposta() é bloqueante.
        Thread quizThread = new Thread(quiz::iniciar, "quiz-programacao");
        quizThread.setDaemon(false);
        quizThread.start();
    }
}
