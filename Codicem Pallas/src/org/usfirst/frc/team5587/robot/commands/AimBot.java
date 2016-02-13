package org.usfirst.frc.team5587.robot.commands;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.Hooves;
import org.usfirst.frc.team5587.robot.subsystems.StrongArm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class AimBot extends Command {
	
	private Hooves hooves;
	private StrongArm arm;
	private NetworkTable table;
	private int index;
	private boolean finished;
	
    public AimBot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.arm );
    	requires( Robot.hooves );
    	hooves = Robot.hooves;
    	arm = Robot.arm;
    	table = Robot.table;
    	finished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double[] defaultValue = new double[0];
    	double [] areas = table.getNumberArray( "Area", defaultValue );
    	if ( areas.length > 0 )
    	{
			int index = 0;
			double check = 0;
			for (int i = 0; i < areas.length; i++)
			{
				if (areas[i] > check) {
					check = areas[i];
					index = i;
				}
			}
			this.index = index;
		}
    	else
    	{
    		finished = true;
    		isFinished();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
