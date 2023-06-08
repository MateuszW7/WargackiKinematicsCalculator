import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private JTextField time;
    private JTextField distance;
    private JTextField velocityI;
    private JTextField velocityF;
    private JTextField acceleration;
    private JButton solveButton;
    private JPanel label;
    private JLabel info;
    private JTabbedPane tabbedPane1;
    private JPanel CM;
    private JTextField massFM;
    private JTextField velocityFM;
    private JTextField momentumFM;
    private JTextField forceFM;
    private JButton solveButton2;
    private JTextField accelerationFM;
    private JLabel textField;
    private JTextField massC;
    private JTextField radiusC;
    private JTextField velocityC;
    private JTextField accelerationC;
    private JTextField forceC;
    private JButton solveButton3;
    private JLabel info2;
    private JLabel info3;

    public GUI() {
        createComponents();
    }
    private void createComponents() {
        info.setForeground(Color.black);
        info2.setForeground(Color.black);
        info3.setForeground(Color.black);
        Equations equ = new Equations();
        setContentPane(label);
        setSize(750,500);
        setLocation(500,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        solveButton.addActionListener(e ->{
            int counter = 0;
            if(!time.getText().equals("")){
                equ.setT(Double.parseDouble(time.getText()));
                counter++;
            }
            if(!distance.getText().equals("")){
                equ.setD(Double.parseDouble(distance.getText()));
                counter++;
            }
            if(!velocityI.getText().equals("")){
                equ.setVi(Double.parseDouble(velocityI.getText()));
                counter++;
            }
            if(!velocityF.getText().equals("")){
                equ.setVf(Double.parseDouble(velocityF.getText()));
                counter++;
            }
            if(!acceleration.getText().equals("")){
                equ.setA(Double.parseDouble(acceleration.getText()));
                counter++;
            }
            if(counter<3){
                info.setText("Please enter at least 3 values");
                info.setForeground(Color.red);
            }else {
                equ.solve();
                time.setText(String.valueOf(equ.getT()) + "s");
                distance.setText(String.valueOf(equ.getD()) + "m");
                velocityF.setText(String.valueOf(equ.getVf()) + "m/s");
                velocityI.setText(String.valueOf(equ.getVi()) + "m/s");
                acceleration.setText(String.valueOf(equ.getA()) + "m/s²");
            }
            equ.refresh();
        });

        solveButton2.addActionListener(e ->{
            if(!massFM.getText().equals("")){
                equ.setM(Double.parseDouble(massFM.getText()));
            }
            if(!velocityFM.getText().equals("")){
                equ.setVi(Double.parseDouble(velocityFM.getText()));
            }
            if(!accelerationFM.getText().equals("")){
                equ.setA(Double.parseDouble(accelerationFM.getText()));
            }
            if(!momentumFM.getText().equals("")){
                equ.setP(Double.parseDouble(momentumFM.getText()));
            }
            if(!forceFM.getText().equals("")){
                equ.setN(Double.parseDouble(forceFM.getText()));
            }
            boolean temp = equ.solveFM();
            if(!temp){
                info2.setText("Unable to solve for values ");
                info2.setForeground(Color.red);
            }else{
                massFM.setText(String.valueOf(equ.getM()) + "kg");
                velocityFM.setText(String.valueOf(equ.getVi()) + "m/s");
                accelerationFM.setText(String.valueOf(equ.getA()) + "m/s²");
                momentumFM.setText(String.valueOf(equ.getP()) + "N*s");
                forceFM.setText(String.valueOf(equ.getN()) + "N");
            }
            equ.refresh();
        });

        solveButton3.addActionListener(e ->{
            if(!massC.getText().equals("")){
                equ.setM(Double.parseDouble(massC.getText()));
            }
            if(!radiusC.getText().equals("")){
                equ.setR(Double.parseDouble(radiusC.getText()));
            }
            if(!velocityC.getText().equals("")){
                equ.setVi(Double.parseDouble(velocityC.getText()));
            }
            if(!accelerationC.getText().equals("")){
                equ.setA(Double.parseDouble(accelerationC.getText()));
            }
            if(!forceC.getText().equals("")){
                equ.setN(Double.parseDouble(forceC.getText()));
            }
            boolean temp = equ.solveCM();
            if(!temp){
                info3.setText("Unable to solve for values ");
                info3.setForeground(Color.red);
            }else{
                massC.setText(String.valueOf(equ.getM()) + "kg");
                radiusC.setText(String.valueOf(equ.getR()) + "m");
                velocityC.setText(String.valueOf(equ.getVi()) + "m/s");
                accelerationC.setText(String.valueOf(equ.getA()) + "m/s²");
                forceC.setText(String.valueOf(equ.getN()) + "N");
            }
            equ.refresh();
        });
    }
}
