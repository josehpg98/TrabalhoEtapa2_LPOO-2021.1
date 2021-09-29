/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lpoo.cs.projetoetapa1.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author joseh
 */
@Entity
@Table(name = "tb_mapa")
public class Mapa implements Serializable{
    //serializable: indica que a classe vai seguir uma ordem em série
    ///quando forem inseridos os elemnetos no banco de dados.
    ///atributos da clase mapa
    @Id
    @SequenceGenerator(name = "seq_mapa", sequenceName = "seq_mapa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_mapa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @ManyToMany(cascade = CascadeType.PERSIST)//agregação por compoição
    ///ttabela associativa
    @JoinTable(name = "tb_locais", joinColumns = {@JoinColumn(name = "mapa_id")}, 
                                       inverseJoinColumns = {@JoinColumn(name = "local_id")})
    private List<Local> locais;
    ///Construtor da classe
    public Mapa(){
        
    }
    //métodos get e set

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the locais
     */
    public List<Local> getLocais() {
        return locais;
    }

    /**
     * @param locais the locais to set
     */
    public void setLocais(List<Local> locais) {
        this.locais = locais;
    }
    
}
