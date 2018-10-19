package frc.mechs;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.config.*;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Mech;

public class RotisserieDora extends Mech {

    Solenoid mechSolenoid = new Solenoid(Config);
    TalonSRX mechTalon = new TalonSRX(2);

    private RotisserieDora() {
        // Config.getInt("RotisserieDora");
        private void loop() throws InterruptedException {
            Solenoid mechSolenoid;
            TalonSRX mechTalon;
    
            mechSolenoid.set(true);
            Thread.sleep(5000);
            mechSolenoid.set(false);
            mechTalon.set(0.25);
            // code here is repeated continuously while the haunted house is enabled
            // there is no built-in delay
        }

        
    }

}