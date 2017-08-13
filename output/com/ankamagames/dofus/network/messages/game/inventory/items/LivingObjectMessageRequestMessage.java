package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LivingObjectMessageRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6066;
    private boolean _isInitialized = false;
    private int msgId = 0;
    private String[] parameters;
    private int livingObject = 0;
    private FuncTree _parameterstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.msgId < 0)
         {
            throw new Exception("Forbidden value (" + this.msgId + ") on element msgId.");
         }
         param1.writeVarShort(this.msgId);
         param1.writeShort(this.parameters.length);
         int _loc2_ = 0;
         while(_loc2_ < this.parameters.length)
         {
            param1.writeUTF(this.parameters[_loc2_]);
            _loc2_++;
         }
         if(this.livingObject < 0)
         {
            throw new Exception("Forbidden value (" + this.livingObject + ") on element livingObject.");
         }
         param1.writeVarInt(this.livingObject);
    }

    public void deserialize(ICustomDataInput param1) {
         String _loc4_ = null;
         this.msgId = param1.readVarUhShort();
         if(this.msgId < 0)
         {
            throw new Exception("Forbidden value (" + this.msgId + ") on element of LivingObjectMessageRequestMessage.msgId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUTF();
            this.parameters.push(_loc4_);
            _loc3_++;
         }
         this.livingObject = param1.readVarUhInt();
         if(this.livingObject < 0)
         {
            throw new Exception("Forbidden value (" + this.livingObject + ") on element of LivingObjectMessageRequestMessage.livingObject.");
         }
    }

}