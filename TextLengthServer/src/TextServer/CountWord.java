package TextServer;

public class CountWord 
{
	public String Counter(String textReceive)
	{
		//split the sentence by word spacing and count
		int words = textReceive.split("\\s+|,\\s*|\\.\\s*").length;
		
		//convert integer result to string
		String result = Integer.toString(words);
		
		return result;
	}
}