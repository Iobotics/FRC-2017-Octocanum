package org.usfirst.frc.team2438.robot.subsystems;

import org.usfirst.frc.team2438.robot.RobotMap;
import org.usfirst.frc.team2438.robot.commands.OctoPodDrive;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

/**
 * @author darrenk1801
 */
public class OctoPod extends Subsystem {

    private CANTalon _driveMain;
    private CANTalon _driveSlave;
    
    private Solenoid _solenoidMain;

    public void init() {
    	_driveMain = new CANTalon(RobotMap.driveMain);
    	
    	_driveSlave = new CANTalon(RobotMap.driveSlave);
    	_driveSlave.changeControlMode(TalonControlMode.Follower);
    	_driveSlave.set(_driveMain.getDeviceID());
    }

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new OctoPodDrive());
	}
	
	public void drivePod(double power) {
		_driveMain.set(power);
	}
	
	public void actuate() {
		_solenoidMain.set(!_solenoidMain.get());
	}
}

