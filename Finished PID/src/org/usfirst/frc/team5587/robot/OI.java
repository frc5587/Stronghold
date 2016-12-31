package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5587.robot.commands.manual.HoldArm;
import org.usfirst.frc.team5587.robot.commands.manual.Lift;
import org.usfirst.frc.team5587.robot.commands.firing.Fire;
import org.usfirst.frc.team5587.robot.commands.firing.Spin;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    public Joystick driver; //declare joystick
	Button sweepIn, prime, up, down,fire; //and buttons we have
	public boolean pid;
    
	public OI()
	{
		//Controls Output-Input->run as object since we need it to run as an instance
		//runs non-drive train stuff independently from TeleOpManual so we don't need to explicitly say to run in Parrallel
		//unless explicitly wanted to run together everytime then we say run parrallel
		//Joysticks
		driver = new Joystick( RobotMap.DRIVER );
	
    	//Buttons
    	sweepIn = new JoystickButton( driver, RobotMap.SWEEP_IN ); //param 1st is joystick object, 2nd is joystick button #
    	prime = new JoystickButton( driver, RobotMap.PRIME );
    	fire = new JoystickButton( driver, RobotMap.FIRE );
		up = new JoystickButton( driver, RobotMap.UP );
    	down = new JoystickButton( driver, RobotMap.DOWN);
		
    
    	//Buttons and Commands
    	sweepIn.toggleWhenPressed( new Spin( false ) ); //While held the launch wheels will spin inwards
    	prime.toggleWhenPressed( new Spin( true ) ); //While held the launch wheels will spin outwards
    	fire.whenPressed( new Fire() ); //If pressed while prime is also pressed, will fire the ball
    	up.whenPressed(new Lift( true ));//lift shooter upward
    	up.whenReleased(new HoldArm() ); //attempt to keep the arm at same position
    	down.whenPressed( new Lift( false ) ); //lift shooter downward
    	down.whenReleased( new HoldArm() ); 
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
	
	/**
	 * Nullifies the up and down buttons so their actions do not accidentally
	 * interfere with the arm's PID control via the throttle
	 */
	public void enablePID()
	{
		pid = true;
	}
	
	/**
	 * Sets the up and down buttons as well as their appropriate commands so that
	 * the arm can be positioned manually
	 */
	public void enableManual()
	{
		pid = false;
	}
}