package connectionPoolTest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class config2 {

	public static void main(String[] args) throws ClientProtocolException, IOException, InterruptedException {
        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
        pool.setDefaultMaxPerRoute(1);
        pool.setMaxTotal(3);
        final HttpClientBuilder httpclient = HttpClients.custom().setConnectionManager(pool);
        //final CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(pool).build();

        final String url = "http://localhost:8080/";
        final String url1 = "http://localhost:8091/";
        
        for (int i = 0; i < 10; i++) {
        	 if(i > 5)
        		 new MyThread(url, httpclient).start();
        	 else
        		 new MyThread(url1, httpclient).start();
        }
        
        Thread.sleep(1000000);
    }

}

class MyThread extends Thread {

    private String url;
    private HttpClientBuilder httpclient;
    //private CloseableHttpClient httpclient;

    public MyThread(String url, HttpClientBuilder httpclient) {
        this.url = url;
        this.httpclient = httpclient;
    }

    @Override
    public void run() {
    	try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpclient.build().execute(httpGet);
            //CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);

            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
