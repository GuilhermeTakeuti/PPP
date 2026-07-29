package lab6.questao1;

public class Cha extends BebidaTemplate {
    @Override
    protected void preparar() {
        System.out.println("Colocando o saquinho de chá");
        System.out.println("Deixando em infusão por 3 minutos");
    }

    @Override
    protected void adicionarCondimentos() {
        System.out.println("Adicionando limão (opcional)");
        System.out.println("Adicionando mel (opcional)");
    }

    @Override
    protected String getNomeBebida() {
        return "Chá";
    }
}
