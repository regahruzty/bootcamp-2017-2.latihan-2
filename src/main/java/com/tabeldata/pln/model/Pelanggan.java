/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.pln.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Diani
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_pelanggan")
public class Pelanggan {
    
    @Id
    @GeneratedValue
    public Integer id;
    private String nama;
    private Integer saldo;
   
    
}
