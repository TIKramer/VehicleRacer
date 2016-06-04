/***************************************************************************
 * Author: Thomas Kramer                                                   *
 * Purpose: The MainMenu of the program allows the user to make choices and*
 *          interact with the program                                      *
 * Date: Date: 04/06/2016 1:20pm                                                *
 **************************************************************************/
public class MainMenu
{
    private Race race;
    private UserInput input;

    /*****************************************************************************
    * Default Constructor: Purpose: To construct a default object of MainMenu    *
    * Date: 04/06/2016 1:20pm                                                   *
    * IMPORT: none                                                               *
    * EXPORT: address of new MainMenu object                                     *
    * ASSERTION: default Race and default UserInput is the                      *
    *            default state for MainMenu                                      *
    *****************************************************************************/
    public MainMenu()
    {
        race = new Race();
        input = new UserInput();
    }

    /************************************************************************
    *SUBMODULE: mainMenu                                                    *
    * Purpose: A Main Menu in console that displays options to the user     *
    * Date: 04/06/2016 1:20pm                                              *                            
    *IMPORT: none                                                           *
    *EXPORT: none                                                           *
    *ASSERTION:                                                             *
    ************************************************************************/
    public void mainMenu()
    {
        int selection = -1;
        int numOfSelectionsAboveZero = 2;
        while (!validateSelection(selection, numOfSelectionsAboveZero))
        {
            selection = input.retrieveIntFromUser("Please enter: " + "\n\t 1: To Add a new Vehicle"
                    + "\n\t 2: To Start Race" + "\n\t 0: To Exit");

            if (!validateSelection(selection, numOfSelectionsAboveZero))
            {
                System.out.println("Invalid input, must enter a interger value between 0 and "
                        + numOfSelectionsAboveZero);
            }
        }
        switch (selection)
        {
            case 1:
                addVehicleMenu();
                mainMenu();
                break;
            case 2:
                race.startRace();
                mainMenu();
                break;
            case 3:
            default:
                // exit();
                break;
        }

    }

