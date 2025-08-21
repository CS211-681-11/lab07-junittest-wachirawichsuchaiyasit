package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    private StudentHardCodeDatasource ds;

    @BeforeEach
    void setUp() {
        ds = new StudentHardCodeDatasource();
    }

    @Test
    void readData_returnsNonNullList_withFourStudents() {
        StudentList list = ds.readData();

        assertNotNull(list);
        assertEquals(4, list.getStudents().size(), "should contain 4 students");
    }

    @Test
    void readData_containsExpectedIds() {
        StudentList list = ds.readData();

        assertNotNull(list.findStudentById("6710400001"));
        assertNotNull(list.findStudentById("6710400002"));
        assertNotNull(list.findStudentById("6710400003"));
        assertNotNull(list.findStudentById("6710400004"));
    }

    @Test
    void readData_containsExpectedNames() {
        StudentList list = ds.readData();

        assertEquals(1, list.filterByName("First").getStudents().size());
        assertEquals(1, list.filterByName("Second").getStudents().size());
        assertEquals(1, list.filterByName("Third").getStudents().size());
        assertEquals(1, list.filterByName("Fourth").getStudents().size());

    }

    @Test
    void readData_orderIsStable_ifOrderMatters() {
        StudentList list = ds.readData();

        assertTrue(list.getStudents().get(0).isId("6710400001"));
        assertTrue(list.getStudents().get(1).isId("6710400002"));
        assertTrue(list.getStudents().get(2).isId("6710400003"));
        assertTrue(list.getStudents().get(3).isId("6710400004"));
    }

    @Test
    void readData_returnsNewInstanceEachCall_notSharedState() {
        StudentList list1 = ds.readData();
        list1.addNewStudent("9999999999", "Temp");

        StudentList list2 = ds.readData();
        assertNull(list2.findStudentById("9999999999"),
                "Second read should not include mutations made on first list");
    }
}
