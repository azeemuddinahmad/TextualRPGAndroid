package com.azeemuddin.textualrpg;

import android.os.Bundle;

public class Crafting extends Inventory {
    private int material1Required, material2Required, material3Required, material4Required;
    public static int[] intCraft = new int[15];
    String[] stringCraft = new String[] {"FirePlace","StoneAxe","Shelter","Spear","Bow","Arrow","FishingRod","Bait","Torch","SnareTrap","FishTrap","Medicine","Bandage","Arrow Quiver","Bait Pouch"};

    public void craftFirePlace()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[0]<3 || intInventory[2]<1 || boolCraft[0]==true)    //inv[0] = Wood, inv[2] = Stone
            {
                material1Required=3; material2Required=1;                               //m1R and m2R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Fire Place can not be crafted <br>Materials required " + stringInventory[0] + material1Required + ' ' + stringInventory[2] + material2Required + "<br>Materials in Inventory " +stringInventory[0] + intInventory[0]  + ' '+ stringInventory[2] + intInventory[2] + "</html>");
                if (material1Required<=intInventory[0] && material2Required<=intInventory[2])
                {
                    InventoryFragment.txtOutput.setText("<html> FirePlace already crafted</html>");
                }
            }
            else
            {
                boolCraft[0]=true;
                intInventory[9]+=1;    intCraft[0]+=1;                  //inv[9] = craft[0] = fireplace
                intInventory[0]-=3;                                  //inv[0] = Wood
                intInventory[2]-=1;                                  //inv[2] = Stone
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\FirePlace.png"));
                InventoryFragment.txtOutput.setText("Fire Place crafted");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void craftStoneAxe()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {

            if (intInventory[1]<1 || intInventory[2]<1 || intInventory[5]<1 || boolCraft[1]==true) //inv[1] = sticks ,inv[2] = stones ,inv[5] = braid
            {
                material1Required=1; material2Required=1; material3Required=1;                        //m1R, m2R and m3R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Stone Axe can not be crafted <br>Materials required " + stringInventory[1]+ material1Required + ' ' + stringInventory[2] + material2Required + ' ' + stringInventory[5] + material3Required + "<br>Materials in Inventory " +stringInventory[1] + intInventory[1]  + ' '+ stringInventory[2] + intInventory[2] + ' ' + stringInventory[5] + intInventory[5] +"</html>" );
                if(material1Required<=intInventory[1] && material2Required <= intInventory[2] && material3Required <= intInventory[5])
                {
                    InventoryFragment.txtOutput.setText("<html> StoneAxe already crafted</html>");
                }
            }
            else
            {
                boolCraft[1]=true;
                intInventory[10]+=1;   intCraft[1]+=1;                  //inv[10] = craft[1] = Stone Axe
                intInventory[1]-=1;                                  //inv[1] = sticks
                intInventory[2]-=1;                                  //inv[2] = stones
                intInventory[5]-=1;                                  //inv[5] = braid
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\StoneAxe.png"));
                InventoryFragment.txtOutput.setText("Stone Axe crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void craftSpear()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[0]<1 || intInventory[2]<1 || intInventory[5]<1 || boolCraft[2]==true) //inv[0] = wood ,inv[2] = stones ,inv[5] = braid
            {
                material1Required=1; material2Required=1; material3Required=1;                        //m1R, m2R and m3R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Spear can not be crafted <br>Materials required " + stringInventory[0]+ material1Required + ' ' + stringInventory[2] + material2Required + ' ' + stringInventory[5] + material3Required + "<br>Materials in Inventory " +stringInventory[0] + intInventory[0]  + ' '+ stringInventory[2] + intInventory[2] + ' ' + stringInventory[5] + intInventory[5] +"</html>" );
                if(material1Required<=intInventory[0] && material2Required <= intInventory[2] && material3Required <= intInventory[5])
                {
                    InventoryFragment.txtOutput.setText("<html> Spear already crafted</html>");
                }
            }
            else
            {
                boolCraft[2]=true;
                intInventory[12]+=1;   intCraft[3]+=1;                  //inv[12] = craft[3]
                intInventory[0]-=1;                                  //inv[0] = wood
                intInventory[2]-=1;                                  //inv[2] = stones
                intInventory[5]-=1;                                  //inv[5] = braid
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Spear.png"));
                InventoryFragment.txtOutput.setText("Spear crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void craftBow()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[1]<2 || intInventory[5]<1 || boolCraft[3]==true)    //inv[1] = sticks, inv[5] = braid
            {
                material1Required=2; material2Required=1;                               //m1R and m2R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Bow can not be crafted <br>Materials required " + stringInventory[1] + material1Required + ' ' + stringInventory[5] + material2Required + "<br>Materials in Inventory " +stringInventory[1] + intInventory[1]  + ' '+ stringInventory[5] + intInventory[5] + "</html>");
                if(material1Required<=intInventory[1] && material2Required <= intInventory[5])
                {
                    InventoryFragment.txtOutput.setText("<html> Bow already crafted</html>");
                }
            }
            else
            {
                boolCraft[3]=true;
                intInventory[13]+=1;   intCraft[4]+=1;                  //inv[13] = craft[4] = Bow
                intInventory[1]-=2;                                  //inv[1] = sticks
                intInventory[5]-=1;                                  //inv[5] = braid
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Bow.png"));
                InventoryFragment.txtOutput.setText("Bow crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void craftFishingRod()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                             //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[1]<1 || intInventory[5]<2 || boolCraft[4]==true)
            {
                material1Required=1; material2Required=2;                                //m1R and m2R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Fishing Rod can not be crafted <br>Materials required " + stringInventory[1] + material1Required + ' ' + stringInventory[5] + material2Required + "<br>Materials in Inventory " +stringInventory[1] + intInventory[1]  + ' '+ stringInventory[5] + intInventory[5] + "</html>");
                if(material1Required<=intInventory[1] && material2Required <= intInventory[5])
                {
                    InventoryFragment.txtOutput.setText("<html> Fishing Rod already crafted</html>");
                }
            }
            else
            {
                boolCraft[4]=true;
                intInventory[15]+=1;   intCraft[6]+=1;                  //inv[15] = craft[6] = Fishing Rod
                intInventory[1]-=1;                                  //inv[1] = sticks
                intInventory[5]-=2;                                  //inv[5] = braid
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\FishingRod.png"));
                InventoryFragment.txtOutput.setText("Fishing Rod crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

    public void craftTorch()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[0]<1 || intInventory[8]<1 || boolCraft[5]==true)    //inv[0] = wood, inv[8] = Leather
            {
                material1Required=1; material2Required=1;                               //m1R and m2R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Fishing Rod can not be crafted <br>Materials required " + stringInventory[0] + material1Required + ' ' + stringInventory[8] + material2Required + "<br>Materials in Inventory " +stringInventory[0] + intInventory[0]  + ' '+ stringInventory[8] + intInventory[8] + "</html>");
                if(material1Required<=intInventory[0] && material2Required <= intInventory[8])
                {
                    InventoryFragment.txtOutput.setText("<html> FireTorch already crafted</html>");
                }
            }
            else
            {
                boolCraft[5]=true;
                intInventory[17]+=1;   intCraft[8]+=1;                  //inv[17] = craft[8] = FireTorch
                intInventory[0]-=1;                                  //inv[0] = wood
                intInventory[8]-=1;                                  //inv[8] = leather
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Torch.png"));
                InventoryFragment.txtOutput.setText("Torch crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void craftSnareTrap()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[1]<4 || intInventory[2]<2 || intInventory[5]<1 || intInventory[16]<1 || boolCraft[6]==true)
            {
                material1Required=4; material2Required=2; material3Required=1; material4Required=1;                 //m1R, m2R, m3R and m4R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Snare Trap can not be crafted <br>Materials required " + stringInventory[1]+ material1Required + ' ' + stringInventory[2] + material2Required + ' ' + stringInventory[5] + material3Required + ' ' +stringInventory[16]+ material4Required + "<br>Materials in Inventory " +stringInventory[1] + intInventory[1]  + ' '+ stringInventory[2] + intInventory[2] + ' ' + stringInventory[5] + intInventory[5] +' ' + stringInventory[16] + intInventory[16] +"</html>" );
                if(material1Required <= intInventory[1] && material2Required <= intInventory[2] && material3Required <= intInventory[5] && material4Required <= intInventory[16])
                {
                    InventoryFragment.txtOutput.setText("<html> SnareTrap already crafted</html>");
                }
            }
            else
            {
                boolCraft[6]=true;
                intInventory[18]+=1;   intCraft[9]+=1;                  //inv[18] = craft[9] = SnareTrap
                intInventory[1]-=4;                                  //inv[1] = sticks
                intInventory[2]-=2;                                  //inv[2] = stones
                intInventory[5]-=1;                                  //inv[5] = braid
                intInventory[16]-=1;                                 //inv[16] = bait
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\SnareTrap.png"));
                InventoryFragment.txtOutput.setText("Snare Trap crafted");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void craftFishTrap()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[1]<1 || intInventory[5]<1 || intInventory[16]<1 || boolCraft[7]==true)
            {
                material1Required=1; material2Required=1; material3Required=1;                        //m1R, m2R and m3R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Fish Trap can not be crafted <br>Materials required " + stringInventory[1]+ material1Required + ' ' + stringInventory[5] + material2Required + ' ' + stringInventory[16] + material3Required + "<br>Materials in Inventory " +stringInventory[1] + intInventory[1]  + ' '+ stringInventory[5] + intInventory[5] + ' ' + stringInventory[16] + intInventory[16] +"</html>" );
                if(boolCraft[7]==true)
                {
                    InventoryFragment.txtOutput.setText("<html> Fish Trap already crafted</html>");
                }
            }
            else
            {
                boolCraft[7]=true;
                intInventory[19]+=1;   intCraft[10]+=1;                 //inv[19] = craft[10] = Fishtrap
                intInventory[1]-=1;                                  //inv[1] = sticks
                intInventory[5]-=1;                                  //inv[5] = braid
                intInventory[16]-=1;                                 //inv[16] = bait
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\FishTrap.png"));
                //GameGUI.lblText.setText("Fish Trap crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void craftShelter()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[0]<3 || intInventory[1]<5 || intInventory[2]<4 || boolCraft[8]==true)
            {
                material1Required=3; material2Required=5; material3Required=4;                        //m1R, m2R and m3R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Shelter can not be created <br>Materials required " + stringInventory[0]+ material1Required + ' ' + stringInventory[1] + material2Required + ' ' + stringInventory[2] + material3Required + "<br>Materials in Inventory " +stringInventory[0] + intInventory[0]  + ' '+ stringInventory[1] + intInventory[1] + ' ' + stringInventory[2] + intInventory[2] +"</html>" );
                if(boolCraft[8]==true)
                {
                    InventoryFragment.txtOutput.setText("<html> Shelter already crafted</html>");
                }
            }
            else
            {
                boolCraft[8]=true;
                intInventory[11]+=1;   intCraft[2]+=1;                  //inv[11] = craft[2] = shelter
                intInventory[0]-=3;                                  //inv[0] = wood
                intInventory[1]-=5;                                  //inv[1] = sticks
                intInventory[2]-=4;                                  //inv[2] = stones
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Shelter.png"));
                InventoryFragment.txtOutput.setText("<html>Shelter Created <br> Ahh now i can sleep peacefully </html>");
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
        }
        else
        {
//            GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void craftArrow()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[1]<1 || intInventory[2]<1 || intInventory[5]<1 || boolCraft[9]==false || intInventory[14]==5)
            {
                material1Required=1; material2Required=1; material3Required=1;                        //m1R, m2R and m3R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html> Arrow can not be crafted <br> Materials required " + stringInventory[1]+ material1Required + ' ' + stringInventory[2] + material2Required + ' ' + stringInventory[5] + material3Required + "<br> Materials in Inventory " +stringInventory[1] + intInventory[1]  + ' '+ stringInventory[2] + intInventory[2] + ' ' + stringInventory[5] + intInventory[5] + "</html>" );
                if (boolCraft[9] == false)
                {
                    InventoryFragment.txtOutput.setText("<html> Need Quiver for arrows</html>");
                }
            }
            else
            {
                intInventory[14]+=1;   intCraft[5]+=1;                  //inv[14] = craft[5] = arrow
                intInventory[1]-=1;                                  //inv[1] = sticks
                intInventory[2]-=1;                                  //inv[2] = stones
                intInventory[5]-=1;                                  //inv[5] = braid
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Arrow.png"));
                InventoryFragment.txtOutput.setText("Arrow crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void craftBait()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if ((intInventory[7]<1 && intInventory[4]<1) || boolCraft[10]==false || intInventory[16]==5)
            {
                material1Required=1; material2Required=1;                               //m1R and m2R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Bait can not be crafted <br>Materials required " + stringInventory[7]+ material1Required + " or " + stringInventory[4] + material2Required + "<br>Materials in Inventory " +stringInventory[7] + intInventory[7]  + " or "+ stringInventory[4] + intInventory[2] + "</html>" );
                if(boolCraft[10] == false)
                {
                    InventoryFragment.txtOutput.setText("<html> Need Bait Pouch for baits</html>");
                }
            }
            else if (intInventory[7]>1 || intInventory[4]>1)
            {
                if (intInventory[7]>1)
                {
                    intInventory[16]+=1;   intCraft[7]+=1;              //inv[16] = craft[7] = bait
                    intInventory[7]-=1;                              //inv[7] = meat
                }
                else if (intInventory[4]>1)
                {
                    intInventory[16]+=1;   intCraft[7]+=1;              //inv[16] = craft[7] = bait
                    intInventory[4]-=1;                              //inv[4] = berries
                }
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Bait.png"));
                InventoryFragment.txtOutput.setText("Bait crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void craftMedicine()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[4]<1)
            {
                material1Required=1;                                      //m1R extra variable to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html> Medicine can not be crafted <br> Materials required " + stringInventory[4]+ material1Required + "<br>Materials in Inventory " +stringInventory[4] + intInventory[4]  + "</html>" );
            }
            else
            {
                intInventory[20]+=1;   intCraft[11]+=1;                 //inv[20] = craft[11] = Medicine
                intInventory[4]-=1;                                  //inv[4] = berries
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Medicine.png"));
                InventoryFragment.txtOutput.setText("Medicine crafted\n");
                extraVariable=gametimer.getSecondsPassed(); extraVariable+=15;
                gametimer.setSecondsPassed(extraVariable);
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=15;
                    gametimer.setFirePlaceTimer(extraVariable);
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=15;
                    gametimer.setTorchTimer(extraVariable);
                }
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void craftBandage()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[8]<1 ||intInventory[20]<1)
            {
                material1Required=1; material2Required=1;                               //m1R and m2R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Bandage can not be crafted <br>Materials required " + stringInventory[8]+ material1Required +' '+ stringInventory[20] + material2Required + "<br>Materials in Inventory " +stringInventory[8] + intInventory[8]+' '+stringInventory[20] + intInventory[20]  + "</html>" );
            }
            else
            {
                intInventory[21]+=1;   intCraft[12]+=1;                 //inv[21] = craft[12] = bandage
                intInventory[8]-=1;                                  //inv[8] = leather
                intInventory[20]-=1;                                 //inv[20] = medicine
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\Bandage.png"));
                InventoryFragment.txtOutput.setText("Bandage crafted\n");
                extraVariable=gametimer.getSecondsPassed(); extraVariable+=15;
                gametimer.setSecondsPassed(extraVariable);
                if (fire ==true)
                {
                    extraVariable=gametimer.getFirePlaceTimer(); extraVariable-=15;
                    gametimer.setFirePlaceTimer(extraVariable);
                }
                if(torch==true)
                {
                    extraVariable=gametimer.getTorchTimer(); extraVariable-=15;
                    gametimer.setTorchTimer(extraVariable);
                }
            }
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void craftArrowQuiver()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[8]<2 ||intInventory[5]<1 || boolCraft[9] == true)
            {
                material1Required=2; material2Required=1;                               //m1R and m2R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Arrow Quiver can not be crafted <br>Materials required " + stringInventory[8]+ material1Required +' '+ stringInventory[5] + material2Required + "<br>Materials in Inventory " +stringInventory[8] + intInventory[8]+' '+stringInventory[5] + intInventory[5]  + "</html>" );
                if(boolCraft[9] == true)
                {
                    InventoryFragment.txtOutput.setText("<html> Arrow Quiver already crafted</html>");
                }
            }
            else
            {
                boolCraft[9]=true;
                intInventory[22]+=1;   intCraft[13]+=1;                 //inv[22] = craft[13] = Arrow Quiver
                intInventory[8]-=2;                                  //inv[8] = leather
                intInventory[5]-=1;                                  //inv[5] = braid
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\ArrowQuiver.png"));
                InventoryFragment.txtOutput.setText("Arrow Quiver crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }
    public void craftBaitPouch()
    {
        light = gametimer.isLight();                          //getting light boolean attribute from Gametimer class
        dark = gametimer.isDark();                            //getting dark boolean attribute from Gametimer class
        if(light == true || (dark==true && torch==true ))
        {
            if (intInventory[8]<1 ||intInventory[5]<1)
            {
                material1Required=1; material2Required=1;                               //m1R and m2R extra variables to represent required materials
                //GameGUI.lblText.setIcon(null);
                InventoryFragment.txtOutput.setText("<html>Bait Pouch can not be crafted <br>Materials required " + stringInventory[8]+ material1Required +' '+ stringInventory[5] + material2Required + "<br>Materials in Inventory " +stringInventory[8] + intInventory[8]+' '+stringInventory[5] + intInventory[5]  + "</html>" );
                if(boolCraft[10] == true)
                {
                    InventoryFragment.txtOutput.setText("<html> Bait Pouch already crafted</html>");
                }
            }
            else
            {
                boolCraft[10]=true;
                intInventory[23]+=1;   intCraft[14]+=1;                 //inv[23] = craft[14] = Bait Pouch
                intInventory[8]-=1;                                  //inv[8] = leather
                intInventory[5]-=1;                                  //inv[5] = braid
                health();                                   //calling health method from parent inventory class
                //GG._display();                              //calling display method from GameGUI class
                //GameGUI.lblText.setIcon(new ImageIcon(file.getAbsolutePath() + "\\Pics\\BaitPouch.png"));
                InventoryFragment.txtOutput.setText("Bait Pouch crafted\n");
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
        }
        else
        {
            //GameGUI.lblText.setIcon(null);
            InventoryFragment.txtOutput.setText("too dark i need a torch to work");
        }
    }

}
