public class Equations {
    private double t;
    private double d;
    private double vi;
    private double vf;
    private double a;

    private boolean isT,isD,isVi,isVf,isA;
    public Equations(){
        isT=false;
        isD=false;
        isVi=false;
        isVf=false;
        isA=false;
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
        if(!isD){
            t = (vf-vi)/a;
        } else {
            t = d/(0.5*(vf+vi));
        }
    }

    public void solveD(){
        if(!isVf){
            d = vi*t + (0.5 * a * Math.pow(t,2));
        } else if (!isVi) {
            d = vf*t - (0.5 * a * Math.pow(t,2));
        } else if (!isT) {
            d = (Math.pow(vf,2) - Math.pow(vi,2))/(2*a);
        } else {
            d = 0.5 * (vf + vi) * t;
        }
    }

    public void solveVi(){
        if(!isD){
            vi = vf - a * t;
        } else if (!isA) {
            vi = 2.0*d/t - vf;
        } else if (!isT){
            vi = Math.sqrt(Math.pow(vf,2)-2*a*d);
        } else {
            vi = (d-0.5*a*Math.pow(t,2))/t;
        }
    }

    public void solveVf(){
        if(!isD){
            vf = vi + a * t;
        } else if (!isA) {
            vf = 2.0*d/t - vi;
        } else if (!isT){
            vf = Math.sqrt(Math.pow(vf,2)+2*a*d);
        } else{
            vf = (d+0.5*a*Math.pow(t,2))/t;
        }
    }

    public void solveA() {
        if (!isT) {
            a = (Math.pow(vf, 2) - Math.pow(vi, 2)) / (2.0 * d);
        } else if (!isVi) {
            a = (d - vf * t) / (-0.5 * Math.pow(t, 2));
        } else if (!isVf) {
            a = (d - vf * t) / (0.5 * Math.pow(t, 2));
        } else {
            a = (vf - vi) / t;
        }
    }

    public void solve(){
        if(!isD){
            solveD();
        }
        if(!isVi){
            solveVi();
        }
        if(!isVf){
            solveVf();
        }
        if(!isA){
            solveA();
        }
        if(!isT){
            solveT();
        }
    }
}
