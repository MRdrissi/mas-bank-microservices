package ma.formations.msa.customerservice.repository;

import ma.formations.msa.customerservice.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author marwane
 **/
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
