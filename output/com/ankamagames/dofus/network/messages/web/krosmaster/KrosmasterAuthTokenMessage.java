package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KrosmasterAuthTokenMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6351;
    private boolean _isInitialized = false;
    private String token = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6351;
    }

    public KrosmasterAuthTokenMessage initKrosmasterAuthTokenMessage(String param1) {
         this.token = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.token = "";
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
         this.serializeAs_KrosmasterAuthTokenMessage(param1);
    }

    public void serializeAs_KrosmasterAuthTokenMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.token);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_KrosmasterAuthTokenMessage(param1);
    }

    public void deserializeAs_KrosmasterAuthTokenMessage(ICustomDataInput param1) {
         this._tokenFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_KrosmasterAuthTokenMessage(param1);
    }

    public void deserializeAsyncAs_KrosmasterAuthTokenMessage(FuncTree param1) {
         param1.addChild(this._tokenFunc);
    }

    private void _tokenFunc(ICustomDataInput param1) {
         this.token = param1.readUTF();
    }

}