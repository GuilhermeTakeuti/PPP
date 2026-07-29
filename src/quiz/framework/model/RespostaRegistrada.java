package quiz.framework.model;

// registro de uma resposta dada pelo jogador, usado para montar o Resultado
public class RespostaRegistrada {

    private final Pergunta pergunta;
    private final int indiceEscolhido;
    private final boolean acertou;
    private final long tempoRespostaMillis;

    public RespostaRegistrada(Pergunta pergunta, int indiceEscolhido, boolean acertou, long tempoRespostaMillis) {
        this.pergunta = pergunta;
        this.indiceEscolhido = indiceEscolhido;
        this.acertou = acertou;
        this.tempoRespostaMillis = tempoRespostaMillis;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public int getIndiceEscolhido() {
        return indiceEscolhido;
    }

    public boolean isAcertou() {
        return acertou;
    }

    public long getTempoRespostaMillis() {
        return tempoRespostaMillis;
    }
}
