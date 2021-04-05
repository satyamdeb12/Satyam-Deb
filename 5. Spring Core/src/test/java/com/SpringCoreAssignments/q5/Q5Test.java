package com.SpringCoreAssignments.q5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SpringCoreAssignment.q5.Config;
import com.SpringCoreAssignment.q5.Student;

class Q5Test {

	

    @Test
    void getAddress() {
    	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Student student = context.getBean(Student.class);
        assertEquals(1, student.getId());
    }

}
