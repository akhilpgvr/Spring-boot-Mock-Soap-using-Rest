package com.sample.trails.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component                  //Converted to bean so it can be accessed by SoapService by auto wiring
public class UserEntity {
    private String userId;
    private String userName;
    private Integer userAge;
    private String userGender;
}
