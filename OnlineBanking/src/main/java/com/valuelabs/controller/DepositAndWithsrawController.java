package com.valuelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.valuelabs.service.DepositAndWithdrawService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/amount")
@Api(value="Employee Service")
public class DepositAndWithsrawController {
	/*
	 * @Autowired(required = true) HomePageService homePageService;
	 */
	
	@Autowired(required = true)
	DepositAndWithdrawService depositAndWithdrawService;
/*
	String fromEmail = "srujanamedagam@gmail.com";
	String password = "Yogireddy@1991";*/

	@RequestMapping("/deposit")
	
	@ApiOperation(value="depositAmount",notes="deposit Amount",response=DepositAndWithsrawController.class)
	public  String depositAmount(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("amount") Double amount,
			@RequestParam("remarks") String remarks) {

		String accNumber = depositAndWithdrawService.depositAmount(accountNumber);
		String result = "";
		String toAccount = "-";
		String transactionType = "Credit";
		/*
		String setSub = "Regarding Money Deposit.";
		String setText = "Money deposited in your account"
				+ amount+"  has been credited to your account";*/
		if (accNumber != "") {
			if (depositAndWithdrawService.depositAmount(accountNumber, amount)) {
				double balanceAmount = depositAndWithdrawService.balanceAmountAfterDeposit(accountNumber);
				depositAndWithdrawService.depositAndWithdrawAmountToTransactionHistory(accountNumber, amount,
						transactionType, balanceAmount, toAccount, remarks);
				String toEmail = depositAndWithdrawService.getEmail(accountNumber);
			//	EmailUtil.sendEmail(toEmail , setSub, setText);
				result = "passed";                                                       
			} else {
				result = "failed";

			}
		}
		return result;
	}

	@RequestMapping("/withdraw")
	public @ResponseBody String withdrawAmount(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("amount") Double amount, @RequestParam("transactionDate") String transactionDate,
			@RequestParam("remarks") String remarks) {

		String accNumber = depositAndWithdrawService.withdrawAmount(accountNumber);
		String toAccount = "-";
		String result = "";
		String transactionType = "Debit";
		/*String setSub = "Regarding Money Deposit.";
		String setText = "Money debited from your account  "
				+ amount+"  has been debited to your account";*/
		if (accNumber != "") {
			if (depositAndWithdrawService.withdrawAmount(accountNumber, amount)) {
				double balanceAmount = depositAndWithdrawService.balanceAmountAfterWithdraw(accountNumber);
				depositAndWithdrawService.depositAndWithdrawAmountToTransactionHistory(accountNumber, amount,
						 transactionType, balanceAmount, toAccount, remarks);
				String toEmail = depositAndWithdrawService.getEmail(accountNumber);
				//EmailUtil.sendEmail(toEmail , setSub, setText);
				result = "pass";
			} else { 
				result = "failed";
			}
		} else {
			result = "failed";
		}
		return result;
	}
}
