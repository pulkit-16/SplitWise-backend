package com.example.splitwise_begginer.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class User extends BaseModel{
//BaseModel   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   @Column(name ="id")
//   private Long id;
//   @Column(name = "name")
   private String name;
//   @Column(name = "userName")
   private String userName;
//   @Column(name= "password")
   private String password;



}
