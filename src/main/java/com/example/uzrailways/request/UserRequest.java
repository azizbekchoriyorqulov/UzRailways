package com.example.uzrailways.request;


import com.example.uzrailways.entity.AuthRole;
import com.example.uzrailways.entity.Role;
import lombok.*;


import java.util.Date;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {

    //    @Pattern(regexp = "^[A-Za-z]+$",
//            message = "First name is not valid")
    private String firstName;
    //    @Pattern(regexp = "^[A-Za-z]+$",
//            message = "Last name is not valid")
    private String lastName;
    private String jshshir;
    private String phoneNumber;
    private Integer sectionNumber;
    private String position;

    // String ni Date qilish kerak
    private String lastMedicalExam;


    //    @Pattern(regexp = "^[A-Za-z]+$",
//            message = "username is not valid")
//    @Length(min = 10,
//            max = 30,
//            message = "must have between 8 and 20 characters")
    private String username;

    //    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$)",
//            message = "password is not valid")
//    @Length(min = 8,
//            max = 20,
//            message = "must have between 8 and 20 characters")
    private String password;

    private Set<AuthRole> roles;
}
