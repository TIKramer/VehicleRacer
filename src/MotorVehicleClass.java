/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds information about a MotorVehicle   * 
 * Date: 15/04/2016 3:23apm                                     *
 ***************************************************************/
public class MotorVehicleClass implements Transport
{
    final public int MINIMUM_NUM_OF_WHEELS = 4;
    private EngineClass engine;
    private int numOfPassengers;
    private String vehicleRegistration;
    private WheelClass wheels[];
    private double velocity = 0;
    final public double maxVelocity = 220.0;

    /********************************************************************
    *Default Constructor:                                               *
    *Purpose: To construct a default object of MotorVehicleClass        *
    *Date: 04/06/2016 1:20pm                                            *
    *IMPORT: none                                                       *
    *EXPORT: address of new MotorVehicleClass object                    *
    *ASSERTION: Default EngineClass, 0 passengers, null registration,   *
    *          0 velocity and [MINIMUM_NUM_OF_WHEELS] of default wheels *       
    ********************************************************************/
    public MotorVehicleClass()
    {
        engine = new EngineClass();
        numOfPassengers = 0;
        vehicleRegistration = null;
        velocity = 0;
        wheels = new WheelClass[MINIMUM_NUM_OF_WHEELS];
        for (int i = 0; i < wheels.length; i++)
        {
            wheels[i] = new WheelClass();
        }

    }

    /******************************************************************************
     *Alternate #1 Constructor:                                                    *
     *Purpose: To construct a object of MotorVehicleClass using imported values    *
     *Date: 04/06/2016 1:20pm                                                      *
     *IMPORT: inEngine (EngineClass), inNumOfPassengers (int),                     *
     *        inVehicleRegistration (String), inWheels (Array of Wheel Class)      *
     *EXPORT: address of new UniEvent object                                       *
     *ASSERTION: Creates the object if the imports are valid and FAILS otherwise   *
     ******************************************************************************/
    public MotorVehicleClass(EngineClass inEngine, int inNumOfPassengers, String inVehicleRegistration,
            WheelClass[] inWheels)
    {
        if (validateNumOfPassengers(inNumOfPassengers) && validateWheelArray(inWheels))
        {
            engine = inEngine;
            numOfPassengers = inNumOfPassengers;
            vehicleRegistration = inVehicleRegistration;
            wheels = inWheels;
        }
        else
        {
            throw new IllegalArgumentException("Invalid inputs!");
        }
    }

    /************************************************************
     *Copy Constructor:
     *IMPORT: inMotorVehicle (MotorVehicleClass)
     *EXPORT: address of new MotorVehicleClass object
     *ASSERTION: Creates an object with an identical object state as the import.
     ************************************************************/
    public MotorVehicleClass(MotorVehicleClass inMotorVehicle)
    {
        engine = inMotorVehicle.getEngine();
        numOfPassengers = inMotorVehicle.getNumOfPassengers();
        vehicleRegistration = inMotorVehicle.getVehicleRegistration();
        wheels = new WheelClass[inMotorVehicle.getWheels().length];
        for (int i = 0; i < inMotorVehicle.getWheels().length; i++)
        {
            wheels[i] = inMotorVehicle.getWheels()[i];
        }
    }

    //MUTATORS
    /**********************************************************************
    *SUBMODULE: setEngine                                                 *
    *Purpose: To change/set engine to a copy of the import                *
    *Date: 04/06/2016 1:20pm                                              *
    *IMPORT: inEngine (EngineClass)                                       *
    *EXPORT: none                                                         *
    *ASSERTION: sets engine to a copy of inEngine.                        *
    **********************************************************************/

    public void setEngine(EngineClass inEngine)
    {
        engine = new EngineClass(inEngine);
    }

    /**********************************************************************
     *SUBMODULE: setNumOfPassengers                                        *
     *Purpose: To change/set passengers to a copy of the import            *
     *Date: 04/06/2016 1:20pm                                              *
     *IMPORT: inPassengers (int)                                           *
     *EXPORT: none                                                         *
     *ASSERTION: sets passengers to a inPassengers if valid else FAILS     *
     **********************************************************************/
    public void setNumOfPassengers(int inPassengers)
    {
        if (validateNumOfPassengers(inPassengers))
        {
            numOfPassengers = inPassengers;
        }
        else
        {
            throw new IllegalArgumentException("Invalid value passed for numOfPassengers");
        }
    }

