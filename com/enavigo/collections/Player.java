package com.enavigo.collections;

import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.io.Serializable;

public class Player implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = -8497409675780971182L;
	private String userName;
    private int score;
    private int health;
    private Set<WeaponRandom> weapons; 
    private List<String> skins;
    private Map<String, String> discordFriends;
    private int weaponCount; // how many weapons the player owns
    private int money;

    public Player (String inUserName) 
    {
        this.userName = inUserName;
        score = 0;
        health = 100;
        weapons = new TreeSet<WeaponRandom>(); // guns will be unique by name
        skins = new ArrayList<String>();
        discordFriends = new HashMap<String, String>();
        weaponCount = 0; // index at the next available empty slot in the weapons array
        money = 50;
    }

    public boolean buyWeapon(WeaponRandom inWeapon)
    {
        // A player can have up to 150 weapons
        // If a player tries to buy more than 150 weapons, we will respond
        // false - standing for purchase failure

        if(weapons.size() >= 150)
        {
            return false; // could not add a new weapon
        }

        if(money < inWeapon.getPrice())
        {
            return false;
        }

        if(weapons.contains(inWeapon))
        {
            System.out.println("You already own a " + inWeapon.getName());
            return false; 
        }

        money = money - inWeapon.getPrice(); 
        weapons.add(inWeapon);
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

    /**
     * Adds a skin
     * @param skinName
     */
    public void addSkin(String skinName)
    {
        skins.add(skinName);
    }

    /**
     * Adds a friend to the player's Discord friend list
     * @param friendName The real world name of the friend
     * @param discordHandle The friend's Discord handle
     */
    public void addDiscordFriend(String friendName, String discordHandle)
    {
        discordFriends.put(friendName, discordHandle);
    }

    /**
     * Finds the Discord handle for a friend by the friend's name
     * @param friendName The name of the friend we want to find the Discord handle for
     * @return The Discord handle for the friend, or null if not found
     */
    public String getDiscordFriendHandle(String friendName)
    {
        String discordHandle = discordFriends.get(friendName);
        return discordHandle;
    }

    public void printPlayerStatus()
    {
        System.out.println("User Name:" + userName);
        System.out.println("Score:" + score);
        System.out.println("Health: " + health);
        System.out.println("Money: " + money);
        Iterator<WeaponRandom> iter = weapons.iterator();
        while(iter.hasNext())
        {
            WeaponRandom weaponRandom = iter.next();
            System.out.println("Weapon: " + weaponRandom.getName());
            System.out.println("Available Ammo: " + weaponRandom.getAvailableAmmo());
        }

        int skinCount = skins.size();
        System.out.println("There are " + skinCount + " skins.");
        for(int i = 0; i < skinCount; i++)
        {
            System.out.println(i + ": " + skins.get(i));
        }
    }
    

}