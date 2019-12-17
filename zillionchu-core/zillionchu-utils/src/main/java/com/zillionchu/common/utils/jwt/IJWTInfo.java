package com.zillionchu.common.utils.jwt;

import io.jsonwebtoken.Claims;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * jwtToken body类
 * @author fanxingxing
 */
public interface IJWTInfo {

	/**
	 * 设置用户唯一登陆名
	 * @param uniqueName
	 */
	void setUniqueName(String uniqueName) ;

	/**
	 * 用户编号
	 * @return
	 */
	String getUserNo();

	/**
	 * 用户登陆名
	 * @return
	 */
	String getUserName();

	/**
	 * 用户手机号
	 * @return
	 */
	String getPhone();

	/**
	 * 用户状态
	 * @return
	 */
	String getStatus();

	String JWT_KEY_USER_NO = "userNo";
	String JWT_KEY_USER_NAME = "userName";
	String JWT_KEY_USER_PHONE = "phone";
	String JWT_KEY_USER_STATUS = "status";

	/**
	 * 创建jwtToken body map
	 * @return
	 */
	default Map<String,Object> buildJwtMap(){
		Map<String,Object>  map = new LinkedHashMap<>();
		map.put(JWT_KEY_USER_NO,getUserNo());
		map.put(JWT_KEY_USER_NAME , getUserName());
		map.put(JWT_KEY_USER_PHONE , getPhone());
		map.put(JWT_KEY_USER_STATUS , getStatus());
		return map;
	}


	/**
	 * 解析json中数据到指定实体
	 * @param body
	 * @param info
	 * @return
	 * @throws Exception
	 */
	default IJWTInfo parserJwtClaims(Claims body, IJWTInfo info) throws Exception {
		//BeanUtils.populate(info, body);
		return info;
	}


}
