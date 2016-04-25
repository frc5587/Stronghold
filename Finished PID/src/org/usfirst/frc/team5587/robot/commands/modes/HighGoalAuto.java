package org.usfirst.frc.team5587.robot.commands.modes;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.commands.arm.AutoLift;
import org.usfirst.frc.team5587.robot.commands.firing.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Scores a High Goal from the spybot position in autonomous.
 * 
 *	Moves the Strong Arm to the angle (Determined to be 70) for firing a 
 *  High Goal from the spybot position. Spins up the Spinning Wheels of Death
 *  and fires the boulder.
 */
public class HighGoalAuto extends CommandGroup {
    
    public  HighGoalAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	requires( Robot.arm );
    	addSequential( new AutoLift( 70 ) );
    	addParallel( new TimeSpin( true, 5 ));
    	addSequential( new WaitFire( 2 ) );
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
