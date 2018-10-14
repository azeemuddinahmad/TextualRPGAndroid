package com.azeemuddin.textualrpg;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListInventoryFragment extends ListFragment {

    ArrayList<String> inventoryArrayList = new ArrayList<>();
    Inventory inventory = new Inventory();
    Crafting craft = new Crafting();
    GameTimer gametimer = new GameTimer();
    String item;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment_inventory, container , false);
        inventoryArrayList.clear();
        for (int i = 0; i < 27; i++) {
            if (Inventory.intInventory[i] > 0) {
                inventoryArrayList.add(inventory.stringInventory[i]);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, inventoryArrayList);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initcomponents(view);
        componentListeners();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        item  = String.valueOf(getListAdapter().getItem(position));
        for (int i =0; i<27; i++)
        {
            if(item == inventory.stringInventory[i])
            {
                txtItemQuantity.setText(String.valueOf(Inventory.intInventory[i]));
            }
        }

        Toast.makeText(getActivity(),item, Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }

    void initcomponents(View view)
    {
        btnAllItems = view.findViewById(R.id.btnAllItems);
        btnEdibles = view.findViewById(R.id.btnEdibles);
        btnCrafted = view.findViewById(R.id.btnCrafted);
        btnUse = view.findViewById(R.id.btnUse);
        btnClose = view.findViewById(R.id.btnClose);
        txtItemQuantity = view.findViewById(R.id.txtItemQuantity);
    }

    void componentListeners()
    {
        btnAllItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryArrayList.clear();
                for (int i = 0; i < 27; i++) {
                    if (Inventory.intInventory[i] > 0) {
                        inventoryArrayList.add(inventory.stringInventory[i]);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, inventoryArrayList);
                        setListAdapter(adapter);
                    }
                }
            }
        });

        btnEdibles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryArrayList.clear();
                for (int i = 0; i < 5; i++) {
                    if (Inventory.intEdibles[i] > 0) {
                        inventoryArrayList.add(inventory.stringEdibles[i]);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, inventoryArrayList);
                        setListAdapter(adapter);
                    }
                }
            }
        });

        btnCrafted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryArrayList.clear();
                for (int i = 0; i < 15; i++) {
                    if (Crafting.intCraft[i] > 0) {
                        inventoryArrayList.add(craft.stringCraft[i]);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, inventoryArrayList);
                        setListAdapter(adapter);
                    }
                }
            }
        });

        btnUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 5; i++) {
                    if (item == inventory.stringEdibles[i]) {
                        if (item == inventory.stringEdibles[4])
                        {gametimer.setSickness(false);}
                        Inventory.intEdibles[i] -= 1;    //Edibles Array of Inventory Class
                        Inventory.energy += 20;           //hD = Hydration variable of Inventory class
                        Inventory.hydration += 20;           //eG = Energy variable of Inventory class
                        Inventory.bodyHeat -= 10;           //bH = BodyHeat variable of Inventory class
                        for (int j = 0; j < 24; j++) {
                            if (item == inventory.stringInventory[j]) {
                                Inventory.intInventory[j] -= 1; //inv array of inventory class
                            }
                        }
                    }
                }
                if(item == inventory.stringInventory[21])
                {
                    Inventory.intInventory[21] -= 1;
                    gametimer.setInjure(false);
                }
                else if (item == inventory.stringInventory[20])
                {
                    Inventory.intInventory[20] -= 1;
                    gametimer.setSickness(false);
                }
                inventory.displayHealthVariables();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                Fragment hideFragment = manager.findFragmentByTag("fragInventoryList");
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.detach(hideFragment);
                transaction.commit();
                Fragment showFragment = manager.findFragmentByTag("fragInventory");
                transaction = manager.beginTransaction();
                transaction.show(showFragment);
                transaction.commit();
            }
        });
    }

    Button btnAllItems, btnEdibles, btnCrafted, btnUse, btnClose;
    TextView txtItemQuantity;

}
