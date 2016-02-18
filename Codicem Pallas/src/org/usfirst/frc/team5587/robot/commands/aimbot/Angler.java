package org.usfirst.frc.team5587.robot.commands.aimbot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Angler
{
	private NetworkTable table;
	private static final double UPPER_LIMIT = 100,
								LOWER_LIMIT = 300,
								LEFT_LIMIT = 100,
								RIGHT_LIMIT = 400,
								TARGET_HEIGHT = 14,
								CENTER_HEIGHT = 90,
								IMAGE_HEIGHT = 240,
								CAMERA_ANGLE_Y = 120,
								CAMERA_ANGLE_X = 120;
								
	private int index;
	private double distance;
	
	public Angler( NetworkTable t )
	{
		table = t;
		findIndex();
	}
	
	private void findIndex()
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
			this.index = index;
		}
    	else
    	{
    		return;
    	}
    }
    
    public double getX()
    {
    	return table.getNumberArray( "xCenter", new double[0] )[index];
    }
    
    public double getY()
    {
    	return table.getNumberArray( "yCenter", new double[0] )[index];
    }
    
    public boolean withinX()
    {
    	return ( getX() <= RIGHT_LIMIT && getX() >= LEFT_LIMIT );
    }
    
    public boolean withinY()
    {
    	return ( getY() <= LOWER_LIMIT && getY() >= UPPER_LIMIT );
    }
    
    private double toRadians( double deg )
    {
    	return Math.toRadians(deg);
    }
    
    public double calcDistance()
    {
    	distance = ( TARGET_HEIGHT * table.getNumberArray( "height", new double [0])[ index ] )
    				/ ( 2 * IMAGE_HEIGHT * Math.tan( toRadians( CAMERA_ANGLE_Y ) ) );
    	return distance;
    }
    
    public double calcAngleY()
    {
    	return Math.atan( CENTER_HEIGHT / distance );
    }
}