package wirebox.panel;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import wirebox.api.IPanel;
import wirebox.api.IWirebox;

public class RedstonePanel implements IPanel {

	private IWirebox wirebox;
	private World worldObj;
	private ForgeDirection side;
	
	private int getRedstoneInputFromSide(int x, int y, int z, ForgeDirection face) {
		switch (face) {
			case DOWN:
				return worldObj.isBlockProvidingPowerTo(x, y-1, z, 1);
			case UP:
				return worldObj.isBlockProvidingPowerTo(x, y+1, z, 0);
			case NORTH:
				return worldObj.isBlockProvidingPowerTo(x, y, z-1, 3);
			case SOUTH:
				return worldObj.isBlockProvidingPowerTo(x, y, z+1, 2);
			case WEST:
				return worldObj.isBlockProvidingPowerTo(x-1, y, z, 5);
			case EAST:
				return worldObj.isBlockProvidingPowerTo(x+1, y, z, 4);
			case UNKNOWN:
				return 0;
		}
		return 0;
	}
	
	@Override
	public String getUid() {
		return "redstone";
	}

	@Override
	public HashMap getRedstoneOutputStates() {
		HashMap outputs = new HashMap();
		ChunkCoordinates location = wirebox.getLocation();
		int signal = getRedstoneInputFromSide(location.posX, location.posY, location.posZ, side);
		outputs.put("input", signal);
		return null;
	}

	@Override
	public String[] getRedstoneOutputNames() {
		String[] names = {"input", "output"};
		return names;
	}

	@Override
	public String[] getRedstoneInputNames() {
		String[] names = {"output"};
		return names;
	}

	@Override
	public boolean canPanelBePlacedOnSide(ForgeDirection side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerEvents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderPanelOnSide(World world, int x, int y, int z,
			ForgeDirection side) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachPanel(World world, IWirebox wirebox, int x, int y, int z,
			ForgeDirection side) {
		this.wirebox = wirebox;
		this.worldObj = world;
		this.side = side;
		
	}

	@Override
	public void tickPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onPanelActivated(World world, int x, int y, int z,
			EntityPlayer player, ForgeDirection side, float hitX, float hitY,
			float hitZ) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		
	}

}
