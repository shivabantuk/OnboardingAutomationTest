package bouquet;

import java.util.List;

public class Bouquet {
    List<Flower> flowers;

    public Bouquet(List<Flower> flowers) {
        // TODO Auto-generated constructor stub
        this.flowers=flowers;

    }

    public  int getCost() {
        int sum = 0;
        for (Flower flower : flowers)
            sum += flower.cost;



        return sum;

    }
}