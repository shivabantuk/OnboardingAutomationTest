package CollectionsTask15;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface NewPostOfficeManagement  {

    Optional<Box> getBoxById(int id);
    String getDescSortedBoxesWeight();
    String getAssSortedBoxesByCost();
    List<Box> getBoxesReceipient(String receipient);

}
