package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

// Motor kontrol modunu değiştiren komut
public class SwitchModeCommand extends Command {
    private final MotorSubsystem motorSubsystem;

    public SwitchModeCommand(MotorSubsystem motorSubsystem) {
        this.motorSubsystem = motorSubsystem;
        // addRequirements(motorSubsystem) kaldırıldı
    }

    @Override
    public void initialize() {
        motorSubsystem.setSwitchMode(!motorSubsystem.isSwitchMode());
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
