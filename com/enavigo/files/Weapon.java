package com.enavigo.files;

import java.io.Serializable;

public class Weapon implements Serializable
{
    /**
     *
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

    public Weapon(String inGunName,
                int inType, int inWeight, 
                int inDamageCaused, int ammoCapacity, 
                int recoil, int price)
    {
        gunName = inGunName;
        type = inType;
        weight = inWeight;
        damageCaused = inDamageCaused;
        this.ammoCapacity = ammoCapacity;
        this.recoil = recoil;
        availableAmmo = 0;   
        this.setPrice(price);      
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

    public boolean shoot()
    {
        if(availableAmmo > 0)
        {
            System.out.println("Pew Pew");
            availableAmmo--; 
            return true;
        }
        else return false;
    }

    
}