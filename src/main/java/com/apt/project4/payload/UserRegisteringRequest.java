package com.apt.project4.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static com.apt.project4.constant.MessageKeys.INVALID_EMAIL_FORMAT;
import static com.apt.project4.constant.MessageKeys.REQUIRED_MSG;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserRegisteringRequest {
    private String id;
    private BCryptPasswordEncoder passwordEncoder;
    @NotBlank(message = REQUIRED_MSG)
    private String firstName;

    @NotBlank(message = REQUIRED_MSG)
    private String lastName;

    @NotBlank(message = REQUIRED_MSG)
    private String phoneNumber;

    @NotBlank(message = REQUIRED_MSG)
    @Email(message = INVALID_EMAIL_FORMAT)
    private String email;

    @NotBlank(message = REQUIRED_MSG)
    private String password;

    private String roleName;
    
    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    private String avatarUrl;
    
    private int active;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
