public class Equations {
    private double t;
    private double d;
    private double vi;
    private double vf;
    private double a;
    private double m;
    private double p;
    private double n;
    private double r;

    private boolean isT,isD,isVi,isVf,isA,isM,isP,isN,isR;
    public Equations(){
        isT=false;
        isD=false;
        isVi=false;
        isVf=false;
        isA=false;
        isM=false;
        isP=false;
        isN=false;
        isR=false;
    }

    public void setT(double t) {
        this.t = t;
        isT = true;
    }
    public void setD(double d) {
        this.d = d;
        isD = true;
    }
    public void setVi(double vi) {
        this.vi = vi;
        isVi = true;
    }
    public void setVf(double vf) {
        this.vf = vf;
        isVf = true;
    }
    public void setA(double a) {
        this.a = a;
        isA = true;
    }
    public void setM(double m) {
        this.m = m;
        isM = true;
    }
    public void setP(double p) {
        this.p = p;
        isP = true;
    }
    public void setN(double n) {
        this.n = n;
        isN = true;
    }

    public void setR(double r) {
        this.r = r;
        isR = true;
    }

    public double getT(){
        return t;
    }
    public double getD(){
        return d;
    }
    public double getA() {
        return a;
    }
    public double getVf() {
        return vf;
    }
    public double getVi() {
        return vi;
    }
    public double getM() {
        return m;
    }
    public double getP() {
        return p;
    }
    public double getN() {
        return n;
    }
    public double getR() {
        return r;
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

    public void solveM() {
        if(!isN) {
            m = p/vi;
        } else if (!isP) {
            m = n/a;
        }
    }

    public void solveP(){

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

    public void refresh(){
        t = 0;
        d = 0;
        vi = 0;
        vf = 0;
        a = 0;
        m = 0;
        p = 0;
        n = 0;
        isA = false;
        isD = false;
        isT = false;
        isVf = false;
        isVi = false;
        isM = false;
        isP = false;
        isN = false;
    }
}
