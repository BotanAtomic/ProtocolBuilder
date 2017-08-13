package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;

public class PartyFollowStatusUpdateMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5581;
    private boolean _isInitialized = false;
    private boolean success = false;
    private boolean isFollowed = false;
    private Number followedId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.success);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isFollowed);
         param1.writeByte(_loc2_);
         if(this.followedId < 0 || this.followedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.followedId + ") on element followedId.");
         }
         param1.writeVarLong(this.followedId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         int _loc2_ = param1.readByte();
         this.success = BooleanByteWrapper.getFlag(_loc2_,0);
         this.isFollowed = BooleanByteWrapper.getFlag(_loc2_,1);
         this.followedId = param1.readVarUhLong();
         if(this.followedId < 0 || this.followedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.followedId + ") on element of PartyFollowStatusUpdateMessage.followedId.");
         }
    }

}