package org.usfirst.frc.team5587.robot.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Angler2
{
	private NetworkTable table;
	private static final double UPPER_LIMIT = 100,
								LOWER_LIMIT = 300,
								LEFT_LIMIT = 100,
								RIGHT_LIMIT = 400,
								TARGET_HEIGHT = 14,
								CENTER_HEIGHT = 90,
								IMAGE_HEIGHT = 240,
								Y_COEFFICIENT = (55.0/87.0),
								X_COEFFICIENT = 120;
								
	public int index;
	private double distance;
	
	public Angler2( NetworkTable t )
	{
		table = t;
		findIndex();
	}
	
	public void findIndex()
    {
    	double[] defaultValue = new double[0];
    	double [] areas = table.getNumberArray( "targets/area", defaultValue );
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
    		this.index = -1;
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
    
    public double calcDistance()
    {
    	if( index >= 0)
    	{
    		distance = ( TARGET_HEIGHT * table.getNumberArray( "target/height", new double [0])[ index ] * Y_COEFFICIENT )
    				/ IMAGE_HEIGHT;
    		return distance;
    	}
    	else
    		return -1;
    }
    
    public double calcAngleY()
    {
    	return Math.toDegrees( Math.atan( CENTER_HEIGHT / distance ) );
    }
}