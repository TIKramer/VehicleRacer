public class MotorVehicleClass
{
    final public int MINIMUM_NUM_OF_WHEELS = 4;
    private EngineClass engine;
    private int numOfPassengers;
    private String vehicleRegistration;
    private WheelClass wheels[];

    public MotorVehicleClass()
    {
        engine = new EngineClass();
        numOfPassengers = 0;
        vehicleRegistration = null;
        wheels = new WheelClass[MINIMUM_NUM_OF_WHEELS];
        for (int i = 0; i < wheels.length; i++)
        {
            wheels[i] = new WheelClass();
        }

    }

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

    public EngineClass getEngine()
    {
        return engine;
    }

    public int getNumOfPassengers()
    {
        return numOfPassengers;
    }

    public String getVehicleRegistration()
    {
        return vehicleRegistration;
    }

    public WheelClass[] getWheels()
    {
        return wheels;
    }

    public void setEngine(EngineClass inEngine)
    {
        engine = inEngine;
    }

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
        vehicleRegistration = inVehicleRegistration;
    }

    public void setWheels(WheelClass[] inWheels)
    {
        if (validateWheelArray(inWheels))
        {
            wheels = inWheels;
        }
        else
        {
            throw new IllegalArgumentException("Invalid value passed to Wheels");
        }

    }

    private boolean validateNumOfPassengers(int inPassengers)
    {
        boolean valid = false;
        if (inPassengers >= 0)
        {
            valid = true;
        }
        return valid;

    }

    private boolean validateWheelArray(WheelClass[] inWheels)
    {
        boolean valid = false;
        if (inWheels.length >= 2)
        {
            valid = true;
        }
        return valid;
    }

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

    public String toString()
    {
        String strWheels = "Wheels attached are: ";
        for (int i = 0; i < wheels.length; i++)
        {
            strWheels += "\n\t\t" + "Wheel " + (i + 1) + ": " + wheels[i].toString() + " .";
        }

        return ("This car has: " + "\n\t" + engine + "\n\t" + strWheels + "\n\t" + "Spaces for passengers: "
                + numOfPassengers + "\n\t" + "Vehicle Registration: " + vehicleRegistration);
    }

}
