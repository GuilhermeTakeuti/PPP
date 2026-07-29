package lab7.questao2;

public class Image implements DocumentElement {
    private String url;
    private String descricao;
    private int largura;
    private int altura;

    public Image(String url, String descricao, int largura, int altura) {
        this.url = url;
        this.descricao = descricao;
        this.largura = largura;
        this.altura = altura;
    }

    public String getUrl() { return url; }
    public String getDescricao() { return descricao; }
    public int getLargura() { return largura; }
    public int getAltura() { return altura; }

    @Override
    public void aceitar(DocumentVisitor visitor) {
        visitor.visitar(this);
    }
}
