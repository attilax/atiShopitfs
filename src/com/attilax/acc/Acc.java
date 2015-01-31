package com.attilax.acc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Acc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="acc"
    ,catalog="iwmshopnow"
)

public class Acc  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer uid;
     private Double amount;


    // Constructors

    /** default constructor */
    public Acc() {
    }

    
    /** full constructor */
    public Acc(Integer uid, Double amount) {
        this.uid = uid;
        this.amount = amount;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="uid")

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    @Column(name="amount", precision=10)

    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
   








}