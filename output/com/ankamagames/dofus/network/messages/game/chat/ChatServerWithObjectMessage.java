package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatServerWithObjectMessage extends ChatServerMessage implements INetworkMessage {

    private int protocolId = 883;
    private boolean _isInitialized = false;
    private ObjectItem[] objects;
    private FuncTree _objectstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ChatServerMessage(param1);
         param1.writeShort(this.objects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objects.length)
         {
            (this.objects[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         ObjectItem _loc4_ = null;
         this.channel = param1.readByte();
         if(this.channel < 0)
         {
            throw new Exception("Forbidden value (" + this.channel + ") on element of ChatAbstractServerMessage.channel.");
         }
         this.content = param1.readUTF();
         this.timestamp = param1.readInt();
         if(this.timestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element of ChatAbstractServerMessage.timestamp.");
         }
         this.fingerprint = param1.readUTF();
         this.senderId = param1.readDouble();
         if(this.senderId < -9.007199254740992E15 || this.senderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.senderId + ") on element of ChatServerMessage.senderId.");
         }
         this.senderName = param1.readUTF();
         this.senderAccountId = param1.readInt();
         if(this.senderAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.senderAccountId + ") on element of ChatServerMessage.senderAccountId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItem();
            _loc4_.deserialize(param1);
            this.objects.push(_loc4_);
            _loc3_++;
         }
    }

}