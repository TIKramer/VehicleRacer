/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds information about a Bus            * 
 * Date: 04/06/2016 1:20pm                                      *
 ***************************************************************/

public class Bus extends MotorVehicleClass
{
    final int MINIMUM_NUM_OF_ROUTES = 1;
    private String busRoutes[];
    private int busNumber;
    final public double maxVelocity = 110.0;

    /***********************************************************************
     *Default Constructor:                                                 *
     *Purpose: To construct a default object of Bus                        *
     *Date: 04/06/2016 1:20pm                                            *
     *IMPORT: none                                                         *
     *EXPORT: address of new Bus object                                    *
     *ASSERTION: Default Super class, busRoutes size MINIMUM_NUM_OF_ROUTES *
     *          busRoute "Curtin to Gosnells" and a bus number 001 is the  *
     *          default state of a bus                                     *       
     **********************************************************************/
    public Bus()
    {
        super();
        busRoutes = new String[MINIMUM_NUM_OF_ROUTES];
        busRoutes[0] = "Curtin to Gosnells";
        busNumber = 001;
    }

     /******************************************************************************
     *Alternate #1 Constructor:                                                    *
     *Purpose: To construct a object of Bus using imported values                  *
     *Date: 04/06/2016 1:20pm                                                    *
     *IMPORT: inEngine (EngineClass), inNumOfPassengers (int),                     *
     *        inVehicleRegistration (String), inWheels (Array of Wheel Class,      *
     *        inRoutes (array of string), inBusNumber (int)                        *
     *EXPORT: address of new UniEvent object                                       *
     *ASSERTION: Creates the object if the imports are valid and FAILS otherwise   *
     ******************************************************************************/
    public Bus(EngineClass inEngine, int inNumOfPassengers, String inVehicleRegistration, WheelClass[] inWheels,
            String inRoutes[], int inBusNumber)
    {
        super(inEngine, inNumOfPassengers, inVehicleRegistration, inWheels);
        if (validateBusRoutes(inRoutes))
        {
            String[] busRoutesCopy = new String[inRoutes.length];
            for (int i = 0; i < inRoutes.length; i++)
            {
                busRoutesCopy[i] = inRoutes[i];
            }
            busRoutes = busRoutesCopy;
            busNumber = inBusNumber;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Bus Route input");
        }
    }
    
     /******************************************************************************
     *Alternate #2 Constructor:                                                    *
     *Purpose: To construct a object of Bus using imported MotorVehicleClass       *
     *Date: 04/06/2016 1:20pm                                                    *
     *IMPORT: inMotorVehicle (MotorVehicleClass)                                   *
     *EXPORT: address of new Bus object                                            *
     *ASSERTION: Creates the object using super MotorVehicleClass,                 *
     *          busRoutes size MINIMUM_NUM_OF_ROUTES busRoute "Curtin to Gosnells" *
     *           and a bus number 001 is the default state of a bus                *  
     ******************************************************************************/
    public Bus(MotorVehicleClass inMotorVehicle)
    {
        super(inMotorVehicle);
        busRoutes = new String[MINIMUM_NUM_OF_ROUTES];
        busRoutes[0] = "Curtin";
        busNumber = 001;

    }

     /*****************************************************************************
     *Alternate #3 Constructor:                                                   *
     *Purpose: To construct a object of Bus using imported values                 *
     *Date: 04/06/2016 1:20pm                                                   *
     *IMPORT: inMotorVehicle (MotorVehicleClass), inRoutes (array of string),     *
     *        inBusNumber (int)                                                   *
     *EXPORT: address of new Bus object                                           *
     *ASSERTION: Creates the object if imports are valid else fails               *  
     ******************************************************************************/
    public Bus(MotorVehicleClass inMotorVehicle, String inRoutes[], int inBusNumber)
    {
        super(inMotorVehicle);
        if (validateBusRoutes(inRoutes))
        {
            String[] busRoutesCopy = new String[inRoutes.length];
            for (int i = 0; i < inRoutes.length; i++)
            {
                busRoutesCopy[i] = inRoutes[i];
            }
            busRoutes = busRoutesCopy;
            busNumber = inBusNumber;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Bus Route input");
        }

    }


