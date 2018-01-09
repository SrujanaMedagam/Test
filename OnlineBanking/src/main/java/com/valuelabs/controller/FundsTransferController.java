package com.valuelabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valuelabs.bean.FundsTransferBean;
import com.valuelabs.service.FundsTransferService;
import com.valuelabs.service.LoginService;

@Controller
@RequestMapping("/funds")
public class FundsTransferController {
	@Autowired(required = true)
	FundsTransferService fundsTransferService;
	@Autowired(required = true)
	LoginService loginService;

	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public @ResponseBody String fundsTransfer(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("accountNumber") String accountNumber,@RequestParam("amount") double amount,@RequestParam("remarks") String remarks) {
		String transactionType = "Debit";
		String result = null;
		String accountDetails = loginService.checkUserAccountNumber(username,
				password);
		/*
		 * Iterator it = list.iterator(); while (it.hasNext()) { accountDetails
		 * = (String) it.next(); }
		 */
		if (fundsTransferService.trnsferFunds(accountDetails, amount)) {
			if (fundsTransferService.trnsferFundsUpdate(accountNumber,
					amount)) {
				double balanceAmount = fundsTransferService.balanceAmountAfterTransferFunds(accountDetails);
				fundsTransferService.transferFundsToTransactionHistory(accountDetails,
						accountNumber, amount,
						 transactionType, balanceAmount,
						remarks);
				double totalAmount = fundsTransferService
						.totalAmountAfterTransferFunds(accountNumber);
				transactionType = "Credit";
				if (fundsTransferService.updatedTransferFundsToTransactionHistory(accountDetails,
						accountNumber, amount,
						 transactionType, totalAmount,
						remarks)) {
					result = "pass";
				} else {
					result = "fail";
				}
			}
		}

		return result;
	}

	@RequestMapping("/isvalidaccountNumber")
	public @ResponseBody boolean isValidAccountNumber(@RequestParam("accountNumber") String accountNumber) {
		List list = loginService.checkIsValidAccountNumber(accountNumber);
		if (list.contains(accountNumber)) {
			return true;
		}
		return false;
	}

}
