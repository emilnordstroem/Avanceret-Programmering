package lektion07AdapterTemplatePattern.adapterPattern.spiritusadapter.superSalg;

public class FoedeVare extends Vare {

    public FoedeVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    double beregnMoms() {
        return super.getPris() * 1.05;
    }

}
