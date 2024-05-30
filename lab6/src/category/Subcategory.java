package category;

import java.util.ArrayList;

public class Subcategory implements CategoryComposite{
    private final String name;
    private final ArrayList<CategoryComposite> categories;

    public Subcategory(String name)
    {
        this.name = name;
        categories = new ArrayList<CategoryComposite>();
    }

    @Override
    public void add(CategoryComposite categoryComposite) {
        categories.add(categoryComposite);
    }

    @Override
    public void remove(CategoryComposite categoryComposite) {
        categories.remove(categoryComposite);
    }

    @Override
    public void print() {
        System.out.println("Podkategoria: " + name);
        for (CategoryComposite categoryComposite : categories) {
            categoryComposite.print();
        }
    }
}
