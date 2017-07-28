package org.usfirst.frc.team2438.robot;

import org.usfirst.frc.team2438.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// joysticks //
    private final Joystick _lStick = new Joystick(1);
    private final Joystick _rStick = new Joystick(2);
    
    // buttons //
    private final Button _actuateButton = new JoystickButton(_rStick, 3);

	public OI() {
		_actuateButton.whenPressed(new ToggleDrive());
	}
    
    public Joystick getLeftStick()  {
        return _lStick;
    }
    
    public Joystick getRightStick()  {
        return _rStick;
    }
}
