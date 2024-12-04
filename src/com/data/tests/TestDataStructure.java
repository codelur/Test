package com.data.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.interview.all.StackType;

class TestDataStructure {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testSize() {
		StackType<Integer> integerStack = new StackType<Integer>();
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7); 
		integerStack.addAll(list);
		assertEquals(7, integerStack.getStackSize());
	}
}
