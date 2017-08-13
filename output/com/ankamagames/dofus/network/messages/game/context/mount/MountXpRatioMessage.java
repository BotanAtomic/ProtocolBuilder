package package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class MountXpRatioMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5970;
    private boolean _isInitialized = false;
    private int ratio = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5970;
    }

    public MountXpRatioMessage initMountXpRatioMessage(int param1) {
         this.ratio = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.ratio = 0;
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
         this.serializeAs_MountXpRatioMessage(param1);
    }

    public void serializeAs_MountXpRatioMessage(ICustomDataOutput param1) {
         if(this.ratio < 0)
            throw new Exception("Forbidden value (" + this.ratio + ") on element ratio.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountXpRatioMessage(param1);
    }

    public void deserializeAs_MountXpRatioMessage(ICustomDataInput param1) {
         this._ratioFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountXpRatioMessage(param1);
    }

    public void deserializeAsyncAs_MountXpRatioMessage(FuncTree param1) {
         param1.addChild(this._ratioFunc);
    }

    private void _ratioFunc(ICustomDataInput param1) {
         this.ratio = param1.readByte();
         if(this.ratio < 0)
            throw new Exception("Forbidden value (" + this.ratio + ") on element of MountXpRatioMessage.ratio.");
    }

}