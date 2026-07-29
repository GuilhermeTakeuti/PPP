package quiz.aplicacao.programacao;

import quiz.framework.core.Quiz;
import quiz.framework.model.Pergunta;
import quiz.framework.model.Resultado;
import quiz.framework.pontuacao.PontuacaoStrategy;
import quiz.framework.ui.QuizView;

import java.util.List;

// Quiz de Programação. Só sobrescreve o hook aoFinalizar; todo o fluxo
// vem do Template Method da classe Quiz.
public class QuizProgramacao extends Quiz {

    public QuizProgramacao(List<Pergunta> perguntas, PontuacaoStrategy pontuacaoStrategy, QuizView view) {
        super("Quiz de Programação", perguntas, pontuacaoStrategy, view);
    }

    @Override
    protected void aoFinalizar(Resultado resultado) {
        if (resultado.getAcertos() == resultado.getTotalPerguntas()) {
            System.out.println("Gabarito perfeito em Programação!");
        }
    }
}
