package category;

import storage.Goods;

import java.util.ArrayList;

public class Category implements CategoryComposite{
    private final String name;
    private final ArrayList<Goods> goods;

    public Category(String name)
    {
        this.name = name;
        goods = new ArrayList<Goods>();
    }

    public void addGoods(Goods goods)
    {
        this.goods.add(goods);
    }

    @Override
    public void add(CategoryComposite categoryComposite) {

    }

    @Override
    public void remove(CategoryComposite categoryComposite) {

    }

    @Override
    public void print() {
        System.out.println("Kategoria: " + name);
        for (Goods goodsList : goods) {
            System.out.println("  Towar: " + goodsList.getName());
        }
    }
}
