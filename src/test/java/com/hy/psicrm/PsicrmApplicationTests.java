package com.hy.psicrm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PsicrmApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	// 变态跳台阶
	public int f(int n) {
		return 1 << (n-1);
	}
}
