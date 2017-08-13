package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightResultListEntry;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.NamedPartyTeamWithOutcome;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class GameFightEndMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 720;
    private boolean _isInitialized = false;
    private int duration = 0;
    private int ageBonus = 0;
    private int lootShareLimitMalus = 0;
    private FightResultListEntry[] results;
    private NamedPartyTeamWithOutcome[] namedPartyTeamsOutcomes;
    private FuncTree _resultstree;
    private FuncTree _namedPartyTeamsOutcomestree;


    public void serialize(ICustomDataOutput param1) {
         if(this.duration < 0)
         {
            throw new Exception("Forbidden value (" + this.duration + ") on element duration.");
         }
         param1.writeInt(this.duration);
         param1.writeShort(this.ageBonus);
         param1.writeShort(this.lootShareLimitMalus);
         param1.writeShort(this.results.length);
         int _loc2_ = 0;
         while(_loc2_ < this.results.length)
         {
            param1.writeShort((this.results[_loc2_] as FightResultListEntry).getTypeId());
            (this.results[_loc2_] as FightResultListEntry).serialize(param1);
            _loc2_++;
         }
         param1.writeShort(this.namedPartyTeamsOutcomes.length);
         int _loc3_ = 0;
         while(_loc3_ < this.namedPartyTeamsOutcomes.length)
         {
            (this.namedPartyTeamsOutcomes[_loc3_] as NamedPartyTeamWithOutcome).serializeAs_NamedPartyTeamWithOutcome(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc6_ = 0;
         FightResultListEntry _loc7_ = null;
         NamedPartyTeamWithOutcome _loc8_ = null;
         this.duration = param1.readInt();
         if(this.duration < 0)
         {
            throw new Exception("Forbidden value (" + this.duration + ") on element of GameFightEndMessage.duration.");
         }
         this.ageBonus = param1.readShort();
         this.lootShareLimitMalus = param1.readShort();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(FightResultListEntry,_loc6_);
            _loc7_.deserialize(param1);
            this.results.push(_loc7_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc8_ = new NamedPartyTeamWithOutcome();
            _loc8_.deserialize(param1);
            this.namedPartyTeamsOutcomes.push(_loc8_);
            _loc5_++;
         }
    }

}