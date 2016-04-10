package org.usfirst.frc.team5587.robot.commands.modes;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.commands.Trot;
import org.usfirst.frc.team5587.robot.commands.PIDarm.AutoLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Allows for a sequencing of commands for Autonomous mode (needs to be tested)
 */
public class LowAuto extends CommandGroup
{
    
    public  LowAuto()
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	requires( Robot.hooves );
    	requires( Robot.arm );
    	addSequential(new AutoLift());
    	addSequential( new Trot( -.5, 0, 4 ) );
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
}
