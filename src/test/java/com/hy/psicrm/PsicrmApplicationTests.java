package com.hy.psicrm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PsicrmApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public int f(int n) {
		if (n == 0 || n == 1){
			return 1;
		} else {
			return 2*f(n-1);
		}
	}
}
