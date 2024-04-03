package pkgJICQ.client.data;
import pkgJICQ.client.frame.*;

import java.net.*;
import java.io.*;
import java.util.*;

class ListPersonTree extends Thread
{
	MyPersonTree mt;
	public ListPersonTree(MyPersonTree mt)
	{
		this.mt=mt;	
	} 
	public void run()
	{
		mt.listPersonTree();
	}
}