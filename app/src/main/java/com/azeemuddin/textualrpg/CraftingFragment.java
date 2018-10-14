package com.azeemuddin.textualrpg;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class CraftingFragment extends Fragment {


    public CraftingFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crafting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
        componentListeners();
    }

    private void initComponents (View view){
        btnClose = (Button) view.findViewById(R.id.btnClose);
        imageBtnFirePlace = (ImageButton) view.findViewById(R.id.imageBtnFirePlace);
        imageBtnFishingRod = (ImageButton) view.findViewById(R.id.imageBtnFishingRod);
        imageBtnShelter = (ImageButton) view.findViewById(R.id.imageBtnShelter);
        imageBtnStoneAxe = (ImageButton) view.findViewById(R.id.imageBtnStoneAxe);
        imageBtnTorch = (ImageButton) view.findViewById(R.id.imageBtnTorch);
        imageBtnArrow = (ImageButton) view.findViewById(R.id.imageBtnArrow);
        imageBtnSpear = (ImageButton) view.findViewById(R.id.imageBtnSpear);
        imageBtnSnareTrap = (ImageButton) view.findViewById(R.id.imageBtnSnareTrap);
        imageBtnBait = (ImageButton) view.findViewById(R.id.imageBtnBait);
        imageBtnBow = (ImageButton) view.findViewById(R.id.imageBtnBow);
        imageBtnFishTrap = (ImageButton) view.findViewById(R.id.imageBtnFishTrap);
        imageBtnMedicine = (ImageButton) view.findViewById(R.id.imageBtnMedicine);
        imageBtnBandage = (ImageButton) view.findViewById(R.id.imageBtnBandage);
        imageBtnArrowQuiver = (ImageButton) view.findViewById(R.id.imageBtnArrowQuiver);
        imageBtnBaitPouch = (ImageButton) view.findViewById(R.id.imageBtnBaitPouch);
    }

    private void componentListeners(){
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
            }
        });

        imageBtnFirePlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftFirePlace();
                replaceFragment();
            }
        });

        imageBtnFishingRod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftFishingRod();
                replaceFragment();
            }
        });

        imageBtnShelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftShelter();
                replaceFragment();
            }
        });

        imageBtnStoneAxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftStoneAxe();
                replaceFragment();
            }
        });

        imageBtnTorch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftTorch();
                replaceFragment();
            }
        });

        imageBtnArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftArrow();
                replaceFragment();
            }
        });

        imageBtnSpear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftSpear();
                replaceFragment();
            }
        });

        imageBtnSnareTrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftSnareTrap();
                replaceFragment();
            }
        });

        imageBtnBait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftBait();
                replaceFragment();
            }
        });

        imageBtnBow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftBow();
                replaceFragment();
            }
        });

        imageBtnFishTrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftFishTrap();
                replaceFragment();
            }
        });

        imageBtnMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftMedicine();
                replaceFragment();
            }
        });

        imageBtnBandage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftBandage();
                replaceFragment();
            }
        });

        imageBtnArrowQuiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftArrowQuiver();
                replaceFragment();
            }
        });

        imageBtnBaitPouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crafting.craftBaitPouch();
                replaceFragment();
            }
        });
    }

    void replaceFragment()
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment hideFragment = (Fragment) getFragmentManager().findFragmentByTag("fragCrafting");
        fragmentTransaction.hide(hideFragment);
        fragmentTransaction.commit();
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment showFragment = (Fragment) getFragmentManager().findFragmentByTag("fragInventory");
        fragmentTransaction.show(showFragment);
        fragmentTransaction.commit();
    }

    Crafting crafting = new Crafting();

    Button btnClose;
    ImageButton imageBtnFirePlace;
    ImageButton imageBtnFishingRod;
    ImageButton imageBtnShelter;
    ImageButton imageBtnStoneAxe;
    ImageButton imageBtnTorch;
    ImageButton imageBtnArrow;
    ImageButton imageBtnSpear;
    ImageButton imageBtnSnareTrap;
    ImageButton imageBtnBait;
    ImageButton imageBtnBow;
    ImageButton imageBtnFishTrap;
    ImageButton imageBtnMedicine;
    ImageButton imageBtnBandage;
    ImageButton imageBtnArrowQuiver;
    ImageButton imageBtnBaitPouch;
}
