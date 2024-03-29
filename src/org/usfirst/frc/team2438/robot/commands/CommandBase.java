package org.usfirst.frc.team2438.robot.commands;

import org.usfirst.frc.team2438.robot.OI;
import org.usfirst.frc.team2438.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {
	
	public static OI oi;
	
	public static final Drivetrain 		 drivetrain = new Drivetrain();
	public static final NavigationSensor navsensor  = new NavigationSensor();

	public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        drivetrain.init();
        navsensor.init();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
