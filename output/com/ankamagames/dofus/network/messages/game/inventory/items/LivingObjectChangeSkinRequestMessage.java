package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LivingObjectChangeSkinRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5725;
    private boolean _isInitialized = false;
    private int livingUID = 0;
    private int livingPosition = 0;
    private int skinId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.livingUID < 0)
         {
            throw new Exception("Forbidden value (" + this.livingUID + ") on element livingUID.");
         }
         param1.writeVarInt(this.livingUID);
         if(this.livingPosition < 0 || this.livingPosition > 255)
         {
            throw new Exception("Forbidden value (" + this.livingPosition + ") on element livingPosition.");
         }
         param1.writeByte(this.livingPosition);
         if(this.skinId < 0)
         {
            throw new Exception("Forbidden value (" + this.skinId + ") on element skinId.");
         }
         param1.writeVarInt(this.skinId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.livingUID = param1.readVarUhInt();
         if(this.livingUID < 0)
         {
            throw new Exception("Forbidden value (" + this.livingUID + ") on element of LivingObjectChangeSkinRequestMessage.livingUID.");
         }
         this.livingPosition = param1.readUnsignedByte();
         if(this.livingPosition < 0 || this.livingPosition > 255)
         {
            throw new Exception("Forbidden value (" + this.livingPosition + ") on element of LivingObjectChangeSkinRequestMessage.livingPosition.");
         }
         this.skinId = param1.readVarUhInt();
         if(this.skinId < 0)
         {
            throw new Exception("Forbidden value (" + this.skinId + ") on element of LivingObjectChangeSkinRequestMessage.skinId.");
         }
    }

}