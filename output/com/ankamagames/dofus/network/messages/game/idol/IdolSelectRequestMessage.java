package package com.ankamagames.dofus.network.messages.game.idol;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;

public class IdolSelectRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6587;
    private boolean _isInitialized = false;
    private int idolId = 0;
    private boolean activate = false;
    private boolean party = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6587;
    }

    public IdolSelectRequestMessage initIdolSelectRequestMessage(int param1,boolean  param2,boolean  param3) {
         this.idolId = param1;
         this.activate = param2;
         this.party = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.idolId = 0;
         this.activate = false;
         this.party = false;
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
         this.serializeAs_IdolSelectRequestMessage(param1);
    }

    public void serializeAs_IdolSelectRequestMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.activate);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.party);
         param1.writeByte(_loc2_);
         if(this.idolId < 0)
            throw new Exception("Forbidden value (" + this.idolId + ") on element idolId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdolSelectRequestMessage(param1);
    }

    public void deserializeAs_IdolSelectRequestMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._idolIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdolSelectRequestMessage(param1);
    }

    public void deserializeAsyncAs_IdolSelectRequestMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._idolIdFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.activate = BooleanByteWrapper.getFlag(_loc2_,0);
         this.party = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _idolIdFunc(ICustomDataInput param1) {
         this.idolId = param1.readVarUhShort();
         if(this.idolId < 0)
            throw new Exception("Forbidden value (" + this.idolId + ") on element of IdolSelectRequestMessage.idolId.");
    }

}