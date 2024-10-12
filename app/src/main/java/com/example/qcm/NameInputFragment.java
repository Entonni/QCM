package com.example.qcm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NameInputFragment extends Fragment {

    private OnNameSubmittedListener callback;

    // Interface pour communiquer avec l'activité
    public interface OnNameSubmittedListener {
        void onNameSubmitted(String userName);
    }

    // Vérification si l'activité implémente l'interface lors de l'attachement du fragment
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNameSubmittedListener) {
            callback = (OnNameSubmittedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnNameSubmittedListener");
        }
    }

    // Création de la vue du fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflation du layout du fragment
        View view = inflater.inflate(R.layout.fragment_name_input, container, false);

        // Récupération des composants du layout
        EditText editTextName = view.findViewById(R.id.editTextName);
        Button buttonSubmit = view.findViewById(R.id.buttonStartQuiz);

        // Logique pour soumettre le nom lorsqu'on clique sur le bouton
        buttonSubmit.setOnClickListener(v -> {
            String userName = editTextName.getText().toString();
            if (!userName.isEmpty()) {
                // Appel de l'interface pour envoyer le nom à l'activité
                callback.onNameSubmitted(userName);
            } else {
                editTextName.setError("Le nom ne peut pas être vide");
            }
        });

        return view;
    }

    // Nettoyage du callback lors du détachement du fragment
    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }
}