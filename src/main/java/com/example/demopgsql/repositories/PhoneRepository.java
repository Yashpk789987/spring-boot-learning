package com.example.demopgsql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demopgsql.models.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
