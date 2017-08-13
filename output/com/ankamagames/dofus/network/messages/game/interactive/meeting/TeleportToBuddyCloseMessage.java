package package com.ankamagames.dofus.network.messages.game.interactive.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TeleportToBuddyCloseMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6303;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private Number buddyId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6303;
    }

    public TeleportToBuddyCloseMessage initTeleportToBuddyCloseMessage(int param1,Number  param2) {
         this.dungeonId = param1;
         this.buddyId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dungeonId = 0;
         this.buddyId = 0;
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
         this.serializeAs_TeleportToBuddyCloseMessage(param1);
    }

    public void serializeAs_TeleportToBuddyCloseMessage(ICustomDataOutput param1) {
         if(this.dungeonId < 0)
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TeleportToBuddyCloseMessage(param1);
    }

    public void deserializeAs_TeleportToBuddyCloseMessage(ICustomDataInput param1) {
         this._dungeonIdFunc(param1);
         this._buddyIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TeleportToBuddyCloseMessage(param1);
    }

    public void deserializeAsyncAs_TeleportToBuddyCloseMessage(FuncTree param1) {
         param1.addChild(this._dungeonIdFunc);
         param1.addChild(this._buddyIdFunc);
    }

    private void _dungeonIdFunc(ICustomDataInput param1) {
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of TeleportToBuddyCloseMessage.dungeonId.");
    }

    private void _buddyIdFunc(ICustomDataInput param1) {
         this.buddyId = param1.readVarUhLong();
         if(this.buddyId < 0 || this.buddyId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.buddyId + ") on element of TeleportToBuddyCloseMessage.buddyId.");
    }

}