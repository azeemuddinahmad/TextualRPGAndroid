package com.azeemuddin.textualrpg;


import android.os.Handler;

public class GameTimer {

    private static boolean light, dark, sickness, injure, fire;
    private static int secondsPassed = 0, hoursPassed = 4, firePlaceTimer, torchTimer;

   Handler handler = new Handler();
   Runnable runnable1 = new Runnable() {
       @Override
       public void run() {
           secondsPassed++;
           if(Inventory.fire==true)
           {firePlaceTimer--;}                    // FirePlace Timer
           if(Inventory.torch==true)
           {torchTimer--;}
           if (secondsPassed%5==0)
           {
               if (injure == false && sickness == false)
               {
                   Inventory.hydration--;         // Hydration variable of Inventory class
                   Inventory.energy--;            // Energy variable of Inventory class
                   Inventory.bodyHeat-=2;         // BodyHeat variable of Inventory class
               }
               else if (injure ==true)
               {
                   Inventory.hydration-=2;         // Hydration variable of Inventory class
                   Inventory.energy-=2;            // Energy variable of Inventory class
                   Inventory.bodyHeat-=4;          // BodyHeat variable of Inventory class
               }
               else if (sickness ==true)
               {
                   Inventory.hydration-=2;         // Hydration variable of Inventory class
                   Inventory.energy-=2;            // Energy variable of Inventory class
                   Inventory.bodyHeat+=4;          // BodyHeat variable of Inventory class
               }
               else if (sickness==true && injure ==true)
               {
                   //UIManager.put("OptionPane.okButtonText", "Close");
                   //JOptionPane.showMessageDialog(null, "You died of Wounds and Sickness ");
                   System.exit(0);
               }
           }
           if (light==true)
           {
               InventoryFragment.lblGameTime.setText("Time Until dark:" );
           }
           else if (dark==true)
           {
               InventoryFragment.lblGameTime.setText("Time Until light:" );
           }
           handler.postDelayed(runnable1,1000);
       }
   };

   Runnable runnable2 = new Runnable() {
       @Override
       public void run() {
           InventoryFragment.txtHydration.setText(String.valueOf(Inventory.hydration));
           InventoryFragment.txtEnergy.setText(String.valueOf(Inventory.energy));
           InventoryFragment.txtBodyHeat.setText(String.valueOf(Inventory.bodyHeat));
           InventoryFragment.txtGameTime.setText(String.valueOf(hoursPassed) + " Hours");
           InventoryFragment.txtTorchTime.setText(String.valueOf(torchTimer));
           if (fire==true)
           {
               //FireGUI.lblFireTimer.setText(String.valueOf(fpTimer));
           }

           if (Inventory.energy <=0)
           {
               InventoryFragment.txtEnergy.setText(String.valueOf(0));
               //UIManager.put("OptionPane.okButtonText", "Close");
               //JOptionPane.showMessageDialog(null, "You died of Hunger");
               System.exit(0);
           }
           if (Inventory.hydration <=0)
           {
               InventoryFragment.txtHydration.setText(String.valueOf(0));
               //UIManager.put("OptionPane.okButtonText", "Close");
               //JOptionPane.showMessageDialog(null, "You died of Thirst");
               System.exit(0);
           }
           if (Inventory.bodyHeat<=0)
           {
               InventoryFragment.txtBodyHeat.setText(String.valueOf(0));
               //UIManager.put("OptionPane.okButtonText", "Close");
               //JOptionPane.showMessageDialog(null, "You died of Hypothermia");
               System.exit(0);
           }
           if (Inventory.bodyHeat>=60)
           {
               InventoryFragment.txtBodyHeat.setText(String.valueOf(60));
               //UIManager.put("OptionPane.okButtonText", "Close");
               //JOptionPane.showMessageDialog(null, "You died of Fever");
               System.exit(0);
           }

           if (hoursPassed<=0 && light==true)
           {
               hoursPassed=12+hoursPassed;
               light=false; dark=true;
               InventoryFragment.lblGameTime.setText("Time Until light:" );
           }
           if (hoursPassed<=0 && dark==true)
           {
               hoursPassed=12+hoursPassed;
               light=true; dark=false;
               InventoryFragment.lblGameTime.setText("Time Until dark:" );
           }
           if (secondsPassed/60==1)
           {
               hoursPassed--;
               secondsPassed=secondsPassed-60;
           }
           if(firePlaceTimer<=0)
           {
               Inventory.fire=false;
           }
           if(torchTimer<=0)
           {
               Inventory.torch=false;
           }
           handler.postDelayed(runnable2,1);
       }
   };


    public void start()
    {
        light = true;
        handler.postDelayed(runnable1,1000);
        handler.postDelayed(runnable2,1);
    }

    public  boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        GameTimer.light = light;
    }

    public  boolean isDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        GameTimer.dark = dark;
    }

    public boolean isSickness() {
        return sickness;
    }

    public void setSickness(boolean sickness) {
        GameTimer.sickness = sickness;
    }

    public boolean isInjure() {
        return injure;
    }

    public  void setInjure(boolean injure) {
        GameTimer.injure = injure;
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

    public void setSecondsPassed(int secondsPassed) {
        GameTimer.secondsPassed = secondsPassed;
    }

    public int getHoursPassed() {
        return hoursPassed;
    }

    public void setHoursPassed(int hoursPassed) {
        GameTimer.hoursPassed = hoursPassed;
    }

    public  int getFirePlaceTimer() {
        return firePlaceTimer;
    }

    public void setFirePlaceTimer(int firePlaceTimer) {
        GameTimer.firePlaceTimer = firePlaceTimer;
    }

    public  int getTorchTimer() {
        return torchTimer;
    }

    public void setTorchTimer(int torchTimer) {
        GameTimer.torchTimer = torchTimer;
    }
}
