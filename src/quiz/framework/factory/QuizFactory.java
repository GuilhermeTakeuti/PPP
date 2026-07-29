package quiz.framework.factory;

import quiz.framework.core.Quiz;
import quiz.framework.model.Pergunta;
import quiz.framework.pontuacao.PontuacaoStrategy;
import quiz.framework.ui.QuizView;

import java.util.List;

// Factory Method: cada aplicação cliente implementa esta fábrica pra dizer
// quais perguntas, qual estratégia de pontuação, qual view e qual Quiz
// concreto usar. O framework não conhece nenhuma classe de quiz.aplicacao.*.
public abstract class QuizFactory {

    protected abstract List<Pergunta> criarPerguntas();

    protected abstract PontuacaoStrategy criarEstrategiaPontuacao();

    protected abstract QuizView criarView();

    protected abstract Quiz criarQuiz(List<Pergunta> perguntas, PontuacaoStrategy pontuacaoStrategy, QuizView view);

    // Método fábrica: monta as peças na ordem certa e devolve o quiz pronto.
    public final Quiz criar() {
        List<Pergunta> perguntas = criarPerguntas();
        PontuacaoStrategy estrategia = criarEstrategiaPontuacao();
        QuizView view = criarView();
        return criarQuiz(perguntas, estrategia, view);
    }
}
