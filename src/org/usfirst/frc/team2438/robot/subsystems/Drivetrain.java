package org.usfirst.frc.team2438.robot.subsystems;

import org.usfirst.frc.team2438.robot.RobotMap;
import org.usfirst.frc.team2438.robot.commands.OperateMecanumDrive;
import org.usfirst.frc.team2438.robot.commands.OperateTankDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.drive.Vector2d;

/**
 * @author iobotics
 */
public class Drivetrain extends Subsystem {
	private TalonSRX _frontLeftMain;
	private TalonSRX _frontLeftSlave;
	private TalonSRX _frontRightMain;
	private TalonSRX _frontRightSlave;

	private TalonSRX _backLeftMain;
	private TalonSRX _backLeftSlave;
	private TalonSRX _backRightMain;
	private TalonSRX _backRightSlave;

	private DoubleSolenoid _solenoid;

	private boolean mecanumActivated;

	public void init() {
		_frontLeftMain = new TalonSRX(RobotMap.frontLeftMain);
		_frontLeftSlave = new TalonSRX(RobotMap.frontLeftSlave);
		_frontLeftSlave.follow(_frontLeftMain);

		_frontRightMain = new TalonSRX(RobotMap.frontRightMain);
		_frontRightSlave = new TalonSRX(RobotMap.frontRightSlave);
		_frontRightSlave.follow(_frontRightMain);

		_backLeftMain = new TalonSRX(RobotMap.backLeftMain);
		_backLeftSlave = new TalonSRX(RobotMap.backLeftSlave);
		_backLeftSlave.follow(_backLeftMain);

		_backRightMain = new TalonSRX(RobotMap.backRightMain);
		_backRightSlave = new TalonSRX(RobotMap.backRightSlave);
		_backRightSlave.follow(_backRightMain);

		_solenoid = new DoubleSolenoid(RobotMap.solenoidMain, RobotMap.solenoidSlave);

		mecanumActivated = false;
	}

	public void setTank(double left, double right) {
		left = Math.copySign(left * left, left);
		right = Math.copySign(right * right, right);

		_frontLeftMain.set(ControlMode.PercentOutput, -left);
		_backLeftMain.set(ControlMode.PercentOutput, -left);
		_frontRightMain.set(ControlMode.PercentOutput, right);
		_backRightMain.set(ControlMode.PercentOutput, right);
	}

	public void setMecanum(double x, double y, double rot, double gyro) {		
		Vector2d input = new Vector2d(y, x);
	    input.rotate(-gyro);

	    double[] wheelSpeeds = new double[4];
	    wheelSpeeds[MotorType.kFrontLeft.value]  = input.x + input.y + rot;
	    wheelSpeeds[MotorType.kFrontRight.value] = input.x - input.y + rot;
	    wheelSpeeds[MotorType.kRearLeft.value]   = -input.x + input.y + rot;
	    wheelSpeeds[MotorType.kRearRight.value]  = -input.x - input.y + rot;

	    double maxMagnitude = Math.abs(wheelSpeeds[0]);
	    for (int i = 1; i < wheelSpeeds.length; i++) {
	      double temp = Math.abs(wheelSpeeds[i]);
	      if (maxMagnitude < temp) {
	        maxMagnitude = temp;
	      }
	    }
	    if (maxMagnitude > 1.0) {
	      for (int i = 0; i < wheelSpeeds.length; i++) {
	        wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
	      }
	    }

	    _frontLeftMain.set(ControlMode.PercentOutput, wheelSpeeds[MotorType.kFrontLeft.value]);
	    _frontRightMain.set(ControlMode.PercentOutput, wheelSpeeds[MotorType.kFrontRight.value]);
	    _backLeftMain.set(ControlMode.PercentOutput, wheelSpeeds[MotorType.kRearLeft.value]);
	    _backRightMain.set(ControlMode.PercentOutput, wheelSpeeds[MotorType.kRearRight.value]);
	}

	public void setPneumaticDriveSwitch(boolean mecanum) {
		if (mecanum) {
			_solenoid.set(DoubleSolenoid.Value.kForward);
			setDefaultCommand(new OperateMecanumDrive());
		} else {
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