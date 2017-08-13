package com.ankamagames.dofus.network.messages.game.ui;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ClientUIOpenedByObjectMessage extends ClientUIOpenedMessage implements INetworkMessage {

    private int protocolId = 6463;
    private boolean _isInitialized = false;
    private int uid = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6463;
    }

    public ClientUIOpenedByObjectMessage initClientUIOpenedByObjectMessage(int param1,int  param2) {
         super.initClientUIOpenedMessage(param1);
         this.uid = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.uid = 0;
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
         this.serializeAs_ClientUIOpenedByObjectMessage(param1);
    }

    public void serializeAs_ClientUIOpenedByObjectMessage(ICustomDataOutput param1) {
         super.serializeAs_ClientUIOpenedMessage(param1);
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
         }
         param1.writeVarInt(this.uid);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ClientUIOpenedByObjectMessage(param1);
    }

    public void deserializeAs_ClientUIOpenedByObjectMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._uidFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ClientUIOpenedByObjectMessage(param1);
    }

    public void deserializeAsyncAs_ClientUIOpenedByObjectMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._uidFunc);
    }

    private void _uidFunc(ICustomDataInput param1) {
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element of ClientUIOpenedByObjectMessage.uid.");
         }
    }

}