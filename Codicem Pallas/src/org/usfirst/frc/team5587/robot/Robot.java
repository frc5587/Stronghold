
package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.IOException;

import org.usfirst.frc.team5587.classes.CameraServer;
import org.usfirst.frc.team5587.robot.commands.aimbot.Angler;
import org.usfirst.frc.team5587.robot.commands.modes.*;
import org.usfirst.frc.team5587.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{	
	public static NetworkTable table;
	public static OI oi;
	public static final Hooves hooves = new Hooves();
	public static final BoulderLoader loader = new BoulderLoader();
	public static final SpinningWheelsOfDeath firingWheels = new SpinningWheelsOfDeath();
	public static final StrongArm arm = new StrongArm( RobotMap.AIMING_MOTOR,
													   RobotMap.ENCODER_A,
													   RobotMap.ENCODER_B);
	
	CameraServer server;
	CommandGroup teleOp;
    CommandGroup autonomousCommand;
    SendableChooser chooser;
    
    private PowerDistributionPanel pdp;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
    	try {
            new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
        oi = new OI();
		teleOp = new TeleOpDrive( oi.driver );
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new BasicAuto());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        
        server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        
        table = NetworkTable.getTable("GRIP");
        pdp = new PowerDistributionPanel();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit()
    {

    }
	
	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit()
    {
        autonomousCommand = (CommandGroup) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        if (teleOp != null ) teleOp.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
        Angler a = new Angler( table );
        //SmartDashboard.putNumber( "DB/String 1", a.calcDistance() );
        //SmartDashboard.putNumber( "DB/String 2", a.calcAngleY());
        //SmartDashboard.putNumber( "DB/String 3", a.index );
        SmartDashboard.putString( "DB/String 0", "" + a.index );
        //SmartDashboard.putString( "DB/String 1", "" + a.calcDistance() );
        SmartDashboard.putString( "DB/String 2", "I0: " + pdp.getCurrent(0));
        SmartDashboard.putString( "DB/String 3", "I1: " + pdp.getCurrent(1));
        SmartDashboard.putString( "DB/String 4", "I2: " + pdp.getCurrent(2));
        SmartDashboard.putString( "DB/String 5", "PDP Temp: " + pdp.getTemperature() );
        SmartDashboard.putString( "DB/String 6", "I3: " + pdp.getCurrent(3));
        SmartDashboard.putString( "DB/String 7", "I13: " + pdp.getCurrent(13));
        SmartDashboard.putString( "DB/String 8", "I14: " + pdp.getCurrent(14));
        SmartDashboard.putString( "DB/String 9", "I15: " + pdp.getCurrent(15));
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}