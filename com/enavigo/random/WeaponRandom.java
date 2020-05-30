package com.enavigo.random;

import java.io.Serializable;
import java.util.Random;

public class WeaponRandom implements Serializable
{
    /**
     * A Weapon that produces random damage!
     */
    private static final long serialVersionUID = -2096494569293989282L;
    private String gunName;
    private int type;
    private int weight;
    private int damageCaused;
    private int ammoCapacity; 
    private int recoil;
    private int availableAmmo;
    private int price;
    private Random randomDamageGenerator;

    public WeaponRandom(String inGunName,
                int inType, int inWeight, 
                int ammoCapacity, 
                int recoil, int price)
    {
        gunName = inGunName;
        type = inType;
        weight = inWeight;
        this.ammoCapacity = ammoCapacity;
        this.recoil = recoil;
        availableAmmo = 0;   
        this.setPrice(price);   
        randomDamageGenerator = new Random(); // uses the current time in nanosecond   
    }

    public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName()
    {
        return gunName;
    }

    public void reload()
    {
        availableAmmo = ammoCapacity;
    }

    public int getAvailableAmmo()
    {
        return availableAmmo;
    }

    /**
     * Checks whether the weapon is loaded, and then shoots it if it is loaded.
     * @return the damaged caused or -1 if it has no ammo!
     */
    public int shoot()
    {
        if(availableAmmo > 0)
        {
            System.out.println("Pew Pew");
            availableAmmo--; 
            damageCaused = randomDamageGenerator.nextInt(450);
            return damageCaused;
        }
        else return -1;
    }

    
}