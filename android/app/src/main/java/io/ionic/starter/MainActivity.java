package io.ionic.starter;
import android.os.Bundle;
import com.getcapacitor.BridgeActivity;
import com.getcapacitor.Plugin;
import java.util.ArrayList;
import android.content.IntentFilter;
import android.content.Intent;
import android.app.PendingIntent;
import android.widget.Toast;


public class MainActivity extends BridgeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Register the BootReceiver to receive BOOT_COMPLETED intent
        BootReceiver receiver = new BootReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BOOT_COMPLETED);
        getApplicationContext().registerReceiver(receiver, intentFilter);

        // Other code...
        Toast.makeText(this, "Welcome to My App!", Toast.LENGTH_SHORT).show();

        Intent intent = PendingIntent.getActivity(
            getApplicationContext().getBaseContext(),
            0,
            new Intent(getIntent()),
            getIntent().getFlags());
    }
}
















