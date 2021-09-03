package json.decoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class jsonDecoder {
	public String deData="";
	public String decodeData(String data) {
		try {
			Object obj=JSONValue.parse(data);
			JSONArray ja=(JSONArray) obj;
			//System.out.println(ja.size());
			JSONObject jo=(JSONObject)ja.get(0);
			deData=deData+"Word:- "+jo.get("word");
			
			JSONObject jo1= (JSONObject) jo.get("meaning");	
			//System.out.println(jo1);
			JSONArray ja1=(JSONArray) jo1.get("noun");//if condition
			//System.out.println(ja1.size());
			JSONObject jo2=(JSONObject) ja1.get(0);
			deData=deData+"\n PartOfSpeech:- Noun";
			deData=deData+"\n Definition:-"+jo2.get("definition");
			deData=deData+"\n Example:- "+jo2.get("example");
			//System.out.println(jo2);
			JSONArray ja3=(JSONArray) jo2.get("synonyms");
			//System.out.println(ja3);
			if(ja3!=null) {
		     	deData=deData+"\n Synonyms:- ";
			    for (int i=0;i<ja3.size();i++) {
				    deData=deData+"\n \t "+ja3.get(i);
				
			    }
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return deData;
	}

}
