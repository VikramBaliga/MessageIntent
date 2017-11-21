package projects.android.my.incomingsms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      if( (ContextCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED) &&
          (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED))
      {
          ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.RECEIVE_SMS,Manifest.permission.READ_SMS},100);
      }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0]==PackageManager.PERMISSION_GRANTED &&
           grantResults[1]==PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this,"Permission Granted",Toast.LENGTH_LONG).show();
        }
    }
}
