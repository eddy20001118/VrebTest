package Main;

import Command.DriveCommand.DriveStraightForTime;
import RobotControl.RoboDrive;
import coppelia.remoteApi;

import static Main.Main.vrep;

public class Robot {
    private int clientID;
    private RoboDrive mydrive;

    public static void delay(int mmSecond) {
        try {
            Thread.sleep(mmSecond);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public Robot(int clientID) {
        this.clientID = clientID;
        mydrive = new RoboDrive(clientID, vrep);
    }

    public int getClientID() {
        return clientID;
    }

    public void autonomousPeriod() {
        //mydrive.aracdeDrive(-3, 0);
        DriveStraightForTime dt = new DriveStraightForTime(clientID);
        dt.run(2,0,5*1000);
        dt.stop();
        //new DriveStraightForTime(this.clientID,0,0,500);
        //new DriveStraightForTime(this.clientID,0,5,2000);
        //new DriveStraightForTime(this.clientID,0,0,500);
    }
}
