package org.usfirst.frc.team2438.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // Drive //
    public static final int frontLeftMain = 2;
    public static final int frontLeftSlave = 1;
    
    public static final int frontRightMain = 3;
    public static final int frontRightSlave = 4;
    
    public static final int backLeftMain = 6;
    public static final int backLeftSlave = 5;
    
    public static final int backRightMain = 8;
    public static final int backRightSlave = 7;
    
    
    // Pneumatics //
    public static final int solenoidMain = 0;
    public static final int solenoidSlave = 1;
    
}