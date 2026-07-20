package lab4.facade.facade;

public class Cinemateca {
    public static void main(String[] args) {
        Amplificador amplificador = new Amplificador();
        Luzes luzes = new Luzes();
        MaquinaPipoca maquinaPipoca = new MaquinaPipoca();
        Projetor projetor = new Projetor();
        PlayerStreaming player = new PlayerStreaming();
        Telao telao = new Telao();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
            amplificador, luzes, maquinaPipoca, projetor, player, telao
        );

        homeTheater.assistirFilme("O Senhor dos Anéis");
        homeTheater.fimDoFilme();
    }
}
