//contains methods for checking and operations on the amount of resources that a player has.

import java.util.Arrays;

public class Resources{

    private static int[] resourceList; // static because the player should only have one list of resources
    private int fuel;
    private int ammo;
    private int steel;
    private int bauxite;

    // Constructors
    public Resources()
    {
        resourceList = new int[]{0,0,0,0};
        fuel = ammo = steel = bauxite = 0;
    }

    public Resources(int f, int a, int s, int b)
    {
        resourceList = new int[]{f, a, s, b};
        fuel = f; ammo = a; steel = s; bauxite = b;
    }

    public Resources(int[] list)
    {
        resourceList = list.clone();
        fuel = list[0]; ammo = list[1]; steel = list[2]; bauxite = list[3];
    }

    // Setter / Getter
    public void setResourceList(int[] list)
    {
        resourceList = list.clone();
        fuel = list[0]; ammo = list[1]; steel = list[2]; bauxite = list[3];
    }

    public void printResourceList()
    {
        for (int i = 0; i < 4; i++){
            System.out.print(resourceList[i] + " ");
        }
        System.out.println();
    }

    public int[] getResourceList()
    {
        return resourceList.clone();
    }

    // Estimates the amount of time needed for all resources to fill to a desired amount (in seconds)
    public int predictTime(int[] required)
    {
        // resourceList has four fields for current resources: oil, ammo, steel, bauxite
        // required is for the desired amount of each resource
        int[] perSecond = {0,0,0,0};
        int biggestTime = 0;
        
        for (int i = 0; i < 4; i++) // Set perSecond to the amount of time in hours needed to accumulate resources
        { 
            // Set perSecond to the difference between required and current
            perSecond[i] = required[i] - resourceList[i];
            if (perSecond[i] < 0)
            {
                perSecond[i] = 0;
            }
            
            // Multiply difference by 60 to get time in seconds for each resource
            perSecond[i] = perSecond[i] * 60;
        }
        perSecond[3] = perSecond[3] * 3; // Bauxite takes 3 times as long to accumulate
        
        for (int i = 0; i < 4; i++) // Pick resource with longest time
        { 
            if (perSecond[i] > biggestTime)
            {
                biggestTime = perSecond[i];
            }
        }
        return biggestTime;
    }
}
