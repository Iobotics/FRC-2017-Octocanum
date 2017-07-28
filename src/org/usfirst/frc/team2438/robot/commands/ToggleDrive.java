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
    protected void execute() {
        /*if(drivetrain.isDriveMecanum()) {
            double mag = oi.getRightStick().getMagnitude();
            double dir = oi.getRightStick().getDirectionDegrees();
            double rot = oi.getLeftStick().getX();
            //PowerScaler scale = oi.getDriveScaler();
            if(scale != null) {
                mag = scale.get(mag);
                rot = scale.get(rot);
            } if(Math.abs(mag) < DEADBAND) { mag = 0.0; }
            if(Math.abs(rot) < DEADBAND) { rot = 0.0; }
        
            //System.out.println(mag + " , " + dir + " , " + rot);
            //System.out.println("LR: " + drivetrain.getLeftRearEncoder() + ", RR: " + drivetrain.getRightRearEncoder());
            //drivetrain.debug();
        
            drivetrain.setMecanum(mag, dir, rot);
        } else {
            double left = -oi.getLeftStick().getY();
            double right = -oi.getRightStick().getY();
        
            drivetrain.setTank(left, right);
        }*/
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
    }
}