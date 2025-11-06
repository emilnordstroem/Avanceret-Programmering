package lektion07AdapterTemplatePattern.adapterPattern.spiritusadapter;

public interface Vare {
    int getPris();
    String getNavn();
    void setPris(int pris);
    void setNavn(String navn);
    double beregnMoms();
}
