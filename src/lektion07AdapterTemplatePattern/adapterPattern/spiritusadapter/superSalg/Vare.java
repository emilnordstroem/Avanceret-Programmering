package lektion07AdapterTemplatePattern.adapterPattern.spiritusadapter.superSalg;

public abstract class Vare {
    private int pris;
    private String navn;

    public Vare(int pris, String navn) {
        this.pris = pris;
        this.navn = navn;
    }

    abstract double beregnMoms ();

    public int getPris() {
        return pris;
    }

    public String getNavn() {
        return navn;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
