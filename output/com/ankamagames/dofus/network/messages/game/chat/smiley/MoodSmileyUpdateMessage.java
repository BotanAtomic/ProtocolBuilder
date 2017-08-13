package package com.ankamagames.dofus.network.messages.game.chat.smiley;

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

public class MoodSmileyUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6388;
    private boolean _isInitialized = false;
    private int accountId = 0;
    private Number playerId = 0;
    private int smileyId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6388;
    }

    public MoodSmileyUpdateMessage initMoodSmileyUpdateMessage(int param1,Number  param2,int  param3) {
         this.accountId = param1;
         this.playerId = param2;
         this.smileyId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.accountId = 0;
         this.playerId = 0;
         this.smileyId = 0;
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
         this.serializeAs_MoodSmileyUpdateMessage(param1);
    }

    public void serializeAs_MoodSmileyUpdateMessage(ICustomDataOutput param1) {
         if(this.accountId < 0)
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MoodSmileyUpdateMessage(param1);
    }

    public void deserializeAs_MoodSmileyUpdateMessage(ICustomDataInput param1) {
         this._accountIdFunc(param1);
         this._playerIdFunc(param1);
         this._smileyIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MoodSmileyUpdateMessage(param1);
    }

    public void deserializeAsyncAs_MoodSmileyUpdateMessage(FuncTree param1) {
         param1.addChild(this._accountIdFunc);
         param1.addChild(this._playerIdFunc);
         param1.addChild(this._smileyIdFunc);
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
            throw new Exception("Forbidden value (" + this.accountId + ") on element of MoodSmileyUpdateMessage.accountId.");
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element of MoodSmileyUpdateMessage.playerId.");
    }

    private void _smileyIdFunc(ICustomDataInput param1) {
         this.smileyId = param1.readVarUhShort();
         if(this.smileyId < 0)
            throw new Exception("Forbidden value (" + this.smileyId + ") on element of MoodSmileyUpdateMessage.smileyId.");
    }

}