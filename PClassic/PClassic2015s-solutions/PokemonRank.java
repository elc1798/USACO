import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class PokemonRank {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
							new FileReader("PokemonRankIN.txt"));

		while (br.ready()) {
			String[] data = br.readLine().split(" ");
			int numPokemon = Integer.parseInt(data[0]);
			int[] pokemon = new int[numPokemon];
			for (int i = 0; i < pokemon.length; i++) 
				pokemon[i] = Integer.parseInt(data[i+1]);
			int collectionSize = Integer.parseInt(data[data.length-1]);
			System.out.println(rank(pokemon, collectionSize));
		}
		br.close();
	}
	public static boolean rank(int[] pokemon, int collectionSize) {
		Arrays.sort(pokemon);
		for (int i = 0; i < pokemon.length; i++) {
			if (i + collectionSize == pokemon[i]) return true;
		}
		return false;
	}
}
