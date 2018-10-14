package com.azeemuddin.textualrpg;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class DialogFragmentFire extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_fire, null);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
        componentListeners();
    }

    void initComponents(View view)
    {
        imageBtnStartFire = view.findViewById(R.id.imageBtnStartFire);
        imageBtnCookFish = view.findViewById(R.id.imageBtnCookFish);
        imageBtnCookMeat = view.findViewById(R.id.imageBtnCookMeat);
        imageBtnBoilWater = view.findViewById(R.id.imageBtnBoilWater);
        imageBtnStokeFire = view.findViewById(R.id.imageBtnStokeFire);
        btnClose = view.findViewById(R.id.btnClose);
    }
    void componentListeners()
    {
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        imageBtnStartFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventory.startFire();
            }
        });

        imageBtnCookFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventory.cookFish();
            }
        });

        imageBtnCookMeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventory.cookMeat();
            }
        });

        imageBtnBoilWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventory.boilWater();
            }
        });

        imageBtnStokeFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    Inventory inventory = new Inventory();
    ImageButton imageBtnStartFire, imageBtnCookFish, imageBtnCookMeat, imageBtnBoilWater, imageBtnStokeFire;
    Button btnClose;
}
