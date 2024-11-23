package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

// Joystick ile motor kontrol komutu
public class JoystickControlCommand extends Command {
    private final MotorSubsystem motorSubsystem;
    private final Supplier<Double> xAxisSupplier; // X ekseni değerini sağlayan Supplier
    private final Supplier<Double> yAxisSupplier; // Y ekseni değerini sağlayan Supplier

    public JoystickControlCommand(MotorSubsystem motorSubsystem, Supplier<Double> xAxisSupplier, Supplier<Double> yAxisSupplier) {
        this.motorSubsystem = motorSubsystem;
        this.xAxisSupplier = xAxisSupplier;
        this.yAxisSupplier = yAxisSupplier;
        addRequirements(motorSubsystem); // Bu komutun motor alt sistemine ihtiyaç duyduğunu belirtir
    }

    // Komut çalıştırıldığında çağrılır
    @Override
    public void execute() {
        // Joystick'in X ve Y eksen değerlerini alır
        double xAxis = xAxisSupplier.get();
        double yAxis = yAxisSupplier.get();

        // Motor hızlarını joystick eksenlerine göre ayarlar
        double motorASpeed = motorSubsystem.isSwitchMode() ? yAxis : xAxis;
        double motorBSpeed = motorSubsystem.isSwitchMode() ? xAxis : yAxis;

        // Motor hızlarını alt sistem üzerinden ayarlar
        motorSubsystem.setMotorSpeeds(motorASpeed, motorBSpeed);
    }

    // Komut sona erdiğinde veya kesildiğinde çağrılır
    @Override
    public void end(boolean interrupted) {
        motorSubsystem.setMotorSpeeds(0, 0);
    }

    // Komutun sürekli çalışmasını sağlar
    @Override
    public boolean isFinished() {
        return false;
    }
}
