import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean GameOn = true;
        while (GameOn)
        {
            System.out.println("Welcome to Coal miner!");
            System.out.println("Type \"S\" to start the game!");
            String StartGame = input.nextLine();
            StartGame = StartGame.toUpperCase();
            if (StartGame.equals("S"))
            {
                System.out.println("Game Started!");
                GameOn = false;
                int minimumCoal = 1;
                int maximumCoal = 10;
                int miningTime = 30000;
                int CoalsInventory = 10;
                boolean GameOnInside = true;
                double price1 = 10;
                double price2 = 10;
                double coins = 0;
                System.out.println("Type \"Q\" to quit the game");
                System.out.println("Type \"M\" to mine coal");
                System.out.println("Type \"I\" to take a look at your inventory");
                System.out.println("Type \"SHOP\" to open shop");
                System.out.println("Type \"SELL\" to sell coals");
                System.out.println("Type \"$\" to take a look at your money");
                while (GameOnInside)
                {
                    String operator = input.nextLine();
                    operator = operator.toUpperCase();
                    if (operator.equals("Q")){
                        System.out.println("Quitting game...");
                        System.out.println("Game Quitted Successfully");
                        GameOnInside = false;
                        GameOn = false;
                    }
                    else if(operator.equals("M"))
                    {
                        Random randomCoalGeneration = new Random();
                        int coalsGotten = randomCoalGeneration.nextInt(minimumCoal, maximumCoal);
                        System.out.println("Mining...");
                        try {
                            Thread.sleep(miningTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("You got "+coalsGotten+" Coals!");
                        CoalsInventory = CoalsInventory+coalsGotten;
                        GameOnInside = true;
                    }
                    else if(operator.equals("I"))
                    {
                        System.out.println("Coals: "+CoalsInventory);
                        GameOnInside = true;
                    }
                    else if(operator.equals("SELL"))
                    {
                        System.out.println("How much would you like to sell?");
                        int SellCoalsAsk = input.nextInt();
                        input.nextLine();
                        if (CoalsInventory >= SellCoalsAsk)
                        {
                            coins = coins+SellCoalsAsk;
                            CoalsInventory = CoalsInventory-SellCoalsAsk;
                            System.out.printf("You now have %,f coins and you have %d Coals\n",coins, CoalsInventory );
                            GameOnInside = true;
                        }
                        else if (CoalsInventory < SellCoalsAsk)
                        {
                            System.out.println("you does not have enough coals!");
                            GameOnInside = true;
                        }
                    }
                    else if(operator.equals("$"))
                    {
                        System.out.printf("You have %f",coins);
                        System.out.println();
                        GameOnInside = true;
                    }
                    else if(operator.equals("SHOP"))
                    {
                        boolean openshop1 = true;
                        while (openshop1 == true)
                        {
                            boolean openShop2 = true;
                            System.out.println("Welcome to shop!");
                            System.out.println("Type \"B\" to go back");
                            System.out.printf("Type \"T\" to decrease time needed to mine ((price: %f), (time decreased -5 seconds(your mining time now is %d))\n",price1, miningTime);
                            System.out.printf("Type \"C\" to add your maximum chance of getting coals!((price: %f),(maximum coal added +5(Your maximum coal now is %d)\n", price2, maximumCoal);
                            while (openShop2 == true)
                            {
                                String RespondShop = input.nextLine();
                                RespondShop = RespondShop.toUpperCase();
                                if (RespondShop.equals("B"))
                                {
                                    System.out.println("You have exited from the shop!");
                                    openShop2 = false;
                                    openshop1 = false;
                                }
                                else if(RespondShop.equals("T"))
                                {
                                    if (coins >= price1)
                                    {
                                        System.out.println("Are you sure you want to buy this item?(Y/N)");
                                        String ShopItemBuy = input.nextLine();
                                        ShopItemBuy = ShopItemBuy.toUpperCase();
                                        if (ShopItemBuy.equals("Y"))
                                        {
                                            if (miningTime <=0)
                                            {
                                                System.out.println("maximum level reached!");
                                                openShop2 = true;
                                            }
                                            else if(miningTime > 0)
                                            {
                                                miningTime = miningTime - 5000;
                                                coins = coins - price1;
                                                price1 = price1 * 2;
                                                System.out.printf("Your mining time is now %d milisecond and the price is now rised to %f",miningTime, price1);
                                                System.out.println();
                                                openShop2 = true;
                                            }
                                            else
                                            {
                                                System.out.println("an error has occured(code 5)");
                                                openShop2 = true;
                                            }
                                        }
                                        else if (ShopItemBuy.equals("N"))
                                        {
                                            System.out.println("buying item cancelled!");
                                            openShop2 = true;
                                        }
                                        else
                                        {
                                            System.out.println("An error occured(code 2)");
                                            openShop2 = true;
                                        }
                                        openShop2 = true;
                                    }
                                    else if(coins < price1)
                                    {
                                        System.out.println("You do not have enough money to buy this item!");
                                        openShop2 = true;
                                    }
                                    else
                                    {
                                        System.out.println("An error has occured(code 4)");
                                        openShop2 = true;
                                    }
                                }
                                else if(RespondShop.equals("C"))
                                {
                                    if (coins >= price2)
                                    {
                                        System.out.println("Are you sure you want to buy this item?(Y/N)");
                                        String ShopItemBuy = input.nextLine();
                                        ShopItemBuy = ShopItemBuy.toUpperCase();
                                        if (ShopItemBuy.equals("Y"))
                                        {
                                            if (maximumCoal >= 500)
                                            {
                                                System.out.println("maximum level reached!");
                                                openShop2 = true;
                                            }
                                            else if(maximumCoal > 0 )
                                            {
                                                maximumCoal = maximumCoal + 5;
                                                if(price2 > coins)
                                                {
                                                    System.out.println("You don't have enough money");
                                                }
                                                coins = coins - price2;
                                                price2 = price2 * 2;
                                                System.out.printf("Your maximum chance of getting coal is now %d and the price is now rised to %f",maximumCoal, price2);
                                                System.out.println();
                                                openShop2 = true;
                                            }
                                            else
                                            {
                                                System.out.println("an error has occured(code 5)");
                                                openShop2 = true;
                                            }
                                        }
                                        else if (ShopItemBuy.equals("N"))
                                        {
                                            System.out.println("buying item cancelled!");
                                            openShop2 = true;
                                        }
                                        else
                                        {
                                            System.out.println("An error occured(code 2)");
                                            openShop2 = true;
                                        }
                                        openShop2 = true;
                                    }
                                    else if(coins < price2)
                                    {
                                        System.out.println("You do not have enough money to buy this item!");
                                        openShop2 = true;
                                    }
                                    else
                                    {
                                        System.out.println("An error has occured(code 4)");
                                        openShop2 = true;
                                    }
                                }
                                else
                                {
                                    System.out.println("An error has occured!(code 3)");
                                    openShop2 = true;
                                }
                            }
                        }


                    }
                    else
                    {
                        boolean errorCode1 = true;
                        while (errorCode1 == true) {
                            System.out.println("An error has occured(Code 1)! Do You Wish To Close The Program?(Y/N)");
                            String answer = input.nextLine();
                            answer = answer.toUpperCase();
                            if (answer.equals("Y"))
                            {
                                System.out.println("Program Stopped!");
                                GameOnInside = false;
                                GameOn = false;
                                errorCode1 = false;
                            }
                            else if (answer.equals("N"))
                            {
                                System.out.println("Program Continued!");
                                GameOnInside = true;
                                errorCode1 = false;
                            }
                            else
                            {
                                errorCode1 = true;
                            }
                        }
                    }
                }
            }
            else
            {
                System.out.println("Game is not started!(code:1)");
                GameOn = false;
            }
        }
        input.close();
    }
}