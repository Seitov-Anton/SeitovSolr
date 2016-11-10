package anton.mysolr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

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
