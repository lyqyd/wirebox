package wirebox.tileentity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dan200.computer.api.IComputerAccess;
import dan200.computer.api.ILuaContext;
import dan200.computer.api.IPeripheral;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import wirebox.api.IPanel;
import wirebox.api.IWirebox;
import wirebox.api.PanelManager;

public class WireboxTileEntity extends TileEntity implements IWirebox, IPeripheral {
	
	public WireboxTileEntity() {
		attachedComputers = Collections.synchronizedMap(new	HashMap());
		
	}
	
	private IPanel[] panels;
	private Map<Integer, IComputerAccess> attachedComputers;

	//IWirebox Interface
	
	@Override
	public ChunkCoordinates getLocation() {
		// TODO Auto-generated method stub
		return new ChunkCoordinates(this.xCoord, this.yCoord, this.zCoord);
	}
	
	@Override
	public void queueEventIfAttached(String eventName, Object[] event) {
		Iterator<IComputerAccess> iter=attachedComputers.values().iterator();
		int sideIndex=-1;
		for (int i=0; i<event.length; ++i)
			if (event[i]==null)
			{
				sideIndex=i;
				break;
			}
		
		while (iter.hasNext())
		{
			IComputerAccess comp=iter.next();
			Object[] argsCopy=event.clone();
			if (sideIndex>=0)
				argsCopy[sideIndex]=comp.getAttachmentName();
			comp.queueEvent(eventName, argsCopy );
		}
	}
	
	//Peripheral Interface

	@Override
	public String getType() {
		return "wirebox";
	}

	@Override
	public String[] getMethodNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] callMethod(IComputerAccess computer, ILuaContext context, int method, Object[] arguments) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canAttachToSide(int side) {
		if (this.panels[side].getUid() == "peripheral") {
			return true;
		}
		return false;
	}

	@Override
	public void attach(IComputerAccess computer) {
		attachedComputers.put(computer.getID(), computer);
	}

	@Override
	public void detach(IComputerAccess computer) {
		attachedComputers.remove(computer.getID());
	}
	
	//Our TE functions.

	@Override
	public void updateEntity() {
		for (int i = 0; i < 5; i++) {
			if (this.panels[i] != null) {
				this.panels[i].tickPanel();
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		NBTTagList panelsList = new NBTTagList();
		for (int i = 0; i < 5; i++) {
			NBTTagCompound panelTag = new NBTTagCompound();
			if (this.panels[i] != null) {
				panelTag.setString("type", this.panels[i].getUid());
				NBTTagCompound panelData = new NBTTagCompound();
				this.panels[i].writeToNBT(panelData);
				panelTag.setCompoundTag("data", panelData);
				panelsList.appendTag(panelTag);
			} else {
				panelTag.setString("type", "none");
				panelsList.appendTag(panelTag);
			}
		}
		tag.setTag("panelList", panelsList);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		if (tag.hasKey("panelList")) {
			NBTTagList panelsList = (NBTTagList) tag.getTag("panelList");
			if (panelsList != null) {
				for (int i = 0; i < 5; i++) {
					NBTTagCompound panelTag = (NBTTagCompound)panelsList.tagAt(i);
					String panelType = panelTag.getString("type");
					if (!panelType.equals("none")) {
						IPanel panel = PanelManager.panelRegistry.getPanel(panelType);
						this.panels[i] = panel;
						panel.readFromNBT(panelTag.getCompoundTag("data"));
					}
				}
			}
		}
	}
	
	public void onActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (this.panels[side] != null) {
			this.panels[side].onPanelActivated(world, x, y, z, player, ForgeDirection.getOrientation(side), hitX, hitY, hitZ);
		}
		
	}

}
