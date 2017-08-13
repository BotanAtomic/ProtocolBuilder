package com.ankamagames.dofus.network.messages.game.script;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class URLOpenMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6266;
    private boolean _isInitialized = false;
    private int urlId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6266;
    }

    public URLOpenMessage initURLOpenMessage(int param1) {
         this.urlId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.urlId = 0;
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
         this.serializeAs_URLOpenMessage(param1);
    }

    public void serializeAs_URLOpenMessage(ICustomDataOutput param1) {
         if(this.urlId < 0)
         {
            throw new Exception("Forbidden value (" + this.urlId + ") on element urlId.");
         }
         param1.writeByte(this.urlId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_URLOpenMessage(param1);
    }

    public void deserializeAs_URLOpenMessage(ICustomDataInput param1) {
         this._urlIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_URLOpenMessage(param1);
    }

    public void deserializeAsyncAs_URLOpenMessage(FuncTree param1) {
         param1.addChild(this._urlIdFunc);
    }

    private void _urlIdFunc(ICustomDataInput param1) {
         this.urlId = param1.readByte();
         if(this.urlId < 0)
         {
            throw new Exception("Forbidden value (" + this.urlId + ") on element of URLOpenMessage.urlId.");
         }
    }

}