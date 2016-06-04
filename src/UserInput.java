import java.util.Scanner;

/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Retrieve input from user                            *
 * Date: 15/04/2016 3:23apm                                     *
 ***************************************************************/
public class UserInput
{
    private Scanner sc;

    /*********************************************************************
    *Default Constructor:                                                *
    *Purpose: To construct a default object of Date                      *
    *Date: 04/06/2016 1:20pm                                             *
    *IMPORT: none                                                        *
    *EXPORT: address of new UserInput object                             *    
    *ASSERTION: default Scanner object is the default state for UserInput*                                              *       
    *********************************************************************/
    public UserInput()
    {
        sc = new Scanner(System.in);
    }

     /*******************************************************************
     * SUBMODULE: readString                                            * 
     * Purpose: To read an String from user and return it               *
     * Date: 04/06/2016 1:20pm                                          *
     * IMPORT: message (String)                                         *
     * EXPORT: input (String)                                           *
     * ASSERTION:                                                       *
     *******************************************************************/
    public String readString(String message)
    {
        String input = "";

        boolean validInput = false;
        while (!validInput)
        {
            System.out.print(message);
            try
            {
                input = sc.nextLine();
                validInput = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.print("You must enter a string");
                sc.nextLine();
            }

        }
        return input;
    }

    /*******************************************************************
     * SUBMODULE: readInt                                               * 
     * Purpose: To read an int from user and return it                  *
     * Date: 04/06/2016 1:20pm                                          *
     * IMPORT: message (String)                                         *
     * EXPORT: inSelection (int)                                        *
     * ASSERTION:                                                       *
     *******************************************************************/
    public int retrieveIntFromUser(String message)
    {
        boolean validInput = false;
        int inSelection = -1;
        while (!validInput)
        {
            System.out.println(message);
            try
            {
                inSelection = sc.nextInt();
                validInput = true;
            }
            catch (Exception e)
            {
                System.out.println("Invalid value");
                sc.next();
            }

        }
        sc.nextLine();
        return inSelection;

    }
    /*******************************************************************
     * SUBMODULE: readDouble                                            * 
     * Purpose: To read an double from user and return it               *
     * Date: 04/06/2016 1:20pm                                          *
     * IMPORT: message (String)                                         *
     * EXPORT: inSelection (double)                                     *
     * ASSERTION:                                                       *
     *******************************************************************/
    public double retrieveDoubleFromUser(String message)
    {
        boolean validInput = false;
        double inSelection = -1;
        while (!validInput)
        {
            System.out.println(message);
            try
            {
                inSelection = sc.nextDouble();
                validInput = true;
            }
            catch (Exception e)
            {
                System.out.println("Invalid value");
                sc.next();
            }
        }
        sc.nextLine();
        return inSelection;
    }

}
