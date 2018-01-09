package com.valuelabs.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.valuelabs.bean.AccountDetailsBean;
import com.valuelabs.bean.LoginDetailsBean;
import com.valuelabs.dao.LoginDao;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired(required = true)
	LoginDao loginDao;
	@Autowired(required = true)
	LoginDetailsBean loginDetailsBean;
	@Autowired(required = true)
	AccountDetailsBean accountDetailsBean;

	@Override
	public boolean checkUserLoginCredentials(String username, String password) {
		List list = loginDao.checkLoginCredentials(username, password);
		Iterator<String> iterator = list.iterator();
		if (!list.isEmpty()) {
			return true;
		}
		return false;

	}

	@Override
	public boolean checkIsAccountNumber(String accountNumber) {
		List list = loginDao.checkIsAccountNumber(accountNumber);
		Iterator<String> iterator = list.iterator();
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public List checkIsValidAccountNumber(String accountNumber) {
		List list = loginDao.checkIsAccountNumber(accountNumber);
		return list;
	}

	@Override
	public boolean checkUserId(String username) {
		List list = loginDao.checkIsUsername(username);
		Iterator<String> iterator = list.iterator();
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public String checkUserAccountNumber(String username, String password) {
		String accountNumber = null;
		List list = loginDao.checkLoginCredentials(username, password);
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			accountNumber = iterator.next();
		}
		return accountNumber;
	}

	public boolean newUserPermission(String accountNumber, String accountName, String username, String password,
			String address, String emailId, int phoneNumber, String panNumber, int aadharNumber, String accountType,
			String date) {
		loginDetailsBean.setAccountNumber(accountNumber);
		loginDetailsBean.setAccountName(accountName);
		loginDetailsBean.setUsername(username);
		loginDetailsBean.setPassword(password);
		loginDetailsBean.setAddress(address);
		loginDetailsBean.setEmailId(emailId);
		loginDetailsBean.setPhoneNumber(phoneNumber);
		loginDetailsBean.setPanNumber(panNumber);
		loginDetailsBean.setAadharNumber(aadharNumber);
		loginDetailsBean.setAccountType(accountType);
		loginDetailsBean.setAccountOpenDate(date);
		accountDetailsBean.setAccNumber(accountNumber);
		accountDetailsBean.setAccName(accountName);
		accountDetailsBean.setStatusOfAccount("Active");
		accountDetailsBean.setAccountOpenDate(date);
		accountDetailsBean.setAccountType(accountType);
		if (loginDao.newUserPermissionInfo(loginDetailsBean, accountDetailsBean)) {
			return true;
		}
		return false;
	}

	@Override
	public String getAccountNumber(String username, String password) {
		String accountNumber = "";
		List list = loginDao.getAccountNumber(username, password);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			accountNumber = (String) iterator.next();
		}
		return accountNumber;
	}

	@Override
	public boolean isAccountNumber(String username, String password) {
		int accountNumber = 0;
		List list = loginDao.getAccountNumber(username, password);
		Iterator iterator = list.iterator();
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public List getProfileData(String accountNumber) {
		List list = loginDao.getProfile(accountNumber);
		return list;
	}

	@Override
	public boolean getProfileUpdate(String accountNumber, String address, String emailId, int phoneNumber,
			String panNumber, int aadharNumber) {
		// loginDao.profileUpdate(con.getConnection(),accountNumber,address,emailId,phoneNumber,panNumber,aadharNumber);
		return loginDao.profileUpdate(address, emailId, phoneNumber, panNumber, aadharNumber, accountNumber);
	}

	/*
	 * @Override public boolean getEmail(String username, String password) {
	 * List list = loginDao.checkLoginCredentials(username, password);
	 * Iterator<String> iterator = list.iterator(); if (!list.isEmpty()) {
	 * return true; } return false;
	 * 
	 * }
	 * 
	 */
}
