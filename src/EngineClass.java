/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds information about an engine        * 
 * Date: 04/06/2016 1:20pm                                      *
 ***************************************************************/
public final class EngineClass
{
    // Class constants
    public static final String[] FUELTYPES =
    { "ULP", "PULP", "DIESEL", "LPG", "98RON" };

    private int numCylinders;
    private double horsePower;
    private String fuelType;

    /***********************************************************************
     *Default Constructor:                                                 *
     *Purpose: To construct a default object of EngineClass                *
     *Date: 04/06/2016 1:20pm                                              *
     *IMPORT: none                                                         *
     *EXPORT: address of new EngineClass object                            *
     *ASSERTION: A bus with 4 cylinders, 200 horsePower and using DIESEL   *
     *           fuel is the default state of an engine                    *       
     **********************************************************************/
    public EngineClass()
    {
        numCylinders = 4;
        horsePower = 200;
        fuelType = "DIESEL";

    }

    /******************************************************************************
    *Alternate #1 Constructor:                                                    *
    *Purpose: To construct a object of EngineClass using imported values          *
    *Date: 04/06/2016 1:20pm                                                      *
    *IMPORT: inNumCylinders (int), inHorsePower (double), inFuelType (String)     *
    *EXPORT: address of new EngineClass object                                    *
    *ASSERTION: Creates the object if the imports are valid and FAILS otherwise   *
    ******************************************************************************/
    public EngineClass(int inNumCylinders, double inHorsePower, String inFuelType)
    {
        if (validateNumCylinders(inNumCylinders) && validateHorsePower(inHorsePower) && validateFuelType(inFuelType))
        {
            numCylinders = inNumCylinders;
            horsePower = inHorsePower;
            fuelType = new String(inFuelType);
        }
        else
        {
            throw new IllegalArgumentException("Invalid Import Values");
        }
    }

    /*****************************************************************************
     *Copy Constructor:                                                           *
     *Purpose: To create a new object with the same object state as the import    *
     *Date: 04/06/2016 1:20pm                                                     *
     *IMPORT: inEngine (EngineClass)                                              *
     *EXPORT: address of new EngineClass object                                   *
     *ASSERTION: Creates an object with an identical object state as the import.  *
     *****************************************************************************/
    public EngineClass(EngineClass inEngine)
    {
        numCylinders = inEngine.getNumCylinders();
        horsePower = inEngine.getHorsePower();
        fuelType = new String(inEngine.getFuelType());
    }

    public int getNumCylinders()
    {
        return numCylinders;

    }

    public double getHorsePower()
    {
        return horsePower;
    }

    public String getFuelType()
    {
        return new String(fuelType);
    }

    //MUTATORS
    /*********************************************************************
    *SUBMODULE: setNumCylinders                                          *
    *Purpose: To change/set numCylinders to import                       *
    *Date: 04/06/2016 1:20pm                                             *
    *IMPORT: inNumCylinders (int)                                        *
    *EXPORT: none                                                        *
    *ASSERTION: sets numCylinders to inNumCylinders if valid else FAILS  *
    *********************************************************************/
    public void setNumCylinders(int inNumCylinders)
    {
        if (validateNumCylinders(inNumCylinders))
        {
            numCylinders = inNumCylinders;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Number of Cylinders");
        }
    }

    /****************************************************************
    *SUBMODULE: setHorsePower                                       *
    *Purpose: To change/set horsePower to import                    *
    *Date: 04/06/2016 1:20pm                                        *
    *IMPORT: inHorsePower (double)                                  *
    *EXPORT: none                                                   *
    *ASSERTION: sets horsePower inHorsePower if valid else FAILS    *
    ****************************************************************/
    public void setHorsePower(double inHorsePower)
    {
        if (validateHorsePower(inHorsePower))
        {
            horsePower = inHorsePower;
        }
        else
        {
            throw new IllegalArgumentException("Invalid number of horse power");
        }
    }

