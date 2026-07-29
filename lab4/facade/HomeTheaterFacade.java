package lab4.facade.facade;

public class HomeTheaterFacade {
    private Amplificador amplificador;
    private Luzes luzes;
    private MaquinaPipoca maquinaPipoca;
    private Projetor projetor;
    private PlayerStreaming player;
    private Telao telao;

    public HomeTheaterFacade(Amplificador amplificador, Luzes luzes,
                             MaquinaPipoca maquinaPipoca, Projetor projetor,
                             PlayerStreaming player, Telao telao) {
        this.amplificador = amplificador;
        this.luzes = luzes;
        this.maquinaPipoca = maquinaPipoca;
        this.projetor = projetor;
        this.player = player;
        this.telao = telao;
    }

    public void assistirFilme(String filme) {
        System.out.println("\n=== Preparando para assistir filme ===");
        maquinaPipoca.ligar();
        maquinaPipoca.arrebentarPipoca();
        luzes.desligar();
        telao.abaixar();
        projetor.ligar();
        amplificador.ligar();
        amplificador.ajustarVolume(10);
        player.ligar();
        player.play(filme);
        System.out.println("=== Filme iniciado! ===");
    }

    public void fimDoFilme() {
        System.out.println("\n=== Finalizando filme ===");
        player.stop();
        player.desligar();
        amplificador.desligar();
        projetor.desligar();
        telao.subir();
        luzes.ligar();
        maquinaPipoca.desligar();
        System.out.println("=== Filme finalizado! ===");
    }
}
