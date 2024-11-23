package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Motorları kontrol eden alt sistem sınıfı
public class MotorSubsystem extends SubsystemBase {
    private final PWMVictorSPX motorA;
    private final PWMVictorSPX motorB;
    private boolean isSwitchMode = false;
    private boolean isReverseMode = false;

    // Alt sistemi başlatmak için gerekli port numaralarını alır
    public MotorSubsystem(int motorPortA, int motorPortB) {
        motorA = new PWMVictorSPX(motorPortA);
        motorB = new PWMVictorSPX(motorPortB);
        motorA.setSafetyEnabled(true);
        motorB.setSafetyEnabled(true);
    }

    // Motor hızlarını ayarlar
    public void setMotorSpeeds(double speedA, double speedB) {
        motorA.set(isReverseMode ? -speedA : speedA);
        motorB.set(isReverseMode ? -speedB : speedB);
    }

    // Switch modunu ayarlar
    public void setSwitchMode(boolean switchMode) {
        isSwitchMode = switchMode;
    }

    // Reverse modunu ayarlar
    public void setReverseMode(boolean reverseMode) {
        isReverseMode = reverseMode;
    }

    // Switch modunun durumunu döner
    public boolean isSwitchMode() {
        return isSwitchMode;
    }

    // Reverse modunun durumunu döner
    public boolean isReverseMode() {
        return isReverseMode;
    }

    // Motor hızlarını joystick kontrol komutuna göre günceller
    @Override
    public void periodic() {
    }
}
