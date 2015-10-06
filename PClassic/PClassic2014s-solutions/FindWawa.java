import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindWawa {
	
	//main method for reading input for text files
	//--------------------------------------
	//Format for text files:
	//[List of Stores;
	// each as 2 lines: name, yes or no for is Wawa]
	//*****
	//[List of Connections Between Wawas; 
	// each of them as 3 lines (wawa1, wawa2, distance)]
	//END OF PROBLEM
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("FindWawaIN.txt"));
		while(reader.ready()){
			String x = reader.readLine();
			Set<Store> stores = new HashSet<Store>();
			while(!x.equals("*****")){
				String nm = x.substring(0);
				x = reader.readLine();
				if(x.equals("yes")){
					stores.add(new Store(nm, true));
				}
				else if(x.equals("no")){
					stores.add(new Store(nm, false));
				}
				else{
					reader.close();
					throw new IllegalArgumentException(nm + 
							" is formatted wrong");
				}
				x = reader.readLine();
			}
			
			x = reader.readLine();
			
			while(!x.equals("END OF PROBLEM")){
				Store w1 = getStoreFromSet(stores, x);
				x = reader.readLine();
				Store w2 = getStoreFromSet(stores, x);
				
				x = reader.readLine();
				Integer i = Integer.decode(x);
				ConnectedStores c = new ConnectedStores(w1, w2, i);
				
				w1.connectedStores.add(c);
				w2.connectedStores.add(c);
				
				x = reader.readLine();
			}
			
			Store start = getStoreFromSet(stores, "start");			
			
			System.out.println(distanceToWawa(start, stores));
			
			x = reader.readLine();
			
		}

		reader.close();
	}

	static int distanceToWawa(Store start, Set<Store> stores){
		PriorityQueue<Store> q = new PriorityQueue<Store>();
		
		start.distanceFromStart = 0;
		
		for(Store s : stores){
			q.offer(s);
		}
		
		while(!q.isEmpty()){
			Store current = q.poll();
			
			if(current.isWawa){
				return current.distanceFromStart;
			}
			
			for(ConnectedStores c : current.connectedStores){
				Store other = c.getOther(current);
				if(other.distanceFromStart > current.distanceFromStart +
							c.distBetween){
					
					q.remove(other);
					other.distanceFromStart = current.distanceFromStart + 
							c.distBetween;
					q.offer(other);
					
				}
			}	
		}
		
		return -1;
	}
	
	//Class which represents Stores, which could be a Wawa
	static public class Store implements Comparable<Store>{
		final boolean isWawa;
		final String name;
		int distanceFromStart;
		HashSet<ConnectedStores> connectedStores;
		
		
		public Store(String name, boolean isWawa){
			this.name = name;
			this.isWawa = isWawa;
			connectedStores = new HashSet<ConnectedStores>();
			distanceFromStart = Integer.MAX_VALUE;
		}
		
		@Override
		public int compareTo(Store other){
			return this.distanceFromStart - other.distanceFromStart;
		}
		
	}
	
	//Method to pull a store with a given name out of a set of Wawa's
	static public Store getStoreFromSet(Set<Store> stores, String name){
		for(Store s : stores){
			if(s.name.equals(name)){
				return s;
			}
		}
		return null;
	}

	//Class which represents the connection between 2 wawas
	//Consists of three fields:
	//				- wawa1 : the first wawa
	//				- wawa2 : the second wawa
	//				- distance : the distance between them.	
	static public class ConnectedStores{

		final int distBetween;
		final Store store1;
		final Store store2;
		
		public ConnectedStores(Store s1, Store s2, int i){
			store1 = s1;
			store2 = s2;
			distBetween = i;
		}
		
		public boolean equals(ConnectedStores other){
			return (this.store1.equals(other.store1) &&
				    this.store2.equals(other.store2) ) ||
				   (this.store1.equals(other.store2) &&
				    this.store2.equals(other.store1) );
		}
		
		public Store getOther(Store w){
			if(!w.equals(store1) && !w.equals(store2)){
				throw new IllegalArgumentException();
			}
			else if(w.equals(store1)){
				return store2;
			}
			else{
				return store1;
			}
		}
		
	}
	

}
