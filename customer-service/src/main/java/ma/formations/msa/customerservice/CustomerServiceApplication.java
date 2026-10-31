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
                            .firstName("Yassmine")
                            .lastName("aloui")
                            .email("yassminr@aloui.test")
                            .build());

            customerRepository.save(
                    Customer.builder()
                            .firstName("Ilham")
                            .lastName("Amine")
                            .email("ilham@amine.ma")
                            .build());


            String[] firstNames = {
                    "Youssef", "Sara", "Mohamed", "Fatima",
                    "Omar", "Salma", "Hamza", "Imane",
                    "Ayoub", "Hajar", "Anas", "Nour",
                    "Mehdi", "Kawtar", "Amine"
            };

            String[] lastNames = {
                    "Benali", "El Mansouri", "Alaoui",
                    "Bennani", "Idrissi", "Tazi",
                    "Berrada", "Fassi", "Amrani",
                    "Chraibi", "Lahlou"
            };

            for (int i = 4; i <= 50; i++) {

                String firstName = firstNames[(i - 4) % firstNames.length];
                String lastName = lastNames[(i - 4) % lastNames.length];

                Customer customer = Customer.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .email("client" + i + "@masbank.test")
                        .build();

                customerRepository.save(customer);
            }

            System.out.println("50 clients initialisés avec succès !");
        };
    }

}
