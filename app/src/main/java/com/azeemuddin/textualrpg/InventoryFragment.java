package com.azeemuddin.textualrpg;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class InventoryFragment extends Fragment {

    public InventoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_inventory, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initcomponents(view);
        componentListeners();
        inventory.displayHealthVariables();
        gametimer.start();
    }

    void initcomponents(View view){
        txtOutput = view.findViewById(R.id.txtOutput);
        txtHydration = view.findViewById(R.id.txtHydration);
        txtEnergy = view.findViewById(R.id.txtEnergy);
        txtBodyHeat = view.findViewById(R.id.txtBodyHeat);
        txtGameTime = view.findViewById(R.id.txtGameTime);
        txtTorchTime = view.findViewById(R.id.txtTorchTime);
        lblGameTime = view.findViewById(R.id.lblGameTime);
        lblTorchTime = view.findViewById(R.id.lblTorchTime);
        imageBtnStone = view.findViewById(R.id.imageBtnStone);
        imageBtnFire = view.findViewById(R.id.imageBtnFire);
        imageBtnSleep = view.findViewById(R.id.imageBtnSleep);
        imageBtnHunt = view.findViewById(R.id.imageBtnHunt);
        imageBtnInventory = view.findViewById(R.id.imageBtnInventory);
        imageBtnWood = view.findViewById(R.id.imageBtnWood);
        imageBtnFish = view.findViewById(R.id.imageBtnFishing);
        imageBtnCraft = view.findViewById(R.id.imageBtnCraft);
        imageBtnSticks = view.findViewById(R.id.imageBtnSticks);
        imageBtnTorch = view.findViewById(R.id.imageBtnTorch);
        imageBtnExplore = view.findViewById(R.id.imageBtnExplore);
        imageBtnWater = view.findViewById(R.id.imageBtnWater);
        btnClose = view.findViewById(R.id.btnClose);
        btnBack = view.findViewById(R.id.btnBack);
    }

    void componentListeners(){
        imageBtnSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventory.sleep();
            }
        });

        imageBtnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                DialogFragmentFire fragment = new DialogFragmentFire();
                fragment.show(manager, "fragFire");
            }
        });

        imageBtnStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventory.collectStones();
            }
        });

        imageBtnHunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventory.hunting();
            }
        });

        imageBtnInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                Fragment hideFragment = manager.findFragmentByTag("fragInventory");
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.hide(hideFragment);
                transaction.commit();
                Fragment showFragment = manager.findFragmentByTag("fragInventoryList");
                transaction = manager.beginTransaction();
                transaction.attach(showFragment);
                transaction.commit();
            }
        });

        imageBtnWood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventory.collectWood();
            }
        });

        imageBtnFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventory.fishing();
            }
        });

        imageBtnCraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                Fragment hideFragment = manager.findFragmentByTag("fragInventory");
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.hide(hideFragment);
                transaction.commit();
                Fragment showFragment = manager.findFragmentByTag("fragCrafting");
                transaction = manager.beginTransaction();
                transaction.show(showFragment);
                transaction.commit();

            }
        });

        imageBtnSticks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventory.collectSticks();
            }
        });

        imageBtnTorch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventory.useTorch();
            }
        });

        imageBtnExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventory.explore();
            }
        });

        imageBtnWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inventory.collectWater();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gametimer.handler.removeCallbacks(gametimer.runnable1);
                gametimer.handler.removeCallbacks(gametimer.runnable2);
                Intent intent = new Intent(getActivity(), MainMenu.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

    }

    Inventory inventory = new Inventory();
    GameTimer gametimer = new GameTimer();

    public static TextView txtOutput, txtHydration, txtEnergy, txtBodyHeat, lblGameTime, txtGameTime, lblTorchTime, txtTorchTime;
    ImageButton imageBtnSleep;
    ImageButton imageBtnFire;
    ImageButton imageBtnStone;
    ImageButton imageBtnHunt;
    ImageButton imageBtnInventory;
    ImageButton imageBtnWood;
    ImageButton imageBtnFish;
    ImageButton imageBtnCraft;
    ImageButton imageBtnSticks;
    ImageButton imageBtnTorch;
    ImageButton imageBtnExplore;
    ImageButton imageBtnWater;
    Button btnClose;
    Button btnBack;
}
