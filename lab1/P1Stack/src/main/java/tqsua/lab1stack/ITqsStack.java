package tqsua.lab1stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ITqsStack<T> {

    private int bound = -1;
    private LinkedList<T> stack;

    /**
     * Constructor for a Stack with no Bound Defined
     */
    public ITqsStack(){
        this.stack = new LinkedList<>();
    }

    /**
     *  Constructor for a Stack with a defined Bound.
     * @param bound : the bound defined for the Stack
     */
    public ITqsStack(int bound){
        this.bound = bound;
        this.stack = new LinkedList<>();
    }

    /**
     * Pushes an element into the Stack. If there's a bound defined,
     * then it will throw an IllegalStateException, in case the number of elements
     * in the stack is already equal to the bound.
     *
     * @param elem: an element to be pushed into the Stack
     */
    public  void push(T elem) {
        // In case the bound is less than zero then no bound will be considered, and
        // the number of elements in the queue is "infinite".
        if( bound  > 0 ) {
            if (stack.size() == bound) throw new IllegalStateException();
        }
        this.stack.push(elem);


    }

    /**
     * Pops the element on the top of the Stack from it.
     * In case the stack is Empty it wil be thrown a NoSuchElementException
     *
     * @return the element popped from the top of  the Stack.
     */
    public  T pop(){
        if ( this.stack.isEmpty() ){
            throw  new NoSuchElementException();
        }
        return  this.stack.pop();
    }

    /**
     *  Returns the element on the elements of the Stack, but this element
     *  will not be popped. In case the stack is Empty it wil be thrown a
     *  NoSuchElementException
     *
     * @return the element on top of the Stack.
     */
    public T peek(){
        if ( this.stack.isEmpty() ){
            throw  new NoSuchElementException();
        }
        return this.stack.peek();
    }

    /**
     *
     * @return the size of the Stack ( the number of elements on it)
     */
    public int size(){
        return this.stack.size();
    }

    /**
     *  Verifies if the stack is Empty or Not
     * @return True or False, based on the size of the Queue.
     */
    public  boolean IsEmpty(){
        return this.stack.isEmpty();
    }
}
