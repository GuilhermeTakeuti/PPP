package lab7.questao1;

public class MensagemVisitor implements VeiculoVisitor {
    @Override
    public void visitar(Carro carro) {
        System.out.println("📱 MENSAGEM PARA DONO DO CARRO:");
        System.out.println("  \"Favor atualizar dados do IPVA\"");
        System.out.println("  Veículo: " + carro.getMarca() + " " + carro.getModelo());
    }

    @Override
    public void visitar(Onibus onibus) {
        System.out.println("📱 MENSAGEM PARA DONO DO ÔNIBUS:");
        System.out.println("  \"Atenção para atualização das licenças\"");
        System.out.println("  Ônibus: " + onibus.getQuantidadeLugares() + " lugares");
    }

    @Override
    public void visitar(Bicicleta bicicleta) {
        System.out.println("📱 MENSAGEM PARA DONO DA BICICLETA:");
        System.out.println("  \"Comemore no parque o dia do ciclismo\"");
        System.out.println("  Bicicleta: " + bicicleta.getCor());
    }
}
