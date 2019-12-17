package com.zillionchu.common.utils.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * jwtToken 生成工具类
 * @author fanxingxing
 */
@Component("jwtTokenUtil")
public class JwtTokenUtil {

    /**
     * token header key
     */
    @Value("${auth.user.token-header:''}")
    private String tokenHeader;
    /**
     * token有效期
     */
    @Value("${jwt.expire:3000}")
    private int expire;
    /**
     * 私钥路径
     */
    @Value("${jwt.pri-key.path:''}")
    private String priKeyPath;
    /**
     * 公钥路径
     */
    @Value("${jwt.pub-key.path:''}")
    private String pubKeyPath;

    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, priKeyPath, expire);
    }

    public IJWTInfo getInfoFromToken(String token,IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.getInfoFromToken(token,jwtInfo,pubKeyPath);
    }

}
