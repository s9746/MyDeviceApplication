package com.example.agata.mydeviceapplication.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agata.mydeviceapplication.R;
import com.example.agata.mydeviceapplication.fragment.GroupFragment;
import com.example.agata.mydeviceapplication.fragment.MainActivityFragment;


public class MainActivity extends Activity implements MainActivityFragment.Communicator {

    MainActivityFragment f1;
    GroupFragment f2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        f1 = (MainActivityFragment) manager.findFragmentById(R.id.fragment); //ten zawsze sie pojawia czy vertical czy horizontal
        f1.setCommunicator(this); //this to obiekt main activity, a w MainActivityFragment jest przypisane do communicator (interfejs)
        // aby moglo byc potem wywolywane w metodzie respond

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public void respond(int index) {
        f2 = (GroupFragment) manager.findFragmentById(R.id.fragment2);
        if (f2 != null && f2.isVisible()) { //oznacza to, ze jest orientacja pozioma
            f2.changeData(index);
        } else { //gdy nie jest widoczny GroupFragment
            Intent intent = new Intent(this, GroupActivity.class);
            intent.putExtra("index", index);
            startActivity(intent); //laczy z GroupActivity
        }
    }
}
