/*
In this part, you will implement a stack using linked lists. Read about Java Generics and implement the stack class using generics. Do not use in-built list data structures.

Deliverables: • 
[15 Points] Write a java class MyStack<E> in  MyStack.java that implements stack with following methods.
– public void push(E item) : Pushes the item onto the top of the stack. 
– public E pop() : Removes the element at the top of the stack and returns it. Throw EmptyStackException if the stack is empty. 
– public E peek() : Returns the top element without removing from top of the stack. Throw EmptyStackException if the stack is empty. 
– public bool empty() : Returns true if the stack is empty and false otherwise.
All other methods or variables in your implementation should be private.

*/
import java.util.*; 
public class MyStack<E>
{
	private E element;
	private MyStack<E> next;
	private MyStack<E> head;
	
	public void push(E item)
	{
		MyStack<E> temp=new MyStack<E>();
		temp.element=item;
		temp.next=head;
		head=temp;
	}
	public E pop()
	{
		if(head!=null)
		{
			E temp=head.element;
			head=head.next;
			return temp;
		}
		else
		{
			throw new EmptyStackException(); 	
		}
	}
	public E peek()
	{
		if(head!=null)
		{
			return head.element;
		}
		else
		{
			throw new EmptyStackException(); 	
		}
	}
	public boolean empty()
	{
		if(head==null)
			return true;
		else
			return false;
	}
	 
}