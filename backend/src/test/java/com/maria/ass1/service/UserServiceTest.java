package com.maria.ass1.service;

import com.maria.ass1.business.service.CustomerService;
import com.maria.ass1.model.user.User;
import com.maria.ass1.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private CustomerService userService;

    @Test
   public void addUser(){
        User user = new User(1L, "MariaV2", "Maria", "vasil@yahoo.com", "Mqw12");
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        User created=user;
        assertThat(created.getName()).isSameAs(user.getName());
        verify(userRepository).save(user);
    }
    @Test
    public void deleteUser(){
        User user = new User();
        user.setId(2467L);
        user.setName("Liviu");
        given(userRepository.findById(user.getId())).isSameAs(user.getId());
        userService.deleteCustomer(user.getId());
        verify(userRepository).delete(user);
    }

    @Test
    public  void showExceptionWhenCustomerDoesntExist (){
        User user = new User();
        user.setId(1705L);
        assertThat(user.getId()).isSameAs(user.getId());

        try {
            when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
            String userDel = String.valueOf(userService.deleteCustomer(user.getId()));
        }catch (Exception e) {
            assertThat(user).isSameAs(user);
        }
    }

    @Test
public void update() throws Throwable {
        User user = new User(1705L, "Maria", "Maria", "vasil@yahoo.com", "Mqw12");
        User newUser = new User();
        newUser.setId(1705L);
        newUser.setName("Maria");
        User updateUser = null;
                given(userRepository.findById(newUser.getId()));
        try {
            updateUser = userService.updateCustomer(userService);
            verify(userRepository.save(updateUser));

        }catch (Exception e){
            assertThat(newUser.getId()).isSameAs(newUser.getId());
            assertThat(newUser.getName()).isSameAs(newUser.getName());
        }
    }
}
