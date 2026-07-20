package questao1;

/**
 * Espécie concreta de Pato.
 */
public class PatoDomestico extends Pato {

    @Override
    public void grasnar() {
        System.out.println("Pato Doméstico: Quack quack (som mais suave)!");
    }

    @Override
    public void voarPato() {
        System.out.println("Pato Doméstico está voando de um lado para o outro no quintal.");
    }
}
