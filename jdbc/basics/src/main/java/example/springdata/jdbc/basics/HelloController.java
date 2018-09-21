package example.springdata.jdbc.basics;

import java.util.Optional;
import java.util.Random;

import org.skyscreamer.jsonassert.Customization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
//    @Autowired
//    CustomerRepository customerRepo;
    
    Random rnd = new Random();
    
    @RequestMapping("/")
    public String index() {
        
//        System.out.println(customerRepo.findAll());
//        
//        System.out.println(customerRepo.findByName("na"));
        
        return "Greetings from Spring Boot!!!S";
    }
    
    @RequestMapping("/save")
    public String save() {
        System.out.println("--------save-----------");
//        Optional<Customer> update = customerRepo.findById((long) 1);
//        
//        customerRepo.save(update.get());
//        Customer cust = new Customer();
//        cust.setId((long) 444);
//        cust.setFirstName("テストユーザ!");
//        customerRepo.save(cust);
        
        return "新たなデータをセーブしました。";
    }
    
    
}
