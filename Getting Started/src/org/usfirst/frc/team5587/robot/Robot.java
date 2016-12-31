package org.usfirst.frc.team5587.robot; //tells us what package it's in (meant for telling the file what's easily accesible to this file and vice versa for others)

import edu.wpi.first.wpilibj.IterativeRobot; 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	RobotDrive myRobot; //declaring RobotDrive object (controls motors) called myRobot
	Joystick stick; //declaring Joystick object called stick
	int autoLoopCounter; //initialize variable needed for autonomousInit method;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	myRobot = new RobotDrive(0,1); //constructors are PWM ports
    	stick = new Joystick(0); //port on US board
    	//initializes all values and objects for robot;
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() 
    {
    	autoLoopCounter = 0; //initializes auto loop counter to 0
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
    	if(autoLoopCounter < 100) //Check if we've completed 100 loops (approximately 2 seconds)
		{
			myRobot.drive(-0.5, 0.0); 	// drive forwards half speed; params 1st is the power, the second is the curve; power range from -1 to 1 (double); curve adjusts value spread (so 0 is balanced) 
			autoLoopCounter++; //this is inside a while loop already so that's why we use an if statement
		} 
    	else 
    	{
			myRobot.drive(0.0, 0.0); 	// stop robot
		}
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit()
    {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        myRobot.arcadeDrive(stick);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
    	LiveWindow.run(); //can test whatever you want immediately without doing teleop or auto
    }
    
}
