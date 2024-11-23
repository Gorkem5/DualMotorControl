package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

// Joystick ile motor kontrol komutu
public class JoystickControlCommand extends Command {
    private final MotorSubsystem motorSubsystem;
    private final Supplier<Double> xAxisSupplier;
    private final Supplier<Double> yAxisSupplier;

    public JoystickControlCommand(MotorSubsystem motorSubsystem, Supplier<Double> xAxisSupplier, Supplier<Double> yAxisSupplier) {
        this.motorSubsystem = motorSubsystem;
        this.xAxisSupplier = xAxisSupplier;
        this.yAxisSupplier = yAxisSupplier;
        addRequirements(motorSubsystem); // Sadece burada bırakıyoruz
    }

    @Override
    public void execute() {
        double xAxis = xAxisSupplier.get();
        double yAxis = yAxisSupplier.get();
        motorSubsystem.setMotorSpeeds(xAxis, yAxis);
    }

    @Override
    public void end(boolean interrupted) {
        motorSubsystem.setMotorSpeeds(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
