package ;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class ResponseDTO implements Serializable {

	@SerializedName("resultCount")
	private int resultCount;

	@SerializedName("results")
	private List<ResultsDTO> results;

	public void setResultCount(int resultCount){
		this.resultCount = resultCount;
	}

	public int getResultCount(){
		return resultCount;
	}

	public void setResults(List<ResultsDTO> results){
		this.results = results;
	}

	public List<ResultsDTO> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"resultCount = '" + resultCount + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}