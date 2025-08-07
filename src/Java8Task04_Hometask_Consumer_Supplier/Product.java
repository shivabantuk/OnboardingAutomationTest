package Java8Task04_Hometask_Consumer_Supplier;

public class Product {
    String name;
    double price;
    String category;
    String grade;
    public Product(String name, double price, String category, String grade) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString(){
        return "product{name " + name + ", price " + price + ", category " + category + ", grade " + grade + "}";
    }
}
