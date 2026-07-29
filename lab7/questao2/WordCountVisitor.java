package lab7.questao2;

public class WordCountVisitor implements DocumentVisitor {
    private int totalPalavras = 0;
    private int totalCaracteres = 0;
    private int totalParagrafos = 0;
    private int totalImagens = 0;
    private int totalTabelas = 0;

    @Override
    public void visitar(Paragraph paragraph) {
        totalParagrafos++;
        String texto = paragraph.getTexto();
        if (texto != null && !texto.trim().isEmpty()) {
            String[] palavras = texto.trim().split("\\s+");
            totalPalavras += palavras.length;
            totalCaracteres += texto.replaceAll("\\s+", "").length();
        }
    }

    @Override
    public void visitar(Image image) {
        totalImagens++;
    }

    @Override
    public void visitar(Table table) {
        totalTabelas++;
        for (String[] linha : table.getDados()) {
            for (String celula : linha) {
                if (celula != null && !celula.trim().isEmpty()) {
                    String[] palavras = celula.trim().split("\\s+");
                    totalPalavras += palavras.length;
                    totalCaracteres += celula.replaceAll("\\s+", "").length();
                }
            }
        }
    }

    public void imprimirEstatisticas() {
        System.out.println("=== ESTATÍSTICAS DO DOCUMENTO ===");
        System.out.println("Total de palavras: " + totalPalavras);
        System.out.println("Total de caracteres (sem espaços): " + totalCaracteres);
        System.out.println("Total de parágrafos: " + totalParagrafos);
        System.out.println("Total de imagens: " + totalImagens);
        System.out.println("Total de tabelas: " + totalTabelas);
        System.out.println("===================================");
    }
}
