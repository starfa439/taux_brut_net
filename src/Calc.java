
public class Calc {
    public double smicHorBrut = 10.15;
    public double smicHorNet = 7.81;
    public double smicMensBrut = 1539.42;
    public double smicMensNet = 1185;
    public double smicAnnBrut = 18468;
    public double smicAnnNet = 14220;


    public double HorBrutVersNet( double valeurHor) {
        double resValHorNet = (smicHorNet * valeurHor) / smicHorBrut ;
        return resValHorNet;
    }
    public double MensBrutVersNet( double valeurMen) {
        double resValMenNet = smicMensNet * valeurMen / smicMensBrut ;
        return resValMenNet;
    }
    public double AnnBrutVersNet( double valeurAnn) {
        double resValAnnNet = smicAnnNet * valeurAnn / smicAnnBrut ;
        return resValAnnNet;
    }

    public double HorNetVersBrut( double valeurHor) {
        double resValHorBrut = smicHorBrut * valeurHor / smicHorNet ;
        return resValHorBrut;
    }
    public double MensNetVersBrut( double valeurMen) {
        double resValMenBrut = smicMensBrut * valeurMen / smicMensNet ;
        return resValMenBrut;
    }
    public double AnnNetVersBrut( double valeurAnn) {
        double resValAnnBrut = smicAnnBrut * valeurAnn / smicAnnNet ;
        return resValAnnBrut;
    }

    public double getSmicHorBrut() {
        return smicHorBrut;
    }

    public void setSmicHorBrut(double smicHorBrut) {
        this.smicHorBrut = smicHorBrut;
    }

    public double getSmicHorNet() {
        return smicHorNet;
    }

    public void setSmicHorNet(double smicHorNet) {
        this.smicHorNet = smicHorNet;
    }

    public double getSmicMensBrut() {
        return smicMensBrut;
    }

    public void setSmicMensBrut(double smicMensBrut) {
        this.smicMensBrut = smicMensBrut;
    }

    public double getSmicMensNet() {
        return smicMensNet;
    }

    public void setSmicMensNet(double smicMensNet) {
        this.smicMensNet = smicMensNet;
    }

    public double getSmicAnnBrut() {
        return smicAnnBrut;
    }

    public void setSmicAnnBrut(double smicAnnBrut) {
        this.smicAnnBrut = smicAnnBrut;
    }

    public double getSmicAnnNet() {
        return smicAnnNet;
    }

    public void setSmicAnnNet(double smicAnnNet) {
        this.smicAnnNet = smicAnnNet;
    }

}
