package questao1;

/**
 * Adapter que converte a interface de Pato (Adaptee) para a
 * interface Ave (Target), esperada pelo cliente.
 */
public class PatoAdapter implements Ave {

    private final Pato pato;

    public PatoAdapter(Pato pato) {
        this.pato = pato;
    }

    @Override
    public void voar() {
        pato.voarPato();
    }

    @Override
    public void emitirSom() {
        pato.grasnar();
    }
}
