package com.bjsxt.service;

import com.bjsxt.pojo.Account;

public interface CheckAccountService {
    //校验转账账户信息
    Account checkOutAccountInfoService(String outId,String outPwd);
    //校验金额
    Account checkMoneyInfoService(String outId, String money);
    //校验收款人信息
    Account checkInInfoService(String inId, String inName);


    //转账功能
    int transferInfoService(String outId, String inId, String money);
}
