package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.MapCoordinatesExtended;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyMemberInFightMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6342;
    private boolean _isInitialized = false;
    private int reason = 0;
    private Number memberId = 0;
    private int memberAccountId = 0;
    private String memberName = "";
    private int fightId = 0;
    private MapCoordinatesExtended fightMap;
    private int timeBeforeFightStart = 0;
    private FuncTree _fightMaptree;


    public void serialize(ICustomDataOutput param1) {
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
         }
         param1.writeVarInt(this.partyId);
         param1.writeByte(this.reason);
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
         }
         param1.writeVarLong(this.memberId);
         if(this.memberAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.memberAccountId + ") on element memberAccountId.");
         }
         param1.writeInt(this.memberAccountId);
         param1.writeUTF(this.memberName);
         param1.writeInt(this.fightId);
         this.fightMap.serializeAs_MapCoordinatesExtended(param1);
         param1.writeVarShort(this.timeBeforeFightStart);
    }

    public void deserialize(ICustomDataInput param1) {
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         this.reason = param1.readByte();
         if(this.reason < 0)
         {
            throw new Exception("Forbidden value (" + this.reason + ") on element of PartyMemberInFightMessage.reason.");
         }
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element of PartyMemberInFightMessage.memberId.");
         }
         this.memberAccountId = param1.readInt();
         if(this.memberAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.memberAccountId + ") on element of PartyMemberInFightMessage.memberAccountId.");
         }
         this.memberName = param1.readUTF();
         this.fightId = param1.readInt();
         this.fightMap = new MapCoordinatesExtended();
         this.fightMap.deserialize(param1);
         this.timeBeforeFightStart = param1.readVarShort();
    }

}