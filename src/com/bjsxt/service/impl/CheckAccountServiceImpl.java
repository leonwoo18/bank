package com.bjsxt.service.impl;

import com.bjsxt.mapper.CheckAccountMapper;
import com.bjsxt.pojo.Account;
import com.bjsxt.service.CheckAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckAccountServiceImpl implements CheckAccountService {
    //声明mapper层属性
    @Autowired
    private CheckAccountMapper checkAccountMapper;

    //校验收款人信息
    @Override
    public Account checkInInfoService(String inId, String inName) {
        return checkAccountMapper.checkInInfoMapper(inId,inName);
    }

    //校验金额
    @Override
    public Account checkMoneyInfoService(String outId, String money) {
        return checkAccountMapper.checkMoneyInfoMapper(outId,money);
    }

    //校验转账账户信息
    @Override
    public Account checkOutAccountInfoService(String outId, String outPwd) {
        return checkAccountMapper.checkAccountOutInfoMapper(outId,outPwd);
    }


    //转账功能
    @Override
    public int transferInfoService(String outId, String inId, String money) {
        //1.出账
        int i = checkAccountMapper.transferOut(outId, money);
        //2.入账
        i+=checkAccountMapper.transferIn(inId,money);
        //返回
        return i;
    }
}
