package wirebox.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import wirebox.tileentity.WireboxTileEntity;

public class WireboxBlock extends BlockContainer {

	protected WireboxBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(0.5f);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("wirebox.wireboxBlock");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new WireboxTileEntity();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		WireboxTileEntity wbte = (WireboxTileEntity)world.getBlockTileEntity(x, y, z);
		if (wbte != null) {
			wbte.onActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
		}
		return false;
	}

}
