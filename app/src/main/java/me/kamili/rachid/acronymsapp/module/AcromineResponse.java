package me.kamili.rachid.acronymsapp.module;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AcromineResponse{

	@SerializedName("sf")
	private String sf;

	@SerializedName("lfs")
	private List<LongForm> lfs;

	public void setSf(String sf){
		this.sf = sf;
	}

	public String getSf(){
		return sf;
	}

	public void setLfs(List<LongForm> lfs){
		this.lfs = lfs;
	}

	public List<LongForm> getLfs(){
		return lfs;
	}

	@Override
 	public String toString(){
		return 
			"AcromineResponse{" + 
			"sf = '" + sf + '\'' + 
			",lfs = '" + lfs + '\'' + 
			"}";
		}
}