
public class AppleFactory implements FabricanteCelular{
 private static AppleFactory instance;
 private AppleFactory(){}
 public static AppleFactory getInstance(){ if(instance==null) instance=new AppleFactory(); return instance; }
 public Celular constroiCelular(String modelo){ return modelo.equals("IPhoneX")?new IPhoneX():new IPhoneS();}
}