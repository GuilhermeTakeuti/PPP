
public class HondaMaker implements IVehicleMaker{
 private static HondaMaker instance;
 private HondaMaker(){}
 public static HondaMaker getInstance(){ if(instance==null) instance=new HondaMaker(); return instance; }
 public IVehicle makeVehicle(String modelo){
   switch(modelo){case "City": return new City(); case "Civic": return new Civic(); default:return new Fit();}
 }
}