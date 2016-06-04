/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: interface that must be implemented to               *
 *          MotorVehicleClass and all its childs as every      *
 *          Vehicle needs to accelerate and decelerate          *
 * Date: 04/06/2016 1:20pm                                      *
 ***************************************************************/
public interface Transport
{
    public abstract void accelerate();
    public abstract void decelerate();
}