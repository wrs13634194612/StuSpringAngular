package com.backendapiRest.models.dao;


import com.backendapiRest.models.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IShopDao extends JpaRepository<Shop, Long> {


}
