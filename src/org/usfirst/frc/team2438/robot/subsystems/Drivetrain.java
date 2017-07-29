package org.usfirst.frc.team2438.robot.subsystems;

import org.usfirst.frc.team2438.robot.commands.OperateMecanumDrive;
import org.usfirst.frc.team2438.robot.commands.OperateTankDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import org.usfirst.frc.team2438.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author iobotics
 */
public class Drivetrain extends Subsystem {
    private CANTalon _frontLeftMain;
	private CANTalon _frontLeftSlave;
	private CANTalon _frontRightMain;
	private CANTalon _frontRightSlave;
	
	private CANTalon _backLeftMain;
	private CANTalon _backLeftSlave;
	private CANTalon _backRightMain;
	private CANTalon _backRightSlave;
    
    private DoubleSolenoid _solenoid;
    
    private RobotDrive _drive;
    
    private boolean mecanumActivated;
    
    public void init() {
    	_frontLeftMain = new CANTalon(RobotMap.frontLeftMain);
		_frontLeftSlave = new CANTalon(RobotMap.frontLeftSlave);
		_frontLeftSlave.changeControlMode(TalonControlMode.Follower);
		_frontLeftSlave.set(_frontLeftMain.getDeviceID());

		_frontRightMain = new CANTalon(RobotMap.frontRightMain);
		_frontRightSlave = new CANTalon(RobotMap.frontRightSlave);
		_frontRightSlave.changeControlMode(TalonControlMode.Follower);
		_frontRightSlave.set(_frontRightMain.getDeviceID());

		_backLeftMain = new CANTalon(RobotMap.backLeftMain);
		_backLeftSlave = new CANTalon(RobotMap.backLeftSlave);
		_backLeftSlave.changeControlMode(TalonControlMode.Follower);
		_backLeftSlave.set(_backLeftMain.getDeviceID());
		
		_backRightMain = new CANTalon(RobotMap.backRightMain);
		_backRightSlave = new CANTalon(RobotMap.backRightSlave);
		_backRightSlave.changeControlMode(TalonControlMode.Follower);
		_backRightSlave.set(_backRightMain.getDeviceID());
		
		_solenoid = new DoubleSolenoid(RobotMap.solenoidMain, RobotMap.solenoidSlave);
        
        _drive = new RobotDrive(_frontLeftMain, _backLeftMain, _frontRightMain, _backRightMain);
        _drive.setSafetyEnabled(false);
        
        mecanumActivated = false;
    }        
    
    public void setTank(double left, double right) {
        _drive.tankDrive(left, right);
    }
    
    public void setMecanum(double x, double y, double rot, double gyro) {
        _drive.mecanumDrive_Cartesian(x, y, rot, gyro);
    }
    
    public void setPneumaticDriveSwitch(boolean mecanum) {
        if(mecanum) {
        	_solenoid.set(DoubleSolenoid.Value.kForward);
        	setDefaultCommand(new OperateMecanumDrive());
        }
        else {
        	_solenoid.set(DoubleSolenoid.Value.kReverse);
        	setDefaultCommand(new OperateTankDrive());
        }
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        _solenoid.set(DoubleSolenoid.Value.kOff);
        
        mecanumActivated = !mecanumActivated;
    }
    
    public boolean isDriveMecanum() {
        return mecanumActivated;
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new OperateTankDrive());
    }
}