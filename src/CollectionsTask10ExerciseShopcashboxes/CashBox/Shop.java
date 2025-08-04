package CollectionsTask10ExerciseShopcashboxes.CashBox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Shop {
    private final List<CashBox> cashBoxes;

    public Shop(int n) {
        cashBoxes = new ArrayList<CashBox>();
        for (int i = 0; i < n; i++)
            cashBoxes.add(new CashBox(i, State.DISABLED));
    }

    public void print(){
        for(CashBox cb : cashBoxes){
            System.out.println(cb);
        }
        System.out.println();
    }
    public void enable(int[] boxNumbers){
        for(int n: boxNumbers) {
            CashBox cb =  cashBoxes.get(n);
            if (cb.getState() == State.DISABLED)
                cb.serveBuyer(State.ENABLED);
        }
    }
    public void addBuyer(Buyer buyer){
        Optional<CashBox> opt = cashBoxes.stream().filter(cb->cb.getState() == State.ENABLED).min(Comparator.comparingInt(cb->cb.getQueue().size()));
        opt.ifPresent(cb->cb.getQueue().add(buyer));
    }

    public void addBuyers(List<Buyer> buyers) {
        for (Buyer buyer : buyers) {
            addBuyer(buyer);
        }
    }

        void tact(){
            List<Buyer> defectorBuyers = new ArrayList<>();
            for(CashBox cb : cashBoxes){
                if(!cb.getQueue().isEmpty()){
                    defectorBuyers.add(cb.remove());
                }
            }
            redistribute(defectorBuyers);
        }
        private void redistribute(List<Buyer> buyers){
        for(Buyer buyer : buyers){
            addBuyer(buyer);
        }
        }
        public void setState(int boxNumber, State state){
        cashBoxes.get(boxNumber).setState(state);
        }



}

