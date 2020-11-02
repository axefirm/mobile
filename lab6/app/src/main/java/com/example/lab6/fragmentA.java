package com.example.lab6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentA extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentA newInstance(String param1, String param2) {
        fragmentA fragment = new fragmentA();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String [] values =
                {"Багш","Оюутан"};
        String [] gender =
                {"-","Эрэгтэй","Эмэгтэй"};

        Spinner genderSpinner = (Spinner) getView().findViewById(R.id.gender);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, gender);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        genderSpinner.setAdapter(genderAdapter);

        Spinner spinner = (Spinner) getView().findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                Log.d("position", String.valueOf(position));
//                switch (position){
//                    case 0:
//
//                        break;
//                    case 1:
//                        break;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//                // your code here
//            }
//
//        });
        Button btn  = (Button) getView().findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner type = (Spinner) getView().findViewById(R.id.spinner1);
                if(type.getSelectedItem().toString().equals("Оюутан")){

                    oyutan fragment2 = new oyutan();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Bundle bundle = new Bundle();
                    EditText lastName = (EditText) getView().findViewById(R.id.lastName);
                    EditText firstName = (EditText) getView().findViewById(R.id.firstName);
                    Spinner gender = (Spinner) getView().findViewById(R.id.gender);

                    bundle.putString("lastName", lastName.getText().toString());
                    bundle.putString("firstName", firstName.getText().toString());
                    bundle.putString("gender", gender.getSelectedItem().toString());

                    fragment2.setArguments(bundle);
                    fragmentTransaction.replace(R.id.fragment_container, fragment2);
                    fragmentTransaction.commit();
                }else{

                    bagsh fragment2 = new bagsh();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Bundle bundle = new Bundle();
                    EditText lastName = (EditText) getView().findViewById(R.id.lastName);
                    EditText firstName = (EditText) getView().findViewById(R.id.firstName);
                    Spinner gender = (Spinner) getView().findViewById(R.id.gender);

                    bundle.putString("lastName", lastName.getText().toString());
                    bundle.putString("firstName", firstName.getText().toString());
                    bundle.putString("gender", gender.getSelectedItem().toString());

                    fragment2.setArguments(bundle);
                    fragmentTransaction.replace(R.id.fragment_container, fragment2);
                    fragmentTransaction.commit();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}