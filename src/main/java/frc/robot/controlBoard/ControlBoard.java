package frc.robot.controlBoard;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public interface ControlBoard {

    //=========Driver Controls===========
    public DoubleSupplier leftX();

    public DoubleSupplier leftY();

    public DoubleSupplier rightX();

    // public Trigger setZeroHeading();

    //========Operator Controls==========
}
