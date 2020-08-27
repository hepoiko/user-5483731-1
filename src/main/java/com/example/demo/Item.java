package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Item")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;  

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="attr_id")
  private Attribute attribute;


  
  @Override
  public String toString()
  {
      return "Item [attribute=" + attribute + ", id=" + id + "]";
  }


  public Long getId()
  {
      return id;
  }


  public void setId(Long id)
  {
      this.id = id;
  }


  public Attribute getAttribute()
  {
      return attribute;
  }


  public void setAttribute(Attribute attribute)
  {
      this.attribute = attribute;
  }
  
  
}