package donorkan.trw.id.donorkan.service;


import donorkan.trw.id.donorkan.common.ApiUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.net.ssl.*;
import java.security.cert.CertificateException;

/**
 * Created by Kristiawan on 06/03/18.
 *
 * this is config retrofit for request API
 * please, do not change or editing this class
 */

public class ApiConfig {

    private Retrofit retrofit;

    private ApiConfig() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_API)
                .validateEagerly(true)
                .addConverterFactory(GsonConverterFactory.create())
                .client(setupOkHttpClient())
                .build();
    }

    private static class ApiConfigHolder {

        private static final ApiConfig INSTANCE = new ApiConfig();
    }

    public static ApiConfig getInstance() {
        return ApiConfigHolder.INSTANCE;
    }

    private OkHttpClient setupOkHttpClient() {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.connectTimeout(0, TimeUnit.SECONDS);
//        httpClient.readTimeout(0, TimeUnit.SECONDS);
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        httpClient.addInterceptor(logging);
//        return httpClient;

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T create(Class<T> T) {
        return retrofit.create(T);
    }
}
