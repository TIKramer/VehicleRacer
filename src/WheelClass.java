//Class Provided by Curtin University 
public final class WheelClass
{
    //Class constants.
    public static final String MAG = "MAGNESIUM";
    public static final String STEEL = "STEEL";

    //private class fields
    private String size, rimType, manufacturer;
    private double airPressure;

    /************************************************************
     *Default Constructor:
     *IMPORT: none
	 *EXPORT: address of new WheelClass object
     *ASSERTION: 185/55 R15 with an airpressure of 29, mag alloy 
     *    rims and no manufacturer is a valid default state
     ************************************************************/
    public WheelClass()
    {
        size = new String("185/55 R15");
        airPressure = 29.0;
        rimType = MAG;
        manufacturer = "";
    }

    /************************************************************
     *Alternate #1 Constructor:
	 *IMPORT: inWidth (int), inTyreDiam (int), inRimDiam (int), inPressure (real), inRim (String), inMake(String)
	 *EXPORT: address of new WheelClass object
	 *ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     ************************************************************/
    public WheelClass(int inWidth, int inTyreDiam, int inRimDiam, double inPressure, String inRim, String inMake)
    {
        if ((validateSize(inWidth, inTyreDiam, inRimDiam)) && (validatePressure(inPressure)) && (validateRim(inRim)))
        {
            setSize(inWidth, inTyreDiam, inRimDiam );
            airPressure = inPressure;
            rimType = inRim.toUpperCase();
            manufacturer = inMake;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Import Values");
        }
    }

    /************************************************************
     *Alternate #2 Constructor:
	 *IMPORT: inSize (String), inPressure (real), inRim (String), inMake(String)
	 *EXPORT: address of new WheelClass object
	 *ASSERTION: Creates the object if the imports are valid and FAILS otherwise
     ************************************************************/
    public WheelClass(String inSize, double inPressure, String inRim, String inMake)
    {

        if ((validatePressure(inPressure)) && (validateRim(inRim)))
        {
            size = inSize;
            airPressure = inPressure;
            rimType = inRim.toUpperCase();
            manufacturer = inMake;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Import Values");
        }
    }

    /************************************************************
     *Copy Constructor:
	 *IMPORT: inWheel (WheelClass)
	 *EXPORT: address of new WheelClass object
	 *ASSERTION: Creates an object with an identical object state as the import.
     ************************************************************/
    public WheelClass(WheelClass inWheel)
    {
	    size = inWheel.getSize();
        airPressure = inWheel.getAirPressure(); 
		rimType = inWheel.getRimType();
		manufacturer = inWheel.getMake();
    }

    //MUTATORS
    /************************************************************
     *SUBMODULE: setSize
	 *IMPORT: inSize (String)
	 *EXPORT: none
	 *ASSERTION: sets the size to inSize.
     ************************************************************/
    public void setSize(String inSize)
    {
        size = inSize;
    }

    /********************************************************************
     *SUBMODULE: setSize
	 *IMPORT: inWidth (integer), inTyreDiam (integer), inRimDiam (Integer)
	 *EXPORT: none
	 *ASSERTION: sets the size if imports are valid and FAILS otherwise.
     *********************************************************************/
    public void setSize(int inWidth, int inTyreDiam, int inRimDiam)
    {
	    if (validateSize(inWidth, inTyreDiam, inRimDiam)) 
        {
            int aspect = (int)(((double)inTyreDiam/(double)inWidth)*100);
            size = inWidth + "/" + aspect + " R" + inRimDiam;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Import Values");
        }
    }

    /********************************************************************
     *SUBMODULE: setAirPressure
	 *IMPORT: inAirPressure (real)
	 *EXPORT: none
	 *ASSERTION: sets the current airPressure if valid and FAILS otherwise.
     *********************************************************************/
    public void setAirPressure(double inAirPressure)
    {
	    if(validatePressure(inAirPressure))
        {
		    airPressure = inAirPressure;
	    }
        else
        {
            throw new IllegalArgumentException("Invalid Air Pressure");
        }
    }

