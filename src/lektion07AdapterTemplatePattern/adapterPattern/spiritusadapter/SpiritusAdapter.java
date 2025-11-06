package lektion07AdapterTemplatePattern.adapterPattern.spiritusadapter;

public class SpiritusAdapter implements Vare {
    private Spiritus spiritus;

    public SpiritusAdapter(Spiritus spiritus) {
        this.spiritus = spiritus;
    }

    @Override
    public int getPris() {
        return spiritus.getPrisen();
    }

    @Override
    public String getNavn() {
        return spiritus.getBetgenelse();
    }

    @Override
    public void setPris(int pris) {
        spiritus.setPrisen(pris);
    }

    @Override
    public void setNavn(String navn) {
        spiritus.setBetgenelse(navn);
    }

    @Override
    public double beregnMoms() {
        return spiritus.hentMoms();
    }
}
