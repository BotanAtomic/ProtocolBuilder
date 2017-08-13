package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LivingObjectMessageMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6065;
    private boolean _isInitialized = false;
    private int msgId = 0;
    private int timeStamp = 0;
    private String owner = "";
    private int objectGenericId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.msgId < 0)
         {
            throw new Exception("Forbidden value (" + this.msgId + ") on element msgId.");
         }
         param1.writeVarShort(this.msgId);
         if(this.timeStamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timeStamp + ") on element timeStamp.");
         }
         param1.writeInt(this.timeStamp);
         param1.writeUTF(this.owner);
         if(this.objectGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGenericId + ") on element objectGenericId.");
         }
         param1.writeVarShort(this.objectGenericId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.msgId = param1.readVarUhShort();
         if(this.msgId < 0)
         {
            throw new Exception("Forbidden value (" + this.msgId + ") on element of LivingObjectMessageMessage.msgId.");
         }
         this.timeStamp = param1.readInt();
         if(this.timeStamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timeStamp + ") on element of LivingObjectMessageMessage.timeStamp.");
         }
         this.owner = param1.readUTF();
         this.objectGenericId = param1.readVarUhShort();
         if(this.objectGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGenericId + ") on element of LivingObjectMessageMessage.objectGenericId.");
         }
    }

}