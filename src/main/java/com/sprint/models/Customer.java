package com.sprint.models;

import java.util.HashSet;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="customer_id")
private long customerId;

@Column(name="customer_name")
private String customerName;

@Column(name="phone_no")
private long phoneNo;

@Column(name="cost")
private double cost;

@JsonIgnoreProperties("customer")
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "Customer_Transaction", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "transaction_id") })
private Set<Transaction> transaction=new HashSet<>();

@JsonIgnore
@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
private List<Booking> booking;

@ManyToOne
 @JoinColumn(name = "admin_id")
 private Admin admin;

}