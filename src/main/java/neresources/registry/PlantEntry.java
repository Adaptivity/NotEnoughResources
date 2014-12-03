package neresources.registry;

import neresources.utils.MapKeys;
import neresources.utils.SeedHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlantEntry
{
    private ItemStack plant;
    private Map<String, PlantDrop> drops = new LinkedHashMap<String, PlantDrop>();
    private int totalWeight = 0;

    public static PlantEntry registerGrass()
    {
        List<PlantDrop> seeds = SeedHelper.getSeeds();
        PlantEntry grass = new PlantEntry(new ItemStack(Blocks.tallgrass, 1, 1), seeds.toArray(new PlantDrop[seeds.size()]));
        grass.multiplyWeight(8);
        return grass;
    }

    public PlantEntry(ItemStack plant, PlantDrop... drops)
    {
        this.plant = plant;
        for (PlantDrop entry : drops)
        {
            this.totalWeight += entry.getWeight();
            this.drops.put(MapKeys.getKey(entry.getSeed()), entry);
        }
    }

    public void add(PlantDrop entry)
    {
        String key = MapKeys.getKey(entry.getSeed());
        if (!this.drops.containsKey(key)) return;
        this.drops.put(key, new PlantDrop(entry.getSeed(), (this.totalWeight + entry.getWeight())));
    }

    public ItemStack getPlant()
    {
        return this.plant;
    }

    public List<PlantDrop> getDrops()
    {
        return new ArrayList<PlantDrop>(this.drops.values());
    }

    public PlantDrop getDrop(ItemStack itemStack)
    {
        return this.drops.get(MapKeys.getKey(itemStack));
    }

    public void multiplyWeight(int multiplier)
    {
        this.totalWeight *= multiplier;
    }

    public int getTotalWeight()
    {
        return totalWeight;
    }
}
