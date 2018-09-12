package Implementations;

import org.junit.jupiter.api.*;

class TodoListItemImplementTest {

    protected TodoListItemImplement item;
    protected String title;
    protected String newTitle = "Title was changed for TODO item";

    @BeforeAll
    public static void setUpGlobal() {

    }

    @BeforeEach
    public void setUp() {
        title = "Todo item for test";
        item = new TodoListItemImplement(title);
    }

    @Test
    public void toggle_an_item() {
        item.toggle();
        Assertions.assertTrue(item.isToggled());
    }

    @Test
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
    @AfterEach
    public void tearDown() {

    }



    @AfterAll
    public static void finalTearDown() {

    }

}