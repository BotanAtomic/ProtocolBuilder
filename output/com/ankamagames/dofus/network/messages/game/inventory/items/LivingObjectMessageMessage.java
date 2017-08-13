package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class LivingObjectMessageMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6065;
    private boolean _isInitialized = false;
    private int msgId = 0;
    private int timeStamp = 0;
    private String owner = "";
    private int objectGenericId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6065;
    }

    public LivingObjectMessageMessage initLivingObjectMessageMessage(int param1,int  param2,String  param3,int  param4) {
         this.msgId = param1;
         this.timeStamp = param2;
         this.owner = param3;
         this.objectGenericId = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.msgId = 0;
         this.timeStamp = 0;
         this.owner = "";
         this.objectGenericId = 0;
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
         this.serializeAs_LivingObjectMessageMessage(param1);
    }

    public void serializeAs_LivingObjectMessageMessage(ICustomDataOutput param1) {
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
         this.deserializeAs_LivingObjectMessageMessage(param1);
    }

    public void deserializeAs_LivingObjectMessageMessage(ICustomDataInput param1) {
         this._msgIdFunc(param1);
         this._timeStampFunc(param1);
         this._ownerFunc(param1);
         this._objectGenericIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LivingObjectMessageMessage(param1);
    }

    public void deserializeAsyncAs_LivingObjectMessageMessage(FuncTree param1) {
         param1.addChild(this._msgIdFunc);
         param1.addChild(this._timeStampFunc);
         param1.addChild(this._ownerFunc);
         param1.addChild(this._objectGenericIdFunc);
    }

    private void _msgIdFunc(ICustomDataInput param1) {
         this.msgId = param1.readVarUhShort();
         if(this.msgId < 0)
         {
            throw new Exception("Forbidden value (" + this.msgId + ") on element of LivingObjectMessageMessage.msgId.");
         }
    }

    private void _timeStampFunc(ICustomDataInput param1) {
         this.timeStamp = param1.readInt();
         if(this.timeStamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timeStamp + ") on element of LivingObjectMessageMessage.timeStamp.");
         }
    }

    private void _ownerFunc(ICustomDataInput param1) {
         this.owner = param1.readUTF();
    }

    private void _objectGenericIdFunc(ICustomDataInput param1) {
         this.objectGenericId = param1.readVarUhShort();
         if(this.objectGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGenericId + ") on element of LivingObjectMessageMessage.objectGenericId.");
         }
    }

}