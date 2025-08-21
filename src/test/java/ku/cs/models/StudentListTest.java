
package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
        studentList.addNewStudent("001","Phai");
        studentList.addNewStudent("002","BigPhai",100);
    }

    @Test
    void testAddStudentNotHaveScore() {
        studentList.addNewStudent("003","Newbie");
        assertNotNull(studentList.findStudentById("003"));
    }

    @Test
    void testAddStudentHaveScore() {
        studentList.addNewStudent("004","ScoreGuy",100);
        assertNotNull(studentList.findStudentById("004"));
    }

    @Test
    void testFindStudentById() {
        assertNotNull(studentList.findStudentById("001"));
        assertNull(studentList.findStudentById("NOPE"));
    }

    @Test
    void testFindStudentByName() {
        var result = studentList.filterByName("Phai");
        assertEquals(2, result.getStudents().size());
    }

    @Test
    void testGiveScore() {
        StudentList list = new StudentList();
        list.addNewStudent("001","Phai");
        list.giveScoreToId("001",100);

        assertEquals("A", list.viewGradeOfId("001"));
    }
}
