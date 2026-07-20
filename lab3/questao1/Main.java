package questao1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Cliente trabalha apenas com a interface Ave, sem conhecer
        // as classes concretas Pato e Pavao.
        List<Ave> aves = new ArrayList<>();

        aves.add(new PatoAdapter(new PatoDomestico()));
        aves.add(new PavaoAdapter(new PavaoAzul()));

        for (Ave ave : aves) {
            ave.emitirSom();
            ave.voar();
            System.out.println("-----------------------------");
        }
    }
}
