package lab7.questao2;

public class Paragraph implements DocumentElement {
    private String texto;
    private String estilo;

    public Paragraph(String texto, String estilo) {
        this.texto = texto;
        this.estilo = estilo;
    }

    public String getTexto() { return texto; }
    public String getEstilo() { return estilo; }

    @Override
    public void aceitar(DocumentVisitor visitor) {
        visitor.visitar(this);
    }
}
