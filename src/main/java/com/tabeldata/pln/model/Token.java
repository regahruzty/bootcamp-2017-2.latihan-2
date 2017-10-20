/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.pln.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "m_token")
public class Token {
    
    @Id
    @GeneratedValue
    private Integer id;
    private Integer nama_produk;
    private Integer harga; 
   
    
}
