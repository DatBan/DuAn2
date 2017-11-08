package com.dao;

import java.util.List;

import com.entity.NguoiDung;

public interface UserDAO {
	public NguoiDung getByUsername(String username);
	public NguoiDung getByIdFacebook(String idfb);
	public NguoiDung getByIdGoogle(String idgg);
	public void createUser(NguoiDung nd);
	public void updateUser(NguoiDung nd);
	public List<NguoiDung> getListByTrangThai(int trangthai);
	public NguoiDung getByTrangThaiAndId(int trangthai, int id);
	public List<NguoiDung> getListByIdQuyen(int idq);
	public void deleteUser(NguoiDung nd);
}