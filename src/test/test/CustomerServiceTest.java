package test;

import model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lww on 2017/9/11.
 */
public class CustomerServiceTest {
    private final CustomerService service;

    public CustomerServiceTest(CustomerService service) {
        this.service = service;
    }

    @Before
    public void init() {
        //Init database
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customers = service.getCustomerList();
        Assert.assertEquals(2, customers.size());
    }

    @Test
    public void getCustomerTest() throws Exception {
        long id = 1;
        Customer customer = service.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception {
        Map<String,Object> field = new HashMap<>(3);
        field.put("name","customer3");
        field.put("contact","John");
        field.put("telephone","1321564561");
        boolean result = service.createCustomer(field);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception {
        long id = 1;
        Map<String,Object> field = new HashMap<>(1);
        field.put("contact","Eric");
        boolean result =service.updateCustomer(id,field);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        long id =3;
        boolean result = service.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
