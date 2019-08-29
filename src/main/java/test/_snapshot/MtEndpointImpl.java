package test._snapshot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MtEndpointImpl{

	 @RequestMapping("/find")
	public String getDetail(String ml, String sp, String max) {
		 StringBuffer value = new StringBuffer();
		 try {
			HttpsURLConnection con = null;
			String str = "https://api.datamuse.com/words?ml="+ml+"&sp="+sp+"*&max=100";
			URL url = new URL(str);
			con = (HttpsURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String input;
			while((input = in.readLine()) != null) {
				value.append(input);
			}
			System.out.println(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
		 return value.toString();
	}

}
