package me.kamili.rachid.acronymsapp.module;

import com.google.gson.annotations.SerializedName;

public class Variation {

	@SerializedName("freq")
	private int freq;

	@SerializedName("lf")
	private String longform;

	@SerializedName("since")
	private int since;

	public void setFreq(int freq){
		this.freq = freq;
	}

	public int getFreq(){
		return freq;
	}

	public void setLongform(String lf){
		this.longform = lf;
	}

	public String getLongform(){
		return longform;
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
			"Variation{" +
			"freq = '" + freq + '\'' + 
			",longform = '" + longform + '\'' +
			",since = '" + since + '\'' + 
			"}";
		}
}