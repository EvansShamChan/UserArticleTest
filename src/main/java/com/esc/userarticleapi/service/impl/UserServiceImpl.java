package com.esc.userarticleapi.service.impl;

import com.esc.userarticleapi.entity.User;
import com.esc.userarticleapi.repository.UserRepository;
import com.esc.userarticleapi.service.ArticleService;
import com.esc.userarticleapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Value("${db.usernames}")
    private String[] userNames;

    @Value("${db.userages}")
    private String[] userAges;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleService articleService;

    public void fillUpUserTable() {
        for (int i = 0; i < 8; i++) {
            User user = new User(userNames[i], Integer.valueOf(userAges[i]));
            userRepository.save(user);
        }
    }

    @Override
    public List<User> getAllUserByAgeGreaterThan(Integer age) {
        return userRepository.findAllByAgeGreaterThan(age);
    }

    @Override
    public List<User> getUsersByArticleColor(String color) {
        List<Integer> userIdByColor = articleService.findUserIdByColor(color);
        return userRepository.findAllByIdIn(userIdByColor);
    }

    @Override
    public List<String> getUserIdByArticleNumberGreaterThan(Integer number) {
        List<Integer> userIdByArticleNumberGreaterThan = articleService.getUserIdByArticleNumberGreaterThan(number);
        return userRepository.getDistinctNamesByIdIn(userIdByArticleNumberGreaterThan);
    }
}
