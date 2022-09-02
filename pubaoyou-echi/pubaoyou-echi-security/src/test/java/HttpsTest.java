import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpsTest {
    private static class TrustAnyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public static String sendHttps(String url) throws Exception {
        InputStream in = null;
        OutputStream out = null;
        String returnValue = "";
        try {
            SSLContext sc = SSLContext.getInstance("SSLV3");
            System.setProperty("https.protocols", "TLSv1.2");
//            SSLContext sc = SSLContext.getInstance("TLS", "SunJSSE");
//            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
            URL console = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
            conn.setSSLSocketFactory(sc.getSocketFactory());
//            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());  
            conn.setRequestMethod("POST");
            conn.connect();
            InputStream is = conn.getInputStream();
            DataInputStream indata = new DataInputStream(is);
            returnValue = indata.readLine();
            conn.disconnect();
        } catch (ConnectException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (Exception e) {  }
            try {
                out.close();
            } catch (Exception e) { }
        }
        return returnValue;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(sendHttps("https://172.16.149.14:32224"));
    }
}