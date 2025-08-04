package CollectionsTask9ExerciseNewPostStorageService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NewPostOfficeStorageImpl implements NewPostOfficeStorage{
    private final List<Box> storage =  new ArrayList<>();

    @Override
    public boolean acceptBox(Box box) {
        if(box==null) throw new NullPointerException("box is null");
        storage.add(box);
        return true;
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        if(boxes==null|| boxes.contains(null)) throw new NullPointerException("boxes is null");
        if(boxes.isEmpty())
        return false;
        storage.addAll(boxes);
        return true;
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        if(boxes==null|| boxes.contains(null)) throw new NullPointerException("boxes is null");
        return storage.removeAll(boxes);
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        if(predicate==null) throw new NullPointerException("predicate is null");
        List<Box> remove = storage.stream().filter(predicate).collect(Collectors.toList());
        storage.removeAll(remove);

        return remove;
    }

    @Override
    public List<Box> getBoxesWithWeightLessThan(double weight) {
        return storage.stream().filter(b->b.getWeight()<weight).collect(Collectors.toList());
    }

    @Override
    public List<Box> getBoxesWithcostGreaterThan(double cost) {
        return storage.stream().filter(b->b.getCost() > cost).collect(Collectors.toList());


    }


    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        return storage.stream().filter(b->b.getVolume()>=volume).collect(Collectors.toList());

    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        if(predicate==null) throw new NullPointerException("predicate is null");
        return storage.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public void updateOfficeOfNumber(Predicate<Box> predicate, int newOfficeNumber) {
        if(predicate==null) throw new NullPointerException("predicate is null");
        storage.stream().filter(predicate).forEach(b->b.setOffice(newOfficeNumber));

    }
}
