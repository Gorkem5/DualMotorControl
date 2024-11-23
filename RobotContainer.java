package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.JoystickControlCommand;
import frc.robot.commands.SwitchModeCommand;
import frc.robot.commands.ReverseModeCommand;
import frc.robot.subsystems.MotorSubsystem;

import java.util.function.Supplier;

// Robot alt sistemlerini ve komutlarını yapılandıran sınıf
public class RobotContainer {
    private final MotorSubsystem motorSubsystem = new MotorSubsystem(
        Constants.MotorPorts.MOTOR_A,
        Constants.MotorPorts.MOTOR_B
    );
    private final Joystick joystick = new Joystick(Constants.OperatorConstants.JOYSTICK_PORT);

    public RobotContainer() {
        configureButtonBindings();
        motorSubsystem.setDefaultCommand(new JoystickControlCommand(
            motorSubsystem,
            () -> joystick.getRawAxis(0), // X ekseni değerini sağlayan Supplier
            () -> joystick.getRawAxis(1)  // Y ekseni değerini sağlayan Supplier
        ));
    }

    private void configureButtonBindings() {
        new JoystickButton(joystick, 1).onTrue(new SwitchModeCommand(motorSubsystem));
        new JoystickButton(joystick, 2).onTrue(new ReverseModeCommand(motorSubsystem));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
