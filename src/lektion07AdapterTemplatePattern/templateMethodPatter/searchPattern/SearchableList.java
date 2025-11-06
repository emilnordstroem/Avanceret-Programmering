package lektion07AdapterTemplatePattern.templateMethodPatter.searchPattern;

import java.util.List;

public class SearchableList <E extends Comparable<E>> extends SearchPattern <E> {
    private final List<E> initialList;
    private List<E> searchList;

    public SearchableList(List<E> list) {
        initialList = list;
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
        return searchList.get(0);
    }

    @Override
    protected void split(E m) {
        searchList = searchList.subList(1, searchList.size());
    }

}
