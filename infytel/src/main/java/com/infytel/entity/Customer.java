package com.infytel.entity;

import com.infytel.dto.CustomerDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @Column(name = "phone_no")
    private long phoneNumber;
    private String name;
    private Integer age;
    private Character gender;
    private String address;
    @Column(name = "plan_id")
    private Integer planId;

    public Customer(){}

    public Customer(long phoneNumber, String name, Integer age, Character gender, String address, Integer planId) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.planId = planId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", planId=" + planId +
                '}';
    }

    public static CustomerDTO prepareDTO(Customer customerEntity){

        CustomerDTO custDTO = new CustomerDTO();

        custDTO.setPhoneNumber(customerEntity.getPhoneNumber());
        custDTO.setName(customerEntity.getName());
        custDTO.setGender(customerEntity.getGender());
        custDTO.setAge(customerEntity.getAge());
        custDTO.setAddress(customerEntity.getAddress());
        custDTO.setPlanId(customerEntity.getPlanId());

        return custDTO;

    }
}