    /**************************************************************************
    *SUBMODULE: setFuelType                                                   *
    *Purpose: To change/set fuelType to import                                *
    *Date: 04/06/2016 1:20pm                                                  *
    *IMPORT: inFuelType (String)                                              *
    *EXPORT: none                                                             *
    *ASSERTION: sets fuelType to a copy of inFuelType if valid else FAILS     *
    **************************************************************************/
    public void setFuelType(String inFuelType)
    {
        if (validateFuelType(inFuelType))
        {
            fuelType = new String(inFuelType);
        }
        else
        {
            throw new IllegalArgumentException("Invalid Fuel Type");
        }
    }

    //PRIVATE SUBMODULES:
    /*******************************************************************************************
    *SUBMODULE: validateNumCylinders                                                           *
    * Purpose: To check if inNumCylinders is a valid number of Cylinders                       *  
    * Date: 04/06/2016 1:20pm                                                                  *                            
    *IMPORT: inNumCylinders (int)                                                              *
    *EXPORT: valid (boolean)                                                                   *
    *ASSERTION:  a valid number of cylinders is greater than or equal to 4 and an even number  *
    *******************************************************************************************/
    private boolean validateNumCylinders(int inNumCylinders)
    {
        boolean valid = false;
        if (inNumCylinders >= 4 && inNumCylinders % 2 == 0)
        {
            valid = true;
        }
        return valid;

    }

    /********************************************************************************************
    *SUBMODULE: validateHorsePower                                                              *
    * Purpose: To check if inHorsePower is a valid number of horsePower                         *  
    * Date: 04/06/2016 1:20pm                                                                   *                            
    *IMPORT: inHorsePower (double)                                                              *
    *EXPORT: valid (boolean)                                                                    *
    *ASSERTION:  a valid number of horsePower is greater than 0 and less than or equal to 640.0 *
    ********************************************************************************************/
    private boolean validateHorsePower(double inHorsePower)
    {
        boolean valid = false;
        if (inHorsePower > 0.0 && inHorsePower <= 640.0)
        {
            valid = true;
        }
        return valid;
    }

    /********************************************************************************************
    *SUBMODULE: validateFuelType                                                                *
    * Purpose: To check if inFuelType is a valid fuel                                           *  
    * Date: 04/06/2016 1:20pm                                                                   *                            
    *IMPORT: inFuelType (String)                                                                *
    *EXPORT: valid (boolean)                                                                    *
    *ASSERTION:  a valid fuleType is a fuel that matches an element in FUELTYPES                *
    ********************************************************************************************/
    private boolean validateFuelType(String inFuelType)
    {
        boolean valid = false;
        for (int i = 0; i < FUELTYPES.length; i++)
        {
            if (inFuelType.equals(FUELTYPES[i]))
            {
                valid = true;
            }
        }
        return valid;
    }
     /***********************************************************************
     * SUBMODULE: equals                                                    *
     * Purpose: To compare if two EngineClass objects are the same          *
     * Date: 04/06/2016 1:20pm                                              *
     * IMPORT: inObj (Object)                                               *
     * EXPORT: same                                                         *
     * ASSERTION:Two EngineClass objects are the same if they have the same *
     *          numCylinders, horsePower and fuelType                       *
     ***********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof EngineClass)
        {
            EngineClass inEngine = (EngineClass) inObj;
            same = (numCylinders == inEngine.getNumCylinders() && horsePower == inEngine.getHorsePower() && fuelType
                    .equals(inEngine.getFuelType()));

        }
        return same;
    }
    /*********************************************************************
     * SUBMODULE: toString                                               * 
     * Purpose: To return a string of the EngineClass object             *
     * Date: 04/06/2016 1:20pm                                           *
     * IMPORT: none                                                      *
     * EXPORT: str (String)                                              *
     * ASSERTION:                                                        *
     ********************************************************************/
    public String toString()
    {
        return ("This engine has " + numCylinders + " cylinders, " + horsePower + " horse power" + " and uses "
                + fuelType + " fuel");
    }

}
