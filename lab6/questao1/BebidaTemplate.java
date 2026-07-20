package lab6.questao1;

public abstract class BebidaTemplate {
    
    public final void prepararBebida() {
        System.out.println("\n=== Preparando " + getNomeBebida() + " ===");
        aquecerAgua();
        preparar();
        colocarNaXicara();
        adicionarCondimentos();
        System.out.println("=== " + getNomeBebida() + " pronto! ===\n");
    }

    private void aquecerAgua() {
        System.out.println("Aquecendo água a 90°C");
    }

    private void colocarNaXicara() {
        System.out.println("Colocando na xícara");
    }

    protected abstract void preparar();
    protected abstract void adicionarCondimentos();
    protected abstract String getNomeBebida();
}
