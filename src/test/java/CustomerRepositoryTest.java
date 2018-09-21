

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import hello.Customer;
import hello.CustomerConfig;
import hello.CustomerRepository;





@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CustomerConfig.class)
@AutoConfigureJdbc
public class CustomerRepositoryTest {

    @Autowired CustomerRepository customerRepo;

    @Test
    public void createSimpleCustomer() {

        Customer customer = new Customer();
        customer.dob = LocalDate.of(1904, 5, 14);
        customer.firstName = "Albert";
        System.out.println("★★補完します");
        
        Customer saved = customerRepo.save(customer);

       // assertThat(saved.id).isNotNull();
        
        System.out.println(saved);

        saved.firstName = "Hans Albert";

        customerRepo.save(saved);

        Optional<Customer> reloaded = customerRepo.findById(saved.id);

       //assertThat(reloaded).isNotEmpty();

        //assertThat(reloaded.get().firstName).isEqualTo("Hans Albert");
    }
    
    @Test
    public void findByName() {
        
        System.out.println(customerRepo.findAll());

    }
}