package RobotControl;

import Main.Main;
import coppelia.IntW;
import coppelia.remoteApi;

public class RoboDrive {
    remoteApi vrep;
    int clientID;
    IntW left_front = new IntW(-1);
    IntW right_front = new IntW(-1);
    IntW left_rear = new IntW(-1);
    IntW right_rear = new IntW(-1);
    public RoboDrive(int clientID, remoteApi vrep){
        System.out.println(clientID);
        this.clientID = clientID;
        this.vrep = vrep;
        vrep.simxGetObjectHandle(clientID,"joint_front_left_wheel", left_front,remoteApi.simx_opmode_blocking);
        vrep.simxGetObjectHandle(clientID,"joint_front_right_wheel", right_front,remoteApi.simx_opmode_blocking);
        vrep.simxGetObjectHandle(clientID,"joint_back_right_wheel", right_rear,remoteApi.simx_opmode_blocking);
        vrep.simxGetObjectHandle(clientID,"joint_back_left_wheel", left_rear,remoteApi.simx_opmode_blocking);
    }

    public void setClientID(int clientID){
        this.clientID = clientID;
    }

    public void aracdeDrive(float xSpeed, float zRotate){
        vrep.simxSetJointTargetVelocity(clientID,left_front.getValue(),xSpeed+zRotate,remoteApi.simx_opmode_streaming);
        vrep.simxSetJointTargetVelocity(clientID,left_rear.getValue(),xSpeed+zRotate,remoteApi.simx_opmode_streaming);
        vrep.simxSetJointTargetVelocity(clientID,right_front.getValue(),-xSpeed+zRotate,remoteApi.simx_opmode_streaming);
        vrep.simxSetJointTargetVelocity(clientID,right_rear.getValue(),-xSpeed+zRotate,remoteApi.simx_opmode_streaming);

    }
    public void stopMotor(){
        vrep.simxSetJointTargetVelocity(clientID,left_front.getValue(),0,remoteApi.simx_opmode_streaming);
        vrep.simxSetJointTargetVelocity(clientID,left_rear.getValue(),0,remoteApi.simx_opmode_streaming);
        vrep.simxSetJointTargetVelocity(clientID,right_front.getValue(),0,remoteApi.simx_opmode_streaming);
        vrep.simxSetJointTargetVelocity(clientID,right_rear.getValue(),0,remoteApi.simx_opmode_streaming);
    }

    public void tankDrive(float leftSpeed, float rightSpeed){

    }

}
