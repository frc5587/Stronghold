package org.usfirst.frc.team5587.robot.commands.arm;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Controls the movements of the arm by tying the throttle's range on
 * the joystick to the arm's range of movement.
 */
public class Throttled extends Command {
	private Joystick joystick1;
	private static final double ABSOLUTE_BOTTOM = 230;
	
	/**
	 * @param j Joystick from which to read values
	 */
    public Throttled(Joystick j) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.arm );
    	joystick1 = j;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	Robot.arm.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	double setPoint = ( joystick1.getZ() + 1 )/ 2 * ABSOLUTE_BOTTOM;
    	if( !Robot.arm.isTop() || setPoint > 20 ) //A safety net to make sure the arm doesn't crush internal systems
    		Robot.arm.setSetpoint( setPoint );
        SmartDashboard.putNumber("Joystick Z", joystick1.getZ());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    }
}
