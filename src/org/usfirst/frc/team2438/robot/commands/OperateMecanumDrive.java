package org.usfirst.frc.team2438.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;

public class OperateMecanumDrive extends CommandBase {
	
	private boolean kiddie;
	
	public OperateMecanumDrive() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = 0;
        double y = 0;
        double rot = 0;
        double gyro = 0.0;
        
    	if(kiddie) {
    		x = oi.getX(GenericHID.Hand.kRight)*0.50;
            y = oi.getY(GenericHID.Hand.kRight)*0.50;
            rot = oi.getX(GenericHID.Hand.kLeft)*0.50;
    	} else {
    		x = oi.getX(GenericHID.Hand.kRight)*0.65;
    		y = oi.getY(GenericHID.Hand.kRight)*0.65;
    		rot = oi.getX(GenericHID.Hand.kLeft)*0.65;
    	}
    	
        drivetrain.setMecanum(x, y, rot, gyro);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
