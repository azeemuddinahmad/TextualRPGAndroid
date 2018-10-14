package com.azeemuddin.textualrpg;



import java.util.Random;

public class Inventory {

    public static int[] intInventory = new int[28];
    String[] stringInventory = new String[] {"Wood","Sticks","Stones","Salt Water","Berries","Braid","Fish","Meat","Leather","Fire Place","Stone Axe","Shelter","Spear","Bow","Arrow","Fishing Rod","Bait","Fire Torch","Snare Trap","Fish Trap","Medicine","Bandage","Arrow Quiver","Bait Pouch","Boiled Water","Cooked Meat","Cooked Fish"};
    static boolean[] boolCraft = new boolean[15];
    static boolean water,shelter,fire,light,dark,torch,sickness,injure;
    static int energy,bodyHeat,hydration,extraVariable;
    Random random = new Random();
    public static int[] intEdibles = new int[5];
    String[] stringEdibles = new String[] {"Boiled Water","Berries","Cooked Fish","Cooked Meat","Medicine"};
    GameTimer gametimer = new GameTimer();

    public void _gameStart(){                                        // initializes all array and add necessory items for new game to start
        energy=0; bodyHeat=0; hydration=0;
        extraVariable = random.nextInt(25)+75;
        energy=extraVariable;
        extraVariable = random.nextInt(10)+20;
        bodyHeat=extraVariable;
        extraVariable = random.nextInt(15)+60;
        hydration=extraVariable;
        for (int j=0 ; j < 28 ; j++)
        {
            intInventory[j]=0;                                       // initializes all the inventory int array items to zero
        }
        for (int j=0;j<10;j++)
        {
            boolCraft[j]=false;                                      // initializes all the crafting boolean array items to false
        }
        intInventory[17]=1;                                          // inv[17] = Fire Torch
        intInventory[21]=1;                                          // inv[21] = Bandage
        intInventory[4]=+3;                                          // inv[4] = Berries
        intEdibles[1]+=3;                                               // intEdibles[1] = Berries in intEdibles array
        intInventory[24]+=1;                                         // inv[24] = Boiled water
        intEdibles[0]=+1;                                               // intEdibles[0] = boiled water in intEdibles array
        intInventory[20]+=1;                                         // inv[20] = medicine
        intEdibles[4]+=1;
    }

    public void health(){
        sickness = gametimer.isSickness();                           //getting sickness boolean attribute from Gametimer class
        injure = gametimer.isInjure();                               //getting injure boolean attribute from Gametimer class
        if(sickness == false && injure == false) {
            energy-=5;
            bodyHeat+=4;
            hydration-=5;
        }
        else if (sickness==true) {
            energy-=20;
            bodyHeat+=15;
            hydration-=20;
        }
        else if (injure == true) {
            energy-=20;
            bodyHeat-=15;
            hydration-=20;
        }
        else {
            // have to write end game message
            System.exit(0);                     //if both are true then it will be an instant death and end game
        }
    }

