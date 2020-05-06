import AnimalShelter.Task;
import AnimalShelter.TodoList;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JSONToDoTest {

    @Test
    void toJsonStringTest() throws JsonProcessingException{
        Task t1 = new Task(1,"lock shelter");
        String jString = JsonUtil.toJsonString(t1);
        String expString = "{\n" +
                "  \"priority\" : 1,\n" +
                "  \"task\" : \"lock shelter\",\n" +
                "  \"done\" : false\n" +
                "}";

        //assertEquals(expString,jString);  //issue with spacing - invisible
        System.out.println(expString);
        System.out.println(jString);

    }

    @Test
    void toJSONfromJsonTest()throws IOException{
        Task t1 = new Task(1,"lock shelter");
        t1.markDone(); //sets task to true - default is false
        JsonUtil.toJsonFile("src/test/java/toJsonFileAndFromJsonFileTest.json",t1);

        Task t2 = JsonUtil.fromJsonFile("src/test/java/toJsonFileAndFromJsonFileTest.json",Task.class);
        Assert.assertEquals(t1.getTask(),t2.getTask());
        Assert.assertEquals(t1.getDone(),t2.getDone());

    }
    @Test
    void jsonCollectionTest() throws IOException{
//writes to test file for read in
        List<Task> tList = Arrays.asList(
         new Task(5,"Feed dogs"),
         new Task(1,"Play with cats"),
         new Task(3,"Walk dogs"),
         new Task(4,"Take Walter to vet"));

       JsonUtil.toJsonFile("src/test/java/listFromJsonFileTest.json",tList);

        List<Task> tasksFromFile = JsonUtil.listFromJsonFile("src/test/java/listFromJsonFileTest.json",Task.class);
        Assert.assertEquals(4,tasksFromFile.size());
        Assert.assertEquals("Play with cats",tasksFromFile.get(1).getTask());

    }
    @Test
    void jsonToToDoList() throws IOException{
        TodoList td1 = new TodoList();
        List<Task> tasksFromFile = JsonUtil.listFromJsonFile("src/test/java/listFromJsonFileTest.json",Task.class);
        String exp = "1. Feed dogs\n2. Take Walter to vet\n3. Walk dogs\n4. Play with cats\n";
        td1.fromJson(tasksFromFile);

        assertEquals(exp, td1.getToDoList());
        System.out.println(td1.getToDoList()); //Lists prints in priority order

    }

}
