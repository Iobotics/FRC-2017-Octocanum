package org.usfirst.frc.team2438.robot.commands;

/**
 * @author iobotics
 */
public class ToggleDrive extends CommandBase {
    
    //private static final double DEADBAND = 0.05;
    
    public ToggleDrive() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drivetrain.setPneumaticDriveSwitch(!drivetrain.isDriveMecanum());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { }

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
    }
}