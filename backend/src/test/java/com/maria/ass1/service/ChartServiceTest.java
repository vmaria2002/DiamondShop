package com.maria.ass1.service;
import com.maria.ass1.business.factory.*;
import com.maria.ass1.business.service.CustomerService;
import com.maria.ass1.model.products.Type;
import com.maria.ass1.model.user.User;
import com.maria.ass1.repository.UserRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
public class ChartServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private CustomerService userService;

    @Test
    public void createChartWithBracelet() {
        String type = String.valueOf(Type.BRACELET);
        Long id = 12L;
        try {
            User myUser = new User();
            User user1 = null;
            if (type.equals("bracelet")) {
                BraceletProduct animalDream = new BraceletProduct(myUser);
                user1 = animalDream.generateChart(type);
            }
        } catch (Exception e) {

        }
  }


    @Test
    public void createChartWithCharm() {
        String type = String.valueOf(Type.CHARM);
        Long id = 12L;
        try {
            User myUser = new User();
            User user1 = null;
            if (type.equals("charm")) {
                CharmProduct charmProduct = new CharmProduct(myUser);
                user1 = charmProduct.generateChart(type);
            }
        } catch (Exception e) {

        }
    }

    @Test
    public void createChartWithEarings() {
        String type = String.valueOf(Type.EARRINGS);
        Long id = 12L;
        try {
            User myUser = new User();
            User user1 = null;
            if (type.equals("earrings")) {
                EarringsProduct earringsProduct = new EarringsProduct(myUser);
                user1 = earringsProduct.generateChart(type);
            }
        } catch (Exception e) {

        }
    }

    @Test
    public void createChartWithNecklage() {
        String type = String.valueOf(Type.NECKLACE);
        Long id = 12L;
        try {
            User myUser = new User();
            User user1 = null;
            if (type.equals("necklace")) {
                NecklageProduct necklageProduct = new NecklageProduct(myUser);
                user1 = necklageProduct.generateChart(type);
            }
        } catch (Exception e) {

        }
    }

    @Test
    public void createChartWithRing() {
        String type = String.valueOf(Type.RING);
        Long id = 12L;
        try {
            User myUser = new User();
            User user1 = null;
            if (type.equals("ring")) {
                RingProduct ringProduct = new RingProduct(myUser);
                user1 = ringProduct.generateChart(type);
            }
        } catch (Exception e) {

        }
    }


}
