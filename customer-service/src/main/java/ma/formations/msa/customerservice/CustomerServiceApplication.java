package ma.formations.msa.customerservice;

import ma.formations.msa.customerservice.entites.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import ma.formations.msa.customerservice.repository.CustomerRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {



    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {

            customerRepository.save(
                    Customer.builder()
                            .firstName("Marwane")
                            .lastName("Drissi")
                            .email("marwane@drissi.test")
                            .build());
            customerRepository.save(
                    Customer.builder()
                            .firstName("Chaimaa")
                            .lastName("Hattab")
                            .email("chaimaa@drissi.test")
                            .build());
        };

    }

}
