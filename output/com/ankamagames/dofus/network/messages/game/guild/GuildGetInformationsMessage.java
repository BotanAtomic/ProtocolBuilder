package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildGetInformationsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5550;
    private boolean _isInitialized = false;
    private int infoType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5550;
    }

    public GuildGetInformationsMessage initGuildGetInformationsMessage(int param1) {
         this.infoType = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.infoType = 0;
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
         this.serializeAs_GuildGetInformationsMessage(param1);
    }

    public void serializeAs_GuildGetInformationsMessage(ICustomDataOutput param1) {
         param1.writeByte(this.infoType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildGetInformationsMessage(param1);
    }

    public void deserializeAs_GuildGetInformationsMessage(ICustomDataInput param1) {
         this._infoTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildGetInformationsMessage(param1);
    }

    public void deserializeAsyncAs_GuildGetInformationsMessage(FuncTree param1) {
         param1.addChild(this._infoTypeFunc);
    }

    private void _infoTypeFunc(ICustomDataInput param1) {
         this.infoType = param1.readByte();
         if(this.infoType < 0)
            throw new Exception("Forbidden value (" + this.infoType + ") on element of GuildGetInformationsMessage.infoType.");
    }

}