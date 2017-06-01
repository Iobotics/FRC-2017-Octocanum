package org.usfirst.frc.team2438.robot;

import org.usfirst.frc.team2438.robot.commands.ActuatePod;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// joysticks //
    private final Joystick _lStick = new Joystick(1);
    
    // buttons //
    private final Button _actuateButton = new JoystickButton(_lStick, 3);

	public OI() {
		_actuateButton.whenPressed(new ActuatePod());
	}
    
    public Joystick getLeftStick()  {
        return _lStick;
    }
}
