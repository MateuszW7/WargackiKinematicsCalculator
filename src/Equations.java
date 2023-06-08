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
            isT = true;
        } else {
            t = d/(0.5*(vf+vi));
            isT = true;
        }
    }
    public void solveD(){
        if(!isVf){
            d = vi*t + (0.5 * a * Math.pow(t,2));
            isD = true;
        } else if (!isVi) {
            d = vf*t - (0.5 * a * Math.pow(t,2));
            isD = true;
        } else if (!isT) {
            d = (Math.pow(vf,2) - Math.pow(vi,2))/(2*a);
            isD = true;
        } else {
            d = 0.5 * (vf + vi) * t;
            isD = true;
        }
    }
    public void solveVi(){
        if(!isD){
            vi = vf - a * t;
            isVi = true;
        } else if (!isA) {
            vi = 2.0*d/t - vf;
            isVi = true;
        } else if (!isT){
            vi = Math.sqrt(Math.pow(vf,2)-2*a*d);
            isVi = true;
        } else {
            vi = (d-0.5*a*Math.pow(t,2))/t;
            isVi = true;
        }
    }
    public void solveVf(){
        if(!isD){
            vf = vi + a * t;
            isVf = true;
        } else if (!isA) {
            vf = 2.0*d/t - vi;
            isVf = true;
        } else if (!isT){
            vf = Math.sqrt(Math.pow(vf,2)+2*a*d);
            isVf = true;
        } else{
            vf = (d+0.5*a*Math.pow(t,2))/t;
            isVf = true;
        }
    }
    public void solveA() {
        if (!isT) {
            a = (Math.pow(vf, 2) - Math.pow(vi, 2)) / (2.0 * d);
            isA = true;
        } else if (!isVi) {
            a = (d - vf * t) / (-0.5 * Math.pow(t, 2));
            isA = true;
        } else if (!isVf) {
            a = (d - vf * t) / (0.5 * Math.pow(t, 2));
            isA = true;
        } else {
            a = (vf - vi) / t;
            isA = true;
        }
    }
    public boolean solveM() {
        if(!isN && isP) {
            m = p/vi;
            isM = true;
            return true;
        } else if (!isP && isN) {
            m = n/a;
            isM = true;
            return true;
        }
        return false;
    }
    public void solveP() {
        if (isVi) {
            p = m * vi;
            isP = true;
        }
    }
    public void solveN(){
        if(isA) {
            n = m * a;
            isN = true;
        }
    }
    public void solveAFM(){
        if(isN) {
            a = n / m;
            isA = true;
        }
    }
    public void solveVFM(){
        if(isP) {
            vi = p / m;
            isVi = true;
        }
    }
    public void solveR(){
        r = Math.pow(vi,2)/a;
        isR = true;
    }
    public void solveAC(){
        a = Math.pow(vi,2)/r;
        isA = true;
    }
    public void solveVC(){
        vi = Math.sqrt(a * r);
        isVi = true;
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
    public boolean solveFM(){
        if(!isM){
            if(!solveM()){
                return false;
            }
        }
        if(!isP){
            solveP();
        }
        if(!isVi){
            solveVFM();
        }
        if(!isN){
            solveN();
        }
        if(!isA){
            solveAFM();
        }
        return true;
    }
    public boolean solveCM(){
        if(isN && isM){
            solveAFM();
        }
        if(isR || isVi){
            int counter = 0;
            if(isR && isA){
                solveVC();
                counter++;
            }
            if(isVi && isR){
                solveAC();
                counter++;
            }
            if(isVi && isA){
                solveR();
                counter++;
            }
            if (counter == 0) {
                return false;
            } else if (isN) {
                solveM();
            } else if (isM) {
                solveN();
            }
            return true;
        }else{
            if(isA){
                if(isN){
                    solveM();
                } else if (isM) {
                    solveN();
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
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
        r = 0;
        isA = false;
        isD = false;
        isT = false;
        isVf = false;
        isVi = false;
        isM = false;
        isP = false;
        isN = false;
        isR = false;
    }
}
