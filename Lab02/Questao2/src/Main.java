
public class Main {
 public static void main(String[] args){
   IVehicleMaker toyota=ToyotaMaker.getInstance();
   IVehicle corolla=toyota.makeVehicle("Corolla");
   corolla.start(); corolla.drive(); corolla.stop();

   IVehicleMaker honda=HondaMaker.getInstance();
   IVehicle civic=honda.makeVehicle("Civic");
   civic.start(); civic.drive(); civic.stop();
 }
}