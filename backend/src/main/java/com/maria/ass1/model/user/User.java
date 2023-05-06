package com.maria.ass1.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maria.ass1.validators.NameConstraint;
import com.maria.ass1.validators.EmailConstraint;
import com.maria.ass1.validators.PasswordConstraint;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 3, max = 50)
    private String username;
    @NameConstraint(message = "Name is mandatory. It should  contain at least 3 characters.")
    private String name;
    @EmailConstraint(message = "Email is mandatory.")
    private String email;
    @PasswordConstraint(message = "Password is mandatory. It should contains at least 8 characters,one digit,one upper case alphabet,one lower case alphabet,one special character which includes \"!@#$%&*()-+=^\" and at most 20 characters. It doesn’t contain any white space.")
    private String password;
    private String img;
    private String address;
    private List<Integer> produse;

    public User(String firstName, String lastName, String userName, String password, String email) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address=address;
    }

    public User(long l, String mariaV2, String maria, String password, String mqw12) {
    }

    public int hashCode() {
        return Objects.hash(id, username, name, email, password);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\''+
                ",address:"+address+ '\'';
    }


    public User(Long id, String username, String name, String email, String password, int idProdus, String address) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.produse.add(idProdus);
        this.address=address;

    }



}
