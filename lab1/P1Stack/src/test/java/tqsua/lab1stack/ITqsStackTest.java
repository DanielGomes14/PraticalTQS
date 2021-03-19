package tqsua.lab1stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ITqsStackTest {

    private ITqsStack<String> tqsStack;
    private ITqsStack<String> stack3Elems;
    @BeforeEach
    void setUp() {
        this.tqsStack = new ITqsStack<String>();
        this.stack3Elems = new ITqsStack<String>();
        stack3Elems.push("Aveiro");
        stack3Elems.push("Porto");
        stack3Elems.push("Viseu");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void push() {

        assertEquals(3,stack3Elems.size());
        assertFalse(stack3Elems.IsEmpty(), () -> "Stack cannot be empty after any push");
    }

    @Test
    void popAfterPush() {
        //Considering a Stack with already 3 pushed elements, only is needed to verify the pop method
        assertEquals("Viseu",stack3Elems.pop());
    }

    @Test
    void peekAfterPush() {
        assertEquals("Viseu",stack3Elems.peek());
    }

    @Test
    void size() {
        for(int i = 0; i <= 2; i++) stack3Elems.pop();

        assertTrue(stack3Elems.IsEmpty(),() -> "Stack must have size 0 after popping all elements");
        assertEquals(0,stack3Elems.size());
    }

    @Test
    void popOnEmptyStack() {
         assertThrows(NoSuchElementException.class,
                () ->  tqsStack.pop());
    }
    @Test
    void peekOnEmpty() {
        assertThrows(NoSuchElementException.class,
                () -> tqsStack.peek());
    }

    @Test
    void pushOnBoundedStack() {
        tqsStack = new ITqsStack<String>(2);

        tqsStack.push("String1");
        tqsStack.push("String2");

        assertThrows( IllegalStateException.class, () -> {
            tqsStack.push("String3");
        });

    }
    @Test
    void sizeOnEmptyStack() {
        assertTrue(tqsStack.IsEmpty(), () ->"Stack must have size 0 on its creation.");
    }

    @Test
    void isEmpty() {
        assertTrue(tqsStack.IsEmpty(), () -> "Stack must be empty on its creation");
    }
}