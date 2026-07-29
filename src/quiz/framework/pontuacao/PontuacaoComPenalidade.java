package quiz.framework.pontuacao;

/** Política com penalidade: +10 pontos por acerto, -5 pontos por erro. */
public class PontuacaoComPenalidade implements PontuacaoStrategy {

    private static final int PONTOS_POR_ACERTO = 10;
    private static final int PENALIDADE_POR_ERRO = -5;

    @Override
    public int calcularPontos(boolean acertou, long tempoRespostaMillis) {
        return acertou ? PONTOS_POR_ACERTO : PENALIDADE_POR_ERRO;
    }

    @Override
    public String getDescricao() {
        return "Com penalidade (+10 acerto / -5 erro)";
    }
}
