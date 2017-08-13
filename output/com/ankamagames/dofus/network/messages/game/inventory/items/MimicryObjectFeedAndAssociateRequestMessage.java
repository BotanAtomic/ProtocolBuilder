package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MimicryObjectFeedAndAssociateRequestMessage extends SymbioticObjectAssociateRequestMessage implements INetworkMessage {

    private int protocolId = 6460;
    private boolean _isInitialized = false;
    private int foodUID = 0;
    private int foodPos = 0;
    private boolean preview = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.symbioteUID < 0)
         {
            throw new Exception("Forbidden value (" + this.symbioteUID + ") on element symbioteUID.");
         }
         param1.writeVarInt(this.symbioteUID);
         if(this.symbiotePos < 0 || this.symbiotePos > 255)
         {
            throw new Exception("Forbidden value (" + this.symbiotePos + ") on element symbiotePos.");
         }
         param1.writeByte(this.symbiotePos);
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element hostUID.");
         }
         param1.writeVarInt(this.hostUID);
         if(this.hostPos < 0 || this.hostPos > 255)
         {
            throw new Exception("Forbidden value (" + this.hostPos + ") on element hostPos.");
         }
         param1.writeByte(this.hostPos);
         if(this.foodUID < 0)
         {
            throw new Exception("Forbidden value (" + this.foodUID + ") on element foodUID.");
         }
         param1.writeVarInt(this.foodUID);
         if(this.foodPos < 0 || this.foodPos > 255)
         {
            throw new Exception("Forbidden value (" + this.foodPos + ") on element foodPos.");
         }
         param1.writeByte(this.foodPos);
         param1.writeBoolean(this.preview);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SymbioticObjectAssociateRequestMessage(param1);
         this.foodUID = param1.readVarUhInt();
         if(this.foodUID < 0)
         {
            throw new Exception("Forbidden value (" + this.foodUID + ") on element of MimicryObjectFeedAndAssociateRequestMessage.foodUID.");
         }
         this.foodPos = param1.readUnsignedByte();
         if(this.foodPos < 0 || this.foodPos > 255)
         {
            throw new Exception("Forbidden value (" + this.foodPos + ") on element of MimicryObjectFeedAndAssociateRequestMessage.foodPos.");
         }
         this.preview = param1.readBoolean();
    }

}