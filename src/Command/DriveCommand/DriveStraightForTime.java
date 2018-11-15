package Command.DriveCommand;

import Main.Robot;
import RobotControl.RoboDrive;
import static Main.Main.vrep;

public class DriveStraightForTime {
    private RoboDrive myDrive;
    private int clientID;
    public DriveStraightForTime(int clientID) {
        this.clientID = clientID;
        myDrive = new RoboDrive(clientID,vrep);
    }

    public void run(float xSpeed, float zRotate, double mmSeconds) {
        while (mmSeconds > 0) {
            myDrive.aracdeDrive(xSpeed, zRotate);
            //TODO
            Robot.delay(10);
            mmSeconds -= 10;
        }

    }

    public void stop(){
        myDrive.stopMotor();
        Robot.delay(100);
    }
}
