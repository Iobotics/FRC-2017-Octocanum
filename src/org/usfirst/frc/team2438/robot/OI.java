package org.usfirst.frc.team2438.robot;

import org.usfirst.frc.team2438.robot.commands.ToggleDrive;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// joysticks //
    private final XboxController _gamepad = new XboxController(1);
    
    // buttons //
    private final Button _actuateButton = new JoystickButton(_gamepad, 2);
    //private final Button _kiddieButton = new JoystickButton(_gamepad, 8);

	public OI() {
		_actuateButton.whenPressed(new ToggleDrive());
	}
    
	public double getX(GenericHID.Hand hand)  {
        return -_gamepad.getX(hand);
    }
	
	public double getY(GenericHID.Hand hand)  {
        return -_gamepad.getY(hand);
    }
    
    public double getMagnitude(GenericHID.Hand hand) {
    	return Math.sqrt(Math.pow(getX(hand), 2) + Math.pow(getY(hand), 2));
    }
    
    public double getDirectionDegrees(GenericHID.Hand hand) {
    	return Math.toDegrees(Math.atan2(getX(hand), -getY(hand)));
    }
}
