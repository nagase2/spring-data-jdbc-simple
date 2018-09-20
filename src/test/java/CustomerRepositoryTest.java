

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import hello.Customer;
import hello.CustomerConfig;
import hello.CustomerRepository;




@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = CustomerConfig.class)
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
        System.out.println("開始");
        Customer customer = new Customer();
        customer.dob = LocalDate.of(1904, 5, 14);
        customer.firstName = "Albert";
        System.out.println("開始１");
        Customer saved = customerRepo.save(customer);

       // assertThat(saved.id).isNotNull();
        System.out.println("開始２");
        customer.id= null; 
        customer.firstName = "Bertram";

        customerRepo.save(customer);

        customer.id= null;
        customer.firstName = "Beth";

        customerRepo.save(customer);

       // assertThat(customerRepo.findByName("bert")).hasSize(2);
    }
}