import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    void test1() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 50_000);
        Product product2 = new Product(22, "книга", 500);
        Product product3 = new Product(400, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 50_000);
        Product product2 = new Product(22, "книга", 500);
        Product product3 = new Product(400, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(555)
        );
    }

}
