package урок6.hw;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class LaptopService {
    private Set<Laptop> laptops = new HashSet<>();


    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }


    public Set<Laptop> findLaptops(Predicate<Laptop> criteria) {
        return laptops.stream()
                .filter(criteria)
                .collect(Collectors.toSet());
    }
}
