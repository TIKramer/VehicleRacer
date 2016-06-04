/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds information about a Limo           * 
 * Date: 04/06/2016 1:20pm                                      *
 ***************************************************************/
public class Limo extends MotorVehicleClass
{
    // Class fields
    private String lights;
    private boolean bar;
    final public double maxVelocity = 150.0;

    /*********************************************************************
     *Default Constructor:                                               *
     *Purpose: To construct a default object of Limo                     *
     *Date: 04/06/2016 1:20pm                                            *
     *IMPORT: none                                                       *
     *EXPORT: address of new Limo object                                 *
     *ASSERTION: Default Super class, Lights: Bright blue lights,        *
     *          and no bar is the default for a limo                     *       
     ********************************************************************/
    public Limo()
    {
        super();
        lights = "Bright blue lights";
        bar = false;
    }

    /******************************************************************************
    *Alternate #1 Constructor:                                                    *
    *Purpose: To construct a object of Limo using imported values                 *
    *Date: 04/06/2016 1:20pm                                                      *
    *IMPORT: inEngine (EngineClass), inNumOfPassengers (int),                     *
    *        inVehicleRegistration (String), inWheels (Array of Wheel Class,      *
    *        inLights (String), inBar (boolean)                                   *
    *EXPORT: address of new UniEvent object                                       *
    *ASSERTION: Creates the object if the imports are valid and FAILS otherwise   *
    ******************************************************************************/
    public Limo(EngineClass inEngine, int inNumOfPassengers, String inVehicleRegistration, WheelClass[] inWheels,
            String inLights, boolean inBar)
    {
        super(inEngine, inNumOfPassengers, inVehicleRegistration, inWheels);
        lights = inLights;
        bar = inBar;
    }

    /***************************************************************************
    *Copy Constructor:                                                         *
    *Purpose: To create a new object with the same object state as the import  *
    *Date: 04/06/2016 1:20pm                                                   *
    *IMPORT: inLimo (Limo)                                                     *
    *EXPORT: address of new Limo object                                        *
    *ASSERTION: Creates an object with an identical object state as the import.*
    ***************************************************************************/
    public Limo(Limo inLimo)
    {
        super(inLimo);
        lights = new String(inLimo.getLights());
        bar = inLimo.getBar();
    }

    //MUTATORS
    /**********************************************************************
    *SUBMODULE: setLights                                                 *
    *Purpose: To change/set lights to a copy of the import                *
    *Date: 04/06/2016 1:20pm                                              *
    *IMPORT: inLights (String)                                            *
    *EXPORT: none                                                         *
    *ASSERTION: sets lights to a copy of inLights.                        *
    **********************************************************************/
    public void setLights(String inLights)
    {
        lights = new String(inLights);
    }

    /**********************************************************************
    *SUBMODULE: setBar                                                    *
    *Purpose: To change/set bar to import                                 *
    *Date: 04/06/2016 1:20pm                                              *
    *IMPORT: inBar (boolean)                                              *
    *EXPORT: none                                                         *
    *ASSERTION: sets bar to inBar.                                        *
    **********************************************************************/
    public void setBar(boolean inBar)
    {
        bar = inBar;
    }

    //ACCESSORS
    /************************************************************
    *SUBMODULE: getLights                                       *
    *Purpose: To get the value of lights from the object        *
    *Date: 04/06/2016 1:20pm                                    *
    *IMPORT: none                                               *
    *EXPORT: lights (String)                                    *
    *ASSERTION: returns copy if lights                          *
    ************************************************************/
    public String getLights()
    {
        return new String(lights);
    }

    /*************************************************************
     *SUBMODULE: getBar                                          *
     *Purpose: To get the value of lights from the object        *
     *Date: 04/06/2016 1:20pm                                    *
     *IMPORT: none                                               *
     *EXPORT: lights                                             *
     *ASSERTION: returns copy if lights                          *
     ************************************************************/
    public boolean getBar()
    {
        return bar;
    }

    /********************************************************************
    * SUBMODULE: equals                                                 *
    * Purpose: To compare if two Limo objects are the same              *
    * Date: 04/06/2016 1:20pm                                           *
    * IMPORT: inObj (Object)                                            *
    * EXPORT: same                                                      *
    * ASSERTION:Two limo objects are the same if they have the same     *
    *          super class, same lights and same bar                    *
    ********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof Limo)
        {
            Limo inLimo = (Limo) inObj;
            same = (super.equals(inLimo) && lights.equals(inLimo.getLights()) && bar == inLimo.getBar());
        }
        return same;
    }

    /*********************************************************************
     * SUBMODULE: toString                                               * 
     * Purpose: To return a string of the Limo object                    *
     * Date: 04/06/2016 1:20pm                                           *
     * IMPORT: none                                                      *
     * EXPORT: str (String)                                              *
     * ASSERTION:                                                        *
     ********************************************************************/
    public String toString()
    {
        return super.toString() + " Lights: " + lights + " Bar: " + bar;
    }

    /*****************************************************************
     *SUBMODULE: accelerate                                           *
     *Purpose: changes velocity based on the acceleration calculation *
     *Date: 04/06/2016 1:20pm                                         *
     *IMPORT: none                                                    *
     *EXPORT: none                                                    *
     *ASSERTION:                                                      *
     *****************************************************************/
    public void accelerate()
    {
        double acceleration = this.getEngine().getNumCylinders();
        this.setVelocity(this.getVelocity() + acceleration);

    }

     /*****************************************************************
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
