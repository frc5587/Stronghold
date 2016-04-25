package org.usfirst.frc.team5587.robot.commands.modes;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.commands.Canter;
import org.usfirst.frc.team5587.robot.commands.arm.Throttled;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Allows the driver to drive Caligula around and control the position
 * of the Strong Arm through the use of the throttle and PID.
 */
public class TeleOpPID extends CommandGroup
{
    
    public  TeleOpPID( Joystick stick )
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	requires( Robot.hooves );
    	requires( Robot.arm );
    	Robot.oi.enablePID();
    	addParallel( new Throttled( Robot.oi.driver ) );
    	addSequential( new Canter( stick ) );
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
