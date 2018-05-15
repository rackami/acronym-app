package me.kamili.rachid.acronymsapp.module;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LongForm {

	@SerializedName("freq")
	private int freq;

	@SerializedName("lf")
	private String longform;

	@SerializedName("vars")
	private List<Variation> variations;

	@SerializedName("since")
	private int since;

	public void setFreq(int freq){
		this.freq = freq;
	}

	public int getFreq(){
		return freq;
	}

	public void setLongform(String longform){
		this.longform = longform;
	}

	public String getLongform(){
		return longform;
	}

	public void setVariations(List<Variation> vars){
		this.variations = vars;
	}

	public List<Variation> getVariations(){
		return variations;
	}

	public void setSince(int since){
		this.since = since;
	}

	public int getSince(){
		return since;
	}

	@Override
 	public String toString(){
		return 
			"LongForm{" +
			"freq = '" + freq + '\'' + 
			",longform = '" + longform + '\'' +
			",variations = '" + variations + '\'' +
			",since = '" + since + '\'' + 
			"}";
		}
}