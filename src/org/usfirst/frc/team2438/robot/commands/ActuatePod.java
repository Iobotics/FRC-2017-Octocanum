package org.usfirst.frc.team2438.robot.commands;

/**
 *
 */
public class ActuatePod extends CommandBase {

    public ActuatePod() {
        this.requires(pod);
    }
    
    protected void initialize() { }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pod.actuate();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
