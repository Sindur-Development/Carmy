package com.sindurdevelopment.carmy.httprequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {

    private static final String urlBase = "https://api.volvocars.com/connected-vehicle/v1/vehicles/";
    private static final String vccApiKey = "607a267caccf4cdda65179f588772043";
    private static String accessToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVFNJR05FRENFUlQiLCJwaS5hdG0iOiI5cjdpIn0.eyJzY29wZSI6WyJjb252ZTpicmFrZV9zdGF0dXMiLCJjb252ZTpmdWVsX3N0YXR1cyIsImNvbnZlOmRvb3JzX3N0YXR1cyIsIm9wZW5pZCIsInByb2ZpbGUiLCJjb252ZTpkaWFnbm9zdGljc193b3Jrc2hvcCIsImNvbnZlOnRyaXBfc3RhdGlzdGljcyIsImNvbnZlOmVudmlyb25tZW50IiwiY29udmU6b2RvbWV0ZXJfc3RhdHVzIiwiY29udmU6ZW5naW5lX3N0YXR1cyIsImNvbnZlOmxvY2tfc3RhdHVzIiwiY29udmU6dmVoaWNsZV9yZWxhdGlvbiIsImNvbnZlOndpbmRvd3Nfc3RhdHVzIiwiY29udmU6dHlyZV9zdGF0dXMiLCJjb252ZTpjb25uZWN0aXZpdHlfc3RhdHVzIiwiY29udmU6ZGlhZ25vc3RpY3NfZW5naW5lX3N0YXR1cyIsImNvbnZlOndhcm5pbmdzIl0sImNsaWVudF9pZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZ3JudGlkIjoiZEVRMGkzTkJSSDVwN25KdnJ4Vnk2emdWdUswUlREbDgiLCJpc3MiOiJodHRwczovL3ZvbHZvaWQuZXUudm9sdm9jYXJzLmNvbSIsImF1ZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZmlyc3ROYW1lIjoiRGV2ZWxvcGVyIiwibGFzdE5hbWUiOiJWb2x2byBDYXJzIiwic3ViIjoiZTNmNTNiZGItYmY1MC00ZTBhLWJlOTctZGI5MzZjMTBhM2I0Iiwic2NvcGVzIjpbImNvbnZlOmJyYWtlX3N0YXR1cyIsImNvbnZlOmZ1ZWxfc3RhdHVzIiwiY29udmU6ZG9vcnNfc3RhdHVzIiwib3BlbmlkIiwicHJvZmlsZSIsImNvbnZlOmRpYWdub3N0aWNzX3dvcmtzaG9wIiwiY29udmU6dHJpcF9zdGF0aXN0aWNzIiwiY29udmU6ZW52aXJvbm1lbnQiLCJjb252ZTpvZG9tZXRlcl9zdGF0dXMiLCJjb252ZTplbmdpbmVfc3RhdHVzIiwiY29udmU6bG9ja19zdGF0dXMiLCJjb252ZTp2ZWhpY2xlX3JlbGF0aW9uIiwiY29udmU6d2luZG93c19zdGF0dXMiLCJjb252ZTp0eXJlX3N0YXR1cyIsImNvbnZlOmNvbm5lY3Rpdml0eV9zdGF0dXMiLCJjb252ZTpkaWFnbm9zdGljc19lbmdpbmVfc3RhdHVzIiwiY29udmU6d2FybmluZ3MiXSwiZW1haWwiOiJkZXZlbG9wZXJ2b2x2b2NhcnNjb21AZ21haWwuY29tIiwiZXhwIjoxNjgxMzc1NDExfQ.Jn0GYi8oz14CxQKFX8mQ_9SVI6ndIsxJqTeRB4XGQnkWOQZbZJ49foFJCiaWKEFTrC43hcF4ecY-FXlRnQshb62fal5W5IQtVSjYuYiGYT8gazXNnr5MVw61woU3hl_izkU8mjLXnYmXtUjbkAi5cY4LxlKaj7IcabuJdpfQk9Xvhz7azy1sIHG6_mkpA8mq728AS64YawSe_GBo8NexN5oltQhBHyQYYfj_H44G-t2zzAjDCCn4QxYVTfncT2-XZQWjJjksNMmFpyl7LsD2fpPTRRJPbyewnc_Guq27vmxRfWvTv7xWrT4v6BDkZiayI-ATFcCkuVmKt6yz3agZaw";
    private static HttpURLConnection conn;

    public static String createRequest(String endpoint, String...methodAndUnlockDuration) throws InterruptedException {
        String[] line = {null}; //ta bort senare
        final String[] httpStringResponse = {""};
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    URL finalUrl = new URL(urlBase + endpoint);
                    conn = (HttpURLConnection) finalUrl.openConnection();
                    conn.setRequestProperty("vcc-api-key", vccApiKey);
                    conn.setRequestProperty("authorization", "Bearer " + accessToken);
                    if (methodAndUnlockDuration[0].equals("Post")) conn.setRequestMethod("Post");
                    if (Integer.parseInt(methodAndUnlockDuration[1]) > 0) {
                        conn.setDoOutput(true);
                        String jsonInputString = "{'unlockDuration':" + Integer.parseInt(methodAndUnlockDuration[1]) + "}";

                        try (OutputStream os = conn.getOutputStream()) {
                            byte[] input = jsonInputString.getBytes("utf-8");
                            os.write(input, 0, input.length);
                        }
                    }

//                conn.setRequestProperty("Accept", "application/json");


                } catch (Exception e) {
                    System.out.println("Fel37: " + e);
                }
                try {
                    final BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getResponseCode() == 200 ? conn.getInputStream() : conn.getErrorStream()));
                    conn.disconnect();
                    while ((line[0] = reader.readLine()) != null) {
                        httpStringResponse[0] += line[0];
                    }
                    reader.close();
                } catch (Exception e) {
                    System.out.println("Fel54: " + e);
                }

                System.out.println("Working: " + httpStringResponse[0]);

            }
        });
        thread.start();
        thread.join();

        return httpStringResponse[0];
    }


}
