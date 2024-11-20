package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Motorları kontrol eden alt sistem sınıfı
public class MotorSubsystem extends SubsystemBase {
    private final PWMVictorSPX motorA; // A motoru
// A motoru
    private final PWMVictorSPX motorB;
    // Switch mod durumu
    // B motoru
    private boolean isSwitchMode = false;
    // Reverse mod durumu
    // Switch mod durumu
    private boolean isReverseMode = false; // Reverse mod durumu

    // Alt sistemi başlatmak için gerekli port numaralarını alır
    public MotorSubsystem(int motorPortA, int motorPortB) {
        motorA = new PWMVictorSPX(motorPortA);
        motorB = new PWMVictorSPX(motorPortB);
        motorA.setSafetyEnabled(true); // Motor güvenliği etkin
        motorB.setSafetyEnabled(true); // Motor güvenliği etkin
    }

    public boolean isIsSwitchMode() {
        return isSwitchMode;
    }

    public void setIsSwitchMode(boolean isSwitchMode) {
        this.isSwitchMode = isSwitchMode;
    }

    public boolean isIsReverseMode() {
        return isReverseMode;
    }

    public void setIsReverseMode(boolean isReverseMode) {
        this.isReverseMode = isReverseMode;
    }

    // Motor hızlarını ayarlar...

}
