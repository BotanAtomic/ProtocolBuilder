package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildPaddockRemovedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5955;
    private boolean _isInitialized = false;
    private int paddockId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5955;
    }

    public GuildPaddockRemovedMessage initGuildPaddockRemovedMessage(int param1) {
         this.paddockId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.paddockId = 0;
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
         this.serializeAs_GuildPaddockRemovedMessage(param1);
    }

    public void serializeAs_GuildPaddockRemovedMessage(ICustomDataOutput param1) {
         param1.writeInt(this.paddockId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildPaddockRemovedMessage(param1);
    }

    public void deserializeAs_GuildPaddockRemovedMessage(ICustomDataInput param1) {
         this._paddockIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildPaddockRemovedMessage(param1);
    }

    public void deserializeAsyncAs_GuildPaddockRemovedMessage(FuncTree param1) {
         param1.addChild(this._paddockIdFunc);
    }

    private void _paddockIdFunc(ICustomDataInput param1) {
         this.paddockId = param1.readInt();
    }

}