package quiz.framework.core;

import quiz.framework.model.Pergunta;
import quiz.framework.model.Resultado;
import quiz.framework.model.RespostaRegistrada;
import quiz.framework.pontuacao.PontuacaoStrategy;
import quiz.framework.ui.QuizView;

import java.util.ArrayList;
import java.util.List;

// Template Method: define a ordem fixa de execução do quiz (exibir pergunta,
// capturar resposta, pontuar, avançar, mostrar resultado). As subclasses
// (QuizProgramacao, QuizConhecimentosGerais) só sobrescrevem os "hooks"
// abaixo para customizar detalhes, sem mudar a ordem das etapas.
public abstract class Quiz {

    private final String titulo;
    private final List<Pergunta> perguntas;
    private final PontuacaoStrategy pontuacaoStrategy;
    private final QuizView view;

    protected Quiz(String titulo, List<Pergunta> perguntas, PontuacaoStrategy pontuacaoStrategy, QuizView view) {
        if (perguntas == null || perguntas.isEmpty()) {
            throw new IllegalArgumentException("O quiz precisa de ao menos uma pergunta.");
        }
        this.titulo = titulo;
        this.perguntas = perguntas;
        this.pontuacaoStrategy = pontuacaoStrategy;
        this.view = view;
    }

    // Método template (final): ninguém pode mudar a sequência de passos.
    public final Resultado iniciar() {
        antesDeIniciar();
        view.exibirBoasVindas(titulo, perguntas.size());

        List<RespostaRegistrada> respostas = new ArrayList<>();
        int acertos = 0;
        int pontuacaoFinal = 0;
        int numero = 1;

        for (Pergunta pergunta : perguntas) {
            QuizView.RespostaCapturada capturada = view.capturarResposta(pergunta, numero, perguntas.size());
            boolean acertou = pergunta.verificarResposta(capturada.indiceEscolhido);
            int pontos = pontuacaoStrategy.calcularPontos(acertou, capturada.tempoRespostaMillis);

            pontuacaoFinal += pontos;
            if (acertou) {
                acertos++;
            }

            respostas.add(new RespostaRegistrada(pergunta, capturada.indiceEscolhido, acertou, capturada.tempoRespostaMillis));
            view.exibirFeedback(pergunta, acertou);
            aposResponder(pergunta, acertou, pontos);
            numero++;
        }

        int erros = perguntas.size() - acertos;
        Resultado resultado = new Resultado(perguntas.size(), acertos, erros, pontuacaoFinal, respostas);
        view.exibirResultado(resultado);
        aoFinalizar(resultado);
        return resultado;
    }

    // Hooks opcionais do Template Method (implementação padrão vazia)
    protected void antesDeIniciar() {
    }

    protected void aposResponder(Pergunta pergunta, boolean acertou, int pontosGanhos) {
    }

    protected void aoFinalizar(Resultado resultado) {
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }
}
