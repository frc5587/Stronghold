package org.usfirst.frc.team5587.robot.commands.aimbot;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class AimBot extends CommandGroup {
    
	private boolean finished = false;
	private NetworkTable table;
	private int index;
	
    public  AimBot() {
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	requires( Robot.arm );
    	requires( Robot.hooves );
    	table = Robot.table;
    	
    	index = findIndex();
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
    
    private int findIndex()
    {
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
			return index;
		}
    	else
    	{
    		finished = true;
    		isFinished();
    		return -1;
    	}
    }
    
    protected boolean isFinished()
    {
    	return finished;
    }
}
