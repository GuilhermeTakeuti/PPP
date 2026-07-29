package lab6.questao1;

public class Capuccino extends BebidaTemplate {
    @Override
    protected void preparar() {
        System.out.println("Adicionando café expresso");
        System.out.println("Adicionando leite vaporizado");
        System.out.println("Adicionando espuma de leite");
    }

    @Override
    protected void adicionarCondimentos() {
        System.out.println("Polvilhando canela por cima");
    }

    @Override
    protected String getNomeBebida() {
        return "Capuccino";
    }
}
