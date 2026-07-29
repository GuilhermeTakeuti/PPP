package quiz.framework.pontuacao;

// Strategy: cada aplicação escolhe a política de pontuação que quiser,
// sem o framework precisar conhecer os detalhes de cada uma.
public interface PontuacaoStrategy {

    // pontos ganhos (ou perdidos) em uma resposta. tempoRespostaMillis só
    // é usado pelas estratégias baseadas em tempo.
    int calcularPontos(boolean acertou, long tempoRespostaMillis);

    String getDescricao();
}
