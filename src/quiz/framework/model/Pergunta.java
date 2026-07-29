package quiz.framework.model;

import java.util.List;

// Pergunta de múltipla escolha, independente de como vai ser exibida.
public class Pergunta {

    private final String enunciado;
    private final List<String> alternativas;
    private final int indiceCorreta;

    public Pergunta(String enunciado, List<String> alternativas, int indiceCorreta) {
        if (enunciado == null || enunciado.isBlank()) {
            throw new IllegalArgumentException("O enunciado da pergunta não pode ser vazio.");
        }
        if (alternativas == null || alternativas.size() < 2) {
            throw new IllegalArgumentException("A pergunta deve ter ao menos duas alternativas.");
        }
        if (indiceCorreta < 0 || indiceCorreta >= alternativas.size()) {
            throw new IllegalArgumentException("Índice da alternativa correta inválido.");
        }
        this.enunciado = enunciado;
        this.alternativas = List.copyOf(alternativas);
        this.indiceCorreta = indiceCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public boolean verificarResposta(int indiceEscolhido) {
        return indiceEscolhido == indiceCorreta;
    }

    public String getAlternativaCorreta() {
        return alternativas.get(indiceCorreta);
    }
}
