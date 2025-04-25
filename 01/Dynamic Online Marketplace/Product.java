import java.util.ArrayList;
import java.util.List;

interface Category{
    String getCategoryName();
}
class BookCategory implements Category{
    public String getCategoryName() {
        return "Books";
    }
}
class ClothingCategory implements Category{
    public String getCategoryName() {
        return "Clothing";
    }
}
class GadgetCategory implements Category{
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category>{
    private String name;
    private double price;
    private  T category;

    public Product(String name, double price, T category){
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public T getCategory(){
        return category;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void display(){
        System.out.println(category.getCategoryName()+" - "+name+": $"+price);
    }
}

class DiscountUtil{
    public static <T extends Product<?>> void applyDiscount(T product, double percentage){
        double discountedPrice = product.getPrice()*(1-percentage/100);
        product.setPrice(discountedPrice);
    }
}

class MarketPlace{
    public static void main(String[] args){
        List<Product<? extends Category>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("The Alchemist",500, new BookCategory());
        Product<ClothingCategory> dress = new Product<>("Maxi A-Line",800,new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Samsung S24",23000, new GadgetCategory());

        catalog.add(book);
        catalog.add(dress);
        catalog.add(phone);

        System.out.println("Before Discount: ");
        for(Product<? extends Category> p : catalog){
            p.display();
        }

        DiscountUtil.applyDiscount(book,10);
        DiscountUtil.applyDiscount(dress,20);
        DiscountUtil.applyDiscount(phone,15);

        System.out.println("\nAfter Discount: ");
        for(Product<? extends  Category> p : catalog){
            p.display();
        }
    }
}