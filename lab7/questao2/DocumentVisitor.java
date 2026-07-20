package lab7.questao2;

public interface DocumentVisitor {
    void visitar(Paragraph paragraph);
    void visitar(Image image);
    void visitar(Table table);
}
