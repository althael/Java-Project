package com.persado.assignment.project.Repositories.UserRepository;//package com.persado.assignment.project.Repository;

import com.persado.assignment.project.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
