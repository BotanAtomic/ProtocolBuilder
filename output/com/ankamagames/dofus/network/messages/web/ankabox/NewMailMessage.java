package com.ankamagames.dofus.network.messages.web.ankabox;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class NewMailMessage extends MailStatusMessage implements INetworkMessage {

    private int protocolId = 6292;
    private boolean _isInitialized = false;
    private int[] sendersAccountId;
    private FuncTree _sendersAccountIdtree;


    public void serialize(ICustomDataOutput param1) {
         if(this.unread < 0)
         {
            throw new Exception("Forbidden value (" + this.unread + ") on element unread.");
         }
         param1.writeVarShort(this.unread);
         if(this.total < 0)
         {
            throw new Exception("Forbidden value (" + this.total + ") on element total.");
         }
         param1.writeVarShort(this.total);
         param1.writeShort(this.sendersAccountId.length);
         int _loc2_ = 0;
         while(_loc2_ < this.sendersAccountId.length)
         {
            if(this.sendersAccountId[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.sendersAccountId[_loc2_] + ") on element 1 (starting at 1) of sendersAccountId.");
            }
            param1.writeInt(this.sendersAccountId[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         this.unread = param1.readVarUhShort();
         if(this.unread < 0)
         {
            throw new Exception("Forbidden value (" + this.unread + ") on element of MailStatusMessage.unread.");
         }
         this.total = param1.readVarUhShort();
         if(this.total < 0)
         {
            throw new Exception("Forbidden value (" + this.total + ") on element of MailStatusMessage.total.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of sendersAccountId.");
            }
            this.sendersAccountId.push(_loc4_);
            _loc3_++;
         }
    }

}