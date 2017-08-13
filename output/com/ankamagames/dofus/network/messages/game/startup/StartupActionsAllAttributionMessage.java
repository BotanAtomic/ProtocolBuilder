package package com.ankamagames.dofus.network.messages.game.startup;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class StartupActionsAllAttributionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6537;
    private boolean _isInitialized = false;
    private Number characterId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6537;
    }

    public StartupActionsAllAttributionMessage initStartupActionsAllAttributionMessage(Number param1) {
         this.characterId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
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
         this.serializeAs_StartupActionsAllAttributionMessage(param1);
    }

    public void serializeAs_StartupActionsAllAttributionMessage(ICustomDataOutput param1) {
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StartupActionsAllAttributionMessage(param1);
    }

    public void deserializeAs_StartupActionsAllAttributionMessage(ICustomDataInput param1) {
         this._characterIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StartupActionsAllAttributionMessage(param1);
    }

    public void deserializeAsyncAs_StartupActionsAllAttributionMessage(FuncTree param1) {
         param1.addChild(this._characterIdFunc);
    }

    private void _characterIdFunc(ICustomDataInput param1) {
         this.characterId = param1.readVarUhLong();
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.characterId + ") on element of StartupActionsAllAttributionMessage.characterId.");
    }

}