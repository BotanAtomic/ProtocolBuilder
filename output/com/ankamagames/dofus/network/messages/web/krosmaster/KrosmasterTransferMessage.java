package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class KrosmasterTransferMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6348;
    private boolean _isInitialized = false;
    private String uid = "";
    private int failure = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6348;
    }

    public KrosmasterTransferMessage initKrosmasterTransferMessage(String param1,int  param2) {
         this.uid = param1;
         this.failure = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.uid = "";
         this.failure = 0;
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
         this.serializeAs_KrosmasterTransferMessage(param1);
    }

    public void serializeAs_KrosmasterTransferMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.uid);
         param1.writeByte(this.failure);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_KrosmasterTransferMessage(param1);
    }

    public void deserializeAs_KrosmasterTransferMessage(ICustomDataInput param1) {
         this._uidFunc(param1);
         this._failureFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_KrosmasterTransferMessage(param1);
    }

    public void deserializeAsyncAs_KrosmasterTransferMessage(FuncTree param1) {
         param1.addChild(this._uidFunc);
         param1.addChild(this._failureFunc);
    }

    private void _uidFunc(ICustomDataInput param1) {
         this.uid = param1.readUTF();
    }

    private void _failureFunc(ICustomDataInput param1) {
         this.failure = param1.readByte();
         if(this.failure < 0)
         {
            throw new Exception("Forbidden value (" + this.failure + ") on element of KrosmasterTransferMessage.failure.");
         }
    }

}