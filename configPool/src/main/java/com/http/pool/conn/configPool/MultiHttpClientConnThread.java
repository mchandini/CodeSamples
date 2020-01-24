package com.http.pool.conn.configPool;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class MultiHttpClientConnThread extends Thread {
    private CloseableHttpClient client;
    private HttpGet get;
    public MultiHttpClientConnThread(CloseableHttpClient httpClient, HttpGet httpget) {
        this.client = httpClient;
        this.get = httpget;
 }
    // standard constructors
    public void run(){
        try {
            HttpResponse response = client.execute(get);
            System.out.println();
            HttpEntity entity = response.getEntity();
            System.out.println(response.getStatusLine());
            if (entity != null) {
               System.out.println("Response content length: " + entity.getContentLength());
            }
            Thread.sleep(1000);
            //System.out.println(EntityUtils.toString(entity));
            EntityUtils.consume(response.getEntity());
            //System.out.println("Done");
        } catch (ClientProtocolException ex) {    
        } catch (IOException ex) {
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}