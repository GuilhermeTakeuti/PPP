package questao1;

/**
 * Classe "existente" (Adaptee), com interface diferente da esperada (Ave).
 * Um Pato sabe grasnar e voar, mas os métodos têm nomes diferentes
 * dos definidos na interface Ave.
 */
public class Pato {

    public void grasnar() {
        System.out.println("Quack quack!");
    }

    public void voarPato() {
        System.out.println("O pato está voando baixinho sobre o lago.");
    }
}
