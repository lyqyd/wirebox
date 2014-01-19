package wirebox.panel;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import wirebox.api.IPanel;
import wirebox.api.IWirebox;

public class LightPanel implements IPanel {
	
	private Block wirebox;

	@Override
	public String getUid() {
		return "light";
	}
	
	@Override
	public boolean canPanelBePlacedOnSide(ForgeDirection side) {
		return true;
	}

	@Override
	public void registerEvents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderPanelOnSide(World world, int x, int y, int z, ForgeDirection side) {
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
	public void attachPanel(World world, IWirebox wirebox, int x, int y, int z,
			ForgeDirection side) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		
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
		String[] returnVal = {"lightOutput"};
		return returnVal;
	}

}
