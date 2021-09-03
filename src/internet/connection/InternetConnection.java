package internet.connection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import json.decoder.jsonDecoder;

public class InternetConnection {
	
	
	
	public String getOnlineData(String word) {
		String decodeData="";
		try {
			String data="";
			URL u=new URL("https://api.dictionaryapi.dev/api/v4/entries/en/"+word);
			HttpURLConnection hr=(HttpURLConnection)u.openConnection();
			
			if (hr.getResponseCode()==200) {
				InputStream im=hr.getInputStream();
				BufferedReader br=new BufferedReader(new InputStreamReader(im));
				String line=br.readLine();
				while(line!=null) {
					data=data+line;
					line=br.readLine();
				}
				br.close();
			//	System.out.println(data);
				jsonDecoder jd=new jsonDecoder();
				decodeData=jd.decodeData(data);
			
			}else {
				decodeData="error";
			}
		} catch (Exception e) {
			try {
				decodeData="error";
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return decodeData;
	}

}
