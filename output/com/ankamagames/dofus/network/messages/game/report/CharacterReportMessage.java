package package com.ankamagames.dofus.network.messages.game.report;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterReportMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6079;
    private boolean _isInitialized = false;
    private Number reportedId = 0;
    private int reason = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6079;
    }

    public CharacterReportMessage initCharacterReportMessage(Number param1,int  param2) {
         this.reportedId = param1;
         this.reason = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.reportedId = 0;
         this.reason = 0;
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
         this.serializeAs_CharacterReportMessage(param1);
    }

    public void serializeAs_CharacterReportMessage(ICustomDataOutput param1) {
         if(this.reportedId < 0 || this.reportedId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.reportedId + ") on element reportedId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterReportMessage(param1);
    }

    public void deserializeAs_CharacterReportMessage(ICustomDataInput param1) {
         this._reportedIdFunc(param1);
         this._reasonFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterReportMessage(param1);
    }

    public void deserializeAsyncAs_CharacterReportMessage(FuncTree param1) {
         param1.addChild(this._reportedIdFunc);
         param1.addChild(this._reasonFunc);
    }

    private void _reportedIdFunc(ICustomDataInput param1) {
         this.reportedId = param1.readVarUhLong();
         if(this.reportedId < 0 || this.reportedId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.reportedId + ") on element of CharacterReportMessage.reportedId.");
    }

    private void _reasonFunc(ICustomDataInput param1) {
         this.reason = param1.readByte();
         if(this.reason < 0)
            throw new Exception("Forbidden value (" + this.reason + ") on element of CharacterReportMessage.reason.");
    }

}