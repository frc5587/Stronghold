package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private RobotDrive train;
	
	/*
	 * Class constructor for the DriveTrain class
	 * 
	 * Accepts no parameters
	 * Declares 'train' to be a new RobotDrive object, using the motor ports as defined in RobotMap
	 */
	public DriveTrain(){
		train = new RobotDrive(RobotMap.LEFT_FRONT_WHEEL, RobotMap.LEFT_REAR_WHEEL, RobotMap.RIGHT_FRONT_WHEEL, RobotMap.RIGHT_REAR_WHEEL);
		train.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		train.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	}
	
	
	
	/*
	 * Create a method called drive
	 * 
	 * It will run the method of the same name for the train object
	 * 
	 * @param power A double between -1 and 1 that dictates the power level of the motor
	 * @param curve A double between -1 and 1 that is used to determine motor power levels for a desired turn radius
	 */
	public void drive(double power, double curve){
		train.drive(power, curve);
	}
	
	/*
	 * Create a method called arcadeDrive
	 * 
	 * It will accept a Joystick as a parameter (Use OI.java)
	 * It will run the method of the same name for the train object
	 */
	public void arcadeDrive(Joystick stick){
		train.arcadeDrive(stick);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

