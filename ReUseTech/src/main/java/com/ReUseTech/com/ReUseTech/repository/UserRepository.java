
package com.ReUseTech.com.ReUseTech.repository;

import com.ReUseTech.com.ReUseTech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
