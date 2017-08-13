package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PartyInvitationDungeonMessage extends PartyInvitationMessage implements INetworkMessage {

    private int protocolId = 6244;
    private boolean _isInitialized = false;
    private int dungeonId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6244;
    }

    public PartyInvitationDungeonMessage initPartyInvitationDungeonMessage(int param1,int  param2,String  param3,int  param4,Number  param5,String  param6,Number  param7,int  param8) {
         super.initPartyInvitationMessage(param1,param2,param3,param4,param5,param6,param7);
         this.dungeonId = param8;
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
         this.serializeAs_PartyInvitationDungeonMessage(param1);
    }

    public void serializeAs_PartyInvitationDungeonMessage(ICustomDataOutput param1) {
         super.serializeAs_PartyInvitationMessage(param1);
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationDungeonMessage(param1);
    }

    public void deserializeAs_PartyInvitationDungeonMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._dungeonIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyInvitationDungeonMessage(param1);
    }

    public void deserializeAsyncAs_PartyInvitationDungeonMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._dungeonIdFunc);
    }

    private void _dungeonIdFunc(ICustomDataInput param1) {
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of PartyInvitationDungeonMessage.dungeonId.");
         }
    }

}