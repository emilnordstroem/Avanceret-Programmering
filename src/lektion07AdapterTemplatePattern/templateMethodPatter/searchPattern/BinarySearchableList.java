package lektion07AdapterTemplatePattern.templateMethodPatter.searchPattern;

import java.util.List;

public class BinarySearchableList <E extends Comparable<E>> extends SearchPattern <E> {
    private final List<E> initialList;
    private List<E> searchList;

    public BinarySearchableList(List<E> initialList) {
        this.initialList = initialList;
    }

    @Override
    protected void init() {
        searchList = initialList;
    }

    @Override
    protected boolean isEmpty() {
        return searchList.isEmpty();
    }

    @Override
    protected E select() {
        return null;
    }

    @Override
    protected void split(E m) {

    }

}