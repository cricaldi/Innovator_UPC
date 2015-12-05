package pe.edu.upc.rentalcarapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.rentalcarapp.R;

/**
 * Created by Aldo Pizarro on 03/12/2015.
 */
public class CarActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView descriptionTextView;
    TextView pricePerHourTextView;
    TextView brandTextView;
    TextView modelTextView;


    //TextView nameTextView;
    //ImageView pictureImageView;
    Button backButton;
    //TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        try {
            Bundle bundle = getIntent().getExtras();
            descriptionTextView = (TextView)findViewById(R.id.descriptionTextView);
            pricePerHourTextView = (TextView)findViewById(R.id.pricePerHourTextView);
            brandTextView = (TextView)findViewById(R.id.brandTextView);
            modelTextView = (TextView)findViewById(R.id.modelTextView);

            descriptionTextView.setText(bundle.getString("description"));
            pricePerHourTextView.setText(bundle.getString("priceperhour"));
            brandTextView.setText(bundle.getString("brand"));
            modelTextView.setText(bundle.getString("model"));

            //pictureImageView.setImageResource(Integer.parseInt(bundle.getString("pictureUrlCar")));
            backButton = (Button) findViewById(R.id.backButton);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            finish();
            startActivity(new Intent(getBaseContext(), UserActivity.class));
        } else if (id == R.id.nav_search) {

        } else if (id == R.id.nav_rents) {

        } /*else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } */else if (id == R.id.nav_logoff) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}