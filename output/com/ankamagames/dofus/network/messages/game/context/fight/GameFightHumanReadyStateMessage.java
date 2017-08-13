package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightHumanReadyStateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 740;
    private boolean _isInitialized = false;
    private Number characterId = 0;
    private boolean isReady = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 740;
    }

    public GameFightHumanReadyStateMessage initGameFightHumanReadyStateMessage(Number param1,boolean  param2) {
         this.characterId = param1;
         this.isReady = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.characterId = 0;
         this.isReady = false;
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
         this.serializeAs_GameFightHumanReadyStateMessage(param1);
    }

    public void serializeAs_GameFightHumanReadyStateMessage(ICustomDataOutput param1) {
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightHumanReadyStateMessage(param1);
    }

    public void deserializeAs_GameFightHumanReadyStateMessage(ICustomDataInput param1) {
         this._characterIdFunc(param1);
         this._isReadyFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightHumanReadyStateMessage(param1);
    }

    public void deserializeAsyncAs_GameFightHumanReadyStateMessage(FuncTree param1) {
         param1.addChild(this._characterIdFunc);
         param1.addChild(this._isReadyFunc);
    }

    private void _characterIdFunc(ICustomDataInput param1) {
         this.characterId = param1.readVarUhLong();
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.characterId + ") on element of GameFightHumanReadyStateMessage.characterId.");
    }

    private void _isReadyFunc(ICustomDataInput param1) {
         this.isReady = param1.readBoolean();
    }

}