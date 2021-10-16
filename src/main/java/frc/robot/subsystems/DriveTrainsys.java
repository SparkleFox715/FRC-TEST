package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainsys extends SubsystemBase{
    private final WPI_VictorSPX m_frontLeft, m_frontRight, m_backLeft, m_backRight;
    
    private final DifferentialDrive m_drive;
    public DriveTrainsys(){
        m_frontLeft = new WPI_VictorSPX(Constants.frontLeft);
        m_frontRight = new WPI_VictorSPX(Constants.frontRight);
        m_backLeft = new WPI_VictorSPX(Constants.backLeft);
        m_backRight = new WPI_VictorSPX(Constants.backRight);

        m_backLeft.follow(m_frontLeft);
        m_backRight.follow(m_frontRight);
        m_drive = new DifferentialDrive(m_frontLeft, m_frontRight);

        m_frontLeft.configFactoryDefault();
        m_frontRight.configFactoryDefault();
        m_backLeft.configFactoryDefault();
        m_backRight.configFactoryDefault();

        m_frontLeft.setNeutralMode(NeutralMode.Brake);
        m_frontRight.setNeutralMode(NeutralMode.Brake);
        m_backLeft.setNeutralMode(NeutralMode.Brake);   
        m_backRight.setNeutralMode(NeutralMode.Brake);
    }
    public void arcadeDrive(double speed, double rotation){
        m_drive.arcadeDrive(speed, rotation);
    }
    public void resetDrive(){
        m_backLeft.set(0);
        m_frontLeft.set(0);
        m_backRight.set(0);
        m_frontRight.set(0);
    }
}
