package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.NativePlace;
import com.example.demo.entity.User;

public interface NpandUserService {
	public void saveUser(User user);
	public void saveNativePlace(NativePlace nativeplace);
	public User findUserByusernameAnduserpwd(String name, String password);
	public List<User> findUserByusername(String name);
	public NativePlace findNativePlaceByNativeplace(String Nativeplace);
}
