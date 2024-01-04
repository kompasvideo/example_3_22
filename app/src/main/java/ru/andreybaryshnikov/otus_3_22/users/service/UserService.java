package ru.andreybaryshnikov.otus_3_22.users.service;

import ru.andreybaryshnikov.otus_3_22.users.model.UserProfile;

public interface UserService {
    UserProfile updateUser(long userId, UserProfile updateUser);
    UserProfile getUserProfileById(long id);
}
