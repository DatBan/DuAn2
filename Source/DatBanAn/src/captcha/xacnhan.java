package captcha;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

import captcha.keycaptchagg;

public class xacnhan {
	public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

	public static boolean verify(String gRecaptchaResponse) {
		if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
			return false;
		}

		try {
			URL verifyUrl = new URL(SITE_VERIFY_URL);

			// Má»Ÿ káº¿t ná»‘i (Connection) tá»›i URL trÃªn.
			HttpsURLConnection conn = (HttpsURLConnection) verifyUrl.openConnection();

			// ThÃªm cÃ¡c thÃ´ng tin Header vÃ o Request chuáº©n bá»‹ gá»­i tá»›i server.
			// Add Request Header
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");
			conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			// Dá»¯ liá»‡u sáº½ gá»­i tá»›i server.
			String postParams = "secret=" + keycaptchagg.SECRET_KEY + "&response=" + gRecaptchaResponse;

			// Send Request
			conn.setDoOutput(true);

			// Láº¥y luá»“ng Ä‘áº§u ra cá»§a káº¿t ná»‘i tá»›i server.
			// Ghi dá»¯ liá»‡u vÃ o luá»“ng nÃ y, cÃ³ nghÄ©a lÃ  gá»­i thÃ´ng tin Ä‘áº¿n Server.
			OutputStream outStream = conn.getOutputStream();
			outStream.write(postParams.getBytes());

			outStream.flush();
			outStream.close();

			// MÃ£ tráº£ lá»�i tráº£ vá»� tá»« Server.
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode=" + responseCode);

			// Láº¥y InputStream tá»« Connection Ä‘á»ƒ Ä‘á»�c dá»¯ liá»‡u gá»­i vá»� tá»« Server.
			InputStream is = conn.getInputStream();

			JsonReader jsonReader = Json.createReader(is);
			JsonObject jsonObject = jsonReader.readObject();
			jsonReader.close();

			// ==> {"success": true}
			System.out.println("Response: " + jsonObject);

			boolean success = jsonObject.getBoolean("success");
			return success;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
