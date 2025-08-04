package CollectionsTask9ExerciseNewPostStorageService;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface NewPostOfficeStorage {

    boolean acceptBox(Box box);
    boolean acceptAllBoxes(Collection<Box> boxes);
   boolean carryOutBoxes(Collection<Box> predicate);
    List<Box> carryOutBoxes(Predicate<Box> predicate);
    List<Box> getBoxesWithWeightLessThan(double weight);

    List<Box> getBoxesWithcostGreaterThan(double cost);
    List<Box> getAllVolumeGreaterOrEqual(double volume);
    List<Box> searchBoxes(Predicate<Box> predicate);
    void updateOfficeOfNumber(Predicate<Box> predicate, int newOfficeNumber);
}
