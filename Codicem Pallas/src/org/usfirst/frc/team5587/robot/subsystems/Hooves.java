package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team5587.classes.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem contains the motors in the drive train
 */
public class Hooves extends Subsystem
{
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	//Provides a limitation to the maximum speed of the drive train (needs to be tested)
	private static final double SCALE_FACTOR = .5;
	
	private RobotDrive trotter;
	
	//Creates a new DriveTrain object and initializes the RobotDrive trotter
	public Hooves()
	{
		trotter = new RobotDrive( RobotMap.LEFT_FRONT_MOTOR,
								  RobotMap.LEFT_REAR_MOTOR,
								  RobotMap.RIGHT_FRONT_MOTOR,
								  RobotMap.RIGHT_REAR_MOTOR );
		trotter.setInvertedMotor( RobotDrive.MotorType.kFrontRight, true );
		trotter.setInvertedMotor( RobotDrive.MotorType.kRearRight, true);
	}
	
	/*
	 * Brings Pallas into motion based on numerical input
	 * 
	 * @param pwr The power level on which to run the drive train motors ( -1 <= pwr <= 1 )
	 * @param curve Tells the robot how much to curve: a curve less than 0 turns , a curve of 0 drives straight, a curve greater than 0 turns , a curve of plus or minus 1 turns the robot in place.  
	 */
	public void trot( double pwr, double curve)
	{
		trotter.drive( pwr * SCALE_FACTOR, curve );
	}

	/*
	 * Allows the driver to take direct control over the movement of Pallas
	 * 
	 * @param stick The joystick that will dictate Pallas's movements
	 */
	public void canter( Joystick stick )
	{
		double xValue = stick.getX();
		double yValue = stick.getY();
		trotter.arcadeDrive( xValue * SCALE_FACTOR, yValue, false);
	}
	
	public void stop()
	{
		this.trot(0, 0);
	}
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}