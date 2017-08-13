package com.ankamagames.dofus.network.messages.game.context.notification;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class NotificationUpdateFlagMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6090;
    private boolean _isInitialized = false;
    private int index = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6090;
    }

    public NotificationUpdateFlagMessage initNotificationUpdateFlagMessage(int param1) {
         this.index = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.index = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_NotificationUpdateFlagMessage(param1);
    }

    public void serializeAs_NotificationUpdateFlagMessage(ICustomDataOutput param1) {
         if(this.index < 0)
         {
            throw new Exception("Forbidden value (" + this.index + ") on element index.");
         }
         param1.writeVarShort(this.index);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NotificationUpdateFlagMessage(param1);
    }

    public void deserializeAs_NotificationUpdateFlagMessage(ICustomDataInput param1) {
         this._indexFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NotificationUpdateFlagMessage(param1);
    }

    public void deserializeAsyncAs_NotificationUpdateFlagMessage(FuncTree param1) {
         param1.addChild(this._indexFunc);
    }

    private void _indexFunc(ICustomDataInput param1) {
         this.index = param1.readVarUhShort();
         if(this.index < 0)
         {
            throw new Exception("Forbidden value (" + this.index + ") on element of NotificationUpdateFlagMessage.index.");
         }
    }

}