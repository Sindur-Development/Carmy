package com.sindurdevelopment.carmy.httprequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    private static final String urlBase = "https://api.volvocars.com/connected-vehicle/v1/vehicles/";
    private static final String vccApiKey = "607a267caccf4cdda65179f588772043";
    private static String accessToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVFNJR05FRENFUlQiLCJwaS5hdG0iOiI5cjdpIn0.eyJzY29wZSI6WyJjb252ZTpicmFrZV9zdGF0dXMiLCJjb252ZTpjbGltYXRpemF0aW9uX3N0YXJ0X3N0b3AiLCJjb252ZTpmdWVsX3N0YXR1cyIsImNvbnZlOmRvb3JzX3N0YXR1cyIsImNvbnZlOmVuZ2luZV9zdGFydF9zdG9wIiwiY29udmU6bG9jayIsIm9wZW5pZCIsImNvbnZlOmRpYWdub3N0aWNzX3dvcmtzaG9wIiwiY29udmU6dHJpcF9zdGF0aXN0aWNzIiwiY29udmU6ZW52aXJvbm1lbnQiLCJjb252ZTpvZG9tZXRlcl9zdGF0dXMiLCJjb252ZTpob25rX2ZsYXNoIiwiY29udmU6Y29tbWFuZF9hY2Nlc3NpYmlsaXR5IiwiY29udmU6ZW5naW5lX3N0YXR1cyIsImNvbnZlOnVubG9jayIsImNvbnZlOmNvbW1hbmRzIiwiY29udmU6bG9ja19zdGF0dXMiLCJjb252ZTp2ZWhpY2xlX3JlbGF0aW9uIiwiY29udmU6d2luZG93c19zdGF0dXMiLCJjb252ZTpuYXZpZ2F0aW9uIiwiY29udmU6dHlyZV9zdGF0dXMiLCJjb252ZTpjb25uZWN0aXZpdHlfc3RhdHVzIiwiY29udmU6ZGlhZ25vc3RpY3NfZW5naW5lX3N0YXR1cyIsImNvbnZlOndhcm5pbmdzIl0sImNsaWVudF9pZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZ3JudGlkIjoiaVRjMlJ3alkxQmM1SllFb2wwRmswN1Y2VThSSUY1NG0iLCJpc3MiOiJodHRwczovL3ZvbHZvaWQuZXUudm9sdm9jYXJzLmNvbSIsImF1ZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZmlyc3ROYW1lIjoiRnJlZHJpayIsImxhc3ROYW1lIjoiQmp1csOpbiAiLCJzdWIiOiI5MTJhNjU1ZC1kOTE1LTQ4YzUtOTZjNS00MDdkMzJlNGNhMzEiLCJzY29wZXMiOlsiY29udmU6YnJha2Vfc3RhdHVzIiwiY29udmU6Y2xpbWF0aXphdGlvbl9zdGFydF9zdG9wIiwiY29udmU6ZnVlbF9zdGF0dXMiLCJjb252ZTpkb29yc19zdGF0dXMiLCJjb252ZTplbmdpbmVfc3RhcnRfc3RvcCIsImNvbnZlOmxvY2siLCJvcGVuaWQiLCJjb252ZTpkaWFnbm9zdGljc193b3Jrc2hvcCIsImNvbnZlOnRyaXBfc3RhdGlzdGljcyIsImNvbnZlOmVudmlyb25tZW50IiwiY29udmU6b2RvbWV0ZXJfc3RhdHVzIiwiY29udmU6aG9ua19mbGFzaCIsImNvbnZlOmNvbW1hbmRfYWNjZXNzaWJpbGl0eSIsImNvbnZlOmVuZ2luZV9zdGF0dXMiLCJjb252ZTp1bmxvY2siLCJjb252ZTpjb21tYW5kcyIsImNvbnZlOmxvY2tfc3RhdHVzIiwiY29udmU6dmVoaWNsZV9yZWxhdGlvbiIsImNvbnZlOndpbmRvd3Nfc3RhdHVzIiwiY29udmU6bmF2aWdhdGlvbiIsImNvbnZlOnR5cmVfc3RhdHVzIiwiY29udmU6Y29ubmVjdGl2aXR5X3N0YXR1cyIsImNvbnZlOmRpYWdub3N0aWNzX2VuZ2luZV9zdGF0dXMiLCJjb252ZTp3YXJuaW5ncyJdLCJlbWFpbCI6ImZianVyZW5AZ21haWwuY29tIiwiZXhwIjoxNjgxNDg3MzE5fQ.WT0tW7BKj9AIS8F5WFhAJR-xEY3m-C8QYQlLHedvU-GpZJ-w3ZXvRzVRrgQND_r7nt4SYtILfVMrWS-VHzFbyFDc1ZQFhvkRnP-yRDE3IfLCJsegFoCeGn7-_BpGArhOVMhRNmPqNkpaR4L5o81iq4H8YfU-x8o7-o-e98Z9IQpHyQ7wha6bqe85sqWKuTo47NK7Jd1vHvWLs8gUkeXcKg_tKs2NLjBJ6oNY6JRQYOmjAl32P6pmzFWGi9t-VPxHcQzJo0mjC8RgAubiFGIGmnebQ3uwpdjbY7XuE1ZqIdPTnHzkR-HJNyLeMJMDE6RicMyfzxLiEo42RNRSwiReZw";
    private static HttpURLConnection conn;

    public static String createGetRequest(String endpoint, String...acceptDetails) throws InterruptedException {
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
//                    conn.setRequestProperty("content-type", "application/vnd.volvocars.api.connected-vehicle.vehicledata.v1+json");
                    conn.setRequestProperty("accept", "application/vnd.volvocars.api.connected-vehicle."+(acceptDetails.length>0?acceptDetails[0]:"vehicledata")+".v1+json");

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

    public static String createHttpPost(String endpoint, String body) throws InterruptedException {
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
                    conn.setRequestProperty("content-type", "application/vnd.volvocars.api.connected-vehicle."+endpoint.split("/")[2]+".v1+json");
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);

                    try (OutputStream os = conn.getOutputStream()) {
                        byte[] input = body.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    } catch (Exception e) {
                        System.out.println("Fel45: " + e);
                    }
                    System.out.println(conn.getResponseCode());
                    System.out.println(conn.getResponseMessage());

                } catch (Exception e) {
                    System.out.println("Fel37: " + e);
                }


                try {
                    final BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getResponseCode() == 202 ? conn.getInputStream() : conn.getErrorStream()));
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



