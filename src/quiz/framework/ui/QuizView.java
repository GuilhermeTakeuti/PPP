package quiz.framework.ui;

import quiz.framework.model.Pergunta;
import quiz.framework.model.Resultado;

// Abstração da camada de exibição. O framework só conhece essa interface,
// nunca uma tecnologia concreta (Swing, console, etc).
public interface QuizView {

    void exibirBoasVindas(String titulo, int totalPerguntas);

    // exibe a pergunta e bloqueia até o jogador confirmar uma resposta
    RespostaCapturada capturarResposta(Pergunta pergunta, int numeroAtual, int totalPerguntas);

    void exibirFeedback(Pergunta pergunta, boolean acertou);

    void exibirResultado(Resultado resultado);

    // resposta capturada: qual alternativa e quanto tempo levou
    class RespostaCapturada {
        public final int indiceEscolhido;
        public final long tempoRespostaMillis;

        public RespostaCapturada(int indiceEscolhido, long tempoRespostaMillis) {
            this.indiceEscolhido = indiceEscolhido;
            this.tempoRespostaMillis = tempoRespostaMillis;
        }
    }
}
