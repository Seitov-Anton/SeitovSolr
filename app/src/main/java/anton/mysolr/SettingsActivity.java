package anton.mysolr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String APP_PREFERENCES = "settings";
    public static final String APP_PREFERENCES_IP = "ip_address";
    public static final String APP_PREFERENCES_PORT = "port";
    public static final String APP_PREFERENCES_CORE_NAME = "coreName";
    private SharedPreferences settings;

    Button buttonOK;
    TextView ipAddressTextView, portTextView, coreNameTextView;
    EditText ipAddressEditText, portEditText, coreNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(this);
        ipAddressTextView = (TextView) findViewById(R.id.ipAddressTextView);
        ipAddressEditText = (EditText) findViewById(R.id.ipAddressEditText);
        portTextView = (TextView) findViewById(R.id.portTextView);
        portEditText = (EditText) findViewById(R.id.portEditText);
        coreNameTextView = (TextView) findViewById(R.id.coreNameTextView);
        coreNameEditText = (EditText) findViewById(R.id.coreNameEditText);
        settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (settings.contains(APP_PREFERENCES_IP))
            ipAddressEditText.setText(settings.getString(APP_PREFERENCES_IP,""));
        if (settings.contains(APP_PREFERENCES_CORE_NAME))
            coreNameEditText.setText(settings.getString(APP_PREFERENCES_CORE_NAME,""));
        if (settings.contains(APP_PREFERENCES_PORT))
            portEditText.setText(settings.getInt(APP_PREFERENCES_PORT,0));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(APP_PREFERENCES_IP,ipAddressEditText.toString());
        editor.putString(APP_PREFERENCES_CORE_NAME,coreNameEditText.toString());
        editor.putInt(APP_PREFERENCES_PORT,Integer.parseInt(portEditText.toString()));
        editor.apply();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonOK:
                startActivity (new Intent(this,SearchActivity.class));
                break;
        }
    }
}
