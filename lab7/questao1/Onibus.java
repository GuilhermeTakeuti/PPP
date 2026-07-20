package lab7.questao1;

public class Onibus implements Veiculo {
    private int quantidadeLugares;
    private int anoFabricacao;

    public Onibus(int quantidadeLugares, int anoFabricacao) {
        this.quantidadeLugares = quantidadeLugares;
        this.anoFabricacao = anoFabricacao;
    }

    public int getQuantidadeLugares() { return quantidadeLugares; }
    public int getAnoFabricacao() { return anoFabricacao; }

    @Override
    public void aceitar(VeiculoVisitor visitor) {
        visitor.visitar(this);
    }
}
