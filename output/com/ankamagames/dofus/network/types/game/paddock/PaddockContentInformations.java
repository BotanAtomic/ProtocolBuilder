package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PaddockContentInformations extends PaddockInformations implements INetworkType {

    private int protocolId = 183;
    private int paddockId = 0;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;
    private boolean abandonned = false;
    private MountInformationsForPaddock[] mountsInformations;
    private FuncTree _mountsInformationstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.maxOutdoorMount < 0)
         {
            throw new Exception("Forbidden value (" + this.maxOutdoorMount + ") on element maxOutdoorMount.");
         }
         param1.writeVarShort(this.maxOutdoorMount);
         if(this.maxItems < 0)
         {
            throw new Exception("Forbidden value (" + this.maxItems + ") on element maxItems.");
         }
         param1.writeVarShort(this.maxItems);
         param1.writeInt(this.paddockId);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
         param1.writeInt(this.mapId);
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         param1.writeBoolean(this.abandonned);
         param1.writeShort(this.mountsInformations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.mountsInformations.length)
         {
            (this.mountsInformations[_loc2_] as MountInformationsForPaddock).serializeAs_MountInformationsForPaddock(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         MountInformationsForPaddock _loc4_ = null;
         this.deserializeAs_PaddockInformations(param1);
         this.paddockId = param1.readInt();
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of PaddockContentInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of PaddockContentInformations.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PaddockContentInformations.subAreaId.");
         }
         this.abandonned = param1.readBoolean();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new MountInformationsForPaddock();
            _loc4_.deserialize(param1);
            this.mountsInformations.push(_loc4_);
            _loc3_++;
         }
    }

}