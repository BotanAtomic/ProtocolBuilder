package package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AllianceFactsErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6423;
    private boolean _isInitialized = false;
    private int allianceId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6423;
    }

    public AllianceFactsErrorMessage initAllianceFactsErrorMessage(int param1) {
         this.allianceId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.allianceId = 0;
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
         this.serializeAs_AllianceFactsErrorMessage(param1);
    }

    public void serializeAs_AllianceFactsErrorMessage(ICustomDataOutput param1) {
         if(this.allianceId < 0)
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceFactsErrorMessage(param1);
    }

    public void deserializeAs_AllianceFactsErrorMessage(ICustomDataInput param1) {
         this._allianceIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceFactsErrorMessage(param1);
    }

    public void deserializeAsyncAs_AllianceFactsErrorMessage(FuncTree param1) {
         param1.addChild(this._allianceIdFunc);
    }

    private void _allianceIdFunc(ICustomDataInput param1) {
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of AllianceFactsErrorMessage.allianceId.");
    }

}