package ru.andreybaryshnikov.otus_3_22.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreybaryshnikov.otus_3_22.users.model.UserProfile;

public interface UserRepository extends JpaRepository<UserProfile,Long> {
}
