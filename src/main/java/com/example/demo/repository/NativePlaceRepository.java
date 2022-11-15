package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.NativePlace;

public interface NativePlaceRepository extends JpaRepository<NativePlace, Integer> {

	public NativePlace findNativePlaceByNativeplace(String Nativeplace);
}
