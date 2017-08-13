package package com.ankamagames.dofus.network.messages.game.startup;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class StartupActionsObjetAttributionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1303;
    private boolean _isInitialized = false;
    private int actionId = 0;
    private Number characterId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1303;
    }

    public StartupActionsObjetAttributionMessage initStartupActionsObjetAttributionMessage(int param1,Number  param2) {
         this.actionId = param1;
         this.characterId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.actionId = 0;
         this.characterId = 0;
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
         this.serializeAs_StartupActionsObjetAttributionMessage(param1);
    }

    public void serializeAs_StartupActionsObjetAttributionMessage(ICustomDataOutput param1) {
         if(this.actionId < 0)
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StartupActionsObjetAttributionMessage(param1);
    }

    public void deserializeAs_StartupActionsObjetAttributionMessage(ICustomDataInput param1) {
         this._actionIdFunc(param1);
         this._characterIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StartupActionsObjetAttributionMessage(param1);
    }

    public void deserializeAsyncAs_StartupActionsObjetAttributionMessage(FuncTree param1) {
         param1.addChild(this._actionIdFunc);
         param1.addChild(this._characterIdFunc);
    }

    private void _actionIdFunc(ICustomDataInput param1) {
         this.actionId = param1.readInt();
         if(this.actionId < 0)
            throw new Exception("Forbidden value (" + this.actionId + ") on element of StartupActionsObjetAttributionMessage.actionId.");
    }

    private void _characterIdFunc(ICustomDataInput param1) {
         this.characterId = param1.readVarUhLong();
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.characterId + ") on element of StartupActionsObjetAttributionMessage.characterId.");
    }

}