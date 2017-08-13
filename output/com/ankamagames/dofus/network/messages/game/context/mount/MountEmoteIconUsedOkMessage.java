package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class MountEmoteIconUsedOkMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5978;
    private boolean _isInitialized = false;
    private int mountId = 0;
    private int reactionType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5978;
    }

    public MountEmoteIconUsedOkMessage initMountEmoteIconUsedOkMessage(int param1,int  param2) {
         this.mountId = param1;
         this.reactionType = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mountId = 0;
         this.reactionType = 0;
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
         this.serializeAs_MountEmoteIconUsedOkMessage(param1);
    }

    public void serializeAs_MountEmoteIconUsedOkMessage(ICustomDataOutput param1) {
         param1.writeVarInt(this.mountId);
         if(this.reactionType < 0)
         {
            throw new Exception("Forbidden value (" + this.reactionType + ") on element reactionType.");
         }
         param1.writeByte(this.reactionType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountEmoteIconUsedOkMessage(param1);
    }

    public void deserializeAs_MountEmoteIconUsedOkMessage(ICustomDataInput param1) {
         this._mountIdFunc(param1);
         this._reactionTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountEmoteIconUsedOkMessage(param1);
    }

    public void deserializeAsyncAs_MountEmoteIconUsedOkMessage(FuncTree param1) {
         param1.addChild(this._mountIdFunc);
         param1.addChild(this._reactionTypeFunc);
    }

    private void _mountIdFunc(ICustomDataInput param1) {
         this.mountId = param1.readVarInt();
    }

    private void _reactionTypeFunc(ICustomDataInput param1) {
         this.reactionType = param1.readByte();
         if(this.reactionType < 0)
         {
            throw new Exception("Forbidden value (" + this.reactionType + ") on element of MountEmoteIconUsedOkMessage.reactionType.");
         }
    }

}