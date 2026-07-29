package quiz.framework.pontuacao;

// Política baseada em tempo: quanto mais rápido acertar, mais pontos ganha.
// Errou = 0 pontos.
public class PontuacaoPorTempo implements PontuacaoStrategy {

    private static final int PONTUACAO_MAXIMA = 15;
    private static final int PONTUACAO_MINIMA = 1;
    private static final long MILLIS_POR_PONTO_PERDIDO = 1000L;

    @Override
    public int calcularPontos(boolean acertou, long tempoRespostaMillis) {
        if (!acertou) {
            return 0;
        }
        long segundosGastos = tempoRespostaMillis / MILLIS_POR_PONTO_PERDIDO;
        int pontos = (int) (PONTUACAO_MAXIMA - segundosGastos);
        return Math.max(PONTUACAO_MINIMA, pontos);
    }

    @Override
    public String getDescricao() {
        return "Baseada em tempo (até " + PONTUACAO_MAXIMA + " por acerto rápido)";
    }
}
