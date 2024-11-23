package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

// Motor kontrol modunu değiştiren komut
public class SwitchModeCommand extends Command {
    private final MotorSubsystem motorSubsystem;

    // Komutu başlatmak için gerekli bağımlılığı alır
    public SwitchModeCommand(MotorSubsystem motorSubsystem) {
        this.motorSubsystem = motorSubsystem;
        addRequirements(motorSubsystem); // Bu komutun motor alt sistemine ihtiyaç duyduğunu belirtir
    }

    @Override
    public void initialize() {
        motorSubsystem.setSwitchMode(!motorSubsystem.isSwitchMode()); 
    }

    // Komutun tamamlandığını belirtir
    @Override
    public boolean isFinished() {
        return true;
    }
}
