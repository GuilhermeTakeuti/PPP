package quiz.aplicacao.geral;

import quiz.framework.core.Quiz;
import quiz.framework.model.Pergunta;
import quiz.framework.pontuacao.PontuacaoStrategy;
import quiz.framework.ui.QuizView;

import java.util.List;

// Quiz de Conhecimentos Gerais. Sobrescreve os hooks antesDeIniciar e
// aposResponder; o fluxo em si vem do Template Method da classe Quiz.
public class QuizConhecimentosGerais extends Quiz {

    private int sequenciaAcertos = 0;

    public QuizConhecimentosGerais(List<Pergunta> perguntas, PontuacaoStrategy pontuacaoStrategy, QuizView view) {
        super("Quiz de Conhecimentos Gerais", perguntas, pontuacaoStrategy, view);
    }

    @Override
    protected void antesDeIniciar() {
        System.out.println("Responda rápido: quanto menos tempo você levar, mais pontos ganha!\n");
    }

    @Override
    protected void aposResponder(Pergunta pergunta, boolean acertou, int pontosGanhos) {
        if (acertou) {
            sequenciaAcertos++;
            if (sequenciaAcertos >= 3) {
                System.out.println("Sequência de " + sequenciaAcertos + " acertos seguidos!\n");
            }
        } else {
            sequenciaAcertos = 0;
        }
    }
}
