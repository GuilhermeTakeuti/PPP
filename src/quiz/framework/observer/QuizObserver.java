package quiz.framework.observer;

import java.util.List;

// Observer (item extra): notifica componentes como um placar sempre que a
// pontuação de algum jogador mudar, em sessões com múltiplos jogadores.
public interface QuizObserver {

    void aoAtualizarPontuacao(Jogador jogador);

    void aoFinalizarPartida(List<Jogador> rankingFinal);
}
