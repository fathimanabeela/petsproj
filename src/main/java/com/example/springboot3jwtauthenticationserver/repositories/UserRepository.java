package com.example.springboot3jwtauthenticationserver.repositories;


import com.example.springboot3jwtauthenticationserver.dto.UserPetsDTO;
import com.example.springboot3jwtauthenticationserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "select o.email as email,string_agg(p.type,',') as pets from users o left join pets p on o.id=p.owner_id where o.email= ?1  group by o.email",nativeQuery = true)
    List<UserPetsDTO> getPetsByAuthenticatedUser(String name);
}
