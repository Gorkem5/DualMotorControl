package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

// Motor dönüş yönünü değiştiren komut
public class ReverseModeCommand extends Command {
    private final MotorSubsystem motorSubsystem;

    public ReverseModeCommand(MotorSubsystem motorSubsystem) {
        this.motorSubsystem = motorSubsystem;
        // addRequirements(motorSubsystem) kaldırıldı
    }

    @Override
    public void initialize() {
        motorSubsystem.setReverseMode(!motorSubsystem.isReverseMode());
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
