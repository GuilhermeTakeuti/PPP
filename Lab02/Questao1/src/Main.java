
public class Main {
    public static void main(String[] args) {
        FabricanteCelular apple = AppleFactory.getInstance();
        Celular iphone = apple.constroiCelular("IPhoneX");
        iphone.fazLigacao();
        iphone.tiraFoto();

        FabricanteCelular samsung = SamsungFactory.getInstance();
        Celular galaxy = samsung.constroiCelular("Galaxy20");
        galaxy.fazLigacao();
        galaxy.tiraFoto();
    }
}
