package quiz.framework.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Sujeito do Observer: gerencia uma partida multiplayer e notifica os
// observadores registrados a cada mudança de pontuação e ao final da partida.
public class SessaoMultiplayer {

    private final List<Jogador> jogadores = new ArrayList<>();
    private final List<QuizObserver> observers = new ArrayList<>();

    public Jogador adicionarJogador(String nome) {
        Jogador jogador = new Jogador(nome);
        jogadores.add(jogador);
        return jogador;
    }

    public void registrarObserver(QuizObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(QuizObserver observer) {
        observers.remove(observer);
    }

    public void registrarPontos(Jogador jogador, int pontos) {
        jogador.somarPontos(pontos);
        notificarAtualizacao(jogador);
    }

    private void notificarAtualizacao(Jogador jogador) {
        for (QuizObserver observer : observers) {
            observer.aoAtualizarPontuacao(jogador);
        }
    }

    public void finalizarPartida() {
        List<Jogador> ranking = new ArrayList<>(jogadores);
        ranking.sort((a, b) -> b.getPontuacao() - a.getPontuacao());
        for (QuizObserver observer : observers) {
            observer.aoFinalizarPartida(ranking);
        }
    }

    public List<Jogador> getJogadores() {
        return Collections.unmodifiableList(jogadores);
    }
}
