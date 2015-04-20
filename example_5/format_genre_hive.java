package assignment_3;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.hive.ql.exec.Description;

public class format_genre_hive extends UDF {
	public Text evaluate(Text originalGenre) {
		Text newGenre = new Text("");
		if (originalGenre != null) {
			try {
				newGenre.set(formatGenre(originalGenre.toString()));
			}
			catch (Exception e) { // Should never happen
				newGenre = new Text(originalGenre);
			}
		}
		return newGenre;
	}
	public String formatGenre(String splittedInput){
		int inputLength = splittedInput.split("\\|").length;
		String[] splitGenre = splittedInput.split("\\|");
		int loopVariable =0;
		String newGenre = null;
		try{
			if(inputLength>2){
				while(loopVariable < inputLength-1){
					if(loopVariable > 0){
						newGenre = newGenre + ", " + splitGenre[loopVariable];
					}
					else{
						newGenre = splitGenre[loopVariable];
					}
					loopVariable++;			
				}
				newGenre = newGenre + ", and " + splitGenre[loopVariable];
			}
			else if(inputLength > 1){
				newGenre = splitGenre[loopVariable++] +", and "+ splitGenre[loopVariable++];
			}
			else{
				newGenre = splitGenre[loopVariable];
			}		
			return newGenre;
		}
		catch(Exception e){
		System.out.println("Found an exception ");
			return null;
		}
	}
}