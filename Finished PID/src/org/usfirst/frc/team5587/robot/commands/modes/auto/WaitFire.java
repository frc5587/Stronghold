package org.usfirst.frc.team5587.robot.commands.modes.auto;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.commands.WaitTime;
import org.usfirst.frc.team5587.robot.commands.firing.Fire;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class WaitFire extends CommandGroup {
    
    public  WaitFire() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	requires( Robot.loader );
    	addSequential( new WaitTime( 2 ) );
    	addSequential( new Fire() );
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