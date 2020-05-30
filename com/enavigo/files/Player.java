package com.enavigo.files;

import java.lang.String;
import java.io.Serializable;

public class Player implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = -8497409675780971182L;
	private String userName;
    private int score;
    private int health;
    private Weapon[] weapons;
    private int weaponCount; // how many weapons the player owns
    private int money;

    /*
    Players have a new property - money. OK
Players get 50 money units (robux). OK
When a player gets a weapon - they need to pay with the money.
You decide how much each weapon is worth.

Update your code to support a new method called 'buyWeapon';
Update each weapon to have a price.
When buyWeapon is called - the player's money is reduced by the cost of the weapon.
*/

    public Player (String inUserName) 
    {
        this.userName = inUserName;
        score = 0;
        health = 100;
        weapons = new Weapon[150]; // make memory ready for 150 weapons
        weaponCount = 0; // index at the next available empty slot in the weapons array
        money = 50;
    }

    public boolean buyWeapon(Weapon inWeapon)
    {
        // A player can have up to 150 weapons
        // If a player tries to buy more than 150 weapons, we will respond
        // false - standing for purchase failure

        if(weaponCount >= 150)
        {
            return false; // could not add a new weapon
        }

        if(money < inWeapon.getPrice())
        {
            return false;
        }

        weapons[weaponCount] = inWeapon;
        weaponCount = weaponCount+1; // weaponCount++;
        
        money = money - inWeapon.getPrice(); 

        return true; // weapon successfully bought
    }

    public void shootWeapon(Weapon inWeapon)
    {
        boolean result = inWeapon.shoot();
        if (result == false)
        {
            System.out.println("Weapon has no ammo! Reload!");
        }
    }

    public void reloadWeapon(Weapon inWeapon)
    {
        inWeapon.reload();
    }

    public void printPlayerStatus()
    {
        System.out.println("User Name:" + userName);
        System.out.println("Score:" + score);
        System.out.println("Health: " + health);
        System.out.println("Money: " + money);
        for (int i=0; i < weaponCount; i++)
        {
            System.out.println("Weapon: " + weapons[i].getName());
            System.out.println("Available Ammo: " + weapons[i].getAvailableAmmo());
        }
    }
    

}