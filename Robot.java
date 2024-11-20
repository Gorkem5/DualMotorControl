package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

// Robotun ana döngüsünü yöneten sınıf
public class Robot extends TimedRobot {
    private RobotContainer robotContainer;

    // Robot başlatıldığında çağrılan metot
    @Override
    public void robotInit() {
        // RobotContainer örneğini oluşturur
        robotContainer = new RobotContainer();
    }

    // Robot periyodik olarak çalıştırıldığında çağrılan metot
    @Override
    public void robotPeriodic() {
        // Komut planlayıcıyı çalıştırır
        CommandScheduler.getInstance().run();
    }

    // Teleoperasyon başlangıcında çağrılan metot
    @Override
    public void teleopInit() {
        // Teleoperasyon moduna geçişte yapılacak işlemler
    }

    // Teleoperasyon periyodik olarak çalıştırıldığında çağrılan metot
    @Override
    public void teleopPeriodic() {
        // Teleoperasyon sırasında yapılacak işlemler
    }

    // Test moduna geçildiğinde çağrılan metot
    @Override
    public void testInit() {
        // Tüm çalışan komutları iptal eder
        CommandScheduler.getInstance().cancelAll();
    }

    // Test modunda periyodik olarak çalıştırıldığında çağrılan metot
    @Override
    public void testPeriodic() {
        // Test modunda yapılacak işlemler
    }

    public RobotContainer getRobotContainer() {
        return robotContainer;
    }

    public void setRobotContainer(RobotContainer robotContainer) {
        this.robotContainer = robotContainer;
    }
}
