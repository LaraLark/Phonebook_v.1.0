package models;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class Contact{
    String name;
    String lastname;
    String email;
    String phone;
    String address;
    String description;
}