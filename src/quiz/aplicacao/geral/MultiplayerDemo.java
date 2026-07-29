package quiz.aplicacao.geral;

import quiz.framework.model.Pergunta;
import quiz.framework.observer.Jogador;
import quiz.framework.observer.SessaoMultiplayer;
import quiz.framework.pontuacao.PontuacaoPadrao;
import quiz.framework.pontuacao.PontuacaoStrategy;
import quiz.framework.ui.QuizView;

import java.util.List;
import java.util.Scanner;

// Extra: demonstração do Observer com múltiplos jogadores. Cada jogador
// responde às mesmas perguntas e o placar é atualizado em tempo real.
public class MultiplayerDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos jogadores vão participar? ");
        int totalJogadores = Integer.parseInt(scanner.nextLine().trim());

        SessaoMultiplayer sessao = new SessaoMultiplayer();
        sessao.registrarObserver(new PlacarConsoleObserver());

        Jogador[] jogadores = new Jogador[totalJogadores];
        for (int i = 0; i < totalJogadores; i++) {
            System.out.print("Nome do jogador " + (i + 1) + ": ");
            jogadores[i] = sessao.adicionarJogador(scanner.nextLine().trim());
        }

        List<Pergunta> perguntas = new GeralQuizFactory().criarPerguntas();
        PontuacaoStrategy estrategia = new PontuacaoPadrao();
        ConsoleQuizView view = new ConsoleQuizView(scanner);

        int numero = 1;
        for (Pergunta pergunta : perguntas) {
            for (Jogador jogador : jogadores) {
                System.out.println("Vez de: " + jogador.getNome());
                QuizView.RespostaCapturada resposta = view.capturarResposta(pergunta, numero, perguntas.size());
                boolean acertou = pergunta.verificarResposta(resposta.indiceEscolhido);
                view.exibirFeedback(pergunta, acertou);
                int pontos = estrategia.calcularPontos(acertou, resposta.tempoRespostaMillis);
                sessao.registrarPontos(jogador, pontos);
            }
            numero++;
        }

        sessao.finalizarPartida();
    }
}
