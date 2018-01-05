package com.revature.util.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.beans.credentials;
import com.revature.util.JWTUtil;

import io.jsonwebtoken.SignatureException;

public class JWTUtilTest {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTokenParsing() {
		int id=1, type=2;
		String x=JWTUtil.createToken(id, type);
		credentials c=JWTUtil.parseJWT(x);
		assertEquals(c.getE_id(),id);
		assertEquals(c.getEmployee_type(),type);
	}
	@Test(expected =  SignatureException.class)
	public void testTokenFailure() {
		int id=1, type=2;
		String x=JWTUtil.createToken(id, type);
		x=x.substring(0,x.length()-1)+"c";
		JWTUtil.parseJWT(x);
		
	}
}
