package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyMemberGeoPosition;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyLocateMembersMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5595;
    private boolean _isInitialized = false;
    private PartyMemberGeoPosition[] geopositions;
    private FuncTree _geopositionstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
         }
         param1.writeVarInt(this.partyId);
         param1.writeShort(this.geopositions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.geopositions.length)
         {
            (this.geopositions[_loc2_] as PartyMemberGeoPosition).serializeAs_PartyMemberGeoPosition(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         PartyMemberGeoPosition _loc4_ = null;
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PartyMemberGeoPosition();
            _loc4_.deserialize(param1);
            this.geopositions.push(_loc4_);
            _loc3_++;
         }
    }

}