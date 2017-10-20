/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.pln.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Diani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_pelanggan_token")
public class PelangganToken {

    @Id
    @GeneratedValue             
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_pelanggan", nullable = true)
    private Pelanggan pelanggan;

    @OneToOne
    @JoinColumn(name = "id_token", nullable = true)
    private Token token;
}

