package com.ankamagames.dofus.network.messages.game.context.roleplay;

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

public class TeleportOnSameMapMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6048;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int cellId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6048;
    }

    public TeleportOnSameMapMessage initTeleportOnSameMapMessage(Number param1,int  param2) {
         this.targetId = param1;
         this.cellId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.targetId = 0;
         this.cellId = 0;
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
         this.serializeAs_TeleportOnSameMapMessage(param1);
    }

    public void serializeAs_TeleportOnSameMapMessage(ICustomDataOutput param1) {
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeVarShort(this.cellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TeleportOnSameMapMessage(param1);
    }

    public void deserializeAs_TeleportOnSameMapMessage(ICustomDataInput param1) {
         this._targetIdFunc(param1);
         this._cellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TeleportOnSameMapMessage(param1);
    }

    public void deserializeAsyncAs_TeleportOnSameMapMessage(FuncTree param1) {
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._cellIdFunc);
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of TeleportOnSameMapMessage.targetId.");
         }
    }

    private void _cellIdFunc(ICustomDataInput param1) {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of TeleportOnSameMapMessage.cellId.");
         }
    }

}