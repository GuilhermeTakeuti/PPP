package lab7.questao2;

public class ExportHTMLVisitor implements DocumentVisitor {
    private StringBuilder html = new StringBuilder();

    @Override
    public void visitar(Paragraph paragraph) {
        html.append("<p style=\"").append(paragraph.getEstilo()).append("\">")
            .append(paragraph.getTexto())
            .append("</p>\n");
    }

    @Override
    public void visitar(Image image) {
        html.append("<img src=\"").append(image.getUrl())
            .append("\" alt=\"").append(image.getDescricao())
            .append("\" width=\"").append(image.getLargura())
            .append("\" height=\"").append(image.getAltura())
            .append("\" />\n");
    }

    @Override
    public void visitar(Table table) {
        html.append("<table border=\"1\">\n");
        for (String[] linha : table.getDados()) {
            html.append("  <tr>\n");
            for (String celula : linha) {
                html.append("    <td>").append(celula).append("</td>\n");
            }
            html.append("  </tr>\n");
        }
        html.append("</table>\n");
    }

    public String getHTML() {
        return "<!DOCTYPE html>\n<html>\n<head>\n"
             + "<meta charset=\"UTF-8\">\n"
             + "<title>Documento Exportado</title>\n"
             + "</head>\n<body>\n"
             + html.toString()
             + "</body>\n</html>";
    }
}
