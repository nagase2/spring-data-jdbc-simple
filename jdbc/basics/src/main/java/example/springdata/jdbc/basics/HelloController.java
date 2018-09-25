package example.springdata.jdbc.basics;

import java.time.Period;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.springdata.jdbc.basics.aggregate.LegoSet;
import example.springdata.jdbc.basics.aggregate.LegoSetRepository;

@RestController
public class HelloController {
    
//    @Autowired
//    CustomerRepository customerRepo;
    @Autowired LegoSetRepository repository;
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
        LegoSet smallCar = createLegoSet("Small Car 01", 5, 12);
       // smallCar.setManual(new Manual("Just put all the pieces together in the right order", "Jens Schauder"));
        smallCar.addModel("suv", "SUV with sliding doors.");
        smallCar.addModel("roadster", "Slick red roadster.");

        repository.save(smallCar);
        Iterable<LegoSet> legoSets = repository.findAll();
        Output.list(legoSets, "Original LegoSet");
        
        return "新たなデータをセーブしました。";
    }
    
    private LegoSet createLegoSet(String name, int minimumAge, int maximumAge) {

        LegoSet smallCar = new LegoSet();

        smallCar.setName(name);
        smallCar.setMinimumAge(Period.ofYears(minimumAge));
        smallCar.setMaximumAge(Period.ofYears(maximumAge));

        return smallCar;
    }

}
