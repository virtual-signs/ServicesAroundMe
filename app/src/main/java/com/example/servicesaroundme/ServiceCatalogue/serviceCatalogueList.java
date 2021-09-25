package com.example.servicesaroundme.ServiceCatalogue;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ExpandableListView;

import com.example.servicesaroundme.R;
import com.example.servicesaroundme.UtilityFunctions.eListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link serviceCatalogueList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class serviceCatalogueList extends Fragment {

    ExpandableListView elvServices;
    ArrayList<String> level1Services = new ArrayList<>();
    HashMap<String, ArrayList<String>> level2Services = new HashMap<>();
    eListViewAdapter elvAdapterServices;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public serviceCatalogueList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment serviceCatalogueList.
     */
    // TODO: Rename and change types and number of parameters
    public static serviceCatalogueList newInstance(String param1, String param2) {
        serviceCatalogueList fragment = new serviceCatalogueList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tmpView = inflater.inflate(R.layout.fragment_service_catalogue_list, container, false);
        elvServices = tmpView.findViewById(R.id.lstServiceCatalogue);

        // adding temp data - this will be loaded from firestore later
        for(int g=0; g<=10; g++){
            level1Services.add("Parent" + g);
            ArrayList<String> arrayList = new ArrayList<>();
            for(int c=0; c<=5; c++){
                arrayList.add("Child" + c);
            }
            level2Services.put(level1Services.get(g),arrayList);
        }
        elvAdapterServices = new eListViewAdapter(level1Services, level2Services);
        elvServices.setAdapter(elvAdapterServices);

        return tmpView;
    }
}