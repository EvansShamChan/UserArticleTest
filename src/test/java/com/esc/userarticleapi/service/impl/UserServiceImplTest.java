package com.esc.userarticleapi.service.impl;

import com.esc.userarticleapi.entity.User;
import com.esc.userarticleapi.repository.UserRepository;
import com.esc.userarticleapi.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void getAllUserByAgeGreaterThan() {
        Integer age = 18;
        User user = getUser();
        List<User> users = new ArrayList<>();
        users.add(user);

        Mockito.when(userRepository.findAllByAgeGreaterThan(Mockito.anyInt())).thenReturn(users);
        List<User> allUserByAgeGreaterThan = userService.getAllUserByAgeGreaterThan(age);

        Assert.assertNotNull(allUserByAgeGreaterThan);
        Assert.assertTrue(allUserByAgeGreaterThan.get(0).getAge() > age);
    }

    private User getUser() {
        return new User("asd", 19);
    }
}
