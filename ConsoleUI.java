package урок6.hw;

import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

public class ConsoleUI {
    private LaptopService service = new LaptopService();
    private Scanner scanner = new Scanner(System.in);


    public void run() {
        service.addLaptop(new Laptop("Lenovo", 16, 256, "Windows 11", "Silver"));
        service.addLaptop(new Laptop("Apple", 8, 512, "macOS", "Gray"));
        service.addLaptop(new Laptop("HP", 32, 512, "Windows 10", "Black"));
        service.addLaptop(new Laptop("Asus", 8, 1024, "Linux", "Black"));

        while (true) {
            System.out.println("Введите критерий поиска (ram, storage, os, color) или 'exit' для выхода:");
            String criterion = scanner.nextLine();

            if ("exit".equalsIgnoreCase(criterion)) {
                break;
            }

            Predicate<Laptop> filter = buildFilter(criterion);
            Set<Laptop> filteredLaptops = service.findLaptops(filter);

            System.out.println("Результаты поиска:");
            filteredLaptops.forEach(System.out::println);
        }
    }


    private Predicate<Laptop> buildFilter(String criterion) {
        Predicate<Laptop> filter = laptop -> true;

        switch (criterion.toLowerCase()) {
            case "ram":
                System.out.println("Введите минимальное значение ОЗУ (в ГБ):");
                int minRam = Integer.parseInt(scanner.nextLine());
                filter = filter.and(laptop -> laptop.getRam() >= minRam);
                break;
            case "storage":
                System.out.println("Введите минимальное значение объема ЖД (в ГБ):");
                int minStorage = Integer.parseInt(scanner.nextLine());
                filter = filter.and(laptop -> laptop.getStorage() >= minStorage);
                break;
            case "os":
                System.out.println("Введите операционную систему:");
                String os = scanner.nextLine();
                filter = filter.and(laptop -> laptop.getOs().equalsIgnoreCase(os));
                break;
            case "color":
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                filter = filter.and(laptop -> laptop.getColor().equalsIgnoreCase(color));
                break;
            default:
                System.out.println("Неизвестный критерий. Попробуйте снова.");
                filter = laptop -> false;
                break;
        }

        return filter;
    }
}
