package lektion07AdapterTemplatePattern.adapterPattern.spiritusadapter.superSalg;

public class ElVare extends Vare {

    public ElVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    double beregnMoms() {
        return super.getPris() >= 3 ? super.getPris() * 1.30 : super.getPris();
    }

}
