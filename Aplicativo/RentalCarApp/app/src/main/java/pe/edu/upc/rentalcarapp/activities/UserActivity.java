package pe.edu.upc.rentalcarapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.bean.Car;
import pe.edu.upc.bean.parse.BrandObject;
import pe.edu.upc.bean.parse.CarObject;
import pe.edu.upc.bean.parse.ModelObject;
import pe.edu.upc.rentalcarapp.R;
import pe.edu.upc.rentalcarapp.activities.UserActivity;
import pe.edu.upc.rentalcarapp.activities.CarActivity;
import pe.edu.upc.rentalcarapp.models.CarAdapter;

/**
 * Created by Aldo Pizarro on 03/12/2015.
 */
public class UserActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private ArrayList<Car> cars;
    private RecyclerView mCarsRecyclerView;
    private RecyclerView.Adapter mCarsAdapter;
    private RecyclerView.LayoutManager mCarsLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initializeCars();
        mCarsRecyclerView = (RecyclerView) findViewById(R.id.carsRecyclerView);
        mCarsRecyclerView.setHasFixedSize(true);
        mCarsLayoutManager = new LinearLayoutManager(this);
        mCarsRecyclerView.setLayoutManager(mCarsLayoutManager);
        mCarsAdapter = new CarAdapter(cars);
        mCarsRecyclerView.setAdapter(mCarsAdapter);

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
            startActivity(new Intent(getBaseContext(), SearchCarActivity.class));
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

    public void initializeCars() {
        cars = new ArrayList<Car>();
        ParseQuery<CarObject> carQuery = ParseQuery.getQuery("Car");
        try {
            List<CarObject> objects = carQuery.find();

            Car car = null;
            for (CarObject c : objects) {
                car = new Car();
                car.setDescription(c.getDescription());
                car.setObjectId(c.getObjectId());
                car.setPricePerHour(c.getPrice());
                car.setBrand(c.getIdBrand().getName());
                car.setModel(c.getIdModel().getName());
                cars.add(car);
            }

        }catch (Exception e1){

        }
    }
}