    public void explore(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            extraVariable = random.nextInt(5)+1;                 //ex = extra variable to create random number
            if (extraVariable==3)
            {
                if (water==false)
                {
                    water = true;
                  //  GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Water.png"));
                    InventoryFragment.txtOutput.setText("<html>I have found water now i can get some to drink and catch some fishes</html>");
                    extraVariable=gametimer.getSecondsPassed(); extraVariable+=45;       //using extra variable to set time of game
                    gametimer.setSecondsPassed(extraVariable);
                }
                else
                {
                    if (intInventory[5]<5)
                    {
                        intInventory[5]+=1;                          //inv[5] = Braid integer array
                       // GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Braid.png"));
                        InventoryFragment.txtOutput.setText(stringInventory[5]+" Collected +1 "+"\n" );
                    }
                    else
                    {
                       // GameGUI.lblText.setIcon(null);
                        InventoryFragment.txtOutput.setText("<html>I am not here to kinap someone i need to survive ... <br> I already have enough braid in my inventory</html>" );
                    }
                }
            }
            else
            {
                if (extraVariable==5)
                {
                    if (intInventory[5]<5)
                    {
                        intInventory[5]+=3;                          //inv[5] = Braid interger array
                        extraVariable = intInventory[5]-5;
                        if(extraVariable<0)                        //this contion the the amount of attribute and make
                        {extraVariable=3;}                         //sure to maintain it in the given limit which is 5
                        else
                        {extraVariable = 3 - extraVariable;}
                        if(intInventory [5]>5)
                        {intInventory[5]=5;}
                      //  GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Braid.png"));
                        InventoryFragment.txtOutput.setText(stringInventory[5] + " Collected +" + extraVariable);
                    }
                    else
                    {
                      //  GameGUI.lblText.setIcon(null);
                        InventoryFragment.txtOutput.setText("<html>I am not here to kinap someone i need to survive ... <br> I already have enough braid in my inventory</html>" );
                    }
                }
                else if (extraVariable==4)
                {
                    if (intInventory [4]<5)
                    {
                        intInventory[4]+=2;   intEdibles[1]+=2;                     //inv[4] = intEdibles[1] = berries of ediles and inventory array
                        extraVariable = intInventory[4] - 5;
                        if(extraVariable<0)                                    //this condition checks the amount of attribute and make
                        {extraVariable=2;}                                     //sure to maintain it in the given limit which is 5
                        else
                        {extraVariable = 2 - extraVariable;}
                        if(intInventory [4]>5)
                        {intInventory[4]=5;}
                       // GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Berries.png"));
                        InventoryFragment.txtOutput.setText(stringInventory[4]+" Collected +" + extraVariable );
                    }
                    else
                    {
                      //  GameGUI.lblText.setIcon(null);
                        InventoryFragment.txtOutput.setText("<html>I am not here to collect berries to sell them ... <br> I need them for surviving and so far i have enough of them</html>" );
                    }
                }
                else if (extraVariable==1)
                {
                    if (intInventory[1] <5)
                    {
                        intInventory[1]+=1;                          //inv[1] = sticks
                      //  GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Sticks.jpg"));
                        InventoryFragment.txtOutput.setText(stringInventory[1]+" Collected +1 "+"\n" );
                    }
                    else
                    {
                      //  GameGUI.lblText.setIcon(null);
                        InventoryFragment.txtOutput.setText("<html> Sticks won't help me with surviving ..... <br> i have enough sticks for crafting </html>");
                    }
                }
                else if (extraVariable==2)
                {
                    if (intInventory[2]<5)
                    {
                        intInventory[2]+=1;                          //inv[2] = stones
                       // GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Stone.png"));
                        InventoryFragment.txtOutput.setText(stringInventory[2]+"Collected +1 "+"\n" );
                    }
                    else
                    {
                       // GameGUI.lblText.setIcon(null);
                        InventoryFragment.txtOutput.setText("<html>It's not that i can eat stones ...... <br> i have enough to built a lot of things</html>");
                    }
                }
                health();
                extraVariable=gametimer.getHoursPassed(); extraVariable-=1;          //Gets the hour attribute of Gametimer class, deduct
                gametimer.setHoursPassed(extraVariable);                             //one from it and then sets the new value
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=60;         //Gets the FireTimer attribute of Gametimer class,
                    gametimer.setFirePlaceTimer(extraVariable);                             //deduct sixty from it and then sets the new value
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=60;          //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                              //deduct sixty from it and then sets the new value
                }

            }
        }
        else
        {
          //  GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void collectWood(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[0] < 5)
            {
                if(intInventory[10]==1)                      //inv[10] = Stone Axe  if stone axe is true only then this statement will execute
                {
                    intInventory[0]+=4;                              //inv[0] = Wood with stone axe
                    extraVariable = intInventory[0]-5;
                    if(extraVariable<0)                                //this condition checks the amount of attribute and make
                    {extraVariable=4;}                                 //sure to maintain it in the given limit which is 5
                    else
                    {extraVariable = 4 - extraVariable;}
                    if (intInventory[0]>5)
                    {
                        intInventory[0]=5;
                    }
                    health();                               //calling health method from above
                    //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Wood.jpg"));
                    InventoryFragment.txtOutput.setText(stringInventory[0] + " Collected +" + extraVariable );
                    extraVariable=gametimer.getSecondsPassed(); extraVariable+=30;       //Gets the seconds attribute of Gametimer class,
                    gametimer.setSecondsPassed(extraVariable);                //deduct thirty from it and then sets the new value
                    if (fire ==true)
                    {
                        extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=30;         //Gets the FireTimer attribute of Gametimer class,
                        gametimer.setFirePlaceTimer(extraVariable);                  //deduct thirty from it and then sets the new value
                    }
                    if(torch==true)
                    {
                        extraVariable=gametimer.getTorchTimer(); extraVariable-=30;          //Gets the TorchTimer attribute of Gametimer class,
                        gametimer.setTorchTimer(extraVariable);                   //deduct thirty from it and then sets the new value
                    }
                }
                else
                {
                    intInventory[0]+=2;                              //inv[0] = Wood without stone axe
                    extraVariable = intInventory[0] -5;
                    if(extraVariable<0)                                //this condition checks the amount of attribute and make
                    {extraVariable=2;}                                 //sure to maintain it in the given limit which is 5
                    else
                    {extraVariable = 2 - extraVariable;}
                    if (intInventory[0]>5)
                    {
                        intInventory[0]=5;
                    }
                    health();
                    //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Wood.jpg"));
                    InventoryFragment.txtOutput.setText(stringInventory[0] + " Collected +"  + extraVariable );
                    extraVariable=gametimer.getSecondsPassed(); extraVariable+=30;       //Gets the seconds attribute of Gametimer class,
                    gametimer.setSecondsPassed(extraVariable);                //deduct thirty from it and then sets the new value
                    if (fire ==true)
                    {
                        extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=30;         //Gets the FireTimer attribute of Gametimer class,
                        gametimer.setFirePlaceTimer(extraVariable);                  //deduct thirty from it and then sets the new value
                    }
                    if(torch==true)
                    {
                        extraVariable=gametimer.getTorchTimer(); extraVariable-=30;          //Gets the TorchTimer attribute of Gametimer class,
                        gametimer.setTorchTimer(extraVariable);                   //deduct thirty from it and then sets the new value
                    }
                }
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>I am not a carpenter there is already enough wood in our inventory</html>");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
        displayHealthVariables();
    }

    public void collectSticks(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[1] < 5)
            {
                intInventory[1]+=3;                                  //inv[1] = sticks
                extraVariable = intInventory[1] - 5;
                if(extraVariable<0)                                    //this condition checks the amount of attribute and make
                {extraVariable=3;}                                     //sure to maintain it in the given limit which is 5
                else
                {extraVariable = 3 - extraVariable;}
                if (intInventory[1]>5)
                {
                    intInventory[1]=5;
                }
                health();
               // GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Sticks.jpg"));
                InventoryFragment.txtOutput.setText(stringInventory[1] + " Collected +" + extraVariable);
                extraVariable=gametimer.getSecondsPassed(); extraVariable+=30;           //Gets the seconds attribute of Gametimer class,
                gametimer.setSecondsPassed(extraVariable);                    //deduct thirty from it and then sets the new value
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=30;         //Gets the FireTimer attribute of Gametimer class,
                    gametimer.setFirePlaceTimer(extraVariable);                  //deduct thirty from it and then sets the new value
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=30;          //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                   //deduct thirty from it and then sets the new value
                }
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html> Sticks won't help me with surviving ..... <br> i have enough sticks for crafting </html>");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void collectStones(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[2] < 5)
            {
                intInventory[2]+=3;                                  //inv[2] = stones
                extraVariable = intInventory[2] - 5;
                if(extraVariable<0)                                    //this contion the the amount of attribute and make
                {extraVariable=3;}                                     //sure to maintain it in the given limit which is 5
                else
                {extraVariable = 3 - extraVariable;}
                if (intInventory[2]>5)
                {
                    intInventory[2]=5;
                }
                health();
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Stone.png"));
                InventoryFragment.txtOutput.setText(stringInventory[2] + " Collected +" + extraVariable );
                extraVariable=gametimer.getSecondsPassed(); extraVariable+=30;           //Gets the seconds attribute of Gametimer class,
                gametimer.setSecondsPassed(extraVariable);                    //deduct thirty from it and then sets the new value
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=30;         //Gets the FireTimer attribute of Gametimer class,
                    gametimer.setFirePlaceTimer(extraVariable);                  //deduct thirty from it and then sets the new value
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=30;          //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                   //deduct thirty from it and then sets the new value
                }
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>It's not that i can eat stones ...... <br> i have enough to built a lot of things</html>");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void collectWater(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if(water == true)
            {
                intInventory[3]+=1;                                  //inv[3] = water
                health();
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\SaltWater.png"));
                InventoryFragment.txtOutput.setText("<html>Salt Water Collected +1 <br> I need to boil this water to make it hygenic </html>");
                extraVariable=gametimer.getSecondsPassed(); extraVariable+=15;           //Gets the seconds attribute of Gametimer class,
                gametimer.setSecondsPassed(extraVariable);                    //deduct fifteen from it and then sets the new value
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=15;             //Gets the FireTimer attribute of Gametimer class,
                    gametimer.setFirePlaceTimer(extraVariable);                      //deduct fifteen from it and then sets the new value
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=15;              //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                       //deduct fifteen from it and then sets the new value
                }
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>I need to find water in order to collect it</html>");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void sleep(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if(shelter == false)
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("I might get sick as i am sleeping in the open\n");
                extraVariable=random.nextInt(5);
                if (extraVariable==4 || extraVariable==3)
                {
                    //GameGUI.lblText.setIcon(null);
                    InventoryFragment.txtOutput.setText("<html>I have caught cold now i need to find medecine <br>Energy,Hydration and Body Heat altered for <br>getting sick</html>");
                    energy-=20;                                 //eG = Energy attribute
                    hydration-=30;                                 //hD = Hydration attribute
                    bodyHeat+=20;                                 //bH = BodyHeat attribute
                    health();                               //calling health method from above
                    gametimer.setSickness(true);                   //setting boolean sickness attribute from GameTimer class
                }
                extraVariable=gametimer.getHoursPassed(); extraVariable-=3;          //Gets the hour attribute of Gametimer class,
                gametimer.setHoursPassed(extraVariable);                  //deduct three from it and sets the new value
                fire=false;
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=180;         //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                   //deduct one eighty from it and then sets the new value
                }
            }
            else
            {
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Shelter.png"));
                InventoryFragment.txtOutput.setText("<html>Ah i can sleep peacefully in shelter <br>Energy,Hydration and Body Heat altered</html>");
                energy+=30;                                     //eG = Energy attribute
                hydration-=10;                                     //hD = Hydration attribute
                bodyHeat-=10;                                     //bH = BodyHeat attribute
                health();                                   //calling health method from above
                extraVariable=gametimer.getHoursPassed(); extraVariable-=3;              //Gets the hour attribute of Gametimer class,
                gametimer.setHoursPassed(extraVariable);                      //deduct three from it and sets the new value
                fire=false;
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=180;             //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                       //deduct one eighty from it and then sets the new value
                }
            }
        }
        else
        {
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void fishing(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if(water == true && (boolCraft[4]==true||boolCraft[7]==true))
            {
                intInventory[6]+=1;                                  //inv[6] = fish
                health();                                   //calling health method from above
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Fish.png"));
                InventoryFragment.txtOutput.setText("Fish Collected +1");
                extraVariable=gametimer.getHoursPassed(); extraVariable-=1;              //Gets the hour attribute of Gametimer class,
                gametimer.setHoursPassed(extraVariable);                      //deduct one from it and sets the new value
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=60;             //Gets the FireTimer attribute of Gametimer class,
                    gametimer.setFirePlaceTimer(extraVariable);                      //deduct sixty from it and then sets the new value
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=60;              //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                       //deduct sixty from it and then sets the new value
                }

            }
            else if (water == false)
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("I need to find water in order to fish");
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Fishing Rod or Trap Required");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void hunting(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if(boolCraft[2]==true || boolCraft[6]==true || (boolCraft[3]==true&& intInventory[14]>=1))
            {
                extraVariable = random.nextInt(3)+1;                     // generating randon number in order to get
                if (extraVariable==1)                                  // the injure percentage for the game and also
                {                                           // set it if its true
                    gametimer.setInjure(true);
                    //GameGUI.lblText.setIcon(null);
                    InventoryFragment.txtOutput.setText("<html>Aah i am injured now <br>Would be good if i can bandage it </html>");
                }
                else
                {
                    intInventory[7]+=1;                              // inv[7] = meat
                    intInventory[8]+=1;                                  // inv[8] = leather
                    boolCraft[2]=false; boolCraft[6]=false;           //bCraft[2] = spear and bcraft[6] = snaretrap
                    health();                                   //calling health method from above
                    //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Meat.png"));
                    InventoryFragment.txtOutput.setText("<html>Meat Collected +1 <br> <br> <br>Leather Collected +1 </html>");
                }
                extraVariable=gametimer.getHoursPassed(); extraVariable-=1;              //Gets the hour attribute of Gametimer class,
                gametimer.setHoursPassed(extraVariable);                      //deduct one from it and sets the new value
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=60;             //Gets the FireTimer attribute of Gametimer class,
                    gametimer.setFirePlaceTimer(extraVariable);                      //deduct sixty from it and then sets the new value
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=60;              //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                       //deduct sixty from it and then sets the new value
                }
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Spear or Bow and Arrows or Trap Required");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void startFire(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[9]>0 && intInventory[1]>1)                       //inv[9] = fireplace and inv[1] = sticks
            {
                intInventory[1]-=2;                                  //inv[1] = sticks
                fire = true;
                InventoryFragment.txtOutput.setText("Fire Started");
                extraVariable=gametimer.getSecondsPassed(); extraVariable+=15;           //Gets the seconds attribute of Gametimer class,
                gametimer.setSecondsPassed(extraVariable);                    //deduct fifteen from it and then sets the new value
                gametimer.setFirePlaceTimer(120);                         // sets the TorchTimer of GameTimer class to 120
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=15;              //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                       //deduct fifteen from it and then sets the new value
                }
            }
            else if (intInventory[9]>0 && intInventory[1]<2)
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Need sticks in order to start fire");
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Need a fire place in order to start fire");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void boilWater(){
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if ( fire==true && intInventory[3]>0)                    //inv[3] = salt water
            {
                intInventory[3]-=1;                                  //inv[3] = salt water
                intInventory[24]+=1;                                 //inv[24] = boiled water for inventory array
                intEdibles[0]=+1;                              //intEdibles[0] = boiled water for intEdibles array
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\BoiledWater.png"));
                InventoryFragment.txtOutput.setText("<html>Water Boiled <br>Now i can drink this water </html>");
                extraVariable=gametimer.getSecondsPassed(); extraVariable+=15;           //Gets the seconds attribute of Gametimer class,
                gametimer.setSecondsPassed(extraVariable);                    //deduct fifteen from it and then sets the new value
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=15;              //Gets the FireTimer attribute of Gametimer class,
                    gametimer.setFirePlaceTimer(extraVariable);                       //deduct fifteen from it and then sets the new value
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=15;               //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                        //deduct fifteen from it and then sets the new value
                }
            }
            else if (fire==true && intInventory[3]<=0)
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Need water to boil on this fire");
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Need a fire in order to boil this water");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void cookMeat() {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if (fire==true && intInventory[7]>0)                     //inv[7] = raw meat
            {
                intInventory[7]-=1;                                  //inv[7] = raw meat
                intInventory[25]+=1; intEdibles[3]+=1;                  //inv[25] = intEdibles[3] = cooked meat of ediibles and inventory array
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\CookedMeat.png"));
                InventoryFragment.txtOutput.setText("<html>Meat Cooked <br>Now i can eat it and get my energy back </html>");
                extraVariable=gametimer.getSecondsPassed(); extraVariable+=30;           //Gets the seconds attribute of Gametimer class,
                gametimer.setSecondsPassed(extraVariable);                    //deduct thirty from it and then sets the new value
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=30;             //Gets the FireTimer attribute of Gametimer class,
                    gametimer.setFirePlaceTimer(extraVariable);                      //deduct thirty from it and then sets the new value
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=30;              //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                       //deduct thirty from it and then sets the new value
                }
            }
            else if (fire==true && intInventory[7]<=0)               //inv[7] = raw meat
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Need Meat to cook on this fire");
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Need a fire in order to cook this meat");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void cookFish()
    {
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(light == true || (dark==true && torch==true ))
        {
            if (fire==true && intInventory[6]>0)                     //inv[6] = raw fish
            {
                intInventory[6]-=1;                                  //inv[6] = raw fish
                intInventory[26]+=1; intEdibles[2]+=1;                  //inv[26] = intEdibles[2] = cooked fish of ediibles and inventory array
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\CookedFish.png"));
                InventoryFragment.txtOutput.setText("<html>Fish Cooked <br>Now i can eat it and get my energy back </html>");
                extraVariable=gametimer.getSecondsPassed(); extraVariable+=30;           //Gets the seconds attribute of Gametimer class,
                gametimer.setSecondsPassed(extraVariable);                    //deduct thirty from it and then sets the new value
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=30;             //Gets the FireTimer attribute of Gametimer class,
                    gametimer.setFirePlaceTimer(extraVariable);                      //deduct thirty from it and then sets the new value
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=30;              //Gets the TorchTimer attribute of Gametimer class,
                    gametimer.setTorchTimer(extraVariable);                       //deduct thirty from it and then sets the new value
                }
            }
            else if (fire==true && intInventory[6]<=0)               //inv[6] = raw fish
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Need Fish to cook on this fire");
            }
            else
            {
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("Need a fire in order to cook this fish");
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void useTorch()
    {
        light = gametimer.isLight();                //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                  //getting dark boolean attribute from Gametimer class

        if(dark == true && intInventory[17]>0)                   //inv[17] = Fire Torch
        {
            intInventory[17]-=1;                                 //inv[17] = Fire Torch
            torch = true;
            extraVariable=gametimer.getTorchTimer(); extraVariable+=300;             //Gets the TorchTimer attribute of Gametimer class,
            gametimer.setTorchTimer(extraVariable);                       //add three hundred in it and then sets the new value
            //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Torch.png"));
            InventoryFragment.txtOutput.setText("Torch lighted");
        }
        else if (light == true)
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("<html>i need to get my head in game..... it's already light </html>");
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("Torch Required");
        }

    }

    public void displayHealthVariables()
    {
        InventoryFragment.txtHydration.setText(String.valueOf(hydration));
        InventoryFragment.txtEnergy.setText(String.valueOf(energy));
        InventoryFragment.txtBodyHeat.setText(String.valueOf(bodyHeat));
    }

}
