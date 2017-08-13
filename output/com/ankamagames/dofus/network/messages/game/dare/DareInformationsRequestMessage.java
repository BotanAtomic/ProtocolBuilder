package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class DareInformationsRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6659;
    private boolean _isInitialized = false;
    private Number dareId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6659;
    }

    public DareInformationsRequestMessage initDareInformationsRequestMessage(Number param1) {
         this.dareId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dareId = 0;
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
         this.serializeAs_DareInformationsRequestMessage(param1);
    }

    public void serializeAs_DareInformationsRequestMessage(ICustomDataOutput param1) {
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareInformationsRequestMessage(param1);
    }

    public void deserializeAs_DareInformationsRequestMessage(ICustomDataInput param1) {
         this._dareIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareInformationsRequestMessage(param1);
    }

    public void deserializeAsyncAs_DareInformationsRequestMessage(FuncTree param1) {
         param1.addChild(this._dareIdFunc);
    }

    private void _dareIdFunc(ICustomDataInput param1) {
         this.dareId = param1.readDouble();
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareInformationsRequestMessage.dareId.");
         }
    }

}