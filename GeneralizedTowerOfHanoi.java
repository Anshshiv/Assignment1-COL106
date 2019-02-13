/*
In this part, you will solve a general version of Tower of Hanoi. Here we have 2n disks. Let the disks be numbered 0 to 2n−1. 
A disk can be colored either red or black. Size and color of disk i are as follows
size(i) = i + 1 
color(i) =(red, for i odd 
		   black, for i even 
Initially, disks are arranged in a stack on rod 1 in increasing order of their sizes i.e., disk 2n−1 is at the bottom and disk 0
 is at the top. Your goal is to stack all red disks on rod 1 and all black disks on rod 2 in the increasing order of their sizes. 
 You can move a disk from top of a stack and place it on top of another stack and at no point of time, a larger disk is on top 
 of a smaller disk. Write a java class GeneralizedTowerOfHanoi in  GeneralizedTowerOfHanoi.java with implementations of 
following methods.

Deliverables: 
• [10 Points] Implement a method gtoh with recursion with following signature. 
public static void gtoh with recursion(int num disks, int start pos, int r, int b)
– Use recursion to solve this problem. 
– int num disks : No. of disks. Sizes increase from disk number 0 to disk number num disks-1. 
– int start pos : This is an integer between 1 and 3 both inclusive. This denotes the rod on which the stack of disks is 
initially on. Initial stack has the largest disk i.e., disk number num disks-1 on bottom and disk number 0 on top. 
– int r: This is an integer which is either 1, 2 or 3. This denotes the rod on which red disks are to be stacked at 
the end. Color of a disk is as  above. 
– int b: This is an integer which is either 1, 2 or 3. This denotes the rod on which black disks are to be stacked 
at the end. Color of a disk is as  above. 

• [40 Points] Implement a method gtoh without recursion with following signature. 
public static void gtoh without recursion(int num disks, int start pos, int r, int b)
– All variables mean same as in above part. 
– You cannot use recursion in the implementation. 
– You should use stack you have implemented to simulate recursion. 
– Output format is same as above.
*/

public class GeneralizedTowerOfHanoi
{
	public static void gtoh_with_recursion(int num_disks, int start_pos, int r, int b)
	{
		
		int pos,pos_1,pos_2,pos_3;
		if(num_disks>2)
		{
			if(num_disks%2==0)
			{
				pos_1=r;
				pos_3=b;
				if(start_pos!=pos_1)
				{
					pos=select(start_pos,r);
				}
				else
				{
					pos=pos_1;
				}
				pos_2=select(pos,b);		
			}
			else
			{
				pos_1=b;
				pos_3=r;
				if(start_pos!=pos_1)
				{
					pos=select(start_pos,b);
				}
				else
				{
					pos=pos_1;
				}
				pos_2=select(pos,r);
			}
			
			if(start_pos!=pos_1)
			{
				GeneralizedTowerOfHanoi.gtoh_with_recursion(num_disks-1, start_pos, pos, pos);
				System.out.println(start_pos+" "+pos_1);
				start_pos=pos;
			}
			if(pos!=pos_3)
			{
				GeneralizedTowerOfHanoi.gtoh_with_recursion(num_disks-2, pos, pos_2, pos_2);
				System.out.println(pos+" "+pos_3);
				start_pos=pos_2;
			}
			GeneralizedTowerOfHanoi.gtoh_with_recursion(num_disks-2, start_pos, r, b);
		}
		else if(num_disks==2)
		{
			int pos_4;
			pos_4=select(start_pos,r);	
			if(start_pos!=r)
			{
				System.out.println(start_pos+" "+pos_4);
				System.out.println(start_pos+" "+r);
				if(pos_4!=b)
					System.out.println(pos_4+" "+b);
			}
			else
			{
				if(start_pos!=b)
					System.out.println(start_pos+" "+b);
			}
		}
		else
		{
			if(start_pos!=b)
				System.out.println(start_pos+" "+b);
		}
	}
	
	public static void gtoh_without_recursion(int num_disks, int start_pos, int r, int b)
	{
		MyStack<element> a=new MyStack<>();
		element e1=new element();		
		int pos,pos_1,pos_2,pos_3,n,sp, r_p,b_p, pos_4,t;	
		e1.n=num_disks;
		e1.sp=start_pos;
		e1.r=r;
		e1.b=b;
		a.push(e1);
		
		while(a.empty()==false)
		{
			element e3=new element();
			e3=a.pop();
			n=e3.n;
			sp=e3.sp;
			r_p=e3.r;
			b_p=e3.b;
			
			if(n==1)
			{
				if(sp!=b_p)
					System.out.println(sp+" "+b_p);
			}
			else if(n==2)
			{
				pos_4=select(sp,r_p);	
				if(sp!=r_p)
				{
					System.out.println(sp+" "+pos_4);
					System.out.println(sp+" "+r_p);
					if(pos_4!=b_p)
						System.out.println(pos_4+" "+b_p);
				}
				else
				{
					if(sp!=b_p)
						System.out.println(sp+" "+b_p);
				}
			}
			else
			{
				if(n%2==0)
				{
					pos_1=r_p;
					pos_3=b_p;
					if(sp!=pos_1)
					{
						pos=select(sp,r_p);
					}
					else
					{
						pos=pos_1;
					}
					pos_2=select(pos,b_p);		
				}
				else
				{
					pos_1=b_p;
					pos_3=r_p;
					if(sp!=pos_1)
					{
						pos=select(sp,b_p);
					}
					else
					{
						pos=pos_1;
					}
					pos_2=select(pos,r_p);
				}
				t=sp;
				if(sp!=pos_1)
				{
					sp=pos;
				}
				if(pos!=pos_3)
				{
					sp=pos_2;
				}
				element e2=new element();
				e2.n=n-2;
				e2.sp=sp;
				e2.r=r_p;
				e2.b=b_p;
				a.push(e2);
				
				sp=t;
				
				if(pos!=pos_3)
				{
					element e4=new element();
					e4.n=1;
					e4.sp=pos;
					e4.r=r_p;
					e4.b=pos_3;
					a.push(e4);
					
					element e5=new element();
					e5.n=n-2;
					e5.sp=pos;
					e5.r=pos_2;
					e5.b=pos_2;
					a.push(e5);	
				}
			
				if(sp!=pos_1)
				{
					element e6=new element();
					e6.n=1;
					e6.sp=sp;
					e6.r=r_p;
					e6.b=pos_1;
					a.push(e6);
					
					element e7=new element();
					e7.n=n-1;
					e7.sp=sp;
					e7.r=pos;
					e7.b=pos;
					a.push(e7);
				}
				
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

class element
{
	public int n;
	public int sp;
	public int r;
	public int b;
}
