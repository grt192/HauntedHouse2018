package frc.mechs;

import frc.robot.Mech;

//import org.opencv.core. ????? ;
//import com.ctre.phoenix.motorcontrol. ????? ; 

public class TurningHead extends Mech {

    public TurningHead() {
        // needs: encoder????, motor, camera
    }

    public void loop() throws InterruptedException {
        // - detect faces - opencv haar classifier? - Plenty of pretrained models (maybe
        // separate thread???)

        // opencv haar classifer returns points of a rectange around detected obj - easy
        // to track

        // - find closest face (the largest one?)

        // - move to closest detected face (put on a timer, so its not snaping around to
        // different faces????)

        // We can also intermitantly do some fancy animations with the head (make it
        // skake, do a 360, etc.)????
    }
}