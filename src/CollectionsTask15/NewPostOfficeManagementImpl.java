package CollectionsTask15;

import java.util.*;

import static java.util.Collections.binarySearch;

public class NewPostOfficeManagementImpl implements NewPostOfficeManagement{

    private final List<Box> parcels = new ArrayList<>();
    public void addBox(String sender, String recipient, double weight, double volume, double cost, String city, String office){
        int id = parcels.size()+1;
        parcels.add(new Box(id, sender, recipient, weight, volume, cost, city, office));
    }
    @Override
    public Optional<Box> getBoxById(int id) {

        List<Box> sortedById = new ArrayList<>(parcels);
        Collections.sort(sortedById);
        int index = Collections.binarySearch(sortedById, new Box(id, "","", 0,0,0,"",""));
        if(index>=0){
            return Optional.of(sortedById.get(index));
        }
        return Optional.empty();
    }

    @Override
    public String getDescSortedBoxesWeight() {
        List<Box> list = new ArrayList<>(parcels);
        Collections.sort(list, new Comparator<Box>() {public int compare (Box b1, Box b2){
            return Double.compare(b2.getWeight(),b1.getWeight());

        }});
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();++i){
            sb.append(list.get(i).getSender());
            if(i!=list.size()-1)
                sb.append(", ");
        }
        return sb.toString();
    }

    @Override
    public String getAssSortedBoxesByCost() {
        List<Box> list = new ArrayList<>(parcels);
        Collections.sort(list, new Comparator<Box>() {
            public int compare (Box b1, Box b2){
                return Double.compare(b2.getCost(),b1.getCost());}
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();++i){
            sb.append(list.get(i).toString());
            if(i!=list.size()-1)
                sb.append(", ");

        }
        return sb.toString();
    }

    @Override
    public List<Box> getBoxesReceipient(String recipient) {
        if(recipient == null) throw new NullPointerException("recipient must not be null");
        List<Box> sortedByRecipient = new ArrayList<>(parcels);
        Collections.sort(sortedByRecipient, new Comparator<Box>() {
            public int compare (Box b1, Box b2){
                if(b1.getRecipient() == null && b2.getRecipient() == null) return 0;
                if(b1.getRecipient() == null ) return -1;
                if(b2.getRecipient() == null)  return 1;
                return b1.getRecipient().compareTo(b2.getRecipient());
            }
        });

        Box key = new Box(0,"", recipient, 0,0,0,"","");
        int index = Collections.binarySearch(sortedByRecipient, key, new Comparator<Box>() {
            public int compare (Box b1, Box b2){
                if(b1.getRecipient() == null && b2.getRecipient() == null) return 0;
                if(b1.getRecipient() == null ) return -1;
                if(b2.getRecipient() == null)  return 1;
                return b1.getRecipient().compareTo(b2.getRecipient());
            }
        });
        List<Box> result = new ArrayList<>(index);
        if(index<0) return result;
        int left = index;
        int right = index;
        while(left-1>=0 && recipient.equals(sortedByRecipient.get(left-1).getRecipient())) --left;
        while(right+1<sortedByRecipient.size() && recipient.equals(sortedByRecipient.get(right+1).getRecipient())) ++right;
        for(int i=left; i<=right; ++i){
            result.add(sortedByRecipient.get(i));
        }
        return result;
    }
}
