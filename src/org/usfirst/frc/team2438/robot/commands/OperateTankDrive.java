package org.usfirst.frc.team2438.robot.commands;

import org.usfirst.frc.team2438.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.GenericHID;

/**
 * @author iobotics
 */
public class OperateTankDrive extends CommandBase {
	
	private boolean kiddie;
    
    public OperateTankDrive() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double left = 0;
    	double right = 0;
    	
    	if(kiddie) {
    		left = -oi.getY(GenericHID.Hand.kLeft)*0.7;
    		right = -oi.getY(GenericHID.Hand.kRight)*0.7;
    	} else {
    		left = -oi.getY(GenericHID.Hand.kLeft)*0.8;
    		right = -oi.getY(GenericHID.Hand.kRight)*0.8;
    	}
        
        drivetrain.setTank(left, right);
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