package com.github.hofls.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	public void should_throw_sneaky() {
		Throwable exception = Assertions.assertThrows(Throwable.class, () -> {
			new LombokDemo().throwException();
		});
		assertEquals("Hola", exception.getMessage());
	}

	@Test
	public void should_generate_to_string() {
		LombokDemo.Entity entity = new LombokDemo.Entity();
		entity.setNumber(3543);
		entity.setText("QQ");
		String expected = "LombokDemo.Entity(text=QQ, number=3543)";
		assertEquals(expected, entity.toString());
	}

	@Test
	public void should_generate_equals_and_hashcode() {
		LombokDemo.Entity entityA = new LombokDemo.Entity();
		entityA.setNumber(3543);
		entityA.setText("QQ");
		LombokDemo.Entity entityB = new LombokDemo.Entity();
		entityB.setNumber(543321);
		entityB.setText("fdsa");
		LombokDemo.Entity entityC = new LombokDemo.Entity();
		entityC.setNumber(3543);
		entityC.setText("QQ");

		assertEquals(entityA, entityC);
		assertNotEquals(entityA, entityB);
		assertNotEquals(entityB, entityC);
	}



}
