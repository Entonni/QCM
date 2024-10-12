package com.example.qcm;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class QuestionFragment extends Fragment {
    private String question;
    private List<String> options;
    private int indiceReponse;

    // Clés pour les arguments du fragment
    private static final String ARG_QUESTION = "question";
    private static final String ARG_OPTIONS = "options";
    private static final String ARG_INDICE_REPONSE = "indiceReponse";

    // Constructeur par défaut obligatoire
    public QuestionFragment() {
        // Required empty public constructor
    }

    // Méthode statique pour créer une instance du fragment avec les arguments
    public static QuestionFragment newInstance(String question, List<String> options, int indiceReponse) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, question);
        args.putStringArrayList(ARG_OPTIONS, new ArrayList<>(options)); // Liste convertie en ArrayList
        args.putInt(ARG_INDICE_REPONSE, indiceReponse);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Vérifie et récupère les arguments passés au fragment
        if (getArguments() != null) {
            question = getArguments().getString(ARG_QUESTION);
            options = getArguments().getStringArrayList(ARG_OPTIONS);
            indiceReponse = getArguments().getInt(ARG_INDICE_REPONSE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    // Méthode pour récupérer la question
    public String getQuestion() {
        return question;
    }

    // Méthode pour récupérer les options
    public List<String> getOptions() {
        return options;
    }

    // Méthode pour récupérer l'indice de la réponse correcte
    public int getIndiceReponse() {
        return indiceReponse;
    }
}
