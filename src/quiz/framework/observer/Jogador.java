package quiz.framework.observer;

// jogador de uma sessão com múltiplos jogadores
public class Jogador {

    private final String nome;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    void somarPontos(int pontos) {
        this.pontuacao += pontos;
    }
}