    public void setVehicleRegistration(String inVehicleRegistration)
    {
        vehicleRegistration = new String(inVehicleRegistration);
    }

    /**********************************************************************
     *SUBMODULE: setWheels                                                 *
     *Purpose: To change/set passengers to a copy of the import            *
     *Date: 04/06/2016 1:20pm                                              *
     *IMPORT: inWheels (array of WheelClass)                               *
     *EXPORT: none                                                         *
     *ASSERTION: sets wheels to a copy of inWheels if valid else FAILS     *
     **********************************************************************/
    public void setWheels(WheelClass[] inWheels)
    {
        if (validateWheelArray(inWheels))
        {
            WheelClass[] wheelsCopy = new WheelClass[inWheels.length];
            for (int i = 0; i < inWheels.length; i++)
            {
                wheelsCopy[i] = new WheelClass(inWheels[i]);
            }
            wheels = wheelsCopy;
        }
        else
        {
            throw new IllegalArgumentException("Invalid value passed to Wheels");
        }

    }

    //ACCESSORS
    /************************************************************
    *SUBMODULE: getEngine                                       *
    *Purpose: To get the value of engine from the object        *
    *Date: 04/06/2016 1:20pm                                    *
    *IMPORT: none                                               *
    *EXPORT: engine                                             *
    *ASSERTION: returns a copy of engine                        *
    ************************************************************/
    public EngineClass getEngine()
    {
        return new EngineClass(engine);
    }

    /**************************************************************
    *SUBMODULE: getNumOfPassengers                                *
    *Purpose: To get the value of numOfPassengers from the object *
    *Date: 04/06/2016 1:20pm                                      *
    *IMPORT: none                                                 *
    *EXPORT: numOfPassengers                                      *
    *ASSERTION: returns numOfPassengers                           *
    **************************************************************/
    public int getNumOfPassengers()
    {
        return numOfPassengers;
    }

    /*******************************************************************
     *SUBMODULE: getVehicleRegistration                                *
     *Purpose: To get the value of vehicleRegistration from the object *
     *Date: 04/06/2016 1:20pm                                          *
     *IMPORT: none                                                     *
     *EXPORT: numOfPassengers                                          *
     *ASSERTION: returns numOfPassengers                               *
     ******************************************************************/
    public String getVehicleRegistration()
    {
        return new String(vehicleRegistration);
    }

    /**************************************************************
     *SUBMODULE: getWheels                                        *
     *Purpose: To get the value of wheels from the object         *
     *Date: 04/06/2016 1:20pm                                     *
     *IMPORT: none                                                *
     *EXPORT: wheelsCopy                                          *
     *ASSERTION: returns a copy of wheels                         *
     *************************************************************/
    public WheelClass[] getWheels()
    {
        WheelClass[] wheelsCopy = new WheelClass[wheels.length];
        for (int i = 0; i < wheels.length; i++)
        {
            wheelsCopy[i] = new WheelClass(wheels[i]);
        }
        return wheelsCopy;
    }

    //PRIVATE SUBMODULES:
    /************************************************************************
    *SUBMODULE: validateNumOfPassengers                                     *
    * Purpose: To check if inPassengers is valid                            *
    * Date: 04/06/2016 1:20pm                                               *                            
    *IMPORT: inPassengers (int)                                             *
    *EXPORT: valid (boolean)                                                *
    *ASSERTION: inPassengers must be 0 or greater                           *
    ************************************************************************/
    private boolean validateNumOfPassengers(int inPassengers)
    {
        boolean valid = false;
        if (inPassengers >= 0)
        {
            valid = true;
        }
        return valid;

    }

