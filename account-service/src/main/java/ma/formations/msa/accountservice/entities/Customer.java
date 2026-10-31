package ma.formations.msa.accountservice.entities;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author marwane
 **/
@Data
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
}
