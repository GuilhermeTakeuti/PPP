package lab7.questao2;

public class ExportPDFVisitor implements DocumentVisitor {
    private StringBuilder pdf = new StringBuilder();

    @Override
    public void visitar(Paragraph paragraph) {
        pdf.append("[PARAGRAPH] ")
           .append("Estilo: ").append(paragraph.getEstilo())
           .append(" | Texto: ").append(paragraph.getTexto())
           .append("\n");
    }

    @Override
    public void visitar(Image image) {
        pdf.append("[IMAGE] ")
           .append("URL: ").append(image.getUrl())
           .append(" | Descrição: ").append(image.getDescricao())
           .append(" | Dimensões: ").append(image.getLargura())
           .append("x").append(image.getAltura())
           .append("\n");
    }

    @Override
    public void visitar(Table table) {
        pdf.append("[TABLE] ")
           .append("Linhas: ").append(table.getLinhas())
           .append(" | Colunas: ").append(table.getColunas())
           .append("\n");
        
        for (String[] linha : table.getDados()) {
            pdf.append("  Linha: ");
            for (String celula : linha) {
                pdf.append("[").append(celula).append("] ");
            }
            pdf.append("\n");
        }
    }

    public String getPDF() {
        return "=== DOCUMENTO EXPORTADO PARA PDF ===\n"
             + "====================================\n\n"
             + pdf.toString()
             + "\n====================================";
    }
}