    /************************************************************************
    *SUBMODULE: validateWheelArray                                          *
    * Purpose: To check if inWheels is valid length                         *
    * Date: 04/06/2016 1:20pm                                               *                            
    *IMPORT:  inWheels (array of WheelClass)                                *
    *EXPORT:   valid (boolean)                                              *
    *ASSERTION: inWheels length must be 2 or greater                        *
    ************************************************************************/
    private boolean validateWheelArray(WheelClass[] inWheels)
    {
        boolean valid = false;
        if (inWheels.length >= 2)
        {
            valid = true;
        }
        return valid;
    }

    /********************************************************************
    * SUBMODULE: equals                                                 *
    * Purpose: To compare if two MotorVehicleClass objects are the same *
    * Date: 04/06/2016 1:20pm                                           *
    * IMPORT: inObj (Object)                                            *
    * EXPORT: same                                                      *
    * ASSERTION:Two MotorVehicleClass objects are the same if they have *
    *          the same wheels, engine and number of passengers         *
    ********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof MotorVehicleClass)
        {
            MotorVehicleClass inMotorVehicle = (MotorVehicleClass) inObj;
            boolean validWheels = true;
            for (int i = 0; i < wheels.length; i++)
            {
                if (wheels[i] != inMotorVehicle.getWheels()[i])
                {
                    validWheels = false;
                }
            }
            same = validWheels && engine == inMotorVehicle.getEngine()
                    && numOfPassengers == inMotorVehicle.getNumOfPassengers();
        }
        return same;
    }

    /*********************************************************************
     * SUBMODULE: toString                                               * 
     * Purpose: To return a string of the MotorVehicleClass object       *
     * Date: 04/06/2016 1:20pm                                           *
     * IMPORT: none                                                      *
     * EXPORT: str (String)                                              *
     * ASSERTION:                                                        *
     ********************************************************************/
    public String toString()
    {
        String strWheels = "Wheels attached are: ";
        for (int i = 0; i < wheels.length; i++)
        {
            strWheels += "\n\t\t" + "Wheel " + (i + 1) + ": " + wheels[i].toString() + " .";
        }

        return ("This car has: " + "\n\t" + engine + "\n\t" + strWheels + "\n\t" + "Spaces for passengers: "
                + numOfPassengers + "\n\t" + "Vehicle Registration: " + vehicleRegistration + "Velocity: " + velocity);
    }
    /**************************************************************
     *SUBMODULE: getVelocity                                      *
     *Purpose: To get the value of velocity from the object       *
     *Date: 04/06/2016 1:20pm                                     *
     *IMPORT: none                                                *
     *EXPORT: velocity                                            *
     *ASSERTION: returns velocity                                 *
     *************************************************************/
    public double getVelocity()
    {
        return velocity;
    }
    /**************************************************************
     *SUBMODULE: getVelocity                                      *
     *Purpose: To get the value of velocity from the object       *
     *Date: 04/06/2016 1:20pm                                     *
     *IMPORT: none                                                *
     *EXPORT: velocity                                            *
     *ASSERTION: returns velocity                                 *
     *************************************************************/
    public void setVelocity(double inVelocity)
    {
        velocity = inVelocity;
       
    }

    /******************************************************************
     *SUBMODULE: accelerate                                           *
     *Purpose: changes velocity based on the acceleration calculation *
     *Date: 04/06/2016 1:20pm                                         *
     *IMPORT: none                                                    *
     *EXPORT: none                                                    *
     *ASSERTION:                                                      *
     *****************************************************************/
    public void accelerate()
    {
        double acceleration = this.getEngine().getNumCylinders() * 0.75;
        this.setVelocity(acceleration);

    }
    /******************************************************************
     *SUBMODULE: decelerate                                           *
     *Purpose: changes velocity based on the decelerate calculation   *
     *Date: 04/06/2016 1:20pm                                         *
     *IMPORT: none                                                    *
     *EXPORT: none                                                    *
     *ASSERTION:                                                      *
     *****************************************************************/
    public void decelerate()
    {
        double deceleration = ((42 / this.getWheels().length) + 1 / this.getNumOfPassengers());
        this.setVelocity(deceleration);

    }

}
