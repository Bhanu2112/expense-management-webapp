package com.org.bhanu.expenseservice.dao;

import com.org.bhanu.expenseservice.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    private Long id;
    
  
    private String username;
    
   
    private String password;
    
    
    private String email;
    
    private String firstName;
    
    private String lastName;
    
    
    private Role role;

    private boolean active = true;

}
