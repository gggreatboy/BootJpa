package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import com.example.demo.entity.NativePlace;
import com.example.demo.entity.User;

public interface NpandUserService {
	public void saveUser(User user);
	public void saveNativePlace(NativePlace nativeplace);
	public User findUserByusernameAnduserpwd(String name, String password);
	public List<User> findUserByUsername(String name,String sortColumn);
	public NativePlace findNativePlaceByNativeplace(String Nativeplace);
	public String findAllUserByPage(Integer page,Model model);
	public String findNativeplaceById(Integer id);
	public List <NativePlace>findAll();
}
