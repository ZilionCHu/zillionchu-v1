package com.zillionchu.common.utils.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * 生成或解析tokenHelper
 */
public class JWTHelper{

	private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

	/**
	 * 根据用户信息生成token
	 * @param jwtInfo
	 * @param priKeyPath
	 * @param expire
	 * @return
	 * @throws Exception
	 */
	public static String generateToken(IJWTInfo jwtInfo, String priKeyPath, int expire) throws Exception {
		String compactJws = Jwts.builder()
				.setSubject(jwtInfo.getUserName())
				.setClaims(jwtInfo.buildJwtMap())
				.setExpiration(DateTime.now().plusSeconds(expire).toDate())
				.signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKeyPath))
				.compact();
		return compactJws;
	}


	/**
	 * 从token中获取用户信息
	 * @param token
	 * @param pubKeyPath
	 * @return
	 * @throws Exception
	 */
	public static <T> T getInfoFromToken(String token, IJWTInfo info, String pubKeyPath) throws Exception {
		Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
		Claims body = claimsJws.getBody();
		info.setUniqueName(body.getSubject());
		info.parserJwtClaims(body,info);
		return (T)info;
	}

	/**
	 * 
	 * @TODO:解析token
	 * @PARAM:
	 * @RETURN:Jws<Claims>
	 * @CREATER:wangchengyu
	 * @DATE:2018年4月24日
	 */
	public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath))
				.parseClaimsJws(token);
		return claimsJws;
	}

}
