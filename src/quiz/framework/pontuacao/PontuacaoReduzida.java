package quiz.framework.pontuacao;

/** Política reduzida: +5 pontos por acerto, 0 pontos por erro. */
public class PontuacaoReduzida implements PontuacaoStrategy {

    private static final int PONTOS_POR_ACERTO = 5;

    @Override
    public int calcularPontos(boolean acertou, long tempoRespostaMillis) {
        return acertou ? PONTOS_POR_ACERTO : 0;
    }

    @Override
    public String getDescricao() {
        return "Reduzida (+5 por acerto)";
    }
}
