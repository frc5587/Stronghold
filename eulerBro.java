/**
 * Program to calculate the area of a function with euler approximation (COMPLETE!)
 * 
 * Saleh Ibrahim Hassen
 * November 3rd, 2016
 */
import java.util.Scanner;
public class eulerBro
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        double x = 1; //variable for x
        double fOfX = 1; //variable for y
        double changeInY = 1; //variable to represent change in y
        double yPrime = 1; //variable to represent derivative of y
        double targetX = 100; //variable to represent the final x value
        double stepSize = .1; //variable to represent the step size for x aka change in x
        
        System.out.println("Insert the initial x value");
         x = in.nextDouble();
        System.out.println("Insert the initial y value");
         fOfX = in.nextDouble();
        System.out.println("Insert the target x value");
        targetX = in.nextDouble();
        System.out.println("Insert the step size (for x) value");
        stepSize = in.nextDouble();
        
        // if the user tries to solve a euler problem using a step size that doesn't land on initial x to final x while maintaining step size
        if (0 != ((targetX-x) % stepSize)) 
        {
            System.out.println("ERROR: your stepsize and your final X value contradict");
        }
        
        //if user is trying crazy huge step sizes then lets at least confirm they want to do that
        else if ((targetX/stepSize) > 100) 
        {
            System.out.println("Are you sure you want to do a euler calculation with more than a hunned steps? (Enter Y / N)");
            String salehsConfirm = in.next();
            if (salehsConfirm.equalsIgnoreCase("N"))
            {
                System.out.println("Smart Choice, ending program");
            }
            else if (salehsConfirm.equalsIgnoreCase("Y"))
            {
                System.out.println("oh boy...");
                while (x != targetX)
                {
                    System.out.println("old x: " + x + "\t old y: " + fOfX);
                   yPrime = x + 2*fOfX;  //insert function here
                   System.out.println("dy/dx at x equals " + x  + " is " + yPrime);
                    x += stepSize;
                    changeInY = stepSize * yPrime;
                   System.out.println("the change in y is " + changeInY);
                    fOfX += changeInY;
                   System.out.println("new x: " + x + "\t new y: " + fOfX);
                   System.out.println("Harambe was here");
                   System.out.println();
              
                }
            }
            else 
            {
                System.out.println("just what the hell are you doing?");
            }
        }
        
        else {
            while (x != targetX)
            {
                System.out.println("old x: " + x + "\t old y: " + fOfX);
               yPrime = x + 2*fOfX;  //insert function here
               System.out.println("dy/dx at x equals " + x  + " is " + yPrime);
                x += stepSize;
                changeInY = stepSize * yPrime;
               System.out.println("the change in y is " + changeInY);
                fOfX += changeInY;
               System.out.println("new x: " + x + "\t new y: " + fOfX);
               System.out.println();
              
            }
            
            System.out.println("I dare you to take a really long euler's problem now");
        }
    }
}