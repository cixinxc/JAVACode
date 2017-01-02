package com.cixin.DesignPatterns.Iterator;

public class Iterator{
	private Iter iter;
	private int length;
	private int l;
	
	public Iterator() {
		iter = new Iter();
		length = 0;
		l = 0;
	}
	
	public Object nexts() {
		if(iter.getNext()!=null)
			return iter.getNext();
		else 
			return null;
	}
	
	public void add(Iter iters) {
		if(length ==0 )
		{
			this.iter = new Iter(iters);
		}
		else
		{
			Iter it = this.iter;
			for(;it.getNext()!=null;it = it.getNext())
			{
				;	
			}
			
			it.setNext(iters);
		}
		this.length ++;
	}
	public Object next() {
		System.out.println("l  :"+l);
	//	System.out.println("l µÄÖµ "+l);
		Iter it = new Iter();
		Iter it0 = this.iter;
		
		for(int i = 0;i<this.l;i++) {
		//	System.out.println(""+l+"  "+this.iter.getNext().getO());
		//	it0.setO(this.iter.getNext().getO());
			it0 = it0.getNext();
		}
		l++;
	//	System.out.println("l is "+ l);

		return it0.getO();
	}

	public Iter getIter() {
		return iter;
	}

	public void setIter(Iter iter) {
		this.iter = iter;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}
	
	
}
