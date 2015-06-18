package com.example.agata.mydeviceapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agata.mydeviceapplication.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnItemClickListener {

    Communicator communicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //String[] beamsGroups = {"HEB", "INP", "IPE", "HEM"};

        ArrayAdapter theAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.groups, android.R.layout.simple_list_item_1);
        ListView theGroupsView = (ListView) view.findViewById(R.id.theGroupsView);
        theGroupsView.setAdapter(theAdapter);
        theGroupsView.setOnItemClickListener(this);

        return view;

    }


    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communicator.respond(position);
    }


    public interface Communicator {
        public void respond(int index);
    }
}
