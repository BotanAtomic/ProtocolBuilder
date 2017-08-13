package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class NpcDialogReplyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5616;
    private boolean _isInitialized = false;
    private int replyId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5616;
    }

    public NpcDialogReplyMessage initNpcDialogReplyMessage(int param1) {
         this.replyId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.replyId = 0;
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
         this.serializeAs_NpcDialogReplyMessage(param1);
    }

    public void serializeAs_NpcDialogReplyMessage(ICustomDataOutput param1) {
         if(this.replyId < 0)
         {
            throw new Exception("Forbidden value (" + this.replyId + ") on element replyId.");
         }
         param1.writeVarInt(this.replyId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NpcDialogReplyMessage(param1);
    }

    public void deserializeAs_NpcDialogReplyMessage(ICustomDataInput param1) {
         this._replyIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NpcDialogReplyMessage(param1);
    }

    public void deserializeAsyncAs_NpcDialogReplyMessage(FuncTree param1) {
         param1.addChild(this._replyIdFunc);
    }

    private void _replyIdFunc(ICustomDataInput param1) {
         this.replyId = param1.readVarUhInt();
         if(this.replyId < 0)
         {
            throw new Exception("Forbidden value (" + this.replyId + ") on element of NpcDialogReplyMessage.replyId.");
         }
    }

}