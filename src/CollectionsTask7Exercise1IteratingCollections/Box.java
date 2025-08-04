package CollectionsTask7Exercise1IteratingCollections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Box {
    String sender, recipient;
    double weight, volume;
    int value;
    BigDecimal shippingCost;

    Box(String sender, String recipient, double weight, double volume, int value) {
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
        this.value = value;
        this.shippingCost = NewPostOffice.calculateCostOfBox(weight, volume, value);
    }

    static class NewPostOffice {
        static List<Box> office = new ArrayList<>();
        NewPostOffice() {
        }

        static Collection<Box> getListBox() {
            return office;
        }

        static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
            double cost = weight * 10 + volume * 100 + value * 0.01;
            return BigDecimal.valueOf(cost);

        }

        Collection<Box> deliveryBoxToRecipient(String recipient) {
            List<Box> result = new ArrayList<>();
            office.removeIf(box -> {
                if (box.sender.equals(recipient)) {
                    result.add(box);
                    return true;

                }
                return false;
            });
            return result;
        }

        void declineCostOfBox(double Percent) {
            for (Box b : office) {
                b.shippingCost = b.shippingCost.multiply(BigDecimal.valueOf(1.0 - Percent / 100));
            }
        }

        boolean addBox(String sender, String recipient, double weight, double volume, int value) {
            Box b = new Box(sender, recipient, weight, volume, value);
            return office.add(b);
        }

    }

}
