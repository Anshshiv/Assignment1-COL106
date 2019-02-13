/*
In this part, you will solve the classic towers of hanoi problem. Towers of hanoi puzzle consists of three rods and n disks of diﬀerent sizes. 
Let the three rods be numbered 1, 2 and 3. Initially, n disks are stacked on rod 1 in ascending order of the sizes with the largest disk at the 
bottom and smallest disk at the top. Your goal is to move this entire stack from rod 1 to rod 3 using a sequence of moves. In a move, you are 
allowed to take a disk from the top of a stack on one of the rods and move to the top of the stack on other rods with a caveat that at no point
of time, a disk is on top of a smaller disk. 
Write a class TowerOfHanoi in TowerOfHanoi.java with implementations of following methods.

Deliverables: 
• [5 Points] Implement a method toh with recursion with following signature.
public static void toh with recursion(int num disks, int start pos, int end pos)
– Use recursion to solve the tower of hanoi problem. 
– num disks: Number of disks. 
– start pos: Integer which is either 1, 2 or 3 denoting the number of rod on which stack of disks is initially located. 
– end pos: Integer which is either 1, 2 or 3 denoting the number of rod on which stack of disks is located at the end. 
– Output Format: Print a line for each move. Each line consists of two integers. In each line, print the number of rod 
from which the disk is taken from followed by a space followed by the number of rod onto which the disk is moved. A sample output is given below.
1 2 
1 3 
2 1 
. . 
. .  
• [30 Points] Implement a method toh without recursion with following signature.
public static void toh without recursion(int num disks, int start pos, int end pos)
– All the variables mean same as in above part. 
– You cannot use recursion in this method. 
– You should use the stack that you have implemented to simulate recursion. 
– Output format is same as above.

*/

public class TowerOfHanoi
{
	
	public static void toh_with_recursion(int num_disks, int start_pos, int end_pos)
	{
		if(start_pos!=end_pos)
		{
			int pos;	
			if(num_disks>1)
			{
				pos=select(start_pos,end_pos);		
				TowerOfHanoi.toh_with_recursion(num_disks-1, start_pos, pos);
				System.out.println(start_pos+" "+end_pos);
				TowerOfHanoi.toh_with_recursion(num_disks-1, pos, end_pos);
			}
			if(num_disks==1)
			{
				System.out.println(start_pos+" "+end_pos);
			}
		}
		else
		{
			
		}
		
	}
	
	public static void toh_without_recursion(int num_disks, int start_pos, int end_pos)
	{
		MyStack<element> a=new MyStack<>();
		element_ e1=new element_();		
		int pos,n1,sp1,ep1;	
		e1.n=num_disks;
		e1.sp=start_pos;
		e1.ep=end_pos;
		a.push(e1);
		
		while(a.empty()==false)
		{
			element_ e3=new element_();
			e3=a.pop();
			n1=e3.n;
			sp1=e3.sp;
			ep1=e3.ep;
			pos=select(sp1,ep1);
			if(sp1!=ep1)
			{
				if(n1==1)
				{
					System.out.println(sp1+" "+ep1);
				}
				else
				{
					element_ e2=new element_();
					e2.n=n1-1;
					e2.sp=pos;
					e2.ep=ep1;
					a.push(e2);
					
					element_ e4=new element_();
					e4.n=1;
					e4.sp=sp1;
					e4.ep=ep1;
					a.push(e4);
					
					element_ e5=new element_();
					e5.n=n1-1;
					e5.sp=sp1;
					e5.ep=pos;
					a.push(e5);
				}
			}
			else
			{
				
			}
		}
	}
	
	static int select(int a, int b)
	{
		if(a!=3 && b!=3)
		{
			return 3;
		}
		else if(a!=2 && b!=2)
		{
			return 2;
		}
		else
		{
			return 1;
		}
	}
}

class element_
{
	public int n;
	public int sp;
	public int ep;
	
	
}

 

