package com.revature.util.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.revature.util.ConnectionUtil;

public class ConnectionUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetConn() {
		try {
			assertTrue(ConnectionUtil.getConn().isValid(1000));
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
