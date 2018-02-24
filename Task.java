import java.util.Arrays;

public class Task
{

	private int id;
	private String type;
	private int[] resourceReward;
	private String specialReward;
	private String[] allType = new String[]{"Composition", "Sortie", "Exercise", "Expedition", "Supply", "Arsenal", "Modernization"};

	public Task ()  //overload
	{
		id = -1; type = "No Type"; resourceReward = new int[]{0,0,0,0}; specialReward = "No Special Reward";
	}

	public Task (int i, String s, int[] rr, String sr)
	{
		id = i; type = s; resourceReward = rr.clone(); specialReward = sr;
	}

	public void setTask (int i, String s, int[] rr, String sr)
	{
		id = i; type = s; resourceReward = rr.clone(); specialReward = sr;
	}

	public void printTask ()
	{
		System.out.println("[ ID:" + id + ", Type:" + type + ", Resource Reward: ");
		this.printResourceReward();
		System.out.println(", " + specialReward + " ]");
	}

	private void printResourceReward()
	{
		System.out.print("[ ");
		for (int i = 0; i < 4; i++)
		{
            System.out.print(resourceReward[i]);
        }
        System.out.print(" ]");
    }
}