     /*****************************************************************************
     *Copy Constructor:                                                           *
     *Purpose: To create a new object with the same object state as the import    *
     *Date: 04/06/2016 1:20pm                                                   *
     *IMPORT: inBus (Bus)                                                         *
     *EXPORT: address of new Bus object                                           *
     *ASSERTION: Creates an object with an identical object state as the import.  *
     *****************************************************************************/
    public Bus(Bus inBus)
    {
        super(inBus);
        String[] busRoutesCopy = new String[inBus.getBusRoutes().length];
        for (int i = 0; i < inBus.getBusRoutes().length; i++)
        {
            busRoutesCopy[i] = inBus.getBusRoutes()[i];
        }
        busRoutes = busRoutesCopy;
        busNumber = inBus.getBusNumber();

    }

  
    /********************************************************************
    * SUBMODULE: equals                                                 *
    * Purpose: To compare if two Bus objects are the same               *
    * Date: 04/06/2016 1:20pm                                         *
    * IMPORT: inObj (Object)                                            *
    * EXPORT: same                                                      *
    * ASSERTION:Two bus objects are the same if they have the same      *
    *          super class, same bus routes and same bus number         *
    ********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof Bus)
        {
            Bus inBus = (Bus) inObj;
            same = (super.equals(inBus) && busRoutes.equals(inBus.getBusRoutes()) && busNumber == inBus.getBusNumber());
        }
        return same;
    }
    
     /********************************************************************
     * SUBMODULE: toString                                               * 
     * Purpose: To return a string of the Bus object                     *
     * Date: 04/06/2016 1:20pm                                         *
     * IMPORT: none                                                      *
     * EXPORT: str (String)                                              *
     * ASSERTION:                                                        *
     ********************************************************************/
    public String toString()
    {
        String routeString = "";
        for(int i = 0; i < busRoutes.length; i++)
        {
            routeString = "Routes " + i+1 + ": " + busRoutes[i].toString() + "\n";
        }
        return super.toString() + " Bus Routes: " + routeString + " BusNumber: " + busNumber;
    }

    //MUTATORS
    /**********************************************************************
    *SUBMODULE: setBusRoute                                               *
    *Purpose: To change/set busRoute to import                            *
    *Date: 04/06/2016 1:20pm                                            *
    *IMPORT: inRoutes (array of String)                                   *
    *EXPORT: none                                                         *
    *ASSERTION: sets busRoute to a copy of inRoutes of valid else FAILS   *
    **********************************************************************/
    public void setBusRoute(String[] inRoutes)
    {
        if (validateBusRoutes(inRoutes))
        {
            String[] busRoutesCopy = new String[inRoutes.length];
            for (int i = 0; i < inRoutes.length; i++)
            {
                busRoutesCopy[i] = inRoutes[i];
            }
            busRoutes = busRoutesCopy;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Bus Route input");
        }
    }

    /**********************************************************************
    *SUBMODULE: setBusNumber                                              *
    *Purpose: To change/set busNumber to import                           *
    *Date: 04/06/2016 1:20pm                                            *
    *IMPORT: inBusNumber (int)                                            *
    *EXPORT: none                                                         *
    *ASSERTION: sets busNumber to inBusNumber                             *
    **********************************************************************/
    public void setBusNumber(int inBusNumber)
    {
        busNumber = inBusNumber;
    }

    //ACCESSORS
    /************************************************************
    *SUBMODULE: getBusRoutes                                    *
    *Purpose: To get the value of busRoutes from the object     *
    *Date: 04/06/2016 1:20pm                                  *
    *IMPORT: none                                               *
    *EXPORT: busRoutesCopy (array of String)                    *
    *ASSERTION: returns copy of busRoutes                       *
    ************************************************************/
    public String[] getBusRoutes()
    {
        String[] busRoutesCopy = new String[busRoutes.length];
        for (int i = 0; i < busRoutes.length; i++)
        {
            busRoutesCopy[i] = busRoutes[i];
        }
        return busRoutesCopy;
    }

    /************************************************************
    *SUBMODULE: getBusNumber                                    *
    *Purpose: To get the value of busNumer from the object      *
    *Date: 04/06/2016 1:20pm                                  *
    *IMPORT: none                                               *
    *EXPORT: busNumber (int)                                    *
    *ASSERTION: returns busNumber                               *
    ************************************************************/
    public int getBusNumber()
    {
        return busNumber;
    }

    //PRIVATE SUBMODULES:
    /************************************************************************
    *SUBMODULE: validateBusRoutes                                           *
    * Purpose: To check if inBusRoute is a valid list of routes             *
    * Date: 04/06/2016 1:20pm                                             *                            
    *IMPORT: inBusRoute (Array of Strings)                                  *
    *EXPORT: valid (boolean)                                                *
    *ASSERTION: all buses must have 1 or more routes                        *
    ************************************************************************/
    private boolean validateBusRoutes(String[] inBusRoute)
    {
        boolean valid = false;
        if (inBusRoute.length > MINIMUM_NUM_OF_ROUTES)
        {
            valid = true;
        }
        return valid;
    }

    /******************************************************************
     *SUBMODULE: accelerate                                           *
     *Purpose: changes velocity based on the acceleration calculation *
     *Date: 04/06/2016 1:20pm                                       *
     *IMPORT: none                                                    *
     *EXPORT: none                                                    *
     *ASSERTION:                                                      *
     *****************************************************************/
    public void accelerate()
    {
        double acceleration = ((this.getEngine().getNumCylinders() % 4) + 1) * 1.5;
        this.setVelocity(this.getVelocity() + acceleration);

    }

    /******************************************************************
     *SUBMODULE: decelerate                                           *
     *Purpose: changes velocity based on the decelerate calculation   *
     *Date: 04/06/2016 1:20pm                                       *
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
