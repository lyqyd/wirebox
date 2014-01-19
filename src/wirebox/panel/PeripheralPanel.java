package wirebox.panel;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import wirebox.api.IPanel;
import wirebox.api.IWirebox;

public class PeripheralPanel implements IPanel {

	@Override
	public String getUid() {
		return "peripheral";
	}

	@Override
	public boolean canPanelBePlacedOnSide(ForgeDirection side) {
		return true;
	}

	@Override
	public void registerEvents() {
		
	}

	@Override
	public void renderPanelOnSide(World world, int x, int y, int z,
			ForgeDirection side) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachPanel(World world, IWirebox wirebox, int x, int y, int z, ForgeDirection side) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickPanel() {
		
	}

	@Override
	public boolean onPanelActivated(World world, int x, int y, int z,
			EntityPlayer player, ForgeDirection side, float hitX, float hitY,
			float hitZ) {
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		
	}

	@Override
	public HashMap getRedstoneOutputStates() {
		return null;
	}

	@Override
	public String[] getRedstoneOutputNames() {
		return null;
	}

	@Override
	public String[] getRedstoneInputNames() {
		return null;
	}

}
