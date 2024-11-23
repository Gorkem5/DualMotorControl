package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

// Robotun yaşam döngüsünü yöneten sınıf
public class Robot extends TimedRobot {
    private RobotContainer robotContainer;

    // Robot başlatıldığında çağrılan metot
    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
    }

    // Robot periyodik olarak çalıştırıldığında çağrılan metot
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    // Teleoperasyon başlangıcında çağrılan metot
    @Override
    public void teleopInit() {}

    // Teleoperasyon periyodik olarak çalıştırıldığında çağrılan metot
    @Override
    public void teleopPeriodic() {}

    // Test moduna geçildiğinde çağrılan metot
    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    // Test modunda periyodik olarak çalıştırıldığında çağrılan metot
    @Override
    public void testPeriodic() {}
}
