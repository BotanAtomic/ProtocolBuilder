package package com.ankamagames.dofus.network.messages.game.idol;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class IdolPartyLostMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6580;
    private boolean _isInitialized = false;
    private int idolId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6580;
    }

    public IdolPartyLostMessage initIdolPartyLostMessage(int param1) {
         this.idolId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.idolId = 0;
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
         this.serializeAs_IdolPartyLostMessage(param1);
    }

    public void serializeAs_IdolPartyLostMessage(ICustomDataOutput param1) {
         if(this.idolId < 0)
            throw new Exception("Forbidden value (" + this.idolId + ") on element idolId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdolPartyLostMessage(param1);
    }

    public void deserializeAs_IdolPartyLostMessage(ICustomDataInput param1) {
         this._idolIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdolPartyLostMessage(param1);
    }

    public void deserializeAsyncAs_IdolPartyLostMessage(FuncTree param1) {
         param1.addChild(this._idolIdFunc);
    }

    private void _idolIdFunc(ICustomDataInput param1) {
         this.idolId = param1.readVarUhShort();
         if(this.idolId < 0)
            throw new Exception("Forbidden value (" + this.idolId + ") on element of IdolPartyLostMessage.idolId.");
    }

}