    /********************************************************************
     *SUBMODULE: setRimType
	 *IMPORT: inRimType (String)
	 *EXPORT: none
	 *ASSERTION: sets the rim type if valid and FAILS otherwise.
     *********************************************************************/
    public void setRimType(String inRimType)
    {
	    if(validateRim(inRimType))
        {
		    rimType = inRimType.toUpperCase();
	    }
        else
        {
            throw new IllegalArgumentException("Invalid Rim Type");
        }
    }
    
    /********************************************************************
     *SUBMODULE: setMake
	 *IMPORT: inManufacturer (String)
	 *EXPORT: none
	 *ASSERTION: sets the manufacturer.
     *********************************************************************/
    public void setMake(String inManufacturer)
    {
	    manufacturer = inManufacturer;
    }

    //ACCESSORS
    public String getSize()
    {
	    return size;
    }

    public double getAirPressure()
    {
	    return airPressure;
    }

    public String getMake()
    {
	    return manufacturer;
    }

    public String getRimType()
    {
	    return rimType;
    }
    
    /********************************************************************
     *SUBMODULE: equals
	 *IMPORT: inSize (String), inRimType (String)
	 *EXPORT: same
	 *ASSERTION: Two wheels are interchangeable if they have the same size and rimType.
     *********************************************************************/
    public boolean equals(String inSize, String inRimType)
    {
	    return (size.equals(inSize) && (rimType.equals(inRimType.toUpperCase())));
    }

    /********************************************************************
     *SUBMODULE: equals
	 *IMPORT: inWidth (integer), inTypeDiam (integer), inRimDiam (integer), inRimType(String)
	 *EXPORT: same
	 *ASSERTION: Two wheels are interchangeable if they have the same size and rimType.
     *********************************************************************/
    public boolean equals(int inWidth, int inTyreDiam, int inRimDiam, String inRimType)
    {
        boolean same = false;
	    if (validateSize(inWidth, inTyreDiam, inRimDiam)) 
        {
            int aspect = (int)(((double)inTyreDiam/(double)inWidth)*100);
            String testSize = inWidth + "/" + aspect + " R" + inRimDiam;
			same = (size.equals(testSize) && (rimType.equals(inRimType.toUpperCase())));
        }
	    return same;
    }

    /********************************************************************
     *SUBMODULE: equals
	 *IMPORT: inWheel (WheelClass)
	 *EXPORT: same
	 *ASSERTION: Two wheels are interchangeable if they have the same size and rimType.
     *********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if(inObj instanceof WheelClass)
        {
            WheelClass inWheel = (WheelClass)inObj;
            same = size.equals(inWheel.getSize()) && rimType.equals(inWheel.getRimType());
        }
	    return same;
    }

    public String toString()
    {
        return ("size: " + size + " current air pressure: " + airPressure + " rim matterial: " + rimType + " made by: " + manufacturer);
    }

    //PRIVATE SUBMODULES:
    /*************************************************************************
     *SUBMODULE: validateSize
	 *IMPORT: inWidth (int), inTyreDiam (int), inRimDiam (int)
	 *EXPORT: valid (boolean)
	 *ASSERTION: width is greater than  150, tyreDiam is less than width, tyreDiam and rimDiam must be positive 
    ************************************************************************/
    private boolean validateSize(int inWidth, int inTyreDiam, int inRimDiam)
    {
        return ((inWidth > 150) && (inTyreDiam < inWidth) && (inTyreDiam > 0) && (inRimDiam > 0));
    }

    /*************************************************************************
     *SUBMODULE: validatePressure
	 *IMPORT: inPressure (real)
	 *EXPORT: valid (boolean)
	 *ASSERTION: pressure is between 0 and 42 (inclusive)
    ************************************************************************/
    private boolean validatePressure(double inPressure)
    {
        return ((inPressure >= 0.0) && (inPressure <= 42.0));
    }

    /*************************************************************************
     *SUBMODULE: validateRim
	 *IMPORT: inRim (String)
	 *EXPORT: valid (boolean)
	 *ASSERTION: rim must be MAG or STEEL
    ************************************************************************/
    private boolean validateRim(String inRim)
    {
        String stripped = inRim.toUpperCase();
        return ((stripped.equals(MAG)) || (stripped.equals(STEEL)));
    }


}
		
