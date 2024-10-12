package com.example.qcm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;
import java.util.List;

public class ResultFragment extends Fragment {

    private static final String ARG_SCORE = "score";
    private static final String ARG_TOTAL = "total";

    private int score;
    private int totalQuestions;

    // Méthode statique pour créer une instance du fragment avec des arguments
    public static ResultFragment newInstance(int score, int totalQuestions) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SCORE, score);
        args.putInt(ARG_TOTAL, totalQuestions);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Récupérer les arguments passés au fragment
        if (getArguments() != null) {
            score = getArguments().getInt(ARG_SCORE);
            totalQuestions = getArguments().getInt(ARG_TOTAL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate le layout pour ce fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        return view;
    }
}