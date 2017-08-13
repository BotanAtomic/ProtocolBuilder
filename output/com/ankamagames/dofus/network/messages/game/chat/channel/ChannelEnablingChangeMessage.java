package com.ankamagames.dofus.network.messages.game.chat.channel;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChannelEnablingChangeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 891;
    private boolean _isInitialized = false;
    private int channel = 0;
    private boolean enable = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 891;
    }

    public ChannelEnablingChangeMessage initChannelEnablingChangeMessage(int param1,boolean  param2) {
         this.channel = param1;
         this.enable = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.channel = 0;
         this.enable = false;
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
         this.serializeAs_ChannelEnablingChangeMessage(param1);
    }

    public void serializeAs_ChannelEnablingChangeMessage(ICustomDataOutput param1) {
         param1.writeByte(this.channel);
         param1.writeBoolean(this.enable);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChannelEnablingChangeMessage(param1);
    }

    public void deserializeAs_ChannelEnablingChangeMessage(ICustomDataInput param1) {
         this._channelFunc(param1);
         this._enableFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChannelEnablingChangeMessage(param1);
    }

    public void deserializeAsyncAs_ChannelEnablingChangeMessage(FuncTree param1) {
         param1.addChild(this._channelFunc);
         param1.addChild(this._enableFunc);
    }

    private void _channelFunc(ICustomDataInput param1) {
         this.channel = param1.readByte();
         if(this.channel < 0)
         {
            throw new Exception("Forbidden value (" + this.channel + ") on element of ChannelEnablingChangeMessage.channel.");
         }
    }

    private void _enableFunc(ICustomDataInput param1) {
         this.enable = param1.readBoolean();
    }

}