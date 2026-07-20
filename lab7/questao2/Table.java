package lab7.questao2;

import java.util.List;

public class Table implements DocumentElement {
    private List<String[]> dados;
    private int colunas;
    private int linhas;

    public Table(List<String[]> dados) {
        this.dados = dados;
        this.linhas = dados.size();
        this.colunas = dados.isEmpty() ? 0 : dados.get(0).length;
    }

    public List<String[]> getDados() { return dados; }
    public int getColunas() { return colunas; }
    public int getLinhas() { return linhas; }

    @Override
    public void aceitar(DocumentVisitor visitor) {
        visitor.visitar(this);
    }
}
