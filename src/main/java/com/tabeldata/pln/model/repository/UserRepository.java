package com.tabeldata.pln.model.repository;

import com.tabeldata.pln.model.User;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
   
    List<User> findAll();
    User findByUsername(String username);
}
