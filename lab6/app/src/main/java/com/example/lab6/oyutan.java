package com.example.lab6;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link oyutan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class oyutan extends Fragment {

    public oyutan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment oyutan.
     */
    // TODO: Rename and change types and number of parameters
    public static oyutan newInstance(String param1, String param2) {
        oyutan fragment = new oyutan();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_oyutan, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String lastName = getArguments().getString("lastName");
        String firstName = getArguments().getString("firstName");
        String gender = getArguments().getString("gender");
        TextView hdnTxt = (TextView) Objects.requireNonNull(getView()).findViewById(R.id.hdnTxt);
        hdnTxt.setText("Овог: " + lastName + " Нэр: " + firstName + " Хүйс: " + gender);
    }
}