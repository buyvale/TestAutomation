package Implementations;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Tag("ToDoList")
class TodoListItemImplementTest {

    private TodoListItemImplement item;
    private TodoListItemImplement list;
    private TodoListItemImplement[] todos;
    private String title;
    private String newTitle = "Title was changed for TODO item";
    private static Logger logger;

    @BeforeAll
    public static void setUpGlobal() {
        logger = LoggerFactory.getLogger(TodoListItemImplement.class);
    }

    @BeforeEach
    public void setUp() {
        title = "Todo item for test";
        item = new TodoListItemImplement(title);
        list = new TodoListItemImplement();
        todos = new TodoListItemImplement[]{
                new TodoListItemImplement("Go for a walk with the dog"),
                new TodoListItemImplement("Buy milk and sugar"),
                new TodoListItemImplement("See favourite TV series")
        };
    }

    @Test
    public void can_add_items_to_the_list() {
        logger.info("Add items to list test");
        list.addItem(todos[0]);
        list.addItem(todos[1]);
       // Assertions.assertEquals(2, list.length());
    }

    @Disabled
    @Test
    public void toggle_an_item() {
        item.toggle();
        Assertions.assertTrue(item.isToggled());
    }

    @Test
    @DisplayName("UnToggle")
    @RepeatedTest(10)
    public void unToggle_an_item() {
        item.toggle();
        item.toggle();
        Assertions.assertFalse(item.isToggled());
    }

    @Test
    public void item_is_not_toggled_after_creation() {
        Assertions.assertFalse(item.isToggled());
    }

    @Test
    public void item_have_title() {
        Assertions.assertEquals("Todo item for test", item.getTitle());
    }

    @Test
    void itemsTitleIsChangedAfterAssignmentOfNewTitle() {
        item.setTitle(newTitle);
        Assertions.assertEquals(newTitle, item.getTitle());
    }

    @Test
    public void cannot_create_item_with_empty_title() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TodoListItemImplement(""));
    }

    @Test
    public void can_set_new_title() {
        TodoListItemImplement newItem = item.setTitle(newTitle);
        Assertions.assertEquals(newTitle, newItem.getTitle());
    }

    @Test
    public void cannot_set_empty_title() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> item.setTitle(""));
    }

    @Test
    public void testPerformance() {

        Assertions.assertTimeout(Duration.ofNanos(1), () -> item.setTitle("New title for performance verify"));

    }

    @Test
    public void given2Strings_whenEqual_thenCorrect() {
        String a = "foo";
        String b = "FOO";
        assertThat(a, equalToIgnoringCase(b));
    }

    @AfterEach
    public void tearDown() {
    }


    @AfterAll
    public static void finalTearDown() {

    }

}