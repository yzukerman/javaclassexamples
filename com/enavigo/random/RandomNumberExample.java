package com.enavigo.random;

public class RandomNumberExample {

    public static void main(String[] args) {
        WeaponRandom negev = new WeaponRandom("Negev", 0, 15, 150, 30, 15);
        int damage = 0;

        for(int i=0; i < 10; i++)
        {
            damage = negev.shoot();
            if(damage < 0)
            {
               negev.reload();
               System.out.println("Realoading...");
            }
            else
            {
                System.out.println("Damage: " + damage);
            }
        }
        
    }
    
}