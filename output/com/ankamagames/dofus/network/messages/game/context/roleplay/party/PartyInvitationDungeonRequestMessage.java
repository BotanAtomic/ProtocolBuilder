package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PartyInvitationDungeonRequestMessage extends PartyInvitationRequestMessage implements INetworkMessage {

    private int protocolId = 6245;
    private boolean _isInitialized = false;
    private int dungeonId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6245;
    }

    public PartyInvitationDungeonRequestMessage initPartyInvitationDungeonRequestMessage(String param1,int  param2) {
         super.initPartyInvitationRequestMessage(param1);
         this.dungeonId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.dungeonId = 0;
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
         this.serializeAs_PartyInvitationDungeonRequestMessage(param1);
    }

    public void serializeAs_PartyInvitationDungeonRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_PartyInvitationRequestMessage(param1);
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationDungeonRequestMessage(param1);
    }

    public void deserializeAs_PartyInvitationDungeonRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._dungeonIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyInvitationDungeonRequestMessage(param1);
    }

    public void deserializeAsyncAs_PartyInvitationDungeonRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._dungeonIdFunc);
    }

    private void _dungeonIdFunc(ICustomDataInput param1) {
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of PartyInvitationDungeonRequestMessage.dungeonId.");
         }
    }

}