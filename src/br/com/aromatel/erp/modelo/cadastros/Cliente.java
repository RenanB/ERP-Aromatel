/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aromatel.erp.modelo.cadastros;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author henriquevalcanaia
 */
@Entity
@Table(name = "CLIENTES")
public class Cliente extends Pessoa implements EntityBase, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "SEQ_CODIGO_CLIENTE", sequenceName = "SEQ_CODIGO_CLIENTE",allocationSize = 1)
    @GeneratedValue(generator = "SEQ_CODIGO_CLIENTE", strategy = GenerationType.SEQUENCE)
    private Integer codigo;

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente" + super.toString();
    }

    @Override
    public boolean existeNoBanco() {
        return true;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
