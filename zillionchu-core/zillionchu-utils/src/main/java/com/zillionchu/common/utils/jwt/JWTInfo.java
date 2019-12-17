package com.zillionchu.common.utils.jwt;

import java.io.Serializable;

/**
 * 用户登陆token信息
 * @author fanxingxing
 */
public class JWTInfo implements Serializable,IJWTInfo{

	private static final long serialVersionUID = 1L;

	/**
	 * 用户唯一标识（用户登陆名）
	 */
	private String uniqueName;
	/**
	 * 用户编号
	 */
	private String userNo;
	/**
	 * 用户登录名
	 */
	private String userName;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 账户状态：1、未启用 2、启用 3、停用
	 */
	private String status;


	@Override
	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	@Override
	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JWTInfo jwtInfo = (JWTInfo) o;

        if (userName != null ? !userName.equals(jwtInfo.userName) : jwtInfo.userName != null) {
            return false;
        }
        return userNo != null ? userNo.equals(jwtInfo.userNo) : jwtInfo.userNo == null;

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (userNo != null ? userNo.hashCode() : 0);
        return result;
    }

}
