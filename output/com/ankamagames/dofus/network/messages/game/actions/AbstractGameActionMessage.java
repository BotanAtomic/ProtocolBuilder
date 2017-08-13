package com.ankamagames.dofus.network.messages.game.actions;

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

public class AbstractGameActionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1000;
    private boolean _isInitialized = false;
    private int actionId = 0;
    private Number sourceId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1000;
    }

    public AbstractGameActionMessage initAbstractGameActionMessage(int param1,Number  param2) {
         this.actionId = param1;
         this.sourceId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.actionId = 0;
         this.sourceId = 0;
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
         this.serializeAs_AbstractGameActionMessage(param1);
    }

    public void serializeAs_AbstractGameActionMessage(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeVarShort(this.actionId);
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element sourceId.");
         }
         param1.writeDouble(this.sourceId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractGameActionMessage(param1);
    }

    public void deserializeAs_AbstractGameActionMessage(ICustomDataInput param1) {
         this._actionIdFunc(param1);
         this._sourceIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractGameActionMessage(param1);
    }

    public void deserializeAsyncAs_AbstractGameActionMessage(FuncTree param1) {
         param1.addChild(this._actionIdFunc);
         param1.addChild(this._sourceIdFunc);
    }

    private void _actionIdFunc(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of AbstractGameActionMessage.actionId.");
         }
    }

    private void _sourceIdFunc(ICustomDataInput param1) {
         this.sourceId = param1.readDouble();
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of AbstractGameActionMessage.sourceId.");
         }
    }

}