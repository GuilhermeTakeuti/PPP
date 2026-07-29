package quiz.aplicacao.programacao;

import quiz.framework.model.Pergunta;
import quiz.framework.model.Resultado;
import quiz.framework.ui.QuizView;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.concurrent.SynchronousQueue;

// Implementação Swing da abstração QuizView. O framework não conhece
// esta classe nem nenhum componente Swing.
//
// Como capturarResposta() precisa ser síncrono (o Template Method espera
// o retorno antes de seguir) e o Swing é orientado a eventos, o quiz roda
// em uma thread separada da EDT, e a resposta clicada é passada de volta
// via SynchronousQueue.
public class SwingQuizView implements QuizView {

    private final JFrame frame = new JFrame("Quiz");
    private final JLabel lblProgresso = new JLabel();
    private final JLabel lblPergunta = new JLabel();
    private final JPanel painelAlternativas = new JPanel();
    private final JButton btnConfirmar = new JButton("Confirmar resposta");
    private final SynchronousQueue<Integer> filaResposta = new SynchronousQueue<>();

    private ButtonGroup grupoAtual;

    public SwingQuizView() {
        montarLayout();
    }

    private void montarLayout() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(12, 12));

        lblProgresso.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 12));
        lblPergunta.setBorder(BorderFactory.createEmptyBorder(8, 12, 12, 12));
        lblPergunta.setFont(lblPergunta.getFont().deriveFont(Font.BOLD, 16f));

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(lblProgresso, BorderLayout.NORTH);
        topo.add(lblPergunta, BorderLayout.CENTER);

        painelAlternativas.setLayout(new BoxLayout(painelAlternativas, BoxLayout.Y_AXIS));
        painelAlternativas.setBorder(BorderFactory.createEmptyBorder(0, 24, 0, 24));

        JPanel rodape = new JPanel();
        btnConfirmar.addActionListener(e -> confirmarResposta());
        rodape.add(btnConfirmar);

        frame.add(topo, BorderLayout.NORTH);
        frame.add(painelAlternativas, BorderLayout.CENTER);
        frame.add(rodape, BorderLayout.SOUTH);
    }

    private void confirmarResposta() {
        if (grupoAtual == null) {
            return;
        }
        int indice = 0;
        int selecionado = -1;
        Enumeration<AbstractButton> elementos = grupoAtual.getElements();
        while (elementos.hasMoreElements()) {
            if (elementos.nextElement().isSelected()) {
                selecionado = indice;
            }
            indice++;
        }
        if (selecionado == -1) {
            JOptionPane.showMessageDialog(frame, "Selecione uma alternativa antes de confirmar.");
            return;
        }
        try {
            filaResposta.put(selecionado);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void exibirBoasVindas(String titulo, int totalPerguntas) {
        SwingUtilities.invokeLater(() -> {
            frame.setTitle(titulo);
            frame.setVisible(true);
        });
    }

    @Override
    public RespostaCapturada capturarResposta(Pergunta pergunta, int numeroAtual, int totalPerguntas) {
        long inicio = System.currentTimeMillis();
        SwingUtilities.invokeLater(() -> exibirPerguntaNaTela(pergunta, numeroAtual, totalPerguntas));

        int indiceEscolhido;
        try {
            indiceEscolhido = filaResposta.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            indiceEscolhido = -1;
        }
        long tempoGasto = System.currentTimeMillis() - inicio;
        return new RespostaCapturada(indiceEscolhido, tempoGasto);
    }

    private void exibirPerguntaNaTela(Pergunta pergunta, int numeroAtual, int totalPerguntas) {
        lblProgresso.setText("Pergunta " + numeroAtual + " de " + totalPerguntas);
        lblPergunta.setText("<html>" + pergunta.getEnunciado() + "</html>");

        painelAlternativas.removeAll();
        grupoAtual = new ButtonGroup();
        for (String alternativa : pergunta.getAlternativas()) {
            JRadioButton rb = new JRadioButton(alternativa);
            grupoAtual.add(rb);
            painelAlternativas.add(rb);
        }
        painelAlternativas.revalidate();
        painelAlternativas.repaint();
    }

    @Override
    public void exibirFeedback(Pergunta pergunta, boolean acertou) {
        SwingUtilities.invokeLater(() -> {
            String mensagem = acertou
                    ? "Você acertou!"
                    : "Você errou. Resposta correta: " + pergunta.getAlternativaCorreta();
            JOptionPane.showMessageDialog(frame, mensagem);
        });
    }

    @Override
    public void exibirResultado(Resultado resultado) {
        SwingUtilities.invokeLater(() -> {
            String mensagem = "Quiz finalizado!\n"
                    + "Acertos: " + resultado.getAcertos() + "\n"
                    + "Erros: " + resultado.getErros() + "\n"
                    + "Pontuação final: " + resultado.getPontuacaoFinal();
            JOptionPane.showMessageDialog(frame, mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
