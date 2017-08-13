package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InventoryPresetItemUpdateRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6210;
    private boolean _isInitialized = false;
    private int presetId = 0;
    private int position = 63;
    private int objUid = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         param1.writeByte(this.position);
         if(this.objUid < 0)
         {
            throw new Exception("Forbidden value (" + this.objUid + ") on element objUid.");
         }
         param1.writeVarInt(this.objUid);
    }

    public void deserialize(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of InventoryPresetItemUpdateRequestMessage.presetId.");
         }
         this.position = param1.readUnsignedByte();
         if(this.position < 0 || this.position > 255)
         {
            throw new Exception("Forbidden value (" + this.position + ") on element of InventoryPresetItemUpdateRequestMessage.position.");
         }
         this.objUid = param1.readVarUhInt();
         if(this.objUid < 0)
         {
            throw new Exception("Forbidden value (" + this.objUid + ") on element of InventoryPresetItemUpdateRequestMessage.objUid.");
         }
    }

}