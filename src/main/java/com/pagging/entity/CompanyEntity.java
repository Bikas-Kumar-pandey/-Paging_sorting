package com.pagging.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class CompanyEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id ;
        private  String name;
        private  String designation;
}
