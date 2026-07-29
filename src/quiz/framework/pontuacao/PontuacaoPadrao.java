package quiz.framework.pontuacao;

/** Política simples: +10 pontos por acerto, 0 pontos por erro. */
public class PontuacaoPadrao implements PontuacaoStrategy {

    private static final int PONTOS_POR_ACERTO = 10;

    @Override
    public int calcularPontos(boolean acertou, long tempoRespostaMillis) {
        return acertou ? PONTOS_POR_ACERTO : 0;
    }

    @Override
    public String getDescricao() {
        return "Padrão (+10 por acerto)";
    }
}
