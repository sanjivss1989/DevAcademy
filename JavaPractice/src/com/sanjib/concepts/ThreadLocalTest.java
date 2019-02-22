/**
 * 
 */
package com.sanjib.concepts;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author server
 *
 */
public class ThreadLocalTest implements Runnable {
	
	
	private static final AtomicInteger        nextId   = new AtomicInteger(0);
	private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>()
			{
		 @Override
         protected Integer initialValue()
         {
            return nextId.getAndIncrement();
         }
			};
			
			
			
	public int getThreadId()
	
			   {
			      return threadId.get();
			   }
			   // Returns the current thread's starting timestamp
			   private static final ThreadLocal<Date> startDate = new ThreadLocal<Date>()
			                                                 {
			                                                    protected Date initialValue()
			                                                    {
			                                                       return new Date();
			                                                    }
			                                                 };
			 

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runnable r1 = new ThreadLocalTest();
		Runnable r2 = new ThreadLocalTest();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 System.out.printf("Starting Thread: %s : %s\n", getThreadId(), startDate.get());
	      try
	      {
	         TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
	      } catch (InterruptedException e)
	      {
	         e.printStackTrace();
	      }
	      System.out.printf("Thread Finished: %s : %s\n", getThreadId(), startDate.get());
		
	}

}
