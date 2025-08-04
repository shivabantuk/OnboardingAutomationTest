package CollectionsTask10ExerciseShopcashboxes.CashBox;

import java.util.ArrayDeque;
import java.util.Deque;

public class CashBox {
    private final int number;
    private State state;
    private Deque<Buyer> queue = new ArrayDeque<>();

    public CashBox(int number, State state) {
        this.number = number;
        this.state = state;

    }

    public Deque<Buyer> getQueue() {
        return queue;
    }
    public boolean inState(State state) {
        return this.state == state;
    }
    public boolean nonState(State state) {
        return this.state != state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }

    public Buyer remove(){
        if(!queue.isEmpty())
            return queue.pollFirst();
        return null;
    }
    public Buyer serveBuyer(State enabled){
        if(queue.isEmpty()&&this.state==State.IS_CLOSING){
            this.state = State.DISABLED;
        }
        return remove();
    }

    @Override
    public String toString() {
        String status = switch (state){
            case ENABLED -> "+";
            case DISABLED -> "-";
            case IS_CLOSING -> "*";
        };
        StringBuilder buyers = new StringBuilder();
        for(Buyer b : queue)
            buyers.append(b);
        return "#" + number + "[" + status + "]" + buyers;
    }


}
