package pe.edu.upc.rentalcarapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pe.edu.upc.bean.Car;
import pe.edu.upc.bean.parse.BrandObject;
import pe.edu.upc.bean.parse.CarObject;
import pe.edu.upc.bean.parse.ModelObject;
import pe.edu.upc.bean.parse.RoleObject;
import pe.edu.upc.bean.parse.UserObject;
import pe.edu.upc.rentalcarapp.R;

public class MainActivity extends AppCompatActivity {
    EditText userEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(UserObject.class);
        ParseObject.registerSubclass(RoleObject.class);
        ParseObject.registerSubclass(CarObject.class);
        ParseObject.registerSubclass(ModelObject.class);
        ParseObject.registerSubclass(BrandObject.class);
        Parse.initialize(this, getString(R.string.app_key), getString(R.string.client_key));

        userEditText = (EditText)findViewById(R.id.userEditText);
        passwordEditText = (EditText)findViewById(R.id.passEditText);

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(getBaseContext(), UserActivity.class));

                if (isEmpty(userEditText)) {
                    Toast.makeText(MainActivity.this, "Please enter a username!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (isEmpty(passwordEditText)) {
                    Toast.makeText(MainActivity.this, "Please enter a password!", Toast.LENGTH_LONG).show();
                    return;
                }

                List<UserObject> user = new ArrayList<UserObject>();

                final ProgressDialog dlg = new ProgressDialog(MainActivity.this);
                dlg.setTitle("Please wait.");
                dlg.setMessage("Logging in.  Please wait.");
                dlg.show();

                ParseQuery<UserObject> userQuery = new ParseQuery<UserObject>("User");
                userQuery.whereEqualTo("Email", userEditText.getText().toString());
                userQuery.whereEqualTo("Password", passwordEditText.getText().toString());
                userQuery.getFirstInBackground(new GetCallback<UserObject>() {
                    @Override
                    public void done(UserObject user, ParseException e) {
                        dlg.dismiss();
                        if (e != null) {
                            dlg.dismiss();
                            Toast.makeText(MainActivity.this, "The user name or password is incorrect", Toast.LENGTH_LONG).show();
                            Log.d("Error", e.getMessage());
                        }

                         user.getIdRole().fetchIfNeededInBackground(new GetCallback<RoleObject>() {
                             @Override
                             public void done(RoleObject role, ParseException e) {
                                 if (role.getName().equals("Client")) {
                                     startActivity(new Intent(MainActivity.this, UserActivity.class));
                                 } else if (role.getName().equals("Administrator")) {
                                     //startActivity(new Intent(getBaseContext(), .class));
                                 }

                             }
                         });

                    }
                });
            }
        });

        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SignInActivity.class));
            }
        });
    }

    private boolean isEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

}
