package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5587.robot.commands.arm.HoldArm;
import org.usfirst.frc.team5587.robot.commands.arm.Lift;
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
    public Joystick driver, codriver;
	Button sweepIn, prime, up, down,fire;
    
	public OI()
	{
		//Joysticks
		driver = new Joystick( RobotMap.DRIVER );
    	codriver = new Joystick( RobotMap.CODRIVER );
	
    	//Buttons
    	sweepIn = new JoystickButton( driver, RobotMap.SWEEP_IN );
    	prime = new JoystickButton( driver, RobotMap.PRIME );
    	fire = new JoystickButton( driver, RobotMap.FIRE );
    	up = new JoystickButton( driver, RobotMap.UP );
    	down = new JoystickButton( driver, RobotMap.DOWN);
    
    	//Buttons and Commands
    	sweepIn.toggleWhenPressed( new Spin( false ) ); //While held the launch wheels will spin inwards
    	prime.toggleWhenPressed( new Spin( true ) ); //While held the launch wheels will spin outwards
    	fire.whenPressed( new Fire() ); //If pressed while prime is also pressed, will fire the ball
    	up.whenPressed(new Lift( true ));
    	up.whenReleased(new HoldArm() );
    	down.whenPressed( new Lift( false ) );
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
}