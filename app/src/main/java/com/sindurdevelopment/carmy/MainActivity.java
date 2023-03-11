package com.sindurdevelopment.carmy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

    private static String accessToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkpXVFNJR05FRENFUlQiLCJwaS5hdG0iOiI5cjdpIn0.eyJzY29wZSI6WyJjb252ZTpicmFrZV9zdGF0dXMiLCJjb252ZTpmdWVsX3N0YXR1cyIsImNvbnZlOmRvb3JzX3N0YXR1cyIsIm9wZW5pZCIsInByb2ZpbGUiLCJjb252ZTpkaWFnbm9zdGljc193b3Jrc2hvcCIsImNvbnZlOnRyaXBfc3RhdGlzdGljcyIsImNvbnZlOmVudmlyb25tZW50IiwiY29udmU6b2RvbWV0ZXJfc3RhdHVzIiwiY29udmU6ZW5naW5lX3N0YXR1cyIsImNvbnZlOmxvY2tfc3RhdHVzIiwiY29udmU6dmVoaWNsZV9yZWxhdGlvbiIsImNvbnZlOndpbmRvd3Nfc3RhdHVzIiwiY29udmU6dHlyZV9zdGF0dXMiLCJjb252ZTpjb25uZWN0aXZpdHlfc3RhdHVzIiwiY29udmU6ZGlhZ25vc3RpY3NfZW5naW5lX3N0YXR1cyIsImNvbnZlOndhcm5pbmdzIl0sImNsaWVudF9pZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZ3JudGlkIjoiZEVRMGkzTkJSSDVwN25KdnJ4Vnk2emdWdUswUlREbDgiLCJpc3MiOiJodHRwczovL3ZvbHZvaWQuZXUudm9sdm9jYXJzLmNvbSIsImF1ZCI6ImRldmVsb3BlcnZjYXJzZG90Y29tIiwiZmlyc3ROYW1lIjoiRGV2ZWxvcGVyIiwibGFzdE5hbWUiOiJWb2x2byBDYXJzIiwic3ViIjoiZTNmNTNiZGItYmY1MC00ZTBhLWJlOTctZGI5MzZjMTBhM2I0Iiwic2NvcGVzIjpbImNvbnZlOmJyYWtlX3N0YXR1cyIsImNvbnZlOmZ1ZWxfc3RhdHVzIiwiY29udmU6ZG9vcnNfc3RhdHVzIiwib3BlbmlkIiwicHJvZmlsZSIsImNvbnZlOmRpYWdub3N0aWNzX3dvcmtzaG9wIiwiY29udmU6dHJpcF9zdGF0aXN0aWNzIiwiY29udmU6ZW52aXJvbm1lbnQiLCJjb252ZTpvZG9tZXRlcl9zdGF0dXMiLCJjb252ZTplbmdpbmVfc3RhdHVzIiwiY29udmU6bG9ja19zdGF0dXMiLCJjb252ZTp2ZWhpY2xlX3JlbGF0aW9uIiwiY29udmU6d2luZG93c19zdGF0dXMiLCJjb252ZTp0eXJlX3N0YXR1cyIsImNvbnZlOmNvbm5lY3Rpdml0eV9zdGF0dXMiLCJjb252ZTpkaWFnbm9zdGljc19lbmdpbmVfc3RhdHVzIiwiY29udmU6d2FybmluZ3MiXSwiZW1haWwiOiJkZXZlbG9wZXJ2b2x2b2NhcnNjb21AZ21haWwuY29tIiwiZXhwIjoxNjc4NTM0ODYyfQ.IZZX4A-AHpyK7koZE6LLsH3Hchqz7EgHA7hxoV_48wJvAEsQaH6bZgb992_T-yZEt-RcSMEV_mYsDZchenNBRn3A-0TCqMbxnLStvNUELHKnVjaz9U6qNvTku6qGfEqlcqMsWEJO7hn1g41JSPSxgi1KDqTbmvNM23Wn3k6E_DraoMkN2ELiQ3d5TDzzMQc-2L34AgWK6lzzMIfpYgh15vMVEf8KxHkrPazv35z8fmEfZQVfYFfOiZxnTrobC7Nbu5PqY2U-zrX1DOpXiak8ErmGEJkojs0VGpHyIBQPctd_Oj6wjkqyKkYPXa7h3dIBHsCuyWZiqrl8b-B6PoiuKw";

    private VehicleFunction vehicleFunction;

    public MainActivity() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Button vehicleList = (Button) findViewById(R.id.VehicleList);
        vehicleList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    vehicleFunction = new VehicleFunction(accessToken);
                } catch (Exception e) {
                    System.out.println("Fel30 (skapa vehicleList): " + e);
                }
            }
        });

        Button tempButton = (Button) findViewById(R.id.Temp);
        tempButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
//                    System.out.println(VehicleFunction.getTemprature(MainActivity.this.vehicleList.getVinNumbers().get(0),vccApiKey,accessToken));
                } catch (Exception e) {
                    System.out.println("Fel30 (skapa vehicleList): " + e);
                }
            }
        });
    }
}