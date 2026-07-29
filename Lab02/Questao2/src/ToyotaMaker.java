
public class ToyotaMaker implements IVehicleMaker{
 private static ToyotaMaker instance;
 private ToyotaMaker(){}
 public static ToyotaMaker getInstance(){ if(instance==null) instance=new ToyotaMaker(); return instance; }
 public IVehicle makeVehicle(String modelo){
   switch(modelo){case "Corolla": return new Corolla(); case "Hilux": return new Hilux(); default:return new Etios();}
 }
}