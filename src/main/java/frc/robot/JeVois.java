package frc.robot;

import edu.wpi.first.wpilibj.SerialPort;

public class JeVois extends Thread {

    private boolean enabled = false;

    private SerialPort camera;
    private String lastString;
    private Double lastDouble = 0.5D;

    public JeVois() {
        this(SerialPort.Port.kUSB);
    }

    public JeVois(SerialPort.Port port) { // port should be kUSB, kUSB1, or kUSB2
        this.camera = new SerialPort(115200, port);
    }

    @Override
    public void run() {
        while (true) {
            if (this.enabled) {
                try {
                    this.lastString = camera.readString().trim();
                    System.out.println(lastString);
                    if (!lastString.equals("")) {
                        if (lastString.equals("None")) {
                            lastDouble = 0.5;
                        } else {
                            try {
                                lastDouble = Double.valueOf(lastString);
                            } catch (NumberFormatException exception) {
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(this.lastDouble);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    public String getLastString() {
        return lastString;
    }

    public Double getLastDouble() {
        return lastDouble;
    }

}