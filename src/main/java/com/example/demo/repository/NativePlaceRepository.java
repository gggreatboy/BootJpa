package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.NativePlace;

public interface NativePlaceRepository extends JpaRepository<NativePlace, Integer> {

	public NativePlace findNativePlaceByNativeplace(String Nativeplace);
	String findNativeplaceById(Integer id);
	List <NativePlace>findAll();
}
