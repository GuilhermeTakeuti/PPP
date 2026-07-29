package quiz.framework.model;

import java.util.List;

// resultado final do quiz: acertos, erros, pontuação e histórico de respostas
public class Resultado {

    private final int totalPerguntas;
    private final int acertos;
    private final int erros;
    private final int pontuacaoFinal;
    private final List<RespostaRegistrada> respostas;

    public Resultado(int totalPerguntas, int acertos, int erros, int pontuacaoFinal,
                      List<RespostaRegistrada> respostas) {
        this.totalPerguntas = totalPerguntas;
        this.acertos = acertos;
        this.erros = erros;
        this.pontuacaoFinal = pontuacaoFinal;
        this.respostas = List.copyOf(respostas);
    }

    public int getTotalPerguntas() {
        return totalPerguntas;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }

    public int getPontuacaoFinal() {
        return pontuacaoFinal;
    }

    public List<RespostaRegistrada> getRespostas() {
        return respostas;
    }
}
