package quiz.aplicacao.geral;

import quiz.framework.model.Pergunta;
import quiz.framework.model.Resultado;
import quiz.framework.ui.QuizView;

import java.util.List;
import java.util.Scanner;

// Implementação em console da abstração QuizView.
public class ConsoleQuizView implements QuizView {

    private final Scanner scanner;

    public ConsoleQuizView() {
        this(new Scanner(System.in));
    }

    // permite reaproveitar um Scanner já existente (usado no MultiplayerDemo,
    // pra não ter dois Scanner lendo System.in ao mesmo tempo)
    public ConsoleQuizView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void exibirBoasVindas(String titulo, int totalPerguntas) {
        System.out.println("==============================================");
        System.out.println(titulo);
        System.out.println("Total de perguntas: " + totalPerguntas);
        System.out.println("==============================================\n");
    }

    @Override
    public RespostaCapturada capturarResposta(Pergunta pergunta, int numeroAtual, int totalPerguntas) {
        System.out.println("Pergunta " + numeroAtual + "/" + totalPerguntas + ": " + pergunta.getEnunciado());
        List<String> alternativas = pergunta.getAlternativas();
        for (int i = 0; i < alternativas.size(); i++) {
            System.out.println("  " + (i + 1) + ") " + alternativas.get(i));
        }

        long inicio = System.currentTimeMillis();
        int escolha = lerOpcaoValida(alternativas.size());
        long tempoGasto = System.currentTimeMillis() - inicio;
        System.out.println();
        return new RespostaCapturada(escolha - 1, tempoGasto);
    }

    private int lerOpcaoValida(int totalAlternativas) {
        while (true) {
            System.out.print("Digite o número da alternativa: ");
            String entrada = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= 1 && valor <= totalAlternativas) {
                    return valor;
                }
            } catch (NumberFormatException ignored) {
                // trata como entrada inválida abaixo
            }
            System.out.println("Entrada inválida. Tente novamente.");
        }
    }

    @Override
    public void exibirFeedback(Pergunta pergunta, boolean acertou) {
        if (acertou) {
            System.out.println(">> Correto!\n");
        } else {
            System.out.println(">> Errado! Resposta certa: " + pergunta.getAlternativaCorreta() + "\n");
        }
    }

    @Override
    public void exibirResultado(Resultado resultado) {
        System.out.println("==============================================");
        System.out.println("Resultado final");
        System.out.println("Acertos: " + resultado.getAcertos());
        System.out.println("Erros: " + resultado.getErros());
        System.out.println("Pontuação final: " + resultado.getPontuacaoFinal());
        System.out.println("==============================================");
    }
}
