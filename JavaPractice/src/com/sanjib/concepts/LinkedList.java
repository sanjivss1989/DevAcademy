/**
 * 
 */
package com.sanjib.concepts;

import java.util.Scanner;

/**
 * @author server
 *
 */
public class LinkedList {
	
	Node head;
	Node end;
	int size;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
        
       LinkedList list = new LinkedList();
       
       System.out.println("Size before addition == "+list.getSize());
       
       list.insertAtStart(1);
       list.insertAtStart(15);
       list.insertAtStart(10);
       list.insertAtStart(1);;
       
       System.out.println("Size after addition == "+list.getSize());
       
     

       

	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return head ==null;
	}
	
	
	
	public void insertAtStart(int data)
	{
		Node newNode = new Node(data, null);
		size++;
		
		if(head==null)
		{
			head = newNode;
			end = head;
		}
		
		else
		{
			newNode.setNext(end);
			head = newNode;
			
		}
		
		
	}
	
	
	public void insertAtEnd(int data)
	{
		Node newNode = new Node(data,null);
		size++;
		
		if(head==null)
		{
			head = newNode;
			end = head;
		}
		
		else
		{
			end.setNext(newNode);
			end = newNode;
		}
	}
	
	
	public void insertAtPos(int pos, int data)
	{
		Node newNode = new Node(data, null);
		Node ptr = head;
		pos = pos -1;
		
		
		for(int i = 1; i<size;i++)
		{
			if(i == pos)
			{
				Node temp = ptr.getNext();
				newNode.setNext(temp);
				ptr.setNext(newNode);
				break;
			}
			
			ptr = ptr.getNext();
		}
		
		size++;
	}
	
	public void deleteAtPos(int pos)
	{
		if(head==null)
			return;
		
		Node ptr = head;
		
		if(pos ==0)
		{
			head = head.next;
			return;
		}
		
		for(int i = 0;ptr!=null && i<pos-1;i++)
		{
			ptr = ptr.next;
			Node temp = ptr.next.next;
			
			ptr.setNext(temp);
		}
		
	size--;	
	}

}

class Node
{
	int data;
	Node next;
	
	public Node()
	{
		data = 0;
		next = null;
	}
	
	public Node(int data, Node next)
	{
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
