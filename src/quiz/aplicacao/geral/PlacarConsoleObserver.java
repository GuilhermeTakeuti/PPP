package quiz.aplicacao.geral;

import quiz.framework.observer.Jogador;
import quiz.framework.observer.QuizObserver;

import java.util.List;

// Observer concreto: mostra o placar no console a cada mudança de pontuação.
public class PlacarConsoleObserver implements QuizObserver {

    @Override
    public void aoAtualizarPontuacao(Jogador jogador) {
        System.out.println("[Placar] " + jogador.getNome() + " agora tem " + jogador.getPontuacao() + " pontos.");
    }

    @Override
    public void aoFinalizarPartida(List<Jogador> rankingFinal) {
        System.out.println("\n=== Ranking final ===");
        int posicao = 1;
        for (Jogador jogador : rankingFinal) {
            System.out.println(posicao + "º - " + jogador.getNome() + ": " + jogador.getPontuacao() + " pontos");
            posicao++;
        }
    }
}
