/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds array of MotorVehicleClass         *
 *                 and handles the adding to and displaying     *
 *                 of the MotorVehicleClass array               *
 * Date: 04/06/2016 1:20pm                                    *
 ***************************************************************/
public class Race
{
    private MotorVehicleClass[] racers;

    /********************************************************************
    *Default Constructor:                                               *
    *Purpose: To construct a default object of Race                     *
    *Date: 04/06/2016 1:20pm                                            *
    *IMPORT: none                                                       *
    *EXPORT: address of new EventList Race                              *
    *ASSERTION: racers size of 5 is default state of racers             *       
    ********************************************************************/
    public Race()
    {
        racers = new MotorVehicleClass[5];
    }

    /************************************************************************
     *SUBMODULE: addToRacers                                                 *
     * Purpose: To add a new racer(Vehicle) to the racers array              *
     * Date: 04/06/2016 1:20pm                                               *                            
     *IMPORT: inRacer(MotorVehicleClass)                                     *
     *EXPORT: none                                                           *
     *ASSERTION:                                                             *
     ************************************************************************/
    public void addToRacers(MotorVehicleClass inRacer)
    {
        boolean racerAdded = false;
        int counter = 0;
        while (counter < racers.length && racerAdded == false)
        {
            if (racers[counter] == null)
            {
                racers[counter] = inRacer;
                racerAdded = true;
            }
            counter++;
        }
    }

    /************************************************************************
    *SUBMODULE: startReace                                                  *
    * Purpose: return the amount of times it take for a car to accelerate
    *          to its maxVelocity                                           *
    * Date: 04/06/2016 1:20pm                                               *                            
    *IMPORT: racerPosition (int)                                            *
    *EXPORT: counter (int)                                                  *
    *ASSERTION:                                                             *
    ************************************************************************/
    public int getScore(int racerPosition)
    {
        int counter = 0;
        while (racers[racerPosition].getVelocity() <= racers[racerPosition].maxVelocity)
        {
            racers[racerPosition].accelerate();
            counter += 1;
        }
        return counter;
    }

    /************************************************************************
    *SUBMODULE: startReace                                                  *
    * Purpose: displays the information of a vehicle and its score          *
    * Date: 04/06/2016 1:20pm                                               *                            
    *IMPORT: none                                                           *
    *EXPORT: none                                                           *
    *ASSERTION:                                                             *
    ************************************************************************/
    public void startRace()
    {
        String type = "";
        String vehicleRegistration = "";
        int score = 0;
        for (int i = 0; i < racers.length; i++)
        {
            if (racers[i] != null)
            {
                if (racers[i] instanceof Limo)
                {
                    type = "Limo";
                }
                else if (racers[i] instanceof Bus)
                {
                    type = "Bus";
                }
                vehicleRegistration = racers[i].getVehicleRegistration();
                score = getScore(i);
                System.out.println(type + ": " + vehicleRegistration + " : " + score);
            }
        }
    }
}
