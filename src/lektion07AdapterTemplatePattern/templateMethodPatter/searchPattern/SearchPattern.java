package lektion07AdapterTemplatePattern.templateMethodPatter.searchPattern;

public abstract class SearchPattern <E extends Comparable<E>> {

    public final boolean search (E m) {
        init();
        while (!isEmpty()) {
            E candidate = select();
            if (m.equals(candidate)) {
                return true;
            } else {
                split(m);
            }
        }
        return false;
    }

    protected abstract void init();
    protected abstract boolean isEmpty();
    protected abstract E select();
    protected abstract void split(E m);

}
