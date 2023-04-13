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
    private static String accessToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVFNJR05FRENFUlQiLCJwaS5hdG0iOiI5cjdpIn0.eyJzY29wZSI6WyJjb252ZTpicmFrZV9zdGF0dXMiLCJjb252ZTpjbGltYXRpemF0aW9uX3N0YXJ0X3N0b3AiLCJjb252ZTpmdWVsX3N0YXR1cyIsImNvbnZlOmRvb3JzX3N0YXR1cyIsImNvbnZlOmVuZ2luZV9zdGFydF9zdG9wIiwiY29udmU6bG9jayIsIm9wZW5pZCIsImNvbnZlOmRpYWdub3N0aWNzX3dvcmtzaG9wIiwiY29udmU6dHJpcF9zdGF0aXN0aWNzIiwiY29udmU6ZW52aXJvbm1lbnQiLCJjb252ZTpvZG9tZXRlcl9zdGF0dXMiLCJjb252ZTpob25rX2ZsYXNoIiwiY29udmU6Y29tbWFuZF9hY2Nlc3NpYmlsaXR5IiwiY29udmU6ZW5naW5lX3N0YXR1cyIsImNvbnZlOnVubG9jayIsImNvbnZlOmNvbW1hbmRzIiwiY29udmU6bG9ja19zdGF0dXMiLCJjb252ZTp2ZWhpY2xlX3JlbGF0aW9uIiwiY29udmU6d2luZG93c19zdGF0dXMiLCJjb252ZTpuYXZpZ2F0aW9uIiwiY29udmU6dHlyZV9zdGF0dXMiLCJjb252ZTpjb25uZWN0aXZpdHlfc3RhdHVzIiwiY29udmU6ZGlhZ25vc3RpY3NfZW5naW5lX3N0YXR1cyIsImNvbnZlOndhcm5pbmdzIl0sImNsaWVudF9pZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZ3JudGlkIjoiZkhyZ0VQREpLSzF1eDlWRGtsOXczNkJKMjNUaVZwRzYiLCJpc3MiOiJodHRwczovL3ZvbHZvaWQuZXUudm9sdm9jYXJzLmNvbSIsImF1ZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZmlyc3ROYW1lIjoiRnJlZHJpayIsImxhc3ROYW1lIjoiQmp1csOpbiAiLCJzdWIiOiI5MTJhNjU1ZC1kOTE1LTQ4YzUtOTZjNS00MDdkMzJlNGNhMzEiLCJzY29wZXMiOlsiY29udmU6YnJha2Vfc3RhdHVzIiwiY29udmU6Y2xpbWF0aXphdGlvbl9zdGFydF9zdG9wIiwiY29udmU6ZnVlbF9zdGF0dXMiLCJjb252ZTpkb29yc19zdGF0dXMiLCJjb252ZTplbmdpbmVfc3RhcnRfc3RvcCIsImNvbnZlOmxvY2siLCJvcGVuaWQiLCJjb252ZTpkaWFnbm9zdGljc193b3Jrc2hvcCIsImNvbnZlOnRyaXBfc3RhdGlzdGljcyIsImNvbnZlOmVudmlyb25tZW50IiwiY29udmU6b2RvbWV0ZXJfc3RhdHVzIiwiY29udmU6aG9ua19mbGFzaCIsImNvbnZlOmNvbW1hbmRfYWNjZXNzaWJpbGl0eSIsImNvbnZlOmVuZ2luZV9zdGF0dXMiLCJjb252ZTp1bmxvY2siLCJjb252ZTpjb21tYW5kcyIsImNvbnZlOmxvY2tfc3RhdHVzIiwiY29udmU6dmVoaWNsZV9yZWxhdGlvbiIsImNvbnZlOndpbmRvd3Nfc3RhdHVzIiwiY29udmU6bmF2aWdhdGlvbiIsImNvbnZlOnR5cmVfc3RhdHVzIiwiY29udmU6Y29ubmVjdGl2aXR5X3N0YXR1cyIsImNvbnZlOmRpYWdub3N0aWNzX2VuZ2luZV9zdGF0dXMiLCJjb252ZTp3YXJuaW5ncyJdLCJlbWFpbCI6ImZianVyZW5AZ21haWwuY29tIiwiZXhwIjoxNjgxNDE2MjMxfQ.h3smP6703W5n91iW8iznL_tZaNruaYN7uUw2ixrEAlL_UzKZy9LEeJsvv3j0KwC3p56GJH6Kok1iDs9H6io43zdmwMqyVWouj0JJd3q4pa9OcVuwZ0xD1JaS63IhjSMf4WtHO89ysVnKuPjR_dyksrZnQ1_pfhpyyhHrfAgwDEXxIEBhRg9oP3m1syl59AiZWcrxC6wAl8LyXYtfopMTYCg0_k2DUYr0u1MX0eCM4mipX1-T6Q46BSxO-fFk9BnQV6FIGvARifmBjqc8fNSH7CasPhotezTQkzFEfoemn7UHLQ07HA6nb2ApiJLN3Xg1pd7pv5uhpBAAkpBtXCqLcA";
    private static HttpURLConnection conn;

    public static String createRequest(String endpoint, String... methodAndUnlockDuration) throws InterruptedException {
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
                    conn.setRequestProperty("content-type", "application/vnd.volvocars.api.connected-vehicle.lock.v1+json");

                    if (methodAndUnlockDuration[0].equals("Post"))
                        conn.setDoOutput(true);
                        conn.setRequestMethod("POST");
                    if (methodAndUnlockDuration.length == 2) {
                        if (methodAndUnlockDuration[1].equals(120)) {

                            String jsonInputString = "{'unlockDuration':120}";

                            try (OutputStream os = conn.getOutputStream()) {
                                byte[] input = jsonInputString.getBytes("utf-8");
                                os.write(input, 0, input.length);
                            } catch (Exception e) {
                                System.out.println("Fel45: " + e);
                            }

                        }
                    }

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
