package lab7.questao2;

import java.util.Arrays;
import java.util.List;

public class MainDocumento {
    public static void main(String[] args) {
        System.out.println("=== VISITOR - EDITOR DE DOCUMENTOS ===\n");

        List<DocumentElement> elementos = Arrays.asList(
            new Paragraph("Bem-vindo ao editor de documentos!", "font-size: 18px; font-weight: bold;"),
            new Paragraph("Este é um exemplo de documento rico com vários elementos.", "font-size: 14px;"),
            new Image("https://exemplo.com/imagem.jpg", "Imagem de exemplo", 300, 200),
            new Paragraph("Abaixo temos uma tabela com dados importantes:", "font-size: 14px;"),
            new Table(Arrays.asList(
                new String[]{"Nome", "Idade", "Cidade"},
                new String[]{"João", "25", "Uberlândia"},
                new String[]{"Maria", "30", "Uberaba"},
                new String[]{"Carlos", "28", "Araguari"}
            )),
            new Paragraph("Fim do documento.", "font-size: 14px; font-style: italic;")
        );

        System.out.println("=== EXPORTANDO PARA HTML ===");
        ExportHTMLVisitor htmlVisitor = new ExportHTMLVisitor();
        for (DocumentElement elemento : elementos) {
            elemento.aceitar(htmlVisitor);
        }
        System.out.println(htmlVisitor.getHTML());
        System.out.println();

        System.out.println("=== EXPORTANDO PARA PDF ===");
        ExportPDFVisitor pdfVisitor = new ExportPDFVisitor();
        for (DocumentElement elemento : elementos) {
            elemento.aceitar(pdfVisitor);
        }
        System.out.println(pdfVisitor.getPDF());
        System.out.println();

        System.out.println("=== CONTANDO PALAVRAS ===");
        WordCountVisitor wordCountVisitor = new WordCountVisitor();
        for (DocumentElement elemento : elementos) {
            elemento.aceitar(wordCountVisitor);
        }
        wordCountVisitor.imprimirEstatisticas();
    }
}
