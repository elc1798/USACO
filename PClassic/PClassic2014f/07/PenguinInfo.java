import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class PenguinInfo {
	static final String FOOD = "FOOD";
	static final String WEIGHT = "WEIGHT";
	static final String HEIGHT = "HEIGHT";
	static final String MUSIC = "MUSIC";
	static final String POET = "POET";

	static String penguinInfo(List<Penguin> penguins, String sort){
		//TODO: Implement
		ArrayList<Penguin> pens = new ArrayList<Penguin>();
		ArrayList<String> names = new ArrayList<String>();
		if (sort.equals("FOOD")){
			String p;
			String n;
			String a;
			Penguin current = penguins.get(0);
			pens.add(current);
			names.add(current.getName());
			for (int i = 1; i < penguins.size(); i ++){
				current = penguins.get(i);
				a = current.getFavoriteFood();
				if (a.compareTo((pens.get(0)).getFavoriteFood()) <= 0){
					pens.add(0, current);
					names.add(0, current.getName());
				}
				else if (a.compareTo((pens.get(pens.size() - 1).getFavoriteFood())) >= 0){
					pens.add(current);
					names.add(current.getName());
				}
				else{
					for (int z = 0; z < pens.size() - 1; z++){
						p = (pens.get(z)).getFavoriteFood();
						n = (pens.get(z + 1).getFavoriteFood());
						if (a.compareTo(p) >= 0 && a.compareTo(n) <= 0){
							pens.add(z + 1, current);
							names.add(z+1, current.getName());
							z = pens.size();
						}
					}
				}
			}
		}
		else if (sort.equals("WEIGHT")){
			Double p;
			Double n;
			Double a;
			Penguin current = penguins.get(0);
			pens.add(current);
			names.add(current.getName());
			for (int i = 1; i < penguins.size(); i ++){
				current = penguins.get(i);
				a = current.getWeight();
				if (a.compareTo((pens.get(0)).getWeight()) <= 0){
					pens.add(0, current);
					names.add(0, current.getName());
				}
				else if (a.compareTo((pens.get(pens.size() - 1).getWeight())) >= 0){
					pens.add(current);
					names.add(current.getName());
				}
				else{
					for (int z = 0; z < pens.size() - 1; z++){
						p = (pens.get(z)).getWeight();
						n = (pens.get(z + 1).getWeight());
						if (a.compareTo(p) >= 0 && a.compareTo(n) <= 0){
							pens.add(z + 1, current);
							names.add(z+1, current.getName());
							z = pens.size();
						}
					}
				}
			}
		}
		else if (sort.equals("HEIGHT")){
			Double p;
			Double n;
			Double a;
			Penguin current = penguins.get(0);
			pens.add(current);
			names.add(current.getName());
			for (int i = 1; i < penguins.size(); i ++){
				current = penguins.get(i);
				a = current.getHeight();
				if (a.compareTo((pens.get(0)).getHeight()) <= 0){
					pens.add(0, current);
					names.add(0, current.getName());
				}
				else if (a.compareTo((pens.get(pens.size() - 1).getHeight())) >= 0){
					pens.add(current);
					names.add(current.getName());
				}
				else{
					for (int z = 0; z < pens.size() - 1; z++){
						p = (pens.get(z)).getHeight();
						n = (pens.get(z + 1).getHeight());
						if (a.compareTo(p) >= 0 && a.compareTo(n) <= 0){
							pens.add(z + 1, current);
							names.add(z+1, current.getName());
							z = pens.size();
						}
					}
				}
			}
		}
		else if (sort.equals("MUSIC")){
			String p;
			String n;
			String a;
			Penguin current = penguins.get(0);
			pens.add(current);
			names.add(current.getName());
			for (int i = 1; i < penguins.size(); i ++){
				current = penguins.get(i);
				a = current.getMusicalArtist();
				if (a.compareTo((pens.get(0)).getMusicalArtist()) <= 0){
					pens.add(0, current);
					names.add(0, current.getName());
				}
				else if (a.compareTo((pens.get(pens.size() - 1).getMusicalArtist())) >= 0){
					pens.add(current);
					names.add(current.getName());
				}
				else{
					for (int z = 0; z < pens.size() - 1; z++){
						p = (pens.get(z)).getMusicalArtist();
						n = (pens.get(z + 1).getMusicalArtist());
						if (a.compareTo(p) >= 0 && a.compareTo(n) <= 0){
							pens.add(z + 1, current);
							names.add(z+1, current.getName());
							z = pens.size();
						}
					}
				}
			}
		}
		else if (sort.equals("POET")){
			String p;
			String n;
			String a;
			Penguin current = penguins.get(0);
			pens.add(current);
			names.add(current.getName());
			for (int i = 1; i < penguins.size(); i ++){
				current = penguins.get(i);
				a = current.getPoet();
				if (a.compareTo((pens.get(0)).getPoet()) <= 0){
					pens.add(0, current);
					names.add(0, current.getName());
				}
				else if (a.compareTo((pens.get(pens.size() - 1).getPoet())) >= 0){
					pens.add(current);
					names.add(current.getName());
				}
				else{
					for (int z = 0; z < pens.size() - 1; z++){
						p = (pens.get(z)).getPoet();
						n = (pens.get(z + 1).getPoet());
						if (a.compareTo(p) >= 0 && a.compareTo(n) <= 0){
							pens.add(z + 1, current);
							names.add(z+1, current.getName());
							z = pens.size();
						}
					}
				}
			}
		}
		String answer = "";
		for (int i = 0; i < names.size() - 1; i++){
			answer += names.get(i) + " ";
		}
		answer += names.get(names.size() - 1);
		return answer;
	}

	//Class which represents Penguins
	static public class Penguin{
		final String name;
		final String favoriteFood;
		final double weight;
		final double height;
		final String musicalArtist;
		final String poet;		

		public Penguin(String name, String favoriteFood, double weight,
				double height, String musicalArtist, String poet){
			this.name = name;
			this.favoriteFood = favoriteFood;
			this.weight = weight;
			this.height = height;
			this.musicalArtist = musicalArtist;
			this.poet = poet;
		}

		public String getName() {
			return name;
		}

		public String getFavoriteFood() {
			return favoriteFood;
		}

		public double getWeight() {
			return weight;
		}

		public double getHeight() {
			return height;
		}

		public String getMusicalArtist() {
			return musicalArtist;
		}

		public String getPoet() {
			return poet;
		}

		public String toString() {
			return name;
		}

	}


	//main method for reading input for text files
	//--------------------------------------
	//Format for text files:
	//END OF PROBLEM
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("PenguinInfoIN.txt"));
		List<Penguin> penguins = new LinkedList<Penguin>();
		while(in.hasNext()){
			String next = in.nextLine();
			while(!next.equals("*****")){
				penguins.add(new Penguin(next,in.nextLine(),Double.parseDouble(in.nextLine()),Double.parseDouble(in.nextLine()),in.nextLine(),in.nextLine()));
				next = in.nextLine();
			}
			System.out.println(penguinInfo(penguins,in.next()));
			penguins.clear();
			if(in.hasNext()){
				in.nextLine();
			}
		}
	}
}
