package package com.ankamagames.dofus.network.messages.game.context.roleplay.objects;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectGroundRemovedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3014;
    private boolean _isInitialized = false;
    private int cell = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 3014;
    }

    public ObjectGroundRemovedMessage initObjectGroundRemovedMessage(int param1) {
         this.cell = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.cell = 0;
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
         this.serializeAs_ObjectGroundRemovedMessage(param1);
    }

    public void serializeAs_ObjectGroundRemovedMessage(ICustomDataOutput param1) {
         if(this.cell < 0 || this.cell > 559)
            throw new Exception("Forbidden value (" + this.cell + ") on element cell.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectGroundRemovedMessage(param1);
    }

    public void deserializeAs_ObjectGroundRemovedMessage(ICustomDataInput param1) {
         this._cellFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectGroundRemovedMessage(param1);
    }

    public void deserializeAsyncAs_ObjectGroundRemovedMessage(FuncTree param1) {
         param1.addChild(this._cellFunc);
    }

    private void _cellFunc(ICustomDataInput param1) {
         this.cell = param1.readVarUhShort();
         if(this.cell < 0 || this.cell > 559)
            throw new Exception("Forbidden value (" + this.cell + ") on element of ObjectGroundRemovedMessage.cell.");
    }

}