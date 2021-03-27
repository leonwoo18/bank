package com.bjsxt.mapper;

import com.bjsxt.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CheckAccountMapper {
    //校验转账账户信息:根据账户ID和密码获取账户信息
    @Select("select * from t_account where aid=#{outId} and apwd=#{outPwd}")
    Account checkAccountOutInfoMapper(@Param("outId") String outId, @Param("outPwd") String outPwd);
    //校验金额
    @Select("select * from t_account where aid=#{outId} and money>=#{money}")
    Account checkMoneyInfoMapper(@Param("outId") String outId, @Param("money") String money);
    //校验收款人信息
    @Select("select a.* from t_account a join t_user u on a.uid=u.uid where a.aid=#{inId} and u.uname=#{inName}")
    Account checkInInfoMapper(@Param("inId") String inId, @Param("inName") String inName);
    //转出
    @Update("update t_account set money=money-#{money} where aid=#{outId}")
    int transferOut(@Param("outId") String outId,@Param("money") String money);
    //转入
    @Update("update t_account set money=money+#{money} where aid=#{inId}")
    int transferIn(@Param("inId") String inId,@Param("money") String money);
}
