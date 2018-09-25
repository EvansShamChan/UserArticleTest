package com.esc.userarticleapi.service;

import com.esc.userarticleapi.entity.User;
import java.util.List;

public interface UserService {
    void fillUpUserTable();

    List<User> getAllUserByAgeGreaterThan(Integer age);

    List<User> getUsersByArticleColor(String color);

    List<String> getUserIdByArticleNumberGreaterThan(Integer number);

    User saveUser(User user);
}
