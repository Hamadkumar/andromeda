package com.io.andromeda.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author hamad
 *
 */
public class UserCreateForm {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
	
	@NotEmpty
    private String username = "";
	@NotEmpty
	private String email="";
	@NotEmpty
    private String password = "";
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty
    private String passwordRepeated = "";
    @NotNull
    private Role role = Role.USER;

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

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
        		"username=" + username +
                ", email='" + email + '\'' +
                ", password=***" + '\'' +
                ", passwordRepeated=***" + '\'' +
                ", role=" + role +
                '}';
    }

}
