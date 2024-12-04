package frc.robot.controlBoard;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class SingleControl implements ControlBoard {
    XboxController controller = new XboxController(0);

    public DoubleSupplier leftX(){
        return () -> controller.getLeftX();
    }
    
    public DoubleSupplier leftY(){
        return() -> controller.getLeftY();
    }

    public DoubleSupplier rightX(){
        return() -> controller.getRightX();
    }

//     public Trigger setZeroHeading(){
//         return new Trigger(() ->{
//             return controller.getRightBumper();
//         }); 
//     }
}
