package jt.db;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class GetRedditAccessToken {

	public static void main(String[] args) {

		String username = "";
		String password = "";
		String appId = "";
		String appSecret = "";
		String url = "";

		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(appId, appSecret));
		HttpClient httpclient = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).build();
		HttpPost httppost = new HttpPost(url);

		List<NameValuePair> params = new ArrayList<NameValuePair>(3);
		params.add(new BasicNameValuePair("grant_type", "password"));
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("password", password));

		try {

			httppost.setEntity(new UrlEncodedFormEntity(params));
			httppost.setHeader("User-Agent", "/u/ user v1.0");
			HttpResponse response;

			try {

				response = httpclient.execute(httppost);
				String responseString = null;

				try {

					responseString = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
					System.out.print(responseString);

				}

				catch (IOException e1) {

					e1.printStackTrace();

				}
			}

			catch (ClientProtocolException e) {

				e.printStackTrace();

			}

			catch (IOException e) {

				e.printStackTrace();

			}
		}

		catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}
	}
}