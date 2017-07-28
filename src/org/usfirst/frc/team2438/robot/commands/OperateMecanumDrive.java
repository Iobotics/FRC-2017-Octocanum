package org.usfirst.frc.team2438.robot.commands;

public class OperateMecanumDrive extends CommandBase {
	public OperateMecanumDrive() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double mag = oi.getRightStick().getMagnitude();
        double dir = oi.getRightStick().getDirectionDegrees();
        double rot = oi.getLeftStick().getX();
        
        drivetrain.setMecanum(mag, dir, rot);
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
