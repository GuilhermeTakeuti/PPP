package lab7.questao1;

public class Bicicleta implements Veiculo {
    private String cor;

    public Bicicleta(String cor) {
        this.cor = cor;
    }

    public String getCor() { return cor; }

    @Override
    public void aceitar(VeiculoVisitor visitor) {
        visitor.visitar(this);
    }
}
