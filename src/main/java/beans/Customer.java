package beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List <Coupon> coupons;

}
