package wirebox.api;

import java.util.HashMap;
import wirebox.api.IWirebox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public interface IPanel {
	
	String getUid();
	
	//internal redstone outputs that other modules/panels can use as inputs.
	String[] getRedstoneOutputNames();
	
	//internal analog (0-15) redstone outputs for other modules/panels to use.
	HashMap getRedstoneOutputStates();
	
	//internal inputs that this panel accepts from other modules/panels.
	String[] getRedstoneInputNames();

	boolean canPanelBePlacedOnSide(ForgeDirection side);
	
	void registerEvents();
	
	void renderPanelOnSide(World world, int x, int y, int z, ForgeDirection side);

	void attachPanel(World world, IWirebox wirebox, int x, int y, int z, ForgeDirection side);

	void tickPanel();
	
	boolean onPanelActivated(World world, int x, int y, int z, EntityPlayer player, ForgeDirection side, float hitX, float hitY, float hitZ);
	
	void writeToNBT(NBTTagCompound tag);
	
	void readFromNBT(NBTTagCompound tag);
}