public class Ship
{
    private String name;
    private int api_id;                 // The id for a ship in the .json files
    private int id;                     // Each ship and its modernizations have seperate ids in the game data
    private int shipClass;              // API provides ship classes by number
    private int[] stats;                // In order: Firepower, Torpedo, AA, ASW, LOS, Luck, HP, Armor, Evasion, Speed*, Aircraft, Range*]
                                        //           0          1        2   3    4    5     6   7      8        9       10        11
                                        // Speed is either Slow (5) or Fast (10).
                                        // Range can be Short (1), Medium (2), or Long (3)
    private int equip_slots;
    private int[] consumption;          // The maximum fuel and ammo that the ship can hold at once, in that order
    private int[] feed;                 // The stats that this ship will provide when fed to another ship
    private int[] remodelReqs;          // Min level (0), ammo (1) and steel (2) needed for remodeling, and remodel shipID (3)
    
    // Constructors
    public Ship()
    {
        name = "";
        api_id = -1;
        id = -1;
        shipClass = -1;
        stats = new int[12];
        equip_slots = 0;
        consumption = new int[2];
        feed = new int[4];
        remodelReqs = new int[4];
    }
    
    public Ship(String n)
    {
        name = n;
        api_id = -1;
        id = -1;
        shipClass = -1;
        stats = new int[12];
        equip_slots = 0;
        consumption = new int[2];
        feed = new int[4];
        remodelReqs = new int[4];
    }
    
    public Ship(String n, int ai)
    {
        name = n;
        api_id = -1;
        id = -1;
        shipClass = -1;
        stats = new int[12];
        equip_slots = 0;
        consumption = new int[2];
        feed = new int[4];
        remodelReqs = new int[4];
    }
    
    public Ship (String n, int ai, int i, int sc, int[] s, int eq, int[] c, int[] f, int[] r)
    {
        name = n;
        api_id = ai;
        id = i;
        shipClass = sc;
        stats = s;
        equip_slots = eq;
        consumption = c;
        feed = f;
        remodelReqs = r;
    }
    
    // Getters / Setters
    public String getName()
    {
        return name;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public int getAPIID()
    {
        return api_id;
    }
    
    public void setAPIID(int ai)
    {
        api_id = ai;
    }
    
    public int getID()
    {
        return id;
    }
    
    public void setID(int i)
    {
        id = i;
    }
    
    public int getShipClass()
    {
        return shipClass;
    }
    
    public void setShipClass(int sc)
    {
        shipClass = sc;
    }
    
    public int[] getStats()
    {
        return stats.clone();
    }
    
    public void setStats(int[] s)
    {
        for (int i = 0; i < 12; i++)
        {
            stats[i] = s[i];
        }
    }
    
    public int getEquipmentSlots()
    {
        return equip_slots;
    }
    
    public void setEquipmentSlots(int eq)
    {
        equip_slots = eq;
    }
    
    public int[] getConsumption()
    {
        return consumption.clone();
    }
    
    public void setConsumption(int[] c)
    {
        for (int i = 0; i < 2; i++)
        {
            consumption[i] = c[i];
        }
    }
    
    public int[] getFeed()
    {
        return feed.clone();
    }
    
    public void setFeed(int[] f)
    {
        for (int i = 0; i < 4; i++)
        {
            feed[i] = f[i]
        }
    }
    
    public int[] getRemodel()
    {
        return remodelReqs.clone();
    }
    
    public void setRemodel(int[] r)
    {
        for (int i = 0; i < 4; i++)
        {
            remodelReqs[i] = r[i];
        }
    }
    
    public void printShip()
    {
        System.out.print("Name: " + name);
        System.out.print(", API ID: " + api_ID);
        System.out.print(", Ship ID: " + id);
        System.out.print(", Ship Class: " + shipClass);
        printStats();
        System.out.print(", Equipment Slots: " + equipSlots);
        printConsumption();
        printFeed();
        printRemodel();
    }
    
    private void printStats()
    {
        System.out.print(", [Ship Stats: ");
        for (int i = 0; i < 12; i++)
        {
            System.out.println(stats[i]) + ", ");
        }
        System.out.print("], ");
    }
    
    private void printConsumption()
    {
        System.out.print(", [Fuel: " + consumption[0] + " Ammo: " + consumption[1] + "], ");
    }
    
    private void printFeed()
    {
        System.out.print(", [Feeding: ");
        for (int i = 0; i < 4; i++)
        {
            System.out.print(feed[i] + ", ");
        }
        System.out.print("], ");
    }
    
    private void printRemodel()
    {
        System.out.print(", [Remodel: ");
        for (int i = 0; i < 4; i++)
        {
            System.out.print(remodelReqs[i] + ", ");
        }
        System.out.print("], ");
    }
    
    public Recipe build(int i) // Gets the recipe for the given ship id from the recipe list
    {
        Recipe r = Recipe.getRecipe();
        return r;
        
        // Later, add functions here that use the recipe to construct the ship
    }   
}