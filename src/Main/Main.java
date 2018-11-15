package Main;

import RobotControl.RoboDrive;
import coppelia.remoteApi;

public class Main {
    public static remoteApi vrep;
    private static int clientID;


    public static void main(String[] args) {
        System.out.println("Program started");
        vrep = new remoteApi();
        vrep.simxFinish(-1); // just in case, close all opened connections
        int clientID = vrep.simxStart("127.0.0.1", 19999, true, true, 5000, 5);
        if (clientID != -1) {
            /*
            int ret;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            ret = vrep.simxSynchronous(clientID, true);
            if (ret == remoteApi.simx_return_ok)
                vrep.simxSynchronousTrigger(clientID); */

            System.out.println("Connected to vrep");
            vrep.simxStartSimulation(clientID, vrep.simx_opmode_blocking);
            Robot myRobot = new Robot(clientID);
            myRobot.autonomousPeriod();
            vrep.simxPauseSimulation(clientID,vrep.simx_opmode_blocking);
        }
        vrep.simxFinish(clientID);
        System.out.println("Program ended");
    }

}


