/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.pln.model.repository;

import com.tabeldata.pln.model.Pelanggan;
import com.tabeldata.pln.model.PelangganToken;
import java.util.List;
import org.exolab.castor.mapping.xml.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Diani
 */
public interface PelangganTokenRepository extends PagingAndSortingRepository<PelangganToken, Integer>{
    
    List<PelangganToken> findAll();
    
    
    
    PelangganTokenRepository findByPelangganId(Integer id);
    
}
