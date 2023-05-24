import javax.swing.*;

public class GUI extends JFrame{
    private JTextField time;
    private JTextField distance;
    private JTextField velocityI;
    private JTextField velocityF;
    private JTextField acceleration;
    private JButton solveButton;
    private JPanel label;
    private JLabel info;

    public GUI() {
        createComponents();
    }
    private void createComponents() {
        Equations equ = new Equations();
        setContentPane(label);
        setSize(750,500);
        setLocation(500,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        solveButton.addActionListener(e ->{
            if(!time.getText().equals("")){
                equ.setT(Double.parseDouble(time.getText()));
            }
            if(!distance.getText().equals("")){
                equ.setD(Double.parseDouble(distance.getText()));
            }
            if(!velocityI.getText().equals("")){
                equ.setVi(Double.parseDouble(velocityI.getText()));
            }
            if(!velocityF.getText().equals("")){
                equ.setVf(Double.parseDouble(velocityF.getText()));
            }
            if(!acceleration.getText().equals("")){
                equ.setA(Double.parseDouble(acceleration.getText()));
            }
            equ.solve();
            time.setText(String.valueOf(equ.getT()));
            distance.setText(String.valueOf(equ.getD()));
            velocityF.setText(String.valueOf(equ.getVf()));
            velocityI.setText(String.valueOf(equ.getVi()));
            acceleration.setText(String.valueOf(equ.getA()));
            equ.refresh();
        });
    }

}