package com.ankamagames.dofus.network.messages.game.tinsel;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class TitleSelectRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6365;
    private boolean _isInitialized = false;
    private int titleId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6365;
    }

    public TitleSelectRequestMessage initTitleSelectRequestMessage(int param1) {
         this.titleId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.titleId = 0;
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
         this.serializeAs_TitleSelectRequestMessage(param1);
    }

    public void serializeAs_TitleSelectRequestMessage(ICustomDataOutput param1) {
         if(this.titleId < 0)
         {
            throw new Exception("Forbidden value (" + this.titleId + ") on element titleId.");
         }
         param1.writeVarShort(this.titleId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TitleSelectRequestMessage(param1);
    }

    public void deserializeAs_TitleSelectRequestMessage(ICustomDataInput param1) {
         this._titleIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TitleSelectRequestMessage(param1);
    }

    public void deserializeAsyncAs_TitleSelectRequestMessage(FuncTree param1) {
         param1.addChild(this._titleIdFunc);
    }

    private void _titleIdFunc(ICustomDataInput param1) {
         this.titleId = param1.readVarUhShort();
         if(this.titleId < 0)
         {
            throw new Exception("Forbidden value (" + this.titleId + ") on element of TitleSelectRequestMessage.titleId.");
         }
    }

}