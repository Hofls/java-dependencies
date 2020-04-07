package com.github.hofls.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LombokDemoTest {

	@Test
	public void should_generate_getters_and_setters() {
		LombokDemo.Entity entity = new LombokDemo.Entity();
		entity.getNumber();
		entity.setText("QQ");
	}

	@Test
	public void should_throw_npe() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			LombokDemo.generateArray(null);
		});
	}

}
