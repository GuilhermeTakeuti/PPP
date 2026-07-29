package quiz.aplicacao.programacao;

import quiz.framework.core.Quiz;
import quiz.framework.factory.QuizFactory;
import quiz.framework.model.Pergunta;
import quiz.framework.pontuacao.PontuacaoComPenalidade;
import quiz.framework.pontuacao.PontuacaoStrategy;
import quiz.framework.ui.QuizView;

import javax.swing.*;
import java.util.List;

// Fábrica concreta (Factory Method) da aplicação de Programação.
public class ProgramacaoQuizFactory extends QuizFactory {

    @Override
    protected List<Pergunta> criarPerguntas() {
        return List.of(
                new Pergunta(
                        "Qual estrutura de dados segue o princípio LIFO (o último a entrar é o primeiro a sair)?",
                        List.of("Fila", "Pilha", "Árvore", "Grafo"),
                        1),
                new Pergunta(
                        "Em orientação a objetos, o que é herança?",
                        List.of(
                                "Capacidade de um objeto assumir várias formas em tempo de execução",
                                "Mecanismo de reutilização de código entre classes relacionadas",
                                "Ocultação dos detalhes internos de implementação de uma classe",
                                "Divisão de um sistema em módulos totalmente independentes"),
                        1),
                new Pergunta(
                        "Qual a complexidade de tempo de uma busca binária em um array ordenado de tamanho n?",
                        List.of("O(n)", "O(n log n)", "O(log n)", "O(1)"),
                        2),
                new Pergunta(
                        "Qual palavra-chave em Java é usada para impedir que uma classe seja estendida?",
                        List.of("static", "final", "private", "abstract"),
                        1),
                new Pergunta(
                        "Qual padrão de projeto define o esqueleto de um algoritmo em uma classe base e delega "
                                + "passos específicos às subclasses?",
                        List.of("Strategy", "Observer", "Template Method", "Singleton"),
                        2)
        );
    }

    @Override
    protected PontuacaoStrategy criarEstrategiaPontuacao() {
        return new PontuacaoComPenalidade();
    }

    @Override
    protected QuizView criarView() {
        // Componentes Swing devem ser criados na Event Dispatch Thread.
        SwingQuizView[] holder = new SwingQuizView[1];
        try {
            SwingUtilities.invokeAndWait(() -> holder[0] = new SwingQuizView());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao inicializar a interface Swing.", e);
        }
        return holder[0];
    }

    @Override
    protected Quiz criarQuiz(List<Pergunta> perguntas, PontuacaoStrategy pontuacaoStrategy, QuizView view) {
        return new QuizProgramacao(perguntas, pontuacaoStrategy, view);
    }
}
