package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5587.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	Joystick driver;
	JoystickButton spinOut, spinIn, fire;
	
	/*
	 * Create a class constructor for OI that accepts no parameters.
	 * 1. Declare 'driver' to be a Joystick in the appropriate port
	 * 2. Declare 'prime' and 'inTake' to be JoystickButtons in the appropriate ports
	 * 3. Set spinIn to run the Load command as long as it is held
	 * 4. Set spinOut to run the SpinOut command as long as it is held
	 * 5. Set fire to run the Fire command when it is pressed
	 */
	public OI(){
		driver = new Joystick(RobotMap.DRIVER);
		spinOut = new JoystickButton(driver, RobotMap.SPIN_OUT);
		spinIn = new JoystickButton(driver, RobotMap.SPIN_IN);
		fire = new JoystickButton(driver, RobotMap.FIRE);
	}
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

