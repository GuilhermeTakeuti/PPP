
public class SamsungFactory implements FabricanteCelular{
 private static SamsungFactory instance;
 private SamsungFactory(){}
 public static SamsungFactory getInstance(){ if(instance==null) instance=new SamsungFactory(); return instance; }
 public Celular constroiCelular(String modelo){ return modelo.equals("Galaxy8")?new Galaxy8():new Galaxy20();}
}