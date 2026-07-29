package quiz.aplicacao.geral;

import quiz.framework.core.Quiz;
import quiz.framework.factory.QuizFactory;
import quiz.framework.model.Pergunta;
import quiz.framework.pontuacao.PontuacaoPorTempo;
import quiz.framework.pontuacao.PontuacaoStrategy;
import quiz.framework.ui.QuizView;

import java.util.List;

// Fábrica concreta (Factory Method) da aplicação de Conhecimentos Gerais.
public class GeralQuizFactory extends QuizFactory {

    @Override
    protected List<Pergunta> criarPerguntas() {
        return List.of(
                new Pergunta(
                        "Qual é o maior planeta do sistema solar?",
                        List.of("Terra", "Saturno", "Júpiter", "Netuno"),
                        2),
                new Pergunta(
                        "Em que ano ocorreu a Proclamação da República no Brasil?",
                        List.of("1822", "1889", "1500", "1930"),
                        1),
                new Pergunta(
                        "Qual é o oceano mais extenso do planeta?",
                        List.of("Atlântico", "Índico", "Ártico", "Pacífico"),
                        3),
                new Pergunta(
                        "Quem pintou a obra 'Guernica'?",
                        List.of("Salvador Dalí", "Pablo Picasso", "Vincent van Gogh", "Claude Monet"),
                        1),
                new Pergunta(
                        "Qual é o elemento químico de símbolo 'O'?",
                        List.of("Ouro", "Oxigênio", "Ósmio", "Ozônio"),
                        1)
        );
    }

    @Override
    protected PontuacaoStrategy criarEstrategiaPontuacao() {
        return new PontuacaoPorTempo();
    }

    @Override
    protected QuizView criarView() {
        return new ConsoleQuizView();
    }

    @Override
    protected Quiz criarQuiz(List<Pergunta> perguntas, PontuacaoStrategy pontuacaoStrategy, QuizView view) {
        return new QuizConhecimentosGerais(perguntas, pontuacaoStrategy, view);
    }
}