    /************************************************************************
    *SUBMODULE: addVehicleMenu                                              *
    * Purpose: A Menu in console that display options to the user           *
    *          for adding a new Vehicle or returning to the main menu       *
    * Date: 04/06/2016 1:20pm                                              *                            
    *IMPORT: none                                                           *
    *EXPORT: none                                                           *
    *ASSERTION:                                                             *
    ************************************************************************/
    public void addVehicleMenu()
    {
        int selection = -1;
        int numOfSelectionsAboveZero = 2;

        while (!validateSelection(selection, numOfSelectionsAboveZero))
        {

            selection = input.retrieveIntFromUser("Please enter: " + "\n\t 1: To Add a Limo" + "\n\t 2: To Add a Bus"
                    + "\n\t 0: To Return To Main Menu");

            if (!validateSelection(selection, numOfSelectionsAboveZero))
            {
                System.out.println("Invalid input, must enter a interger value between 0 and "
                        + numOfSelectionsAboveZero);
            }

        }

        switch (selection)
        {

            case 1:
                createLimo();
                break;
            case 2:
                createBus();
                break;
            default:
                mainMenu();
                break;
        }
    }
    /************************************************************************
     *SUBMODULE: createEngine                                                *
     * Purpose: creates a new EngineClass object from user input             *
     * Date: 04/06/2016 1:20pm                                              *                            
     *IMPORT: none                                                           *
     *EXPORT: engine (EngineClass)                                           *
     *ASSERTION:                                                             *
     ************************************************************************/
    private EngineClass createEngine()
    {
        EngineClass engine = new EngineClass();
        boolean validNumCylinders = false;
        boolean validHorsePower = false;
        while (!validNumCylinders)
        {
            try
            {
                int numOfCylinders = input.retrieveIntFromUser("Please enter the number of cylinders for the engine:");
                engine.setNumCylinders(numOfCylinders);
                validNumCylinders = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e);
            }
        }
        while (!validHorsePower)
        {
            try
            {
                double horsePower = input
                        .retrieveDoubleFromUser("Please enter the number of Horse Power for the engine:");
                engine.setHorsePower(horsePower);
                validHorsePower = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e);
            }
        }
        engine.setFuelType(retrieveFuelType());
        return engine;
    }
    /************************************************************************
    *SUBMODULE: createMotorVehicle                                          *
    * Purpose: creates a new MotorVehicleClass object from user input       *
    * Date: 04/06/2016 1:20pm                                              *                            
    *IMPORT: none                                                           *
    *EXPORT: vehicle (MotorVehicleClass)                                    *
    *ASSERTION:                                                             *
    ************************************************************************/
    private MotorVehicleClass createMotorVehicle()
    {
        MotorVehicleClass vehicle = new MotorVehicleClass();
        EngineClass engine = createEngine();
        vehicle.setEngine(engine);
        boolean validNumOfPassengers = false;
        while (!validNumOfPassengers)
            try
            {
                int numOfPassengers = input.retrieveIntFromUser("Please enter the number of passengers: ");
                vehicle.setNumOfPassengers(numOfPassengers);
                validNumOfPassengers = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e);
            }

        String vehicleRegistration = input.readString("Please enter the vehicle Registration: ");
        vehicle.setVehicleRegistration(vehicleRegistration);
        WheelClass[] wheels = createWheelArray();
        vehicle.setWheels(wheels);

        return vehicle;
    }

     /***********************************************************************************
     *SUBMODULE: createBus                                                              *
     * Purpose: creates a new bus object from user input and adds it to the race object *
     * Date: 04/06/2016 1:20pm                                                         *                            
     *IMPORT: none                                                                      *
     *EXPORT: none                                                                      *
     *ASSERTION:                                                                        *
     ***********************************************************************************/
    public void createBus()
    {
        MotorVehicleClass motorVehicle = createMotorVehicle();
        String[] busRoutes = createBusRoutes();

        Bus bus = new Bus(motorVehicle);
        bus.setBusRoute(busRoutes);
        boolean validBusNumber = false;
        while (!validBusNumber)
        {
            try
            {
                int busNumber = input.retrieveIntFromUser("Please enter the bus number: ");
                bus.setBusNumber(busNumber);
                validBusNumber = true;

            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e);
            }
        }

        race.addToRacers(bus);

    }
     /************************************************************************************
     *SUBMODULE: createLimo                                                              *
     * Purpose: creates a new limo object from user input and adds it to the race object *
     * Date: 04/06/2016 1:20pm                                                          *                            
     *IMPORT: none                                                                       *
     *EXPORT: none                                                                       *
     *ASSERTION:                                                                         *
     ************************************************************************************/
    public void createLimo()
    {

        MotorVehicleClass motorVehicle = createMotorVehicle();
        String limoLighting = input.readString("Please enter the lighting of the limo: ");
        boolean bar = false;

        int barSelection = -1;
        while (barSelection < 0 || barSelection > 1)
        {
            barSelection = input.retrieveIntFromUser("Does the limo have a bar attached:" + "\nType: 0 if no bar."
                    + "\n Type: 1 if bar is attached ");
            if (barSelection == 1)
            {
                bar = true;
            }
            else if (barSelection == 0)
            {
                bar = false;
            }
            else
            {
                System.out.println("Invalid inputm ust be 1 or 0");
            }

        }
        Limo newLimo = new Limo(motorVehicle.getEngine(), motorVehicle.getNumOfPassengers(),
                motorVehicle.getVehicleRegistration(), motorVehicle.getWheels(), limoLighting, bar);
        race.addToRacers(newLimo);
    }
   
     /************************************************************************
     *SUBMODULE: createWheel                                                 *
     * Purpose: creates a new WheelClass object from user input              *
     * Date: 04/06/2016 1:20pm                                              *                            
     *IMPORT: none                                                           *
     *EXPORT: wheel (WheelClass)                                             *
     *ASSERTION:                                                             *
     ************************************************************************/
    private WheelClass createWheel(int wheelNumber)
    {
        WheelClass wheel = new WheelClass();
        String wheelSize = input.readString("Please enter the wheel#" + (wheelNumber) + " size as a string :  ");
        wheel.setSize(wheelSize);
        boolean validAirPressure = false;
        while (!validAirPressure)
        {
            try
            {
                Double airPressure = input.retrieveDoubleFromUser("Please enter the air pressure of the wheel: ");
                wheel.setAirPressure(airPressure);
                validAirPressure = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e);
            }
        }
        String wheelMake = input.readString("Please enter the wheel make as a string: ");
        wheel.setMake(wheelMake);
        return wheel;
    }
     /************************************************************************
     *SUBMODULE: createWheelArray                                            *
     * Purpose: creates a new array of WheelClass objects using user input   *
     * Date: 04/06/2016 1:20pm                                              *                            
     *IMPORT: none                                                           *
     *EXPORT: wheelArray (array of WheelClass)                               *
     *ASSERTION:                                                             *
     ************************************************************************/
    private WheelClass[] createWheelArray()
    {
        int numOfWheels = input.retrieveIntFromUser("Please enter the number of wheels for this Vehicle:");
        WheelClass[] wheelArray = new WheelClass[numOfWheels];
        for (int i = 0; i < numOfWheels; i++)
        {
            wheelArray[i] = createWheel(i + 1);
        }
        return wheelArray;
    }
    /************************************************************************
     *SUBMODULE: validateSelection                                           *
     * Purpose: validates if the user selection is within the max value      *
     * Date: 04/06/2016 1:20pm                                              *                            
     *IMPORT: inSelection (int), maxSelctionValue (int)                      *
     *EXPORT: valid (boolean)                                                *
     *ASSERTION:                                                             *
     ************************************************************************/
    public boolean validateSelection(int inSelection, int maxSelctionValue)
    {
        boolean valid = false;
        if (inSelection >= 0 && inSelection <= maxSelctionValue)
        {
            valid = true;
        }
        return valid;
    }
     /************************************************************************
     *SUBMODULE: createBusRoutes                                             *
     * Purpose: creates a new array of BusRoutes from user input             *
     * Date: 04/06/2016 1:20pm                                              *                            
     *IMPORT: none                                                           *
     *EXPORT: busRoutes (array of String)                                    *
     *ASSERTION:                                                             *
     ************************************************************************/
    private String[] createBusRoutes()
    {
        int numOfBusRoutes = input.retrieveIntFromUser("Please enter the number of bus routes: ");
        String[] busRoutes = new String[numOfBusRoutes];
        for (int i = 0; i < numOfBusRoutes; i++)
        {
            busRoutes[i] = createBusRoute();
        }
        return busRoutes;
    }
    /********************************************************************************************
     *SUBMODULE: retrieveFuelType                                                                *
     * Purpose: returns a fuel type if the users input is a valid fuel                           *  
     * Date: 04/06/2016 1:20pm                                                                  *                            
     *IMPORT: none                                                                               *
     *EXPORT: validFuel (String)                                                                 *
     *ASSERTION:                                                                                 *
     ********************************************************************************************/
    private String retrieveFuelType()
    {
        String[] fuels = EngineClass.FUELTYPES;
        boolean validFuelSelection = false;
        String validFuel = "";
        while (!validFuelSelection)
        {
            for (int i = 0; i < fuels.length; i++)
            {
                System.out.println(fuels[i]);
            }
            String inFuel = input.readString("Please enter one of the above fuels: ");
            for (int i = 0; i < fuels.length; i++)
            {

                if (inFuel.equals(fuels[i]))
                {
                    validFuel = inFuel;
                    validFuelSelection = true;
                }
            }
        }
        return validFuel;

    }
     /************************************************************************
     *SUBMODULE: createBusRoute                                              *
     * Purpose: creates a new busRoute from user input                       *
     * Date: 04/06/2016 1:20pm                                              *                            
     *IMPORT: none                                                           *
     *EXPORT: str (String)                                                   *
     *ASSERTION:                                                             *
     ************************************************************************/
    private String createBusRoute()
    {
        String origin = input.readString("Please enter the route origin: ");
        String destination = input.readString("Please enter the destination: ");
        return "Orgin: " + origin + " To: " + "Destination: " + destination;
    }

}
