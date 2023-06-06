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
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;

    public GUI() {
        createComponents();
    }
    private void createComponents() {
        info.setForeground(Color.black);
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

        });
    }
}