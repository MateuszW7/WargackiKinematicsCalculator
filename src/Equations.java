public class Equations {
    private double t;
    private double d;
    private double vi;
    private double vf;
    private double a;

    public Equations(){
    }

    public void setT(double t) {
        this.t = t;
    }
    public void setD(double d) {
        this.d = d;
    }
    public void setVi(double vi) {
        this.vi = vi;
    }
    public void setVf(double vf) {
        this.vf = vf;
    }
    public void setA(double a) {
        this.a = a;
    }

    public void solveT(){
        if(){
            t = (vf-vi)/a;
        }
        if(){
            t = d/(0.5*(vf+vi));
        }

    }

    public void solveD(){
        if(){
            d = vi*t + (0.5 * a * Math.pow(t,2));
        }
        if(){
            d = vf*t - (0.5 * a * Math.pow(t,2));
        }
        if(){
            d = (Math.pow(vf,2) - Math.pow(vi,2))/(2*a);
        }
        if(){
            d = 0.5 * (vf + vi) * t;
        }
    }

    public void solveVi(){
        if(){
            
        }
    }

}
