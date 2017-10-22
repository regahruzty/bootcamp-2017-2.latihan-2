/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.pln.model.repository;


import com.tabeldata.pln.model.Role;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Diani
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer>{
    
    List<Role> findAll();
    
}
