package com.revature.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import com.revature.beans.credentials;

import io.jsonwebtoken.*;

public class JWTUtil {
	public static String createToken(int user_id, int user_type) {
		SignatureAlgorithm sa = SignatureAlgorithm.HS256;
		Date now = new Date(System.currentTimeMillis());
		String key = "random_secret_key";
		String base64Key = DatatypeConverter.printBase64Binary(key.getBytes());
		byte[] secretBytes = DatatypeConverter.parseBase64Binary(base64Key);
		Map<String,Object> claims = new HashMap<>();
		claims.put("e_id", user_id);
		claims.put("e_type", user_type);
		Date exp = new Date((long) (System.currentTimeMillis()+900000.0));
		JwtBuilder Jws = Jwts.builder()
				.setIssuedAt(now)
				.setClaims(claims)
				.setExpiration(exp)
				.setIssuer("TRMS")
				.signWith(sa, secretBytes);
		return Jws.compact();
	}
	public static credentials parseJWT(String jwt) {
		String key = "random_secret_key";
		String base64Key = DatatypeConverter.printBase64Binary(key.getBytes());
		byte[] secretBytes = DatatypeConverter.parseBase64Binary(base64Key);
		try {
		    Jwts.parser().setSigningKey(secretBytes).parseClaimsJws(jwt);
		    Claims claims=Jwts.parser()
		    		.setSigningKey(secretBytes)
		    		.parseClaimsJws(jwt)
		    		.getBody();
		    credentials c = new credentials((Integer) claims.get("e_id"), (Integer) claims.get("e_type"));
		    return c;
		} catch (SignatureException e) {
		    e.printStackTrace();
		    return null;
		}
	}

}
