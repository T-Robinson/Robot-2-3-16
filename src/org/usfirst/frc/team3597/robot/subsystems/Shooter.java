package org.usfirst.frc.team3597.robot.subsystems;

import org.usfirst.frc.team3597.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    Relay ShooterLoad; 
    Relay ShooterShoot; 

    DigitalInput LoadedSwitch; //Let's get loaded switch! 
    
    Boolean isLoaded;
    
    public Shooter(){
    	
    	ShooterLoad = new Relay(RobotMap.ShooterLoad);
    	ShooterShoot = new Relay(RobotMap.ShooterFire);
    	
    	LoadedSwitch = new DigitalInput(RobotMap.ShooterSwitch);
    	
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }
    
    
    public void driveLoadMotor(){

    	ShooterLoad.setDirection(Relay.Direction.kForward);
    	ShooterLoad.set(Relay.Value.kOn);

    } 
    
    
    public void stopLoadMotor(){
    	
    	ShooterLoad.set(Relay.Value.kOff);
    	
    }
    
    public void loadShooter(){
    
    	isLoaded = LoadedSwitch.get();
    
    	while(isLoaded == false){
    		
        	ShooterLoad.setDirection(Relay.Direction.kForward);
        	ShooterLoad.set(Relay.Value.kOn);	
    	}
    
    	ShooterLoad.set(Relay.Value.kOff);
    	
    }
    
    
    public void shooterFire(){
    	
    	ShooterShoot.setDirection(Relay.Direction.kForward);
    	ShooterShoot.set(Relay.Value.kOn);
    	
    	
    }
    
    public void stopShootMotor(){
    	
    	ShooterShoot.set(Relay.Value.kOff);
    	
    }
    
    
    
    

    

}

