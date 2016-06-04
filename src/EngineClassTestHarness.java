/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class to create test for program                    * 
 * Date: 04/06/2016 1:20pm                                      *
 ***************************************************************/
public class EngineClassTestHarness
{

   
    public static void main(String[] args)
    {
        try{
            MotorVehicleClass myCar = new MotorVehicleClass();
            
            System.out.println(myCar);
            EngineClass[] engine = new EngineClass[3]; 
            engine[0] = new EngineClass();
            engine[1] = new EngineClass(engine[0]);
            engine[2] = new EngineClass(6, 100, "DIESEL");
            WheelClass[] wheelArray = new WheelClass[4];
            wheelArray[0] = new WheelClass(160, 100, 6, 12.00, "STEEL", "Johns Rimmies");
            wheelArray[1] = new WheelClass(222, 112, 6, 12.00, "STEEL", "Johns Rimmies");
            wheelArray[2] = new WheelClass(256, 126, 8, 22.00, "STEEL", "Cool Rims R Us");
            wheelArray[3] = new WheelClass(256, 126, 8, 22.00, "STEEL", "Cool Rims R Us");
            MotorVehicleClass myCar2 = new MotorVehicleClass(engine[2], 2, "2FAST4U",wheelArray);
            System.out.println(myCar2);

            //Print out created objects
            for(int i = 0; i < engine.length; i++){
                System.out.println("Engine " + i + ":" + engine[i].toString());
            }
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (calculate) expected TRUE: " + engine[0].equals(engine[1]));
            
            //getters and setters
            System.out.println("\nGETTERS AND SETTERS:");
            engine[0].setHorsePower(engine[2].getHorsePower());
            System.out.println(engine[0].getHorsePower() + " = " + engine[2].getHorsePower());
           

            
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

    }

}
