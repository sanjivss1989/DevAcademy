/**
 * 
 */
package com.sanjib.concepts;

import java.util.Arrays;

/**
 * @author server
 *
 */
public class ArrayListImplementation {

	
	public static void main(String args[])
	{
		
	}
}

class ArrayList
{
	private int size = 0;
	private static final  int DEFAULT_SIZE = 10;
	private Object[] entries = new Object[DEFAULT_SIZE];
	
	
	public Object get(int index)
	{
		if(index>size)
			throw new ArrayIndexOutOfBoundsException();
		else
		return entries[index];
	}
	
	
	public boolean add(Object element)
	{
		boolean isAdded = false;
		
		if(entries.length-size<=5)
		{
			resizeList();
		}
		entries[size++] = element;
		isAdded=true;
		return isAdded;
	}
	
	private void resizeList()
	{
		
		Arrays.copyOf(entries, entries.length*2 );
	}
	
	public int size()
	{
		return size;
	}
}
