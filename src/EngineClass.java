public final class EngineClass
{
    // Class constants
    public static final String[] FUELTYPES =
    { "ULP", "PULP", "DIESEL", "LPG", "98RON" };

    private int numCylinders;
    private double horsePower;
    private String fuelType;

    public EngineClass()
    {
        numCylinders = 4;
        horsePower = 200;
        fuelType = "DIESEL";

    }

    public EngineClass(EngineClass inEngine)
    {
        numCylinders = inEngine.getNumCylinders();
        horsePower = inEngine.getHorsePower();
        fuelType = inEngine.getFuelType();
    }

    public EngineClass(int inNumCylinders, double inHorsePower, String inFuelType)
    {
        if (validateNumCylinders(inNumCylinders) && validateHorsePower(inHorsePower) && validateFuelType(inFuelType))
        {
            numCylinders = inNumCylinders;
            horsePower = inHorsePower;
            fuelType = inFuelType;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Import Values");
        }
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
        return fuelType;
    }

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

    public void setFuelType(String inFuelType)
    {
        if (validateFuelType(inFuelType))
        {
            fuelType = inFuelType;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Fuel Type");
        }
    }

    private boolean validateNumCylinders(int inNumCylinders)
    {
        boolean valid = false;
        if (inNumCylinders >= 4 && inNumCylinders % 2 == 0)
        {
            valid = true;
        }
        return valid;

    }

    private boolean validateHorsePower(double inHorsePower)
    {
        boolean valid = false;
        if (inHorsePower > 0.0 && inHorsePower <= 640.0)
        {
            valid = true;
        }
        return valid;
    }

    private boolean validateFuelType(String inFuelTypes)
    {
        boolean valid = false;
        for (int i = 0; i < FUELTYPES.length; i++)
        {
            if (inFuelTypes == FUELTYPES[i])
            {
                valid = true;
            }
        }
        return valid;
    }

    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof EngineClass)
        {
            EngineClass inEngine = (EngineClass) inObj;
            same = (numCylinders == inEngine.getNumCylinders() && horsePower == inEngine.getHorsePower() && fuelType == inEngine
                    .getFuelType());

        }
        return same;
    }

    public String toString()
    {
        return ("This engine has " + numCylinders + " cylinders, " + horsePower + " horse power" + " and uses "
                + fuelType + " fuel");
    }

}
