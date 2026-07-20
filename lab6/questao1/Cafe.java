package lab6.questao1;

public class Cafe extends BebidaTemplate {
    @Override
    protected void preparar() {
        System.out.println("Adicionando pó de café");
        System.out.println("Filtrando o café");
    }

    @Override
    protected void adicionarCondimentos() {
        System.out.println("Adicionando açúcar (opcional)");
    }

    @Override
    protected String getNomeBebida() {
        return "Café";
    }
}
