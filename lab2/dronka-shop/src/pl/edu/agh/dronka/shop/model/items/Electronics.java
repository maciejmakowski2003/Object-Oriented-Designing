package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

public class Electronics extends Item {
    boolean isMobile;
    boolean isGuarantee;

    public Electronics(String name, Category category, int price, int quantity, boolean isMobile, boolean isGuarantee) {
        super(name, category, price, quantity);
        this.isMobile = isMobile;
        this.isGuarantee = isGuarantee;
    }

    public Electronics(){
        super();
    };

    public boolean getMobile() {
        return isMobile;
    }

    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }

    public boolean getGuarantee() {
        return isGuarantee;
    }

    public void setGuarantee(boolean guarantee) {
        isGuarantee = guarantee;
    }
}
