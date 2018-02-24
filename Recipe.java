public class Recipe
{
    private int id;
    private int time;
    private int[] resources;
    // add global dictionary variable here
    
    // Constructors
    public Recipe()
    {
        id = -1;
        time = -1;
        resources = {0, 0, 0, 0};
    }
    
    public Recipe(int i)
    {
        id = i;
        time = -1;
        resources = {0, 0, 0, 0};
    }
    
    public Recipe(int i, int t, int[] r)
    {
        id = i;
        time = t;
        for (int i = 0; i < 4; i++)
        {
            resources[i] = r[i];
        }
    }
    
    // Getters / Setters
    public static Recipe getRecipe(int shipID)
    {
        makeDictionary(); // Instantiates the dictionary used for searching
        
        Stack<Task> dict = new Stack<Task>(); // Copies the dictionary so the orignial is not changed
        dict.addAll(dictionary);
        
        for (int i = 0; i < dictionary.size(); i++) // Searches through the dictionary stack until the proper ID is found
        {
            a = dict.pop();
            if (a.getID() == shipID)
            {
                return a;
            }
        }
        
        return new Recipe(shipID);
    }
    
    public void makeDictionary() // Creates the dictionary if it has not already been made
    {
        if (dictionary.size() < // Total number of recipes)
        {
            // Build dictionary
        }
    }
}