
package org.usfirst.frc.team3597.robot.subsystems;

import org.usfirst.frc.team3597.robot.Robot;
import org.usfirst.frc.team3597.robot.RobotMap;
import org.usfirst.frc.team3597.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    
    Talon LeftMotor; 
    Talon RightMotor; 
    Talon TestTalon; 
    
    RobotDrive TankDrive; 
    
    Joystick DriveStick; 
    
    DigitalInput TestSwitch; 
    
    Boolean isSwitchPressed; 
    
    public Chassis(){
    	LeftMotor = new Talon(RobotMap.LeftTalon);
    	RightMotor = new Talon(RobotMap.RightTalon);
    	TestTalon = new Talon(RobotMap.TestTalon);
    	
    	TankDrive = new RobotDrive(LeftMotor, RightMotor); 
    
    	TestSwitch = new DigitalInput(RobotMap.TestSwitch);
    	
    }
    
    public void initDefaultCommand() {
    	
    	setDefaultCommand(new TankDrive());
    	
    }
    
    
    public void tankDrive(){
    	
    	DriveStick = Robot.oi.getDriverStick(); 
    	
    	TankDrive.tankDrive(DriveStick.getRawAxis(2), DriveStick.getRawAxis(5));
    
    }
    
    public void driveUntilSwitch() {
    	
    	isSwitchPressed = TestSwitch.get();
    	
    	while(isSwitchPressed == false){
    		
    		TestTalon.set(1.0);
    		
    		
    	}
    	
    	TestTalon.set(0.0);
    	
    }
    
}

