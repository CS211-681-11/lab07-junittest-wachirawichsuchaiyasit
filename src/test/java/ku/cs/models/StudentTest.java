package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s ;
    @BeforeEach
    void init() {
        s = new Student("67104055486","Phai");
    }

    @Test
    void testAddStudentByNameAndId() {
        Student addStudentByNameAndId = new Student("67104055486","Phai");
        assertEquals("Phai",addStudentByNameAndId.getName());
        assertEquals("67104055486",addStudentByNameAndId.getId());
    }

    @Test
    void testAddStudentByNameAndIdAndScore() {
        Student addStudentByNameAndId = new Student("67104055486","Phai",20.0);
        assertEquals("Phai",addStudentByNameAndId.getName());
        assertEquals("67104055486",addStudentByNameAndId.getId());
        assertEquals(20.0,addStudentByNameAndId.getScore());
    }


    @Test
    void testAddScore() {
        init();
        s.addScore(40);
        assertEquals(40,s.getScore());
    }

    @Test
    void testCalculateScore() {
        init();
        s.addScore(100);
        assertEquals("A",s.grade());
    }

    @Test
    void testChangeName() {
        init();
        s.changeName("BigPhai");
        assertEquals("BigPhai",s.getName());
    }


}