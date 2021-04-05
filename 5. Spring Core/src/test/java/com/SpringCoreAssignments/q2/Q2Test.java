package com.SpringCoreAssignments.q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringCoreAssignment.q2.Question;

class Q2Test {

	@Test
	void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCoreAssignment/q2/q2.xml");
		Question question = (Question) context.getBean("question");

		assertEquals(1, question.getQuestionId());

	}

